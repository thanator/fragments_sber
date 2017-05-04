package com.tan_ds.fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Tan-DS on 5/2/2017.
 */

public class TestFragment extends Fragment {

    private static final String ARG_TEXT = "text";
    private int onCountCreate = 0;

    public static TestFragment newInstance (String text){
        TestFragment fragment = new TestFragment();
        Bundle args = new Bundle();

        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }


    public void setText(String text){
        ((TextView)getView()).setText(text);
        getArguments().putString(ARG_TEXT, text);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        onCountCreate++;
        TextView view = (TextView) inflater.inflate(R.layout.test_fragment, container, false);
        String text = getArguments().getString(ARG_TEXT);
        view.setText(text + " " + Integer.toString(onCountCreate));
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_in_fragment:

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(R.string.mssg_string_dialog);
                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();


                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // для вывода только одной штуки
       if (TextUtils.isEmpty(getTag())){
            return;
        }

        inflater.inflate(R.menu.fragment_menu, menu);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true); // для счётчика. тип он нормально, увеличивается при каждом пересоздании.
    }
}
