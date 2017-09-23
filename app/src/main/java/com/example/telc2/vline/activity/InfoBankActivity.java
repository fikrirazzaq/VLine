package com.example.telc2.vline.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.telc2.vline.R;

import java.io.IOException;

public class InfoBankActivity extends AppCompatActivity {

    TextView txInfoAlamat, txInfoJamBuka, txInfoEstimasi, txNomorAntri, txJumlahAntri;
    Button btnAntriTeller, btnAntriCS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_bank);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Injeksibos");

        btnAntriTeller = (Button) findViewById(R.id.btn_info_antrian_teller_antri);
        btnAntriCS = (Button) findViewById(R.id.btn_info_antrian_cs_antri);

        btnAntriTeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int choice) {
                        switch (choice) {
                            case DialogInterface.BUTTON_POSITIVE:
                                Toast.makeText(InfoBankActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                Toast.makeText(InfoBankActivity.this, "NoInjek", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(InfoBankActivity.this);
                builder.setMessage("Anda yakin mengambil tiket antrian Teller?")
                        .setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();

            }
        });

        btnAntriCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int choice) {
                        switch (choice) {
                            case DialogInterface.BUTTON_POSITIVE:
                                Toast.makeText(InfoBankActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                Toast.makeText(InfoBankActivity.this, "NoInjek", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(InfoBankActivity.this);
                builder.setMessage("Anda yakin mengambil tiket antrian Customer Service?")
                        .setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
        });
    }
}
