package com.netflix.netflixdb.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.netflix.netflixdb.R;
import com.netflix.netflixdb.models.Movie;

import org.w3c.dom.Text;

import java.util.List;

public class MovieArrayAdapter extends ArrayAdapter<Movie>{
    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        Movie movie = getItem(position);

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);


        }
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.lvMovieImage);
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        return convertView;

    }
}
