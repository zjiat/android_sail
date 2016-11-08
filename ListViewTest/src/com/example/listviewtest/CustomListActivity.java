package com.example.listviewtest;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class CustomListActivity extends Activity {
	
	private List<Fruit> fruitLst = new ArrayList<Fruit>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initFruits();
		FruitAdapter adapter = new FruitAdapter(CustomListActivity.this, R.layout.fruit_item, fruitLst);
		ListView listView = (ListView)findViewById(R.id.list_view);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Fruit fruit = fruitLst.get(position);
				Toast.makeText(CustomListActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
			}			
		});
	}
	
	private void initFruits(){
		Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
		fruitLst.add(apple);
		Fruit banana = new Fruit("Apple", R.drawable.banana_pic);
		fruitLst.add(banana);
		Fruit orange = new Fruit("Apple", R.drawable.orange_pic);
		fruitLst.add(orange);
		Fruit watermelon = new Fruit("Apple", R.drawable.watermelon_pic);
		fruitLst.add(watermelon);
		Fruit pear = new Fruit("Apple", R.drawable.pear_pic);
		fruitLst.add(pear);
		Fruit grape = new Fruit("Apple", R.drawable.grape_pic);
		fruitLst.add(grape);
		Fruit pineapple = new Fruit("Apple", R.drawable.pineapple_pic);
		fruitLst.add(pineapple);
		Fruit strawberry = new Fruit("Apple", R.drawable.strawberry_pic);
		fruitLst.add(strawberry);
		Fruit cherry = new Fruit("Apple", R.drawable.cherry_pic);
		fruitLst.add(cherry);
		Fruit mango = new Fruit("Apple", R.drawable.mango_pic);
		fruitLst.add(mango);
	}
	
}
