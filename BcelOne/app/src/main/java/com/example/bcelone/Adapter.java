package com.example.bcelone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final Context context;
    private final ArrayList<Model> courseModelArrayList;

    // Constructor
    public Adapter(Context context, ArrayList<Model> courseModelArrayList) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        // to set data to textview and imageview of each card layout
        Model model = courseModelArrayList.get(position);

        holder.Simage.setImageResource(model.getSimage());
        holder.Stitle.setText(model.getStitle());
        holder.Sdes.setText(model.getSDescription()); // Assuming you have a getSdes() method in your Model class
        holder.Smoney.setText(model.getSmoney()); // Assuming you have a getSmoney() method in your Model class
        holder.Sfrmacc.setText(model.getFromAcc());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing the number of card items in the recycler view
        return courseModelArrayList.size();
    }

    // View holder class for initializing your views such as TextView and ImageView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView Stitle;
        private final TextView Sdes;
        private final ImageView Simage;
        private final TextView Smoney;
        private final TextView Sfrmacc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Simage = itemView.findViewById(R.id.sImage);
            Stitle = itemView.findViewById(R.id.txtstatus);
            Sdes = itemView.findViewById(R.id.txtdes);
            Smoney = itemView.findViewById(R.id.txtmoney);
            Sfrmacc = itemView.findViewById(R.id.txtfrmacc);
        }
    }
}
