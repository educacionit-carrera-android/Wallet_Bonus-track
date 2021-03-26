package com.example.walletbonustrack;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.walletbonustrack.HomeActivity.CARD;

public class DetalleTarjetaActivity extends AppCompatActivity {

    private TextView txtNumero;
    private TextView txtNombre;
    private TextView txtFechaExpiracion;
    private Card tarjeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_tarjeta);

        tarjeta = (Card) getIntent().getSerializableExtra(CARD);
        setupUI();
    }

    private void setupUI() {
        txtNumero = findViewById(R.id.textViewNumero);
        txtNombre = findViewById(R.id.textViewNombre);
        txtFechaExpiracion = findViewById(R.id.textViewFechaExpiracion);

        txtNumero.setText(tarjeta.getNumeroOfuscado());
        txtNombre.setText(tarjeta.getNombre());
        txtFechaExpiracion.setText(tarjeta.getFechaExpiracion());
    }
}