package com.s92060639.triphive;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class centralPlaceFragment extends Fragment {

    Button goToDistrictsFragmentBtn;
    public centralPlaceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_central_place, container, false);

        //        Go to Central Province
        goToDistrictsFragmentBtn = view.findViewById(R.id.nuwaEliyaPl);
        goToDistrictsFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new NuwaraEliyaPlace();
                FragmentTransaction transaction = getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.fram_layout, fragment)
                        .addToBackStack("name")
                        .commit();
            }

        });

        //        Go to Kandy
        goToDistrictsFragmentBtn = view.findViewById(R.id.KandyPl);
        goToDistrictsFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new Kandy();
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