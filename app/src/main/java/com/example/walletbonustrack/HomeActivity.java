package com.example.walletbonustrack;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvCards;
    private CardsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupUI();
        setupAdapter();
    }

    private void setupUI() {
        rvCards = findViewById(R.id.recyclerViewCards);
    }

    private void setupAdapter() {
        adapter = new CardsAdapter();
        rvCards.setAdapter(adapter);
        adapter.actualizarTarjetas(obtenerTarjetas());
    }

    private List<Card> obtenerTarjetas() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card("123456789012", "10/24", "123", "Nicolas Diaz"));
        cards.add(new Card("412391230121", "02/22", "351", "Juan Perez"));
        cards.add(new Card("946383412490", "06/23", "912", "Esteban Garcia"));

        return cards;
    }
}
