package com.example.geodezhelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);

        ViewPager viewPager =(ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar !=null){
            VectorDrawableCompat indicator = VectorDrawableCompat.create(getResources(), R.drawable.ic_menu, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(),R.color.white,getTheme()));
            supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

    }
    public void setupViewPager(ViewPager viewPager){
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new ListContentFragment(),"Нив. журнал");
        adapter.addFragment(new TileContentFragment(),"Нивелир");
        adapter.addFragment(new CardContentFragment(),"Точки");
        adapter.addFragment(new FragmentForBaseline(),"Базовая линия");
        viewPager.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        public Adapter(FragmentManager manager){
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFragment(Fragment fragment,String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
