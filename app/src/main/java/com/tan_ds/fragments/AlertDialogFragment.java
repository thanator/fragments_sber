package com.tan_ds.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Tan-DS on 5/2/2017.
 */

public class AlertDialogFragment extends DialogFragment {


    private static final String ARG_TEXT = "text";

    public static AlertDialogFragment newInstance (String text){
        AlertDialogFragment fragment = new AlertDialogFragment();
        Bundle args = new Bundle();

        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(getArguments().getString(ARG_TEXT));
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        return builder.create();


    }
}
