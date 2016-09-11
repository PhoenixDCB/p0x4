package com.glacial.p0x4.general;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

/**
 * Created by dacuesta on 11/9/16.
 */
public class DialogManager {

    private static AlertDialog dialog;

    public static void showDialog(Context context, String title, String body, String button, @Nullable DialogInterface.OnClickListener listener) {
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

}
