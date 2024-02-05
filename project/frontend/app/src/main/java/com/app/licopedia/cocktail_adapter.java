package com.app.licopedia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class cocktail_adapter extends RecyclerView.Adapter<cocktail_view_holder>{
    private cocktails_list cocktails_list;
    public cocktail_adapter(cocktails_list cocktail) {
        this.cocktails_list = cocktail;
    }

    @Override
    public int getItemCount() {
        return this.cocktails_list.get_cocktails_list().size();
    }

    @NonNull
    @Override
    public cocktail_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View cellView = inflater.inflate(R.layout.cocktails_view_holder, parent, false);
        cocktail_view_holder cellViewHolder = new cocktail_view_holder(cellView);
        return cellViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull cocktail_view_holder holder, int position) {
        cocktails dataForThisCell = this.cocktails_list.get_cocktails_list().get(position);
        holder.showData(dataForThisCell);
    }

}
