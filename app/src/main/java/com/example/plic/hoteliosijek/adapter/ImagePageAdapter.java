package com.example.plic.hoteliosijek.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.plic.hoteliosijek.R;
import com.example.plic.hoteliosijek.app.AppController;
import com.navercorp.volleyextensions.view.TwoLevelDoubleTapZoomNetworkImageView;

import java.util.List;

public class ImagePageAdapter extends PagerAdapter {

    private Activity activity;
    private List<String> imagePaths;
    private LayoutInflater inflater;

    // constructor
    public ImagePageAdapter(Activity activity,
                                  List<String> imagePaths) {
        this.activity = activity;
        this.imagePaths = imagePaths;
    }

    @Override
    public int getCount() {
        return imagePaths.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        TwoLevelDoubleTapZoomNetworkImageView imgDisplay;

        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.fragment_image, container,
                false);
        viewLayout.setTag(position);

        imgDisplay = (TwoLevelDoubleTapZoomNetworkImageView) viewLayout.findViewById(R.id.imgDisplay);
        imgDisplay.setImageUrl(imagePaths.get(position), AppController.getInstance().getImageLoader());

        ((ViewPager) container).addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}
