package com.example.hongnhung.tytimeass.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.hongnhung.tytimeass.R;
import com.example.hongnhung.tytimeass.models.Article;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by hongnhung on 26/02/2017.
 */

public class ArticleAdapter extends RecyclerView.Adapter {

    public Context mContext;
    public List<Article> mListArticle;

    public ChoiceArticle choiceArticle;

    public ChoiceArticle getChoiceArticle() {
        return choiceArticle;
    }


    public void setChoiceArticle(ChoiceArticle choiceArticle) {
        this.choiceArticle = choiceArticle;
    }


    public void addArticle(List<Article> mListArticle) {
        int startPosition = mListArticle.size();
        mListArticle.addAll(mListArticle);
        notifyItemRangeInserted(startPosition, mListArticle.size());
    }

    public ArticleAdapter(Context mContext, List<Article> mListArticle) {
        this.mContext = mContext;
        this.mListArticle = mListArticle;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, null);
        return new ArticleHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Article article = mListArticle.get(position);
        ArticleHolder articleHolder = (ArticleHolder) holder;
        articleHolder.mTvHead.setText(article.getSnippet());
        articleHolder.mLnItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceArticle.Choice(getItem(position));
            }
        });

        Configuration configuration = mContext.getResources().getConfiguration();
        if (article.getListMultimedias() == null) {

        } else {

            if (article.getListMultimedias() == null) {


            } else {
                if (article.getListMultimedias().size() == 0) {

                } else {
                    if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                        Glide.with(mContext)
                                .load(article.getListMultimedias().get(0).getImageUrl())
//                                .bitmapTransform(new RoundedCornersTransformation(mContext, 30, 2))
                                .placeholder(R.drawable.no_image)
                                .animate(android.R.anim.slide_out_right)
                                .into(articleHolder.mImageArticle);
                    } else {
                        Glide.with(mContext)
                                .load(article.getListMultimedias().get(1).getImageUrl())
//                                .bitmapTransform(new RoundedCornersTransformation(mContext, 30, 2))
                                .placeholder(R.drawable.no_image)
                                .animate(android.R.anim.slide_out_right)
                                .into(articleHolder.mImageArticle);
                    }

                }

            }


        }


        Log.e("positionA", position+"");
        if (position == mListArticle.size() - 1 ) {
            choiceArticle.onLoadMore();
            Log.e("position", position + "");
        }

    }

    @Nullable
    public Article getItem(int position) {
        return mListArticle.get(position);
    }


    @Override
    public int getItemCount() {
        return mListArticle.size();
    }


}
