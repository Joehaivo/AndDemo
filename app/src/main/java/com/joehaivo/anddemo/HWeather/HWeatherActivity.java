package com.joehaivo.anddemo.HWeather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;

import com.google.gson.Gson;
import com.joehaivo.anddemo.R;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.AsyncRequestExecutor;
import com.yanzhenjie.nohttp.rest.JsonObjectRequest;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Response;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class HWeatherActivity extends AppCompatActivity implements TencentLocationListener{
    private String TAG;
    String cityName;
    StringBuilder urlWeather;
    GifDrawable gifFromResource;
    MediaController mc;
    GifImageView gifView;
    TencentLocationRequest tencentLocationRequest;
    TencentLocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hweather);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        gifView = (GifImageView)findViewById(R.id.gifImageView);
        setSupportActionBar(toolbar);
        TAG = "LogD";

        //Nohttp
        NoHttp.initialize(this);

        //和风天气API
        urlWeather = new StringBuilder("https://free-api.heweather.com/v5/forecast?city=");
//                https://free-api.heweather.com/v5/forecast?city=北京市&key=bbeef92e1fe94133b1c298024e7629f5


        //GifDraw
        try {
            gifFromResource = new GifDrawable( getResources(), R.drawable.androidifyone);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mc = new MediaController(this);
        mc.setMediaPlayer(gifFromResource);

        //TencentLoc
        tencentLocationRequest = TencentLocationRequest.create();
        tencentLocationRequest.setRequestLevel(3);
        locationManager = TencentLocationManager.getInstance(getApplicationContext());
        int error = locationManager.requestLocationUpdates(tencentLocationRequest, this);
        Log.d(TAG, "onCreate: "+error);
    }

    public void btnGETClick(View view){
        JsonObjectRequest request = new JsonObjectRequest(urlWeather.toString());
        AsyncRequestExecutor.INSTANCE.execute(0, request, new OnResponseListener<JSONObject>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, Response<JSONObject> response) {
                Gson gson = new Gson();
                HeBean heBean = gson.fromJson(response.get().toString(),HeBean.class);
                List<HeBean.HeWeather5Bean> heWeather5List = heBean.getHeWeather5();
                HeBean.HeWeather5Bean he5Bean = heWeather5List.get(0);
                List<HeBean.HeWeather5Bean.DailyForecastBean> dailyBean = he5Bean.getDaily_forecast();
                HeBean.HeWeather5Bean.DailyForecastBean daily = dailyBean.get(1);
                HeBean.HeWeather5Bean.DailyForecastBean.TmpBean tmp = daily.getTmp();
                HeBean.HeWeather5Bean.DailyForecastBean.CondBean cond = daily.getCond();
                Toast.makeText(HWeatherActivity.this,"明日天气:"+cond.getTxt_d()+", "+tmp.getMin()+" - "+tmp.getMax()+"℃",Toast.LENGTH_LONG).show();
                mc.show();
                gifView.setImageResource(R.drawable.androidifyone);
                gifFromResource.start();

            }

            @Override
            public void onFailed(int what, Response<JSONObject> response) {

            }

            @Override
            public void onFinish(int what) {

            }
        });
    }

    @Override
    public void onLocationChanged(TencentLocation tencentLocation, int i, String s) {
        if (TencentLocation.ERROR_OK == i) {
            // 定位成功
            String city = tencentLocation.getCity();
            Toast.makeText(HWeatherActivity.this,"位置："+city,Toast.LENGTH_LONG).show();
            cityName = city;
            urlWeather.append(cityName);
            urlWeather.append("&key=bbeef92e1fe94133b1c298024e7629f5");
            locationManager.removeUpdates(this);
        } else {
            // 定位失败
        }
    }

    @Override
    public void onStatusUpdate(String s, int i, String s1) {

    }
}
