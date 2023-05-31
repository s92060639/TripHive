package com.s92060639.triphive;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class toothRelic extends Fragment {

Button goToDistrictsFragmentBtn;

    public toothRelic() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tooth_relic, container, false);

        //        Go to Temple Of Tooth Relic
        goToDistrictsFragmentBtn = view.findViewById(R.id.mapbtn);
        goToDistrictsFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new toothRelicMap();
                FragmentTransaction transaction = getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.fram_layout, fragment)
                        .addToBackStack("name")
                        .commit();
            }

        });
        return view;
    }
}