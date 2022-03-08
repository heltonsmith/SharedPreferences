package com.heltonbustos.ejemplosharedpreference01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtCorreo;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtCorreo = findViewById(R.id.txtCorreo);
        btnGuardar = findViewById(R.id.btnGuardar);

        SharedPreferences preferences = getSharedPreferences("almacenamiento_sp", Context.MODE_PRIVATE);
        txtNombre.setText(preferences.getString("sp_nombre", ""));
        txtCorreo.setText(preferences.getString("sp_correo", ""));

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtNombre.getText().toString();
                String correo = txtCorreo.getText().toString();

                SharedPreferences preferences = getSharedPreferences("almacenamiento_sp", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("sp_nombre", nombre);
                editor.putString("sp_correo", correo);
                editor.commit();
            }
        });
    }
}