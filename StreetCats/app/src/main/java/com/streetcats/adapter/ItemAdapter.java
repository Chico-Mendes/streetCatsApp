package com.streetcats.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.streetcats.CatProfileActivity;
import com.streetcats.MainActivity;
import com.streetcats.R;
import com.streetcats.model.Cat;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private Context context;
    private ArrayList<Cat> dataset;

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private TextView nameView;
        private ImageView imageView;

        public ItemViewHolder(@NonNull View view) {
            super(view);
            cardView = view.findViewById(R.id.cardView);
            nameView = view.findViewById(R.id.nameView);
            imageView = view.findViewById(R.id.imageView);
        }
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    public ItemAdapter(Context ctx, ArrayList<Cat> inputDataset) {
        context = ctx;
        dataset = inputDataset;
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.streetcats_item, parent, false);
        return new ItemViewHolder(view);
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Cat item = dataset.get(position);
        holder.nameView.setText(item.getName());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CatProfileActivity.class);
                intent.putExtra(MainActivity.CAT_NAME, item.getName());
                context.startActivity(intent);
            }
        });
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
