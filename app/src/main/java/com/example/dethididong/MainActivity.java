package com.example.dethididong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    Button b1, b2;
    int dem = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.bt1);
        b2 = findViewById(R.id.bt2);
        e1 = findViewById(R.id.ed1);
        e2 = findViewById(R.id.ed2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = e1.getText().toString();
                String mk = e2.getText().toString();
                if (ten.equals("Admin") && mk.equals("12345")){
                    Intent i1 = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i1);
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Tên đăng nhập hoặc mật khẩu không đúng. Vui lòng nhập lại!");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.show();
                    dem++;
                    if (dem>=3) finish();
                }
            }

            private void startActivities(Intent i1) {
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
}