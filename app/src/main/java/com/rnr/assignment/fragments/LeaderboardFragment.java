package com.rnr.assignment.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.rnr.assignment.R;
import com.rnr.assignment.activties.MainActivity;
import com.rnr.assignment.adapters.HomeAdapter;
import com.rnr.assignment.adapters.LeaderboardAdapter;
import com.rnr.assignment.models.LeaderboardModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeaderboardFragment extends Fragment {

    private Context context;
    private List<LeaderboardModel> list= new ArrayList<>();
    private LeaderboardAdapter adapter;
    private RecyclerView rvLeaderboards;
    private ImageView imgPos1,imgPos2,imgPos3;

    public LeaderboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leaderboard, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MainActivity) Objects.requireNonNull(getActivity())).visibleNavigation();

        rvLeaderboards= view.findViewById(R.id.id_recycler_leaderboard);
        imgPos1= view.findViewById(R.id.position1);
        imgPos2= view.findViewById(R.id.position2);
        imgPos3= view.findViewById(R.id.position3);

        Glide.with(context)
                .load(R.drawable.raina)
                .circleCrop()
                .into(imgPos1);

        Glide.with(context)
                .load(R.drawable.sarang)
                .circleCrop()
                .into(imgPos2);

        Glide.with(context)
                .load(R.drawable.manjeet)
                .circleCrop()
                .into(imgPos3);

        setUpRecycler(context);
        if (list!=null){
            list.clear();
            addData();
        }
    }

    private void setUpRecycler(Context context) {
        adapter = new LeaderboardAdapter(context, list);
        LinearLayoutManager manager = new LinearLayoutManager(context, RecyclerView.VERTICAL,false);
        rvLeaderboards.setLayoutManager(manager);
        rvLeaderboards.setAdapter(adapter);
    }

    private void addData(){
        LeaderboardModel model= new LeaderboardModel("3","Anil","1231 Points",R.drawable.sarang);
        list.add(model);
        LeaderboardModel model2= new LeaderboardModel("4","Anita","1151 Points",R.drawable.anita);
        list.add(model2);
        LeaderboardModel model3= new LeaderboardModel("5","Robert","1120 Points",R.drawable.robert);
        list.add(model3);
        LeaderboardModel model4= new LeaderboardModel("6","Soni","1119 Points",R.drawable.soni);
        list.add(model4);
        LeaderboardModel model5= new LeaderboardModel("7","Raina","1054 Points",R.drawable.raina);
        list.add(model5);
        LeaderboardModel model6= new LeaderboardModel("8","Gautam","1032 Points",R.drawable.gautam);
        list.add(model6);
        LeaderboardModel model7= new LeaderboardModel("9","Manjeet","1006 Points",R.drawable.manjeet);
        list.add(model7);
    }
}
