package com.arba.rifki.kelon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final TextInputEditText fullname = findViewById(R.id.fullname);
        final TextInputEditText shortname = findViewById(R.id.shortname);
        final TextInputEditText email = findViewById(R.id.email);
        final TextInputEditText pw = findViewById(R.id.password);
        Button register = findViewById(R.id.btn_register);

        ImageButton back = (ImageButton)findViewById(R.id.back);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(fullname.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Nama Lengkap kosong",
                            Toast.LENGTH_SHORT).show();
                }  else if (TextUtils.isEmpty(shortname.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Nama Panggilan kosong",
                            Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(email.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Email kosong",
                            Toast.LENGTH_SHORT).show();
                }  else if (TextUtils.isEmpty(pw.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Password kosong",
                            Toast.LENGTH_SHORT).show();
                } else {
                    //cara peratama SharedPreference
                    SharedPreferences sharedPreferences = getSharedPreferences("Test", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("KEY_FULLNAME", fullname.getText().toString());
                    editor.putString("KEY_SHORTNAME", shortname.getText().toString());
                    editor.putString("KEY_EMAIL", email.getText().toString());
                    editor.putString("KEY_PASSWORD", pw.getText().toString());
                    editor.commit();

                    Toast.makeText(RegisterActivity.this, "Registrasi Berhasil",
                            Toast.LENGTH_SHORT).show();

                    //mengembalikan ke nilai awal
                    fullname.setText(null);
                    shortname.setText(null);
                    email.setText(null);
                    pw.setText(null);

                    Intent nextInten = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(nextInten);
                    finish();

                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backLogin = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(backLogin);
            }
        });
    }
}