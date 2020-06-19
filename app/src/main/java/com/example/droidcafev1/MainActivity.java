package com.example.droidcafev1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        setSupportActionBar(toolbar);


        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label_1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label_2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label_3));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.view_pager);

        final PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
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

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String appUrl = "http://www.github.com/Righa/DroidCafeV1";
                switch (item.getItemId()) {
                    case R.id.option_pizza:
                        Toast.makeText(MainActivity.this, "soon you will see pizza when you click that", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.option_cocktails:
                        Toast.makeText(MainActivity.this, "soon you will see cocktails when you click that", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.option_pasta:
                        Toast.makeText(MainActivity.this, "soon you will see pasta when you click that", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.contact_us:
                        Intent callUs = new Intent(Intent.ACTION_DIAL);
                        callUs.setData(Uri.parse("*144#"));
                        startActivity(callUs);
                        break;

                    case R.id.about_us:
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(appUrl));
                        startActivity(i);
                        break;

                    case R.id.share_app:
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");
                        shareIntent.putExtra(Intent.EXTRA_TEXT, "Take a look at this app, " + appUrl);

                        Intent chooser = Intent.createChooser(shareIntent, "Share via");
                        if (shareIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(chooser);
                        }
                        break;

                    default:
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void toggleClicked(View view) {
        view.setBackgroundColor(getResources().getColor(R.color.bright_tab));
    }
}
