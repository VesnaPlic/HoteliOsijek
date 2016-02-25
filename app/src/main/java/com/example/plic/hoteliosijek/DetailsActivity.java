package com.example.plic.hoteliosijek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RatingBar;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.plic.hoteliosijek.model.Accommodation;
import com.example.plic.hoteliosijek.adapter.GridViewImageAdapter;
import com.example.plic.hoteliosijek.app.AppController;
import com.example.plic.hoteliosijek.utils.RobotoBlackTextView;
import com.example.plic.hoteliosijek.utils.RobotoTextView;
import com.example.plic.hoteliosijek.utils.TypefaceSpan;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    private GridView gridView;
    private NetworkImageView image;
    private RobotoBlackTextView name;
    private RobotoTextView address,description;
    private RatingBar rating;
    private GridViewImageAdapter imageAdapter;
    private List<String> images;
    private Accommodation acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String jsonAccommodation="";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            jsonAccommodation = extras.getString("Accommodation");
        }
        acc = new Gson().fromJson(jsonAccommodation, Accommodation.class);

        SpannableString s = new SpannableString(acc.getName());
        s.setSpan(new TypefaceSpan(this, "MyriadPro-Regular.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        setTitle(s);

        image= (NetworkImageView) findViewById(R.id.accImg);
        image.setImageUrl(acc.getImage(), imageLoader);
        rating = (RatingBar) findViewById(R.id.accRatingBar);
        rating.setRating(acc.getRating());
        name=(RobotoBlackTextView) findViewById(R.id.accName);
        name.setText(acc.getName());
        address=(RobotoTextView) findViewById(R.id.accAddress);
        address.setText(acc.getAddress() + " \n" + acc.getCity());
        description = (RobotoTextView) findViewById(R.id.accDescription);
        description.setText(acc.getDescription());

        images = Arrays.asList(acc.getImages().split("[\\s,]+"));

        gridView = (GridView) findViewById(R.id.gridView);
        imageAdapter=new GridViewImageAdapter(this,images);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(DetailsActivity.this, FullScreenViewActivity.class);
                i.putExtra("images", acc.getImages());
                i.putExtra("position",position);
                startActivity(i);
            }
        });
    }

}
