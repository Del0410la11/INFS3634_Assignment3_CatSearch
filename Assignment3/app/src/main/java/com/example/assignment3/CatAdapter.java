package com.example.assignment3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ExampleViewHolder> implements Filterable {
    private ArrayList<cat> mExampleList;
    private ArrayList<cat> mExampleListFull;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public TextView mTextView4;


        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.catImage);
            mTextView1 = itemView.findViewById(R.id.name);
            mTextView2 = itemView.findViewById(R.id.temperament);
            mTextView3 = itemView.findViewById(R.id.origin);
            mTextView4 = itemView.findViewById(R.id.weight);
        }
    }

    public CatAdapter(ArrayList<cat> exampleList) {
        mExampleList = exampleList;
        mExampleListFull = new ArrayList<>(exampleList);
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        cat currentItem = mExampleList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getName());
        holder.mTextView2.setText(currentItem.getTemperament());
        holder.mTextView3.setText(currentItem.getOrigin());
        holder.mTextView4.setText(currentItem.getImperial_weight());

    }


    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private final Filter exampleFilter = new Filter() {

        protected FilterResults performFiltering(CharSequence constraint) {
            List<cat> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mExampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (cat item : mExampleListFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mExampleList.clear();
            mExampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}