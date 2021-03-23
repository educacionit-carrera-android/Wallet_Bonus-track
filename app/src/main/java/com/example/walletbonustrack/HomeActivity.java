package com.example.walletbonustrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvCards;
    private CardsAdapter adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupToolbar();
        setupUI();
        setupAdapter();
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbarHome);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.my_cards);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemAgregar) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
