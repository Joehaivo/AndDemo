package com.joehaivo.anddemo.zxing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.joehaivo.anddemo.R;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class ZxingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);

        ZXingLibrary.initDisplayOpinion(this);
    }
}
