package com.tvcnews.app.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tvcnews.app.R;
import com.tvcnews.app.model.ScheduleObject;

import java.util.List;

/**
 * Created by iFwAxTel on 13/01/2017.
 */
public class ScheduleListAdapter extends RecyclerView.Adapter<ScheduleListAdapter.ProgrammeHolder> {

    private LayoutInflater mInflater;
    private List<ScheduleObject> items;
    Context context;

    public ScheduleListAdapter(Context context, List<ScheduleObject> itemsList) {
        this.context = context;
        this.items = itemsList;
        mInflater = LayoutInflater.from(context);
    }

    public ScheduleObject getItem(int position) {
        return items.get(position);
    }

    @Override
    public ProgrammeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = DataBindingUtil.inflate(mInflater, R.layout.item_programme, parent, false).getRoot();
        ProgrammeHolder holder = new ProgrammeHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ProgrammeHolder holder, final int position) {
        ScheduleObject obj = items.get(position);

        holder.programmeTitle.setText(obj.getTitle());
        holder.programmeAnchor.setText(obj.getAnchor());
        holder.newsImage.setImageDrawable(obj.getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ProgrammeHolder extends RecyclerView.ViewHolder {

        TextView programmeTitle,programmeAnchor,programmeTime;
        ImageView newsImage;

        public ProgrammeHolder(View v) {
            super(v);
            programmeTitle = (TextView)v.findViewById(R.id.programmeTitle);
            programmeAnchor = (TextView)v.findViewById(R.id.programmeAnchor);
            programmeTime = (TextView)v.findViewById(R.id.programmeTime);
            newsImage = (ImageView) v.findViewById(R.id.newsImage);


        }
    }
}
