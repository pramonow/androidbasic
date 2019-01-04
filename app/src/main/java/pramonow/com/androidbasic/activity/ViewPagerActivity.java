package pramonow.com.androidbasic.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

import pramonow.com.androidbasic.R;
import pramonow.com.androidbasic.fragment.SampleFragment;

public class ViewPagerActivity extends AppCompatActivity {

    FragmentStatePagerAdapter fragmentManager;
    ViewPager viewPager;
    TabLayout tabLayout;
    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);



        fragmentManager = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragmentList.get(i);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewPager.setAdapter(fragmentManager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        addTabFragment("asd", new SampleFragment());
        addTabFragment("def", new SampleFragment());
        addTabFragment("zxc", new SampleFragment());
        addTabFragment("iop", new SampleFragment());
        addTabFragment("jkl", new SampleFragment());
    }

    public void addTabFragment(String title, Fragment fragment)
    {
        tabLayout.addTab(tabLayout.newTab().setText(title));
        fragmentList.add(fragment);
        fragmentManager.notifyDataSetChanged();
    }

}
