package com.rnr.assignment.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rnr.assignment.R;
import com.rnr.assignment.activties.MainActivity;
import com.rnr.assignment.adapters.LearnWithRNRAdapter;
import com.rnr.assignment.models.LearnWithRNRModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class LearnWithRNRFragment extends Fragment {

    private Context context;
    private LearnWithRNRAdapter adapter;
    private List<LearnWithRNRModel> list = new ArrayList<>();
    private RecyclerView rvLearnWithRNR;

    public LearnWithRNRFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learn_with_r_n_r, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MainActivity) Objects.requireNonNull(getActivity())).hideNavigation();

        rvLearnWithRNR = view.findViewById(R.id.id_recycler_learn_with_rnr);

        setUpRecycler(context);
        if (list!=null){
            list.clear();
            addData();
        }

        view.findViewById(R.id.idBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                getFragmentManager().popBackStack();
            }
        });
    }

    private void setUpRecycler(Context context) {
        adapter = new LearnWithRNRAdapter(context, list);
        LinearLayoutManager manager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        rvLearnWithRNR.setLayoutManager(manager);
        rvLearnWithRNR.setAdapter(adapter);
    }

    private void addData() {
        LearnWithRNRModel model = new LearnWithRNRModel("Why Invest?", "Why you should invest in\nStock market?", R.drawable.invest);
        list.add(model);
        LearnWithRNRModel model2 = new LearnWithRNRModel("Basic of Stock Market.", "What you should know\nbefore investing?", R.drawable.stock_market);
        list.add(model2);
        LearnWithRNRModel model3 = new LearnWithRNRModel("Finding great companies.", "Where you should invest?", R.drawable.companies);
        list.add(model3);
        LearnWithRNRModel model4 = new LearnWithRNRModel("Your investing life.", "Everything you should know about \ninvesting.", R.drawable.grwoth_life);
        list.add(model4);
        LearnWithRNRModel model5 = new LearnWithRNRModel("Getting started.", "How you should start investing?", R.drawable.getting_started);
        list.add(model5);
}
}
