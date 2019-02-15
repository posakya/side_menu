package com.cloud_verge.side_menu.model_class;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;


import com.cloud_verge.side_menu.R;

public class ReplaceFragment {

    Activity activity;

    public ReplaceFragment(Activity activity) {
        this.activity = activity;
    }

    public void replaceFragment(int pos,Fragment fragment){
        fragment = new Fragment();
        FragmentManager fragmentManager = ((FragmentActivity)activity).getSupportFragmentManager();

        switch (pos){
            case 0:
                fragmentManager.beginTransaction().replace(R.id.main_content,fragment).commit();
                break;
            case 1:

                fragmentManager.beginTransaction().replace(R.id.main_content,fragment).commit();
                break;


        }
    }
}
