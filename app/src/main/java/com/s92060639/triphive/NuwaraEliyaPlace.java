package com.s92060639.triphive;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class NuwaraEliyaPlace extends Fragment {

    Button goToNuwaraEliyaFragmentBtn;
    public NuwaraEliyaPlace() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nuwara_eliya_place, container, false);

        goToNuwaraEliyaFragmentBtn = view.findViewById(R.id.kandyLake);
        goToNuwaraEliyaFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new VictoriaParkFragment();
                FragmentTransaction transaction = getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.fram_layout, fragment)
                        .addToBackStack("name")
                        .commit();
            }

        });
//    got to tea
        goToNuwaraEliyaFragmentBtn = view.findViewById(R.id.toothRelic);
        goToNuwaraEliyaFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new PedroTeaEstateFragment();
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