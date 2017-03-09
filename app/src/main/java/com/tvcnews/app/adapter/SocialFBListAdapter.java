package com.tvcnews.app.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tvcnews.app.R;
import com.tvcnews.app.model.SocialItemsObject;

import java.util.List;

/**
 * Created by iFwAxTel on 13/01/2017.
 */
public class SocialFBListAdapter extends RecyclerView.Adapter<SocialFBListAdapter.SocialHolder> {

    private LayoutInflater mInflater;
    private List<SocialItemsObject> items;
    Context context;

    public SocialFBListAdapter(Context context, List<SocialItemsObject> itemsList) {
        this.context = context;
        this.items = itemsList;
        mInflater = LayoutInflater.from(context);
    }

    public SocialItemsObject getItem(int position) {
        return items.get(position);
    }

    @Override
    public SocialHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = DataBindingUtil.inflate(mInflater, R.layout.item_feed_fb, parent, false).getRoot();
        SocialHolder holder = new SocialHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(SocialHolder holder, final int position) {
        SocialItemsObject obj = items.get(position);

        //holder.dayText.setText(obj.getWeekDay());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class SocialHolder extends RecyclerView.ViewHolder {

        TextView newsTitle,newsContentMini,newsLikes,newsTime;
        ImageView newsImage,newsBookmark;

        public SocialHolder(View v) {
            super(v);
            newsTitle = (TextView)v.findViewById(R.id.newsTitle);
            newsContentMini = (TextView)v.findViewById(R.id.newsContentMini);
            newsLikes = (TextView)v.findViewById(R.id.newsLikes);
            newsTime = (TextView)v.findViewById(R.id.newsTime);
            newsImage = (ImageView) v.findViewById(R.id.newsImage);
            newsBookmark = (ImageView) v.findViewById(R.id.newsBookmark);


        }
    }
}
