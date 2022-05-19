package com.example.mycontact.ContactAdapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mycontact.Listener;
import com.example.mycontact.Models.ContactModel;
import com.example.mycontact.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<myViewHolder> {

    List<ContactModel> list;
    Context context;
    Listener listener;

    public Adapter(List<ContactModel> list, Context context, Listener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.samplelayout,parent,false);
        myViewHolder myViewHolder = new myViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.name.setText(list.get(position).getContactName());
        holder.number.setText(list.get(position).getContactNumber());
        holder.itemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                listener.onclickListener();

            }
        });





    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}


class myViewHolder extends RecyclerView.ViewHolder{
    TextView name,number;
    CardView itemContainer;
    ImageView imguser;

    public myViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.Cname);
        number = itemView.findViewById(R.id.Cnumber);
        imguser = itemView.findViewById(R.id.imageuser);

        itemContainer=itemView.findViewById(R.id.itemcontainer);
    }
}
