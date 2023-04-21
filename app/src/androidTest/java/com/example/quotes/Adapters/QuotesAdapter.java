package com.example.quotes.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.quotes.R;

import java.util.ArrayList;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuotesHolder> {

    ArrayList<String> quotes;

     QuotesClick click;

     Context context;

     public QuotesAdapter(ArrayList<String> quotes,QuotesClick click){
         this.quotes = quotes;
         this.click = click;
     }


    @NonNull
    @Override
    public QuotesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

         context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quotes,parent,false);
        return new QuotesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesAdapter.QuotesHolder holder, int position) {

         holder.quotes.setText(quotes.get(position));

         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 click.getQuotes(quotes.get(position));

             }
         });
    }

    @Override
    public int getItemCount() {return quotes.size();}

     class QuotesHolder extends RecyclerView.ViewHolder {

         TextView quotes;

        public QuotesHolder(View itemView) {
            super(itemView);

            quotes = itemView.findViewById(R.id.quotes);
        }
    }
}
