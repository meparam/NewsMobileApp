package com.tvcnews.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tvcnews.app.R;
import com.tvcnews.app.dialog.PlayVideo;
import com.tvcnews.app.model.StreamingItemsObject;

import java.util.List;

/**
 * Created by iFwAxTel on 13/01/2017.
 */
public class StreamingListAdapter extends RecyclerView.Adapter<StreamingListAdapter.StreamsHolder> {

    private LayoutInflater mInflater;
    private List<StreamingItemsObject> items;
    Context context;
    FragmentManager fm;
    Activity activity;

    public StreamingListAdapter(Context context, List<StreamingItemsObject> itemsList, FragmentManager frag,Activity _activity) {
        this.context = context;
        this.items = itemsList;
        mInflater = LayoutInflater.from(context);
        fm = frag;
        this.activity = _activity;
    }

    public StreamingItemsObject getItem(int position) {
        return items.get(position);
    }

    @Override
    public StreamsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = DataBindingUtil.inflate(mInflater, R.layout.item_streams, parent, false).getRoot();
        StreamsHolder holder = new StreamsHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(StreamsHolder holder, final int position) {
        StreamingItemsObject obj = items.get(position);

        //holder.dayText.setText(obj.getWeekDay());
        holder.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayVideo playVideo = new PlayVideo();
                playVideo.addContext(activity);
                playVideo.show(fm,"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class StreamsHolder extends RecyclerView.ViewHolder {

        TextView newsTitle,newsViews;
        ImageView newsImage,playButton;
        AppCompatCheckBox newsBookmark,newsLikes;

        public StreamsHolder(View v) {
            super(v);
            newsTitle = (TextView)v.findViewById(R.id.newsTitle);
            newsLikes = (AppCompatCheckBox)v.findViewById(R.id.newsLikes);
            newsViews = (TextView)v.findViewById(R.id.newsViews);
            newsImage = (ImageView) v.findViewById(R.id.newsImage);
            newsBookmark = (AppCompatCheckBox) v.findViewById(R.id.newsBookmark);
            playButton = (ImageView) v.findViewById(R.id.playButton);


        }
    }
}
