package com.example.plic.hoteliosijek.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.plic.hoteliosijek.R;
import com.example.plic.hoteliosijek.app.AppController;

import java.util.List;

public class GridViewImageAdapter extends BaseAdapter {

    private Activity activity;
    private List<String> imageUrl;
    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    // constructor
    public GridViewImageAdapter(Activity activity, List<String> imageUrl) {
        this.activity = activity;
        this.imageUrl = imageUrl;
    }

    @Override
    public int getCount() {
        return imageUrl.size();
    }

    @Override
    public Object getItem(int position) {
        return imageUrl.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.grid_item, null);
        }

        NetworkImageView imageView = (NetworkImageView) convertView.findViewById(R.id.imageGrid);

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageUrl(imageUrl.get(position), imageLoader);

        return convertView;
    }

}
