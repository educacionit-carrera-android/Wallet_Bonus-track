package com.example.walletbonustrack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardViewHolder> {

    private List<Card> cards = new ArrayList<>();
    private OnItemClickListener listener;

    public CardsAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardViewHolder = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);

        return new CardViewHolder(cardViewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Card card = cards.get(position);
        holder.txtNombre.setText(card.getNombre());
        holder.txtNumero.setText(card.getNumeroOfuscado());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(card);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public void actualizarTarjetas(List<Card> newCards) {
        cards = newCards;
        notifyDataSetChanged();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre;
        TextView txtNumero;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNombre = itemView.findViewById(R.id.textViewNombre);
            txtNumero = itemView.findViewById(R.id.textViewNumero);
        }
    }

    interface OnItemClickListener {
        void onItemClick(Card tarjeta);
    }
}
