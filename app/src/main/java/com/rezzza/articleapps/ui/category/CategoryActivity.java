package com.rezzza.articleapps.ui.category;

import android.annotation.SuppressLint;
import android.content.Intent;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rezzza.articleapps.entities.Category;
import com.rezzza.articleapps.R;
import com.rezzza.articleapps.ui.base.MyActivity;
import com.rezzza.articleapps.ui.source.SourceActivity;
import com.rezzza.articleapps.ui.view.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class CategoryActivity extends MyActivity {

    protected SearchView scvw_search;

    ArrayList<Category> listCategory = new ArrayList<>();
    protected CategoryAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.category_activity;
    }

    @Override
    protected void initLayout() {
        scvw_search = findViewById(R.id.scvw_search);
        scvw_search.create(getResources().getString(R.string.search_news));

        RecyclerView rcvw_category = findViewById(R.id.rcvw_category);
        rcvw_category.setLayoutManager(new GridLayoutManager(mActivity, 3));
        rcvw_category.setNestedScrollingEnabled(false);
        mAdapter = new CategoryAdapter(listCategory);
        rcvw_category.setAdapter(mAdapter);

        loadData();
    }

    @Override
    protected void initListener() {
        scvw_search.setOnActionListener(() -> startActivity(new Intent(mActivity, FindAllActivity.class)));

        mAdapter.setOnSelectedListener(data -> {
            Intent intent = new Intent(mActivity, SourceActivity.class);
            intent.putExtra("category", data);
            startActivity(intent);
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void loadData(){
        listCategory.addAll(Arrays.asList(Category.values()));
        mAdapter.notifyDataSetChanged();
    }

}
