package com.recip.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recip.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DirectionsAdapter extends RecyclerView.Adapter<DirectionsAdapter.DirectionsViewHolder> {
    private Context mContext;
    ArrayList<String> stringArrayList;

    public DirectionsAdapter(Context mContext, ArrayList<String> stringArrayList) {
        this.mContext = mContext;
        this.stringArrayList = stringArrayList;
    }

    @NonNull
    @Override
    public DirectionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.directions_list_item, parent, false);
        return new DirectionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DirectionsViewHolder holder, int position) {
        String string = stringArrayList.get(position);
        holder.directionsNumber.setText(Integer.toString(position+1));
        holder.directionsText.setText(string);

    }

    @Override
    public int getItemCount() {
        return stringArrayList.size();
    }

    class DirectionsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.directionsNumber)
        TextView directionsNumber;

        @BindView(R.id.directionsText)
        TextView directionsText;

        public DirectionsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
