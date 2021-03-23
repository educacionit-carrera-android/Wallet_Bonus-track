package com.example.walletbonustrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNumeroTarjeta;
    private EditText etFechaExpiracion;
    private EditText etCvv;
    private EditText etNombre;
    private Button btnAgregar;
    private CheckBox checkBoxTerms;
    private TextView textViewTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
        setupCheckBoxListener();
    }

    private void setupUI() {
        etNumeroTarjeta = findViewById(R.id.etCardNumber);
        etFechaExpiracion = findViewById(R.id.editTextDate);
        etCvv = findViewById(R.id.editTextCvv);
        etNombre = findViewById(R.id.editTextTextPersonName);
        btnAgregar = findViewById(R.id.btnAddCard);
        checkBoxTerms = findViewById(R.id.checkBoxTerms);
        textViewTerms = findViewById(R.id.textViewTerms);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (datosValidos()) {
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Datos inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        textViewTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarTermsAndConditionActivity();
            }
        });
    }

    private void lanzarTermsAndConditionActivity() {
        Intent intent = new Intent(this, TermsAndConditionsActivity.class);
        startActivity(intent);
    }

    private void setupCheckBoxListener() {
        checkBoxTerms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                btnAgregar.setEnabled(isChecked);
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
