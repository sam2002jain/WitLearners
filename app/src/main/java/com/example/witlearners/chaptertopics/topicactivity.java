package com.example.witlearners.chaptertopics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.witlearners.R;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;

public class topicactivity extends AppCompatActivity {
    Toolbar toolbar;
    expandableheigthgridview gridView;

    String message = "hello sanyam";

    String topicname[] = {"Java", "Python", "Javascript", "C++", "C", "C#"};
    private StorageReference storageReference;
    private HashMap<String, String> chapterToPDFMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topicactivity);

        toolbar = findViewById(R.id.toolbarPL);
        gridView = findViewById(R.id.topic_grid);
        gridView.setExpanded(true);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        storageReference = FirebaseStorage.getInstance().getReference();
        initializeChapterToPDFMap();

        topicAdapter adapter = new topicAdapter(topicname, topicactivity.this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String pdfFileName = getFileNameForChapter(topicname[position]);
                if (pdfFileName != null) {
                    openPDF(pdfFileName);
                } else {
                    Toast.makeText(topicactivity.this, "PDF file not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initializeChapterToPDFMap() {
        // Initialize your map with chapter name to PDF file name mappings
        // For example:
        chapterToPDFMap = new HashMap<>();
        chapterToPDFMap.put("Java", "OS_Full_Notes.pdf");
        chapterToPDFMap.put("Python", "Unit - 5 Notes.pdf");
        // Add mappings for other chapters
    }

    private String getFileNameForChapter(String chapterName) {
        // Returns the PDF file name corresponding to the chapter name
        return chapterToPDFMap.get(chapterName);
    }

    private void openPDF(String fileName) {
        storageReference.child(fileName).getDownloadUrl().addOnSuccessListener(uri -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            Log.e(message,"pdf is opening rn");
        }).addOnFailureListener(exception -> {
            // Handle any errors
            Toast.makeText(topicactivity.this, "Failed to open PDF", Toast.LENGTH_SHORT).show();
        });
    }
}
