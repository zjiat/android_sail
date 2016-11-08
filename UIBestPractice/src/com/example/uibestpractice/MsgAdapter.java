package com.example.uibestpractice;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgAdapter extends ArrayAdapter<Msg> {

	private int resourceId;

	public MsgAdapter(Context context, int resource, List<Msg> objects) {
		super(context, resource, objects);
		resourceId = resource;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Msg msg = getItem(position);
		View view;
		ViewHolder viewholder;
		
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			//viewholder进行备份
			viewholder = new ViewHolder();
			viewholder.leftLayout = (LinearLayout)view.findViewById(R.id.left_layout);
			viewholder.rightLayout = (LinearLayout)view.findViewById(R.id.right_layout);
			viewholder.leftMsg = (TextView)view.findViewById(R.id.left_msg);
			viewholder.rightMsg = (TextView)view.findViewById(R.id.right_msg);
			view.setTag(viewholder);
		}else {
			view = convertView;
			viewholder = (ViewHolder)view.getTag();
		}
		
		if (msg.getType() == Msg.TYPE_RECEIVED) {
			viewholder.leftLayout.setVisibility(view.VISIBLE);
			viewholder.rightLayout.setVisibility(view.GONE);
			viewholder.leftMsg.setText(msg.getContent());
		}else if (msg.getType() == Msg.TYPE_SEND) {
			viewholder.leftLayout.setVisibility(view.GONE);
			viewholder.rightLayout.setVisibility(view.VISIBLE);
			viewholder.rightMsg.setText(msg.getContent());
		}
		
		return view;
	}
	
	class ViewHolder{
		LinearLayout leftLayout;
		LinearLayout rightLayout;
		TextView leftMsg;
		TextView rightMsg;
	}

}
