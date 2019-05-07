package com.edteam.app.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder>{
    List<Notes> notes;
    Context context;

    //Creamos el constructor
    public NotesAdapter (Context context, List<Notes> notes){
        this.context = context;
        this.notes = notes;

    }

    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.count.setText(String.valueOf(notes.get(position).count));
        holder.name.setText(notes.get(position).name);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    //
    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView count, name;
        ImageView delete;

        public ViewHolder (View view) {
            super(view);
            cardView = view.findViewById(R.id.cardView);
            count = view.findViewById(R.id.count);
            name = view.findViewById(R.id.name);
            delete = view.findViewById(R.id.delete);
        }

    }

}
