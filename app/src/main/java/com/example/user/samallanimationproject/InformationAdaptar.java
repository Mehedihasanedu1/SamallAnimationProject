package com.example.user.samallanimationproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 3/12/2018.
 */

public class InformationAdaptar extends RecyclerView.Adapter<InformationAdaptar.InformationViewHolder> {
    private Context context;
    private List<RecyclerViewResponse>recyclerViewResponses;

     public InformationAdaptar(Context context, List<RecyclerViewResponse> recyclerViewResponses) {
        this.context = context;
        this.recyclerViewResponses = recyclerViewResponses;
    }

    @Override
    public InformationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v =inflater.inflate(R.layout.single_title,parent,false);
        return new InformationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(InformationViewHolder holder, int position) {
         holder.title.setText(recyclerViewResponses.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return recyclerViewResponses.size();
    }

    public class InformationViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        public InformationViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }

}
