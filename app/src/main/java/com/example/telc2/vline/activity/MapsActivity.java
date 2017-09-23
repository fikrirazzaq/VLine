package com.example.telc2.vline.activity;

import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.telc2.vline.R;
import com.example.telc2.vline.adapter.BankAdapter;
import com.example.telc2.vline.model.Bank;
import com.example.telc2.vline.model.BankMarker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

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

        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();

                LatLng latestlatLng = new LatLng(latitude, longitude);

                Marker myself = mMap.addMarker(new MarkerOptions().position(latestlatLng).title("It's Me!"));
                //  myself.setDraggable(true);
                mMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
            }
        });

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        // Set a listener for marker click.
        mMap.setOnMarkerClickListener(this);

    }

    public void addDummyData() {

    }

    private void showMarker() {
        //String array untuk menyimpan nama semua nama kamera
        String[] bank_nama = new String[bankmarkers.size()];
        String[] bank_latitude = new String[bankmarkers.size()];
        String[] bank_longitude = new String[bankmarkers.size()];

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
