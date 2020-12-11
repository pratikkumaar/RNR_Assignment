package com.rnr.assignment.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rnr.assignment.R;
import com.rnr.assignment.activties.MainActivity;
import com.rnr.assignment.adapters.HomeAdapter;
import com.rnr.assignment.models.HomeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private HomeAdapter adapter;
    private List<HomeModel> list= new ArrayList<>();
    private RecyclerView rvHome;
    private Context context;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MainActivity) Objects.requireNonNull(getActivity())).visibleNavigation();

        rvHome= view.findViewById(R.id.id_recycler_home);


        setUpRecycler(context);

        if (list!=null){
            list.clear();
            addData();
        }

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    private void setUpRecycler(Context context) {
        adapter = new HomeAdapter(context, list);
        GridLayoutManager manager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        rvHome.setLayoutManager(manager);
        rvHome.setAdapter(adapter);
    }

    private void addData(){
        HomeModel model= new HomeModel("Learn with RNR","Start Now \u2192",R.drawable.learn_with_rnr);
        list.add(model);
        HomeModel model2= new HomeModel("Videos","Watch Now \u2192",R.drawable.videos);
        list.add(model2);
        HomeModel model3= new HomeModel("Blog & Articles","Read Now \u2192",R.drawable.blogs_articles);
        list.add(model3);
        HomeModel model4= new HomeModel("Monthly Newsletter","Explore Now \u2192",R.drawable.news_letter);
        list.add(model4);
        HomeModel model5= new HomeModel("Announcements","Explore Now \u2192",R.drawable.announcements);
        list.add(model5);
        HomeModel model6= new HomeModel("Monthly Research","Explore Now \u2192",R.drawable.monthly_researches);
        list.add(model6);
    }
}
