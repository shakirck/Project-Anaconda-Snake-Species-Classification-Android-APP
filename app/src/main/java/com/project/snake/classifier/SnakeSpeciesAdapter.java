package com.project.snake.classifier;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SnakeSpeciesAdapter extends ArrayAdapter<SnakeSpecies> {

    public SnakeSpeciesAdapter(@NonNull Context context, List<SnakeSpecies>  snakeSpecies) {
        super(context, 0,  snakeSpecies);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_listview, parent, false);
        }

        SnakeSpecies snakeclass = getItem(position);

        String lesion =  snakeclass.getSnakenType();
        TextView lesionTextView = (TextView) listItemView.findViewById(R.id.lesion);
        lesionTextView.setText(lesion);

        String probability =  snakeclass.getProbability();
        probability = probability + "%";
        TextView probabilityTextView = (TextView) listItemView.findViewById(R.id.probability);
        probabilityTextView.setText(probability);

        return listItemView;
    }
}