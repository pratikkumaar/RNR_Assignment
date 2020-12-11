package com.rnr.assignment.adapters;

import android.content.Context;
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
import com.rnr.assignment.fragments.WhyInvest;
import com.rnr.assignment.models.LeaderboardModel;
import com.rnr.assignment.models.LearnWithRNRModel;

import java.util.List;

/**
 * Created by Prateek on 10-Dec-20.
 */

public class LearnWithRNRAdapter extends RecyclerView.Adapter<LearnWithRNRAdapter.ViewHolder> {

    private Context context;
    private List<LearnWithRNRModel> list;


    public LearnWithRNRAdapter(Context context, List<LearnWithRNRModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_row_learn_with_rnr, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final LearnWithRNRModel model = list.get(position);

        holder.tvTitle.setText(model.getTitle());
        holder.tvShortDescription.setText(model.getShortDescription());

        Glide.with(context)
                .load(model.getIme())
                .into(holder.ivImage);

        holder.cardMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==0){
                    AppCompatActivity activity = (AppCompatActivity) context;
                    Fragment myFragment = new WhyInvest();
                    activity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_main, myFragment)
                            .addToBackStack(null)
                            .commit();
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

        TextView tvTitle, tvShortDescription;
        ImageView ivImage;
        CardView cardMain;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle= itemView.findViewById(R.id.tvTitle);
            tvShortDescription= itemView.findViewById(R.id.tvShortDescription);
            ivImage = itemView.findViewById(R.id.ivImage);
            cardMain= itemView.findViewById(R.id.cardMain);

        }
    }
}
