package com.project.snake.classifier;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private SnakeSpeciesAdapter mAdapter;
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Detection Result");

        Intent intent = getIntent();
        List<SnakeSpecies>  snakeSpecies = (ArrayList<SnakeSpecies>) intent.getSerializableExtra(" snakeSpecies");

        ListView snakeSpeciesListView = (ListView) findViewById(R.id.list);
        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.listview_header, snakeSpeciesListView, false);
        snakeSpeciesListView.addHeaderView(header, null, false);
        snakeSpeciesListView.setEmptyView(mEmptyStateTextView);
        mAdapter = new SnakeSpeciesAdapter(this, new ArrayList<SnakeSpecies>());
        snakeSpeciesListView.setAdapter(mAdapter);

        mAdapter.addAll( snakeSpecies);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

}