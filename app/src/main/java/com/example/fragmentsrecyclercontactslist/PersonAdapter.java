package com.example.fragmentsrecyclercontactslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> people;

    ItemClicked activity;

    public interface ItemClicked {

        void onItemClicked(int index);

    }

    // When the PersonAdapter accepts a list, it binds that list to our people list in ths class
    public PersonAdapter(Context context, ArrayList<Person> list){

        people = list;
        activity = (ItemClicked) context;

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;


        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    activity.onItemClicked(people.indexOf(view.getTag()));



                }
            });
        }
    }

    // Essentially constructing our view holder
    // First we must create our view by inflating the layout
    // We then attach our variables in ViewHolder constructor
    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {

        holder.itemView.setTag(people.get(position));

        holder.tvName.setText(people.get(position).getName());




    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
