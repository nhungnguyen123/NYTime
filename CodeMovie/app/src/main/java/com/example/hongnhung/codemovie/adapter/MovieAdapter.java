package com.example.hongnhung.codemovie.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.hongnhung.codemovie.R;
import com.example.hongnhung.codemovie.model.Movie;
import com.google.gson.Gson;

import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by hongnhung on 2/18/17.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {

    private List<Movie> mMovies;
    private Context context;

    public ChoiceMovie choiceMovie;

    public ChoiceMovie getChoiceMovie() {
        return choiceMovie;
    }

    public void setChoiceMovie(ChoiceMovie choiceMovie) {
        this.choiceMovie = choiceMovie;
    }


    public MovieAdapter(Context context, List<Movie> movies) {
        super(context, -1);
        this.context = context;
        this.mMovies = movies;

    }


    @Override
    public int getCount() {
        if (mMovies == null) {
            return 0;
        } else {
            return mMovies.size();
        }
    }

    @Nullable
    @Override
    public Movie getItem(int position) {
        return mMovies.get(position);
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_movie, parent, false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            viewHolder.imCover = (ImageView) convertView.findViewById(R.id.ivCover);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Movie movie = getItem(position);
        viewHolder.tvDescription.setText(movie.getOverview());
        viewHolder.tvTitle.setText(movie.getTitle());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceMovie.SetMovie(getItem(position));

            }
        });

        Configuration configuration = getContext().getResources()
                .getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Glide.with(getContext())
                    .load(movie.getPosterPath())
                    .bitmapTransform(new RoundedCornersTransformation( context,30, 2))
//                    .bitmapTransform(new CenterCrop(context),new RoundedCornersTransformation( context,30, 2))
                    .placeholder(R.drawable.demo)
                    .animate(android.R.anim.slide_out_right)
                    .centerCrop()
                    .into(viewHolder.imCover);
        } else {
            Glide.with(getContext())
                    .load(movie.getBackdropPath())
                    .bitmapTransform(new RoundedCornersTransformation( context,30, 2))
                    .placeholder(R.drawable.demo)
                    .animate(android.R.anim.slide_out_right)
                    .centerCrop()
                    .into(viewHolder.imCover);
        }

        return convertView;
    }


    public class ViewHolder {
        public TextView tvTitle;
        public TextView tvDescription;
        public ImageView imCover;
    }

    public void clear() {
        mMovies.clear();
        notifyDataSetChanged();
    }

    // Add a list of items
    public void addAll(List<Movie> list) {
        mMovies.addAll(list);
        notifyDataSetChanged();
    }
}
