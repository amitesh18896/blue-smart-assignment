package com.blusmart.assignment.utility;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentManagerUtil {
    public static final String TAG = FragmentManagerUtil.class.getSimpleName();

    private FragmentManagerUtil() {
        // TODO Auto-generated constructor stub
    }

    public static void replaceFragment(FragmentManager fm, int container, Fragment target, boolean backstack, String TAG) {
        // Insert the fragment by replacing any existing fragment
        fm.executePendingTransactions();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(container, target, TAG);
        if (backstack)
            fragmentTransaction.addToBackStack(TAG);
        fragmentTransaction.commit();
    }

    public static void addFragment(FragmentManager fm, int container, Fragment target, boolean backstack, String TAG) {

        // Insert the fragment by replacing any existing fragment
        fm.executePendingTransactions();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(container, target, TAG);
        //add to backstack only if backstack flag is true
        if (backstack)
            fragmentTransaction.addToBackStack(TAG);
        fragmentTransaction.commit();
    }

    private FragmentManagerUtil(FragmentManager fm, int container, Fragment target) {


        // Insert the fragment by replacing any existing fragment
        fm.executePendingTransactions();
        fm.beginTransaction()
                .replace(container, target)
                .addToBackStack(null)
                .commit();

    }

    public void changeFragmentWithExtra(FragmentManager fm, int container, Fragment target, Bundle bundle) {

        target.setArguments(bundle);
        // Insert the fragment by replacing any existing fragment
        fm.beginTransaction()
                .replace(container, target)
                .addToBackStack(null)
                .commit();
    }
}
