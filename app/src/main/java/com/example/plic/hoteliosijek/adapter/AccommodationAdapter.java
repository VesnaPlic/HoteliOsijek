package com.example.plic.hoteliosijek.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.plic.hoteliosijek.model.Accommodation;
import com.example.plic.hoteliosijek.R;
import com.example.plic.hoteliosijek.app.AppController;
import com.example.plic.hoteliosijek.utils.RobotoBlackTextView;
import com.example.plic.hoteliosijek.utils.RobotoTextView;

import java.util.List;

public class AccommodationAdapter extends BaseAdapter{

    private Activity activity;
    private LayoutInflater inflater;
    private List<Accommodation> accItems;
    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    // constructor
    public AccommodationAdapter(Activity activity, List<Accommodation> accItems) {
        this.activity=activity;
        this.accItems=accItems;
    }

    @Override
    public int getCount() {
        return accItems.size();
    }

    @Override
    public Object getItem(int position) {
        return accItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.acc_row, parent, false);
        }
        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        Accommodation item = accItems.get(position);

        RobotoBlackTextView name=(RobotoBlackTextView) convertView.findViewById(R.id.acc_name);
        RobotoTextView address=(RobotoTextView) convertView.findViewById(R.id.acc_address);
        NetworkImageView image = (NetworkImageView) convertView.findViewById(R.id.acc_img);

        name.setText(item.getName());
        address.setText(item.getAddress()+" \n" + item.getCity());
        image.setImageUrl(item.getImage(), imageLoader);

        return convertView;
    }
}
