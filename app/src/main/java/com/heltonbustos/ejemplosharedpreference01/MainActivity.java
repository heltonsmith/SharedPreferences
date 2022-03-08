package com.heltonbustos.ejemplosharedpreference01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtCorreo, txtClave;
    Button btnGuardar;
    CheckBox chkRecordar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCorreo = findViewById(R.id.txtCorreo);
        txtClave = findViewById(R.id.txtClave);
        btnGuardar = findViewById(R.id.btnGuardar);
        chkRecordar = findViewById(R.id.chkRecordar);

        SharedPreferences preferences = getSharedPreferences("almacenamiento_sp", Context.MODE_PRIVATE);
        txtCorreo.setText(preferences.getString("sp_correo", ""));
        txtClave.setText(preferences.getString("sp_clave", ""));

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chkRecordar.isChecked()){
                    String correo = txtCorreo.getText().toString();
                    String clave = txtClave.getText().toString();

                    SharedPreferences preferences = getSharedPreferences("almacenamiento_sp", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();

                    editor.putString("sp_correo", correo);
                    editor.putString("sp_clave", clave);
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Cuenta almacenada", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Cuenta no almacenada", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}