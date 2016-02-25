package com.example.plic.hoteliosijek;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.plic.hoteliosijek.adapter.ImagePageAdapter;

import java.util.Arrays;
import java.util.List;

public class FullScreenViewActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private List<String> imageList;
    private Integer data=0;
    private Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_view);

        String images = getIntent().getExtras().getString("images");
        imageList = Arrays.asList(images.split("[\\s,]+"));
        data=getIntent().getExtras().getInt("position");

        viewPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ImagePageAdapter(FullScreenViewActivity.this,imageList);
        viewPager.setAdapter(pagerAdapter);

        viewPager.post(new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem(data, false);
            }
        });

        btnClose = (Button) findViewById(R.id.btnClose);

        // close button click event
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
