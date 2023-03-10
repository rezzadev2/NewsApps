package com.rezzza.articleapps.ui.source;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.rezzza.articleapps.entities.Source;
import com.rezzza.articleapps.R;

import java.util.ArrayList;

public class SourceAdapter extends RecyclerView.Adapter<SourceAdapter.AdapterView>{

    private final ArrayList<Source> listData;
    private OnSelectedListener listener;

    SourceAdapter(ArrayList<Source> sources){
        listData = sources;
    }

    @NonNull
    @Override
    public AdapterView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.source_adapter,parent, false);
        return new AdapterView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterView holder, int position) {
        Source source = listData.get(position);

        holder.txvw_title.setText(source.getName());
        holder.txvw_description.setText(source.getDescription());

        holder.mrly_action.setOnClickListener(view -> {
            if (listener != null){
                listener.onSelected(source);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    static class AdapterView extends RecyclerView.ViewHolder{
        TextView txvw_title,txvw_description;
        MaterialRippleLayout mrly_action;

        public AdapterView(@NonNull View itemView) {
            super(itemView);

            txvw_description = itemView.findViewById(R.id.txvw_description);
            txvw_title = itemView.findViewById(R.id.txvw_title);
            mrly_action = itemView.findViewById(R.id.mrly_action);
        }
    }

    public void setOnSelectedListener(OnSelectedListener listener){
        this.listener = listener;
    }
    interface OnSelectedListener{
        void onSelected(Source data);
    }

}
