package com.example.witlearners.chaptertopics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.witlearners.R;

public class topicactivity extends AppCompatActivity {
    Toolbar toolbar;
    expandableheigthgridview gridView;

    String topicname[] = {"sanyam","Jain","asdasd","dsadsad","ads","ssadas"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topicactivity);

        toolbar  = findViewById(R.id.toolbarPL);
        gridView= findViewById(R.id.topic_grid);
        gridView.setExpanded(true);

        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        topicAdapter adapter = new topicAdapter(topicname,topicactivity.this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(topicactivity.this,topicname[position],Toast.LENGTH_SHORT).show();
                
            }
        });
    }
}