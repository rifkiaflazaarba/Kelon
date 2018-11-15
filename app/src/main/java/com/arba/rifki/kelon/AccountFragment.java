package com.arba.rifki.kelon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    private TextView uname;
    private View myMainView;
    String username;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myMainView = inflater.inflate(R.layout.fragment_account, container, false);
        username = getActivity().getIntent().getExtras().getString("username");
        uname = myMainView.findViewById(R.id.textView);
        uname.setText(username);
        return myMainView;
    }

}
