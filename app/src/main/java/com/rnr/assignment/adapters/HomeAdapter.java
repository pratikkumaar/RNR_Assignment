package com.rnr.assignment.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rnr.assignment.R;
import com.rnr.assignment.fragments.LearnWithRNRFragment;
import com.rnr.assignment.models.HomeModel;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context context;
    private List<HomeModel> list;


    public HomeAdapter(Context context, List<HomeModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_row_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final HomeModel model = list.get(position);

        holder.tvAction.setText(model.getAction());
        holder.tvTitle.setText(model.getTitle());

        Glide.with(context)
                .load(model.getImage())
                .into(holder.ivImage);

        holder.cardMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==0){
                    AppCompatActivity activity = (AppCompatActivity) context;
                    Fragment myFragment = new LearnWithRNRFragment();
                    activity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_main, myFragment)
                            .addToBackStack(null)
                            .commit();

                   /* Bundle data_bundle = new Bundle();
                    data_bundle.putParcelable("", model);
                    myFragment.setArguments(data_bundle);*/
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvAction;
        ImageView ivImage;
        CardView cardMain;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAction = itemView.findViewById(R.id.tvAction);
            ivImage = itemView.findViewById(R.id.ivImage);
            cardMain = itemView.findViewById(R.id.cardMain);
        }
    }
}
