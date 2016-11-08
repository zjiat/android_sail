package com.example.listviewtest;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit> {

	private int resourceId;
	
	public FruitAdapter(Context context, int textViewResourceId, 
			List<Fruit> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//先获取数据结构
		Fruit fruit = getItem(position);
		//优化list显示
		View view;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		}else {
			view = convertView;
		}
		
//		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		ImageView  fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
		TextView fruitname = (TextView)view.findViewById(R.id.fruit_name);
		fruitImage.setImageResource(fruit.getImageId());
		fruitname.setText(fruit.getName());
		return view;
	}

	
	
}
