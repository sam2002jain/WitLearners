package com.example.witlearners.chaptertopics;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.witlearners.R;

public class topicAdapter extends BaseAdapter {

    String topicname[];

    public topicAdapter(String[] topicname, Context context) {
        this.topicname = topicname;
        this.context = context;
    }

    Context context;

    @Override
    public int getCount() {
        return topicname.length;
    }

    @Override
    public Object getItem(int position) {
        return topicname[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridview = convertView;
        LayoutInflater inflater;
        if(convertView==null){
            inflater = (LayoutInflater) context.getSystemService( context.LAYOUT_INFLATER_SERVICE);
            gridview = inflater.inflate(R.layout.custom_layout_item_topic,null);
        }

        TextView textView = gridview.findViewById(R.id.topic_text);
        textView.setText(topicname[position]);


        return gridview;
    }
}
