package com.blusmart.assignment.utility;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * The Class Utils is a common class that hold many kind of different useful
 * utility methods.
 */
public class DialogUtils {
    public static final String TAG = DialogUtils.class.getSimpleName();
    private static final boolean show = false;

    /**
     * Show dialog.
     *
     * @param ctx       the ctx
     * @param title     the title
     * @param msg       the msg
     * @param resID     the layout resID
     * @param listener1 the listener1
     * @param listener2 the listener2
     * @return the alert dialog
     */
    public static AlertDialog showDialog(Context ctx, String title, String msg,
                                         int resID, DialogInterface.OnClickListener listener1,
                                         DialogInterface.OnClickListener listener2) {

        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        // ...Irrelevant code for customizing the buttons and title
        LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
        View dialogView = inflater.inflate(resID, null);
        builder.setView(dialogView)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton("done", listener1);
        if (listener2 != null)
            builder.setNegativeButton("cancle", listener2);


        AlertDialog alert = builder.create();

        alert.show();

        return alert;

    }

    /**
     * Show dialog.
     *
     * @param ctx       the ctx
     * @param msg       the msg
     * @param btn1      the btn1
     * @param btn2      the btn2
     * @param listener1 the listener1
     * @param listener2 the listener2
     * @return the alert dialog
     */
    private static AlertDialog showDialog(Context ctx, String msg, String btn1,
                                          String btn2, DialogInterface.OnClickListener listener1,
                                          DialogInterface.OnClickListener listener2) {

        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        // builder.setTitle(R.string.app_name);
        builder.setMessage(msg).setCancelable(false)
                .setPositiveButton(btn1, listener1);
        if (btn2 != null && listener2 != null)
            builder.setNegativeButton(btn2, listener2);

        AlertDialog alert = builder.create();

        alert.show();
        return alert;

    }


    /**
     * Show dialog.
     *
     * @param ctx       the ctx
     * @param msg       the msg
     * @param btn1      the btn1
     * @param btn2      the btn2
     * @param listener1 the listener1
     * @param listener2 the listener2
     * @return the alert dialog
     */
    public static AlertDialog showDialog(Context ctx, int msg, int btn1,
                                         int btn2, DialogInterface.OnClickListener listener1,
                                         DialogInterface.OnClickListener listener2) {

        return showDialog(ctx, ctx.getString(msg), ctx.getString(btn1),
                ctx.getString(btn2), listener1, listener2);

    }

    /**
     * Show dialog.
     *
     * @param ctx      the ctx
     * @param msg      the msg
     * @param btn1     the btn1
     * @param btn2     the btn2
     * @param listener the listener
     * @return the alert dialog
     */
    private static AlertDialog showDialog(Context ctx, String msg, String btn1,
                                          String btn2, DialogInterface.OnClickListener listener) {

        return showDialog(ctx, msg, btn1, btn2, listener,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });

    }


    /**
     * Show dialog.
     *
     * @param ctx      the ctx
     * @param msg      the msg
     * @param btn1     the btn1
     * @param btn2     the btn2
     * @param listener the listener
     * @return the alert dialog
     */
    public static AlertDialog showDialog(Context ctx, int msg, int btn1,
                                         int btn2, DialogInterface.OnClickListener listener) {

        return showDialog(ctx, ctx.getString(msg), ctx.getString(btn1),
                ctx.getString(btn2), listener);

    }

    /**
     * Show dialog.
     *
     * @param ctx      the ctx
     * @param msg      the msg
     * @param listener the listener
     * @return the alert dialog
     */
    public static AlertDialog showDialog(Context ctx, String msg,
                                         DialogInterface.OnClickListener listener) {

        return showDialog(ctx, msg, ctx.getString(android.R.string.ok), null,
                listener, null);
    }

    /**
     * Show dialog.
     *
     * @param ctx      the ctx
     * @param msg      the msg
     * @param listener the listener
     * @return the alert dialog
     */
    public static AlertDialog showDialog(Context ctx, int msg,
                                         DialogInterface.OnClickListener listener) {

        return showDialog(ctx, ctx.getString(msg),
                ctx.getString(android.R.string.ok), null, listener, null);
    }

    /**
     * Show dialog.
     *
     * @param ctx the ctx
     * @param msg the msg
     * @return the alert dialog
     */
    public static AlertDialog showDialog(Context ctx, String msg) {

        return showDialog(ctx, msg, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

                dialog.dismiss();
            }
        });

    }

    /**
     * Show dialog.
     *
     * @param ctx the ctx
     * @param msg the msg
     * @return the alert dialog
     */
    public static AlertDialog showDialog(Context ctx, int msg) {

        return showDialog(ctx, ctx.getString(msg));

    }

    /**
     * Show dialog.
     *
     * @param ctx   the ctx
     * @param title the title
     * @param resID the layoutID
     */
    public static void showDialog(Context ctx, String title, int resID) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(ctx);
        // ...Irrelevant code for customizing the buttons and title
        LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
        View dialogView = inflater.inflate(resID, null);
        dialogBuilder.setView(dialogView);

//		EditText editText = (EditText) dialogView.findViewById(R.id.label_field);
//		editText.setText("test label");
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.setTitle(title);
        alertDialog.show();
    }

    /**
     * Show dialog.
     *
     * @param ctx      the ctx
     * @param title    the title
     * @param msg      the msg
     * @param listener the listener
     */

    public static void showDialog(Context ctx, int title, int msg,
                                  DialogInterface.OnClickListener listener) {

        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setMessage(msg).setCancelable(false)
                .setPositiveButton(android.R.string.ok, listener);
        builder.setTitle(title);
        AlertDialog alert = builder.create();
        alert.show();
    }

    /**
     * Show dialog.
     *
     * @param ctx      the ctx
     * @param listener the listener
     */

    public static void showInternetCheckDialog(Context ctx,
                                               DialogInterface.OnClickListener listener) {

        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("Connection Failed")
                .setIcon(android.R.drawable.ic_delete)
                .setCancelable(true)
                .setMessage("You are not connected to internet check connection and retry").setCancelable(false)
                .setPositiveButton("Retry", listener);

        AlertDialog alert = builder.create();
        alert.show();
    }

    /**
     * Hide keyboard.
     *
     * @param ctx the ctx
     */
    public static final void hideKeyboard(Activity ctx) {

        if (ctx.getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) ctx
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(ctx.getCurrentFocus().getWindowToken(),
                    0);
        }
    }

    /**
     * Hide keyboard.
     *
     * @param ctx the ctx
     * @param v   the v
     */
    public static final void hideKeyboard(Activity ctx, View v) {

        try {
            InputMethodManager imm = (InputMethodManager) ctx
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AlertDialog showTestDialog(Context ctx, String msg) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        // builder.setTitle(R.string.app_name);
        builder.setMessage(msg)
                .setTitle("TESTING DIALOG")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(true);
        AlertDialog alert = builder.create();
        if (show)
            alert.show();
        return alert;

    }

    public static AlertDialog showAmenitiesAddDialog(Context ctx, String msg, DialogInterface.OnClickListener listener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        // builder.setTitle(R.string.app_name);
        builder.setMessage(msg)
                .setTitle("ADD AMENITIES DETAIL")
                .setPositiveButton("ADD", listener)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        if (show)
            alert.show();
        return alert;

    }


}
