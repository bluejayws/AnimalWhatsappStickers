package com.example.animalwhatsappstickers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {
    Context context;
    int[] imageArray;

    LayoutInflater layoutInf;

    public GridAdapter(Context context,  int[] imageArray) {
        this.context = context;
        this.imageArray = imageArray;
    }


    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    //i is position
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (layoutInf == null){
            layoutInf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(view == null){
            view = layoutInf.inflate(R.layout.grid_item, null);
        }

        ImageView imgView = view.findViewById(R.id.grid_image);

        imgView.setImageResource(imageArray[i]);

        return view;
    }
}
