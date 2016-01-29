package com.example.prolan.httprequestvolly;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Prolan on 27/01/2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.dataViewHolder> {
    List<Data> oneRecord;

    RVAdapter(List<Data> oneRecord){
        this.oneRecord = oneRecord;
    }
    public static class dataViewHolder extends RecyclerView.ViewHolder{

        CardView cV ;
        TextView tV ;
        dataViewHolder(View itemView){
            super(itemView);
            cV = (CardView) itemView.findViewById(R.id.cardView);
            tV = (TextView) itemView.findViewById(R.id.tV);
        }

    }
    @Override
    public dataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main, viewGroup, false);
        dataViewHolder oneRC = new dataViewHolder(v);
        return oneRC;
    }

    @Override
    public void onBindViewHolder(dataViewHolder holder, int position) {
        holder.tV.setText(oneRecord.get(position).oneRecord);
    }

    @Override
    public int getItemCount() {
        return this.oneRecord.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
