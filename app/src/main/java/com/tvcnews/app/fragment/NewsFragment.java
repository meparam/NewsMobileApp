package com.tvcnews.app.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tvcnews.app.R;
import com.tvcnews.app.activity.ViewNewsActivity;
import com.tvcnews.app.adapter.NewsListAdapter;
import com.tvcnews.app.model.NewsItemsObject;
import com.tvcnews.app.util.Divider;
import com.tvcnews.app.util.ItemClickSupport;

import java.util.ArrayList;

public class NewsFragment extends Fragment{

    private int page;
    private String title;

    RecyclerView recList;
    NewsListAdapter adapter;
    ArrayList array = new ArrayList();
    SwipeRefreshLayout swipeRefresh;


    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance(int page, String title) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        //args.putInt(VariableConstants.PAGE_NUMBER, page);
        //args.putString(VariableConstants.PAGE_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //page = getArguments().getInt(VariableConstants.PAGE_NUMBER, 0);
            //title = getArguments().getString(VariableConstants.PAGE_TITLE);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_news, container, false);
        recList = (RecyclerView)v.findViewById(R.id.recList);
        swipeRefresh = (SwipeRefreshLayout)v.findViewById(R.id.swipeRefresh);

        populateContent();
        adapter = new NewsListAdapter(getActivity(),array);
        recList.addItemDecoration(new Divider(getActivity(), LinearLayoutManager.VERTICAL));
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recList.setLayoutManager(llm);

        recList.setAdapter(adapter);

        ItemClickSupport.addTo(recList).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = new Intent(getActivity(), ViewNewsActivity.class);
                startActivity(intent);
            }
        });

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefresh.setRefreshing(false);
                Toast.makeText(getActivity(), "Page refreshed", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    private void populateContent(){
        for (int i = 0; i<10; i++){
            NewsItemsObject no = new NewsItemsObject();
            array.add(no);
        }
    }




    @Override
    public void onAttach(Activity a){
        super.onAttach(a);

    }

}
