package com.arba.rifki.kelon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRegister = (TextView)findViewById(R.id.register_tv);
        tvRegister.setOnClickListener(this);
        final EditText usernameEt = findViewById(R.id.email_ed);
        final EditText passwordEt = findViewById(R.id.password_ed);
        Button btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(usernameEt.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Email kosong",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(passwordEt.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Password kosong",
                            Toast.LENGTH_SHORT).show();
                } else {
                    //cara peratama SharedPreference
                    SharedPreferences sharedPreferences = getSharedPreferences("Test", Context.MODE_PRIVATE);
                    String dataUsername = sharedPreferences.getString("KEY_USERNAME", null);
                    String dataPassword = sharedPreferences.getString("KEY_PASSWORD", null);

                    if (! usernameEt.getText().toString().equalsIgnoreCase(dataUsername)) {
                        //error username tidak sama
                        Toast.makeText(MainActivity.this, "Email tidak terdaftar",
                                Toast.LENGTH_SHORT).show();
                    } else if (! passwordEt.getText().toString().equalsIgnoreCase(dataPassword)) {
                        //error username tidak sama
                        Toast.makeText(MainActivity.this, "Password tidak terdaftar",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Berhasil",
                                Toast.LENGTH_SHORT).show();

                        Intent nextIntent = new Intent(MainActivity.this, HomeActivity.class);
                        nextIntent.putExtra("email", dataUsername);
                        startActivity(nextIntent);
                    }
                }
            }
        });

    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.register_tv:
                Intent loginIntent = new Intent(MainActivity.this,
                        RegisterActivity.class);
                startActivity(loginIntent);
                break;
        }
    }
}