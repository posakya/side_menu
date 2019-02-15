package com.cloud_verge.side_menu.model_class;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.cloud_verge.side_menu.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.INPUT_METHOD_SERVICE;


public class SideMenu {

    ReplaceFragment replaceFragment;
    private List<ItemSlideMenu> listSliding;
    public static final int[] image={};
    public static final String[] menus={};

    Context context;

    public SideMenu(Context context) {
        this.context = context;
    }


    public void setSideMenu(final ListView listViewSliding, final DrawerLayout drawerLayout, final RelativeLayout mainView, final RelativeLayout drawerView, ActionBarDrawerToggle toggle, Toolbar toolbar, ImageView drawer_image, final Fragment fragment){

        listSliding = new ArrayList<>();

        replaceFragment = new ReplaceFragment((Activity) context);

        for (int i=0; i<image.length; i++){
            ItemSlideMenu itemSlideMenu = new ItemSlideMenu();
            itemSlideMenu.setImgId(image[i]);
            itemSlideMenu.setTitle(menus[i]);
            listSliding.add(itemSlideMenu);
        }

        SlidingMenuAdapter adapter = new SlidingMenuAdapter(context, listSliding);
        listViewSliding.setAdapter(adapter);

        //Set title
        ((Activity) context).setTitle(listSliding.get(0).getTitle());
        //item selected
        listViewSliding.setItemChecked(0, true);
        //Close menu
        drawerLayout.closeDrawer(drawerView);

        //remove shadow from drawer

        drawerLayout.setScrimColor(context.getResources().getColor(android.R.color.transparent));

        //Display fragment 1 when start
        replaceFragment.replaceFragment(0,fragment);
        //Hanlde on item click

//        listViewSliding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                //Set title
//                ((Activity) context).setTitle(listSliding.get(position).getTitle());
//
//                //item selected
//                listViewSliding.setItemChecked(position, true);
//
//                //Replace fragment
//                replaceFragment.replaceFragments(position);
//
//                //Close menu
//                drawerLayout.closeDrawer(drawerView);
//
//                try {
//                    InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(), 0);
//                } catch (Exception e) {
//                    // TODO: handle exception
//                }
//            }
//        });
//

        toggle = new ActionBarDrawerToggle(((Activity) context),drawerLayout,toolbar, R.string.drawer_opened, R.string.drawer_closed){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                ((Activity) context).invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                mainView.setTranslationX(slideOffset * drawerView.getWidth());

                drawerLayout.bringChildToFront(drawerView);

                drawerLayout.requestLayout();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                ((Activity) context).invalidateOptionsMenu();
            }
        };

        drawerLayout.setDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        drawer_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {

                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);

                }
            }
        });
    }

}
