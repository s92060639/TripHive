package com.s92060639.triphive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {
    Button goToDistrictsFragmentBtn;
    Activity context;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();

        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        //        Go to Central Province
//        goToDistrictsFragmentBtn = view.findViewById(R.id.weather);
//        goToDistrictsFragmentBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Fragment fragment = new weatherFragment();
//                FragmentTransaction transaction = getActivity()
//                        .getSupportFragmentManager()
//                        .beginTransaction();
//                transaction.replace(R.id.fram_layout, fragment)
//                        .addToBackStack("name")
//                        .commit();
//            }
//
//        });
        return  view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Button btn = (Button) context.findViewById(R.id.weather);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TempActivity.class);
                startActivity(intent);
            }
        });

        Button btn1 = (Button) context.findViewById(R.id.login);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, welcomeActivity.class);
                startActivity(intent);
            }
        });

        Button btn2 = (Button) context.findViewById(R.id.LiveLoca);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LiveTrackActivity.class);
                startActivity(intent);
            }
        });
    }
}