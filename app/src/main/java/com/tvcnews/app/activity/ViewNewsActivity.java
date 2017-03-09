package com.tvcnews.app.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tvcnews.app.R;

public class ViewNewsActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton fab;
    AppBarLayout appBarLayout;
    ImageView back, save;
    TextView tipView;

    RelativeLayout statusBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_news);

        appBarLayout = (AppBarLayout)findViewById(R.id.app_bar);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        back = (ImageView)findViewById(R.id.back);
        save = (ImageView)findViewById(R.id.save);
        tipView = (TextView)findViewById(R.id.tip_content);
        statusBar = (RelativeLayout)findViewById(R.id.statusBar);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);

        appBarLayout.addOnOffsetChangedListener(this);
        back.setOnClickListener(clickManager);
        save.setOnClickListener(clickManager);
        fab.setOnClickListener(clickManager);

        String some = "<body><h1>Heading Text</h1> <p>" +
                "This is just to show how we can use <strong>HTML</strong> formatted text in this view </p> " +
                "<img src=\"test.jpg\"/> " +
                "<blockquote>Example from <a href=\"www.facebook.com/team3\">Team 3</a></blockquote>" +
                "<img src=\"test.jpg\"/> " +
                "<blockquote>Example from <a href=\"www.facebook.com/team3\">Team 3</a></blockquote> " +
                "<p>This way we don't need to worry about organising images from the tips in our view" +
                " we can just organise the entire tip with html and pass it to the app and the app" +
                "will format it properly</p</body>";

        tipView.setText((Html.fromHtml(some,new ImageGetter(),null)));

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT){
            statusBar.setVisibility(View.VISIBLE);
        }

    }

    //We can use this class to append images to strings
    //this way we can use a single textview to parse the tip and all its images
    //this way we can use a single textview to parse the tip and all its images
    private void setContent(){
        Drawable[] drawables = new Drawable[2];
        drawables[0] = getResources().getDrawable(R.drawable.testimg);
        drawables[1] = getResources().getDrawable(R.drawable.testimg);

        SpannableStringBuilder ssb = new SpannableStringBuilder(getResources().getString(R.string.text_content));

        int len = ssb.length();

        for (int i = 0; i < ssb.length(); i++){
            if (Character.toString(ssb.charAt(i)).equals("=")){
                Drawable drawable = drawables[1];
                drawable.setBounds(0,0,400,400);
                //String newStr = drawable.toString()+"\n";

                //ssb.append(newStr);

                ImageSpan im = new ImageSpan(drawable,ImageSpan.ALIGN_BASELINE);
                ssb.setSpan(
                        im,
                        i,
                        i+len,
                        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                );
            }
            len += len -1;
        }
        tipView.setTransformationMethod(null);
        tipView.setText(ssb);

    }

    //this will handle saving the tip on the users device
    private void saveToDevice(){
        long id;
        String title;
        String coverPhoto;
        Spannable content;

        /*Realm mRealm = Realm.getDefaultInstance();
        mRealm.beginTransaction();
        TipsObjectClient tipClient = mRealm.createObject(TipsObjectClient.class);
        tipClient.setId();
        tipClient.setTitle(title);
        tipClient.setCoverphoto(coverPhoto);
        tipClient.setContent(content);
        mRealm.commitTransaction();*/


    }

    private class ImageGetter implements Html.ImageGetter{


        @Override
        public Drawable getDrawable(String source) {
            int id;
            if (source.equals("test.jpg")){
                id = R.drawable.testimg;
            }
            else{
                return null;
            }

            Drawable d = getResources().getDrawable(id);
            d.setBounds(0,0,400,400);

            return d;
        }
    }

    private View.OnClickListener clickManager = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.back:
                    finish();
                    break;
                case R.id.save:
                    Toast.makeText(getApplicationContext(), "Save Clicked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.fab:

                    break;
            }
        }
    };

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (Math.abs(verticalOffset)==appBarLayout.getTotalScrollRange()){
            //closed
            save.setVisibility(View.VISIBLE);
        }
        else if (verticalOffset == 0){
            //open
            save.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(Build.VERSION.SDK_INT>=21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
}
