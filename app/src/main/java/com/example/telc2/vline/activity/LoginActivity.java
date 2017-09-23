package com.example.telc2.vline.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.telc2.vline.R;
import com.example.telc2.vline.api.ApiRequest;
import com.example.telc2.vline.api.RetroServer;
import com.example.telc2.vline.model.UserRegis;
import com.example.telc2.vline.model.responsemodel.UserLoginResponseModel;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;
    List<UserRegis> userRegisList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = (EditText) findViewById(R.id.edt_act_login_username);
        edtPassword = (EditText) findViewById(R.id.edt_act_login_pass);
        btnLogin = (Button) findViewById(R.id.btn_act_login_signup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ApiRequest api = RetroServer.getRequestService();
                Call<UserLoginResponseModel> loginAdmin =
                        api.loginUser(edtUsername.getText().toString(), edtPassword.getText().toString());
                loginAdmin.enqueue(new Callback<UserLoginResponseModel>() {
                    @Override
                    public void onResponse(Call<UserLoginResponseModel> call, Response<UserLoginResponseModel> response) {
                        Log.d("Retrofit", "Response: " + response.body().getSukses());
                        UserLoginResponseModel res = response.body();
                        userRegisList = res.getResult();

                        if (response.body().getSukses().equals("1")) {
                            Toast.makeText(LoginActivity.this, "Selamat Datang!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MapsActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Login gagal, silahkan coba lagi!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserLoginResponseModel> call, Throwable t) {
                        Log.d("Retrofit", "Response: asdfasdfasdf");
                        Toast.makeText(LoginActivity.this, "Login gagal, silahkan coba lagi!", Toast.LENGTH_SHORT).show();
                    }
                });
//
//                Intent intent = new Intent(LoginActivity.this, MapsActivity.class);
//                startActivity(intent);
            }
        });
    }
}
