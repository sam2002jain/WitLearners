package com.example.witlearners;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.witlearners.chaptertopics.topicactivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    CardView heading1;
    CardView heading2;

    CardView heading3;

    CardView heading4;
    CardView heading5;
    CardView heading6;





    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        heading1 = view.findViewById(R.id.heading1);
        heading2 = view.findViewById(R.id.heading2);
        heading3 = view.findViewById(R.id.heading3);
        heading4 = view.findViewById(R.id.heading4);
        heading5 = view.findViewById(R.id.heading5);
        heading6 = view.findViewById(R.id.heading6);



        heading1.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(), topicactivity.class);
            startActivity(intent);

        });
        heading2.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(),topicactivity.class);
            startActivity(intent);

        });
        heading3.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(),topicactivity.class);
            startActivity(intent);

        });
        heading4.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(),topicactivity.class);
            startActivity(intent);

        });
        heading5.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(),topicactivity.class);
            startActivity(intent);

        });
        heading6.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(),topicactivity.class);
            startActivity(intent);

        });
        return view;
    }
}