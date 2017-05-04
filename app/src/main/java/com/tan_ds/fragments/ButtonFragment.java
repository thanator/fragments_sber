package com.tan_ds.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Tan-DS on 5/2/2017.
 */

public class ButtonFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View button = inflater.inflate(R.layout.button_fragment, container, false);
        button.setOnClickListener(this);
        return button;
    }

    @Override
    public void onClick(View v) {
        ((TestFragmentHost) getActivity()).changeText("qwer");
        }
    }
