package com.tvcnews.app.adapter;

import android.app.TimePickerDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.tvcnews.app.R;
import com.tvcnews.app.model.NewsItemsObject;

import java.util.Calendar;
import java.util.List;

/**
 * Created by iFwAxTel on 13/01/2017.
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsHolder> {

    private LayoutInflater mInflater;
    private List<NewsItemsObject> items;
    Context context;

    public NewsListAdapter(Context context, List<NewsItemsObject> itemsList) {
        this.context = context;
        this.items = itemsList;
        mInflater = LayoutInflater.from(context);
    }

    public NewsItemsObject getItem(int position) {
        return items.get(position);
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = DataBindingUtil.inflate(mInflater, R.layout.item_news, parent, false).getRoot();
        NewsHolder holder = new NewsHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, final int position) {
        NewsItemsObject obj = items.get(position);

        if (obj.isChecked()){
            holder.newsBookmark.setChecked(true);
        }
        //holder.dayText.setText(obj.getWeekDay());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {

        TextView newsTitle,newsContentMini,newsViews;
        ImageView newsImage;
        AppCompatCheckBox newsBookmark,newsLikes;

        public NewsHolder(View v) {
            super(v);
            newsTitle = (TextView)v.findViewById(R.id.newsTitle);
            newsContentMini = (TextView)v.findViewById(R.id.newsContentMini);
            newsLikes = (AppCompatCheckBox)v.findViewById(R.id.newsLikes);
            newsViews = (TextView)v.findViewById(R.id.newsViews);
            newsImage = (ImageView) v.findViewById(R.id.newsImage);
            newsBookmark = (AppCompatCheckBox) v.findViewById(R.id.newsBookmark);


        }
    }
}
