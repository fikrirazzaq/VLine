package com.example.telc2.vline.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.telc2.vline.R;
import com.example.telc2.vline.api.ApiRequest;
import com.example.telc2.vline.api.RetroServer;
import com.example.telc2.vline.model.responsemodel.UserRegisResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText edtNamaLengkap, edtUsername, edtNoTelp, edtPassword, edtConfirPassword;
    Button btnRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtNamaLengkap = (EditText) findViewById(R.id.edt_act_reg_nama);
        edtUsername = (EditText) findViewById(R.id.edt_act_reg_username);
        edtNoTelp = (EditText) findViewById(R.id.edt_act_reg_telp);
        edtPassword = (EditText) findViewById(R.id.edt_act_reg_pass);
        edtConfirPassword = (EditText) findViewById(R.id.edt_act_reg_passconf);

        btnRegis = (Button) findViewById(R.id.btn_act_reg_signup);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiRequest api = RetroServer.getRequestService();
                Call<UserRegisResponseModel> regisUser =
                        api.regisUser(edtNamaLengkap.getText().toString(),
                                edtUsername.getText().toString(),
                                edtNoTelp.getText().toString(),
                                edtPassword.getText().toString());
                regisUser.enqueue(new Callback<UserRegisResponseModel>() {
                    @Override
                    public void onResponse(Call<UserRegisResponseModel> call, Response<UserRegisResponseModel> response) {
                        Log.d("Retrofit", "Response: " + response.body().getSukses());
                    }

                    @Override
                    public void onFailure(Call<UserRegisResponseModel> call, Throwable t) {
                        Log.d("Retrofit", "Response: Failed");
                    }
                });
            }
        });

    }
}
