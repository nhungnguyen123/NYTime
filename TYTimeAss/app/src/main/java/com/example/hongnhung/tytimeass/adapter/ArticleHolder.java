package com.example.hongnhung.tytimeass.adapter;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hongnhung.tytimeass.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hongnhung on 26/02/2017.
 */

public class ArticleHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.tv_head)
    TextView mTvHead;

    @Bind(R.id.img_article)
    ImageView mImageArticle;

    @Bind(R.id.ln_item_article)
    LinearLayout mLnItem;


    public ArticleHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
