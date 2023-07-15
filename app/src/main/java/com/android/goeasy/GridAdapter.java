package com.android.goeasy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class GridAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> text ;
    ArrayList<Integer> image;

    public GridAdapter(Context context, ArrayList<String> text, ArrayList<Integer> image) {
        this.context = context;
        this.text = text;
        this.image = image;
    }

    @Override
    public int getCount() {
        return text.size();
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
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View view1 = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gridlayout,viewGroup,false);
        ImageView imageView = view1.findViewById(R.id.grid_imageView);
        TextView textView = view1.findViewById(R.id.grid_textView);
        imageView.setImageResource(image.get(i));
        textView.setText(text.get(i));
        return view1;
    }
}
