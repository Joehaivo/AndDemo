package com.joehaivo.anddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.joehaivo.anddemo.zxing.ZxingActivity;
import com.joehaivo.anddemo.calculator.calcuActivity;
import com.joehaivo.anddemo.exRate.ExRateActivity;
import com.joehaivo.anddemo.contact.ContentActivity;
import com.joehaivo.anddemo.appChoose.AppChooseActivity;
import com.joehaivo.anddemo.musicPlayer.MusicPlayerActivity;
import com.joehaivo.anddemo.HWeather.HWeatherActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            //二维码
            Intent intent = new Intent(this, ZxingActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            //计算器
            Intent intent = new Intent(this, calcuActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
            //汇率
            Intent intent = new Intent();
            intent.setClass(this, ExRateActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {
            //联系人
            Intent intent = new Intent(this, ContentActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_appChoose) {
            //应用选择器
            Intent intent = new Intent(this, AppChooseActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_music_play) {
            //音乐播放器
            Intent intent = new Intent(this, MusicPlayerActivity.class);
            startActivity(intent);
        }else if (id == R.id.nav_HWeather) {
            //NoHttp
            Intent intent = new Intent(this, HWeatherActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
