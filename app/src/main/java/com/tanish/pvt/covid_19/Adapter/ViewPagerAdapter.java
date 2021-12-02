package com.tanish.pvt.covid_19.Adapter;

import  android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.airbnb.lottie.LottieAnimationView;
import com.tanish.pvt.covid_19.R;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;

    //array of images
    public String[] slide_images={

            "cvid.json",

            "stayhome.json",

            "mask.json",

            "wash.json"


    };


    int[] headings = {

            R.string.heading_one,
            R.string.heading_two,
            R.string.heading_three,
            R.string.heading_fourth
    };

    int[] description = {

      R.string.desc_one,
      R.string.desc_two,
      R.string.desc_three,
      R.string.desc_fourth
    };

    public ViewPagerAdapter(Context context){

        this.context = context;

    }

    @Override
    public int getCount() {
        return  headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);

        LottieAnimationView slidetitleimage= view.findViewById(R.id.intro_img);

//        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.titleImage);
        TextView slideHeading = view.findViewById(R.id.texttitle);
        TextView slideDesciption = view.findViewById(R.id.textdeccription);

        slidetitleimage.setAnimation(slide_images[position]);
        slideHeading.setText(headings[position]);
        slideDesciption.setText(description[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);

    }
}
