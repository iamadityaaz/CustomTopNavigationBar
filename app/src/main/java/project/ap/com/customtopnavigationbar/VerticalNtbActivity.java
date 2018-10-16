package project.ap.com.customtopnavigationbar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import devlight.io.library.ntb.NavigationTabBar;

import java.util.ArrayList;

/**
 * Created by GIGAMOLE on 28.03.2016.
 */
public class VerticalNtbActivity extends AppCompatActivity {



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_ntb);
        initUI();
    }

    private void initUI() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.vp_vertical_ntb);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            /**
             * Return the number of views available.
             */
            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0: // Fragment # 0 - This will show FirstFragment

                        return new Fragment1st();
                    case 1: // Fragment # 1 - This will show SecondFragment

                        return new Fragment2nd();

                    default:
                        return new Fragment1st();
                }
            }
        });

        final String[] colors = getResources().getStringArray(R.array.vertical_ntb);

        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb_vertical);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_first),
                        Color.parseColor(colors[0]))
                        .title("ic_first")
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_second),
                        Color.parseColor(colors[1]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("ic_second")
                        .build()
        );

//        models.add(
//                new NavigationTabBar.Model.Builder(
//                        getResources().getDrawable(R.drawable.ic_third),
//                        Color.parseColor(colors[2]))
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
//                        .title("ic_third")
//                        .build()
//        );
//        models.add(
//                new NavigationTabBar.Model.Builder(
//                        getResources().getDrawable(R.drawable.ic_fourth),
//                        Color.parseColor(colors[3]))
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
//                        .title("ic_fourth")
//                        .build()
//        );
//        models.add(
//                new NavigationTabBar.Model.Builder(
//                        getResources().getDrawable(R.drawable.ic_fifth),
//                        Color.parseColor(colors[4]))
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
//                        .title("ic_fifth")
//                        .build()
//        );
//        models.add(
//                new NavigationTabBar.Model.Builder(
//                        getResources().getDrawable(R.drawable.ic_sixth),
//                        Color.parseColor(colors[5]))
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
//                        .title("ic_sixth")
//                        .build()
//        );
//        models.add(
//                new NavigationTabBar.Model.Builder(
//                        getResources().getDrawable(R.drawable.ic_seventh),
//                        Color.parseColor(colors[6]))
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
//                        .title("ic_seventh")
//                        .build()
//        );
//        models.add(
//                new NavigationTabBar.Model.Builder(
//                        getResources().getDrawable(R.drawable.ic_eighth),
//                        Color.parseColor(colors[7]))
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
//                        .title("ic_eighth")
//                        .build()
//        );

        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPager, 0);
    }
}
