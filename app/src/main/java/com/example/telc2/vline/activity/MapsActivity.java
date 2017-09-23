package com.example.telc2.vline.activity;

import android.app.ProgressDialog;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.telc2.vline.R;
import com.example.telc2.vline.adapter.BankAdapter;
import com.example.telc2.vline.api.ApiRequest;
import com.example.telc2.vline.api.RetroServer;
import com.example.telc2.vline.model.Bank;
import com.example.telc2.vline.model.BankMarker;
import com.example.telc2.vline.model.responsemodel.BankMarkerResponseModel;
import com.example.telc2.vline.model.responsemodel.UserRegisResponseModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    List<Marker> markers;
    List<BankMarker> bankmarkers;
    List<Bank> banks;
    RecyclerView rcBank;

    private static final LatLng PERTH = new LatLng(-31.952854, 115.857342);
    private static final LatLng SYDNEY = new LatLng(-33.87365, 151.20689);
    private static final LatLng BRISBANE = new LatLng(-27.47093, 153.0235);

    private Marker mPerth;
    private Marker mSydney;
    private Marker mBrisbane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        initViews();

    }

    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rcv_bank);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(layoutManager);

        List<Bank> banks = prepareData();
        BankAdapter adapter = new BankAdapter(banks, getApplicationContext());
        recyclerView.setAdapter(adapter);

    }
    private List<Bank> prepareData(){

        List<Bank> banks = new ArrayList<>();
        banks.add(new Bank("1", "BNI Kopo", "29", "20", "23", "24"));
        banks.add(new Bank("2", "BNI Soreang", "7", "20", "8", "10"));
        banks.add(new Bank("3", "BNI Telkom", "9", "32", "4", "5"));
        banks.add(new Bank("4", "BNI Indosat", "11", "20", "2", "8"));
        banks.add(new Bank("5", "BNI XL", "4", "22", "1", "7"));
//
//        for(int i=0;i<banks.size();i++){
//            Bank bank = new Bank();
//            bank.setBank_nama(bank.getBank_nama());
//            bank.setBank_nomor_antri_teller_sekarang(bank.getBank_nomor_antri_teller_sekarang());
//            bank.setBank_jumlah_antri_teller(bank.getBank_jumlah_antri_teller());
//            bank.setBank_nomor_antri_cs_sekarang(bank.getBank_nomor_antri_cs_sekarang());
//            bank.setBank_jumlah_antri_cs(bank.getBank_jumlah_antri_cs());
//            banks.add(bank);
//        }
        return banks;
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        Marker marker;

        UiSettings mapUi = mMap.getUiSettings();
        mapUi.setCompassEnabled(true);
        mapUi.setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng bandung = new LatLng(-6.90389, 107.61861);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                bandung).zoom(12).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));



        // Set a listener for marker click.
        mMap.setOnMarkerClickListener(this);

    }

    private void getKamera() {
        //Ketika Aplikasi mengambil data kita akan melihat progress dialog
        final ProgressDialog loading = ProgressDialog.show(this,"Memuat Data","Harap Tunggu..",false,false);

        ApiRequest api = RetroServer.getRequestService();
        Call<BankMarkerResponseModel> regisUser =
                api.getBankMarker();
        regisUser.enqueue(new Callback<BankMarkerResponseModel>() {
            @Override
            public void onResponse(Call<BankMarkerResponseModel> call, Response<BankMarkerResponseModel> response) {
                List<BankMarker> bankMarkers = response.body().getResult();
                bankmarkers = bankMarkers;

                showMarker();
            }

            @Override
            public void onFailure(Call<BankMarkerResponseModel> call, Throwable t) {

            }
        });
    }

    private void showMarker() {
        //String array untuk menyimpan nama semua nama kamera
        String[] nama_bank = new String[bankmarkers.size()];
        String[] lat = new String[bankmarkers.size()];
        String[] lng = new String[bankmarkers.size()];

        markers = new ArrayList<Marker>();

        for (int i = 0; i < bankmarkers.size(); i++) {
//            mMap.addMarker(new MarkerOptions()
//                    .position(new LatLng(Double.parseDouble(kameras.get(i).getLat()), Double.parseDouble(kameras.get(i).getLng())))
//                    .title(kameras.get(i).getNamaLokasi())
//                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
//                    .alpha(0.55f));
            markers.add(mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(Double.parseDouble(bankmarkers.get(i).getBankLat()), Double.parseDouble(bankmarkers.get(i).getBankLon())))
                    .title(bankmarkers.get(i).getBankNama())
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .alpha(0.55f)));
        }

        markers.size();

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
