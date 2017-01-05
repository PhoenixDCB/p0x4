package com.glacial.p0x4.general;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by dacuesta on 11/9/16.
 */
public class DialogManager {

    private static AlertDialog dialog;

    public static void showDialog(Context context, String title, String body, String button, DialogInterface.OnClickListener listener) {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }

        if (listener == null) {
            listener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            };
        }

        dialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(body)
                .setPositiveButton(button, listener)
                .show();
    }

    public static void showDialog(Context context, String title, String body, String firstButtonStr, String secondButtonStr, DialogInterface.OnClickListener firstButtonListener, DialogInterface.OnClickListener secondButtonListener) {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }

        if (firstButtonListener == null) {
            firstButtonListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            };
        }

        if (secondButtonListener == null) {
            secondButtonListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            };
        }

        dialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(body)
                .setPositiveButton(firstButtonStr, firstButtonListener)
                .setNegativeButton(secondButtonStr, secondButtonListener)
                .show();
    }



}
