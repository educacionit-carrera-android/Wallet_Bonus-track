package com.example.walletbonustrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNumeroTarjeta;
    private EditText etFechaExpiracion;
    private EditText etCvv;
    private EditText etNombre;
    private Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
    }

    private void setupUI() {
        etNumeroTarjeta = findViewById(R.id.etCardNumber);
        etFechaExpiracion = findViewById(R.id.editTextDate);
        etCvv = findViewById(R.id.editTextCvv);
        etNombre = findViewById(R.id.editTextTextPersonName);
        btnAgregar = findViewById(R.id.btnAddCard);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (datosValidos()) {
                    // TODO Bonus track - parte 3
                } else {
                    Toast.makeText(MainActivity.this, "Datos inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean datosValidos() {
        return numeroTarjetaValido() &&
                fechaExpiracionValido() &&
                cvvValido() &&
                nombreValido();
    }

    private boolean numeroTarjetaValido() {
        return etNumeroTarjeta.getText().toString().length() == 12;
    }

    private boolean fechaExpiracionValido() {
        return etFechaExpiracion.getText().toString().length() == 5;
    }

    private boolean cvvValido() {
        return etCvv.getText().toString().length() == 3;
    }

    private boolean nombreValido() {
        return etNombre.getText().toString().length() > 5;
    }
}
