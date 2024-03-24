package com.example.witlearners.chaptertopics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.witlearners.R;

public class topicactivity2 extends AppCompatActivity {
    Toolbar toolbar;
    expandableheigthgridview gridView;

    String topicname[] = {"sam","Jain","asdasd","dsadsad","ads","ssadas"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topicactivity2);

        toolbar  = findViewById(R.id.toolbarPL);
        gridView= findViewById(R.id.topic_grid);
        gridView.setExpanded(true);

        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        topicAdapter adapter = new topicAdapter(topicname,topicactivity2.this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(topicactivity2.this,topicname[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}