package com.arba.rifki.kelon;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private CardView card1;
    private CardView card2;
    private CardView card3;
    private CardView card4;
    private CardView card5;
    private TextView shortname;
    private View myMainView;
    String username;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myMainView = inflater.inflate(R.layout.fragment_home, container, false);
        username = getActivity().getIntent().getExtras().getString("email");
        shortname = myMainView.findViewById(R.id.uname);
        card1 = myMainView.findViewById(R.id.card1);
        card2 = myMainView.findViewById(R.id.card2);
        card3 = myMainView.findViewById(R.id.card3);
        card4 = myMainView.findViewById(R.id.card4);
        card5 = myMainView.findViewById(R.id.card5);
        shortname.setText(username);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card1Intent = new Intent(getContext(), MapsActivity.class);
                startActivity(card1Intent);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card2Intent = new Intent(getContext(), MapsActivity.class);
                startActivity(card2Intent);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card3Intent = new Intent(getContext(), MapsActivity.class);
                startActivity(card3Intent);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card4Intent = new Intent(getContext(), MapsActivity.class);
                startActivity(card4Intent);
            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card5Intent = new Intent(getContext(), MapsActivity.class);
                startActivity(card5Intent);
            }
        });
        return myMainView;

    }

}
