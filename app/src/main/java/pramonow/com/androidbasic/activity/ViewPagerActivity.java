package pramonow.com.androidbasic.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
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

        //initialize fragment manager used to maintain each fragment in the tab layout
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

        //initialize the tab layout, tab layout acts like the view
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //Not Implemented
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //Not Implemented
            }
        });

        //initialize the view pager, view pager is used as data source for the tab layout
        viewPager.setAdapter(fragmentManager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        addTabFragment("Tab 1", new SampleFragment());
        addTabFragment("Tab 2", new SampleFragment());
        addTabFragment("Tab 3", new SampleFragment());
        addTabFragment("Tab 4", new SampleFragment());
        addTabFragment("Tab 5", new SampleFragment());
    }

    //Method for adding more tab in the layout
    public void addTabFragment(String title, Fragment fragment)
    {
        tabLayout.addTab(tabLayout.newTab().setText(title));
        fragmentList.add(fragment);
        fragmentManager.notifyDataSetChanged();
    }

}
