package com.joehaivo.anddemo.exRate;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.joehaivo.anddemo.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

//import javax.net.ssl.HttpsURLConnection;

public class ExRateActivity extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;
    String currency1;
    String currency2;
    TextView textView1;
    TextView textView2;
    boolean isDotClicked;
    boolean isText1Clicked;
    boolean isText2Clicked;
    Double text1num;
    Double text2Num;
    Double RMB_TO_USA;
    Double RMB_TO_JP;
    Double RMB_TO_KRW;
    final Double RMB_TO_EUR = 0.128559;
    final Double RMB_TO_GBP = 0.118220;
    HttpURLConnection urlConnection;
    String address;
    MyReceiver myReceiver;
    @Override
    protected void onResume() {
        super.onResume();
        //注册广播接收器
        if (myReceiver == null) {
            myReceiver = new MyReceiver();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(myReceiver, filter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_rate);

        spinner1 = (Spinner) findViewById(R.id.spinner2);
        spinner2 = (Spinner) findViewById(R.id.spinner3);
        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        isText1Clicked = true;
        isText2Clicked = false;
        RMB_TO_USA = 0.15316;
        RMB_TO_JP =  16.7305;
        RMB_TO_KRW = 172.935;
        address = "https://query.yahooapis.com/v1/public/yql?q=" +
                "select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20" +
                "(%22CNYUSD%22%2C%22CNYJPY%22%2C%22CNYKRW%22)" +
                "&format=json&diagnostics=true&env=store" +
                "%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";
        // http协议 雅虎APi GSon
//        urlConnection =
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] currencys1 = getResources().getStringArray(R.array.currency_CN);
                currency1 = currencys1[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] currencys2 = getResources().getStringArray(R.array.currency);
                currency2 = currencys2[i];
                ECBtnClick(spinner2.findFocus());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //广播接收器

    }

    public void numBtnClick(View v) {
        if (isText1Clicked) {
            switch (v.getId()) {
                case R.id.btnE0:
                    textView1.append("0");
                    break;
                case R.id.btnE1:
                    textView1.append("1");
                    break;
                case R.id.btnE2:
                    textView1.append("2");
                    break;
                case R.id.button23:
                    textView1.append("3");
                    break;
                case R.id.button24:
                    textView1.append("4");
                    break;
                case R.id.button25:
                    textView1.append("5");
                    break;
                case R.id.button26:
                    textView1.append("6");
                    break;
                case R.id.button27:
                    textView1.append("7");
                    break;
                case R.id.button28:
                    textView1.append("8");
                    break;
                case R.id.button29:
                    textView1.append("9");
                    break;
                case R.id.button2Dot:
                    if (!isDotClicked) {
                        textView1.append(".");
                        isDotClicked = true;
                    }
                    break;
            }
        } else if (isText2Clicked) {
            switch (v.getId()) {
                case R.id.btnE0:
                    textView2.append("0");
                    break;
                case R.id.btnE1:
                    textView2.append("1");
                    break;
                case R.id.btnE2:
                    textView2.append("2");
                    break;
                case R.id.button23:
                    textView2.append("3");
                    break;
                case R.id.button24:
                    textView2.append("4");
                    break;
                case R.id.button25:
                    textView2.append("5");
                    break;
                case R.id.button26:
                    textView2.append("6");
                    break;
                case R.id.button27:
                    textView2.append("7");
                    break;
                case R.id.button28:
                    textView2.append("8");
                    break;
                case R.id.button29:
                    textView2.append("9");
                    break;
                case R.id.button2Dot:
                    if (!isDotClicked) {
                        textView2.append(".");
                        isDotClicked = true;
                    }
                    break;
            }
        }

    }

    public void text1Click(View v) {
        isText1Clicked = true;
        isText2Clicked = false;
    }

    public void text2Click(View v) {
        isText2Clicked = true;
        isText1Clicked = false;
    }

    public void ECBtnClick(View v) {
        isText1Clicked = true;
        isText2Clicked = false;
        textView1.setText("");
        textView2.setText("");
    }

    public void equal2BtnClick(View v) {
        if (!textView1.getText().toString().equals("") && !textView1.getText().toString().equals(".")) {
            text1num = Double.valueOf(textView1.getText().toString());
            if (currency1.equals(currency2)) {
                text2Num = text1num;
            } else if (currency1.equals("人民币") && currency2.equals("美元")) {
                text2Num = text1num * RMB_TO_USA;
            } else if (currency1.equals("人民币") && currency2.equals("日元")) {
                text2Num = text1num * RMB_TO_JP;
            } else if (currency1.equals("人民币") && currency2.equals("韩元")) {
                text2Num = text1num * RMB_TO_KRW;
            } else if (currency1.equals("人民币") && currency2.equals("欧元")) {
                text2Num = text1num * RMB_TO_EUR;
            } else if (currency1.equals("人民币") && currency2.equals("英镑")) {
                text2Num = text1num * RMB_TO_GBP;
            }
            textView2.setText(text2Num.toString());
        } else {
            textView2.setText(">_<");
        }
    }

    public void btnUpdateRateClick(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL yahooAPI = new URL(address);
                    urlConnection = (HttpURLConnection) yahooAPI.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setReadTimeout(5 * 1000);
                    urlConnection.setConnectTimeout(6 * 1000);
                    InputStream in = urlConnection.getInputStream();
                    BufferedReader bReader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String str = bReader.readLine();
//                    while((str=bReader.readLine()) != null){
//                        response.append(str);
//                    }

                    Gson gson = new Gson();
//                    YahooAPIDate yahooDate = new YahooAPIDate();
//                    String sJsonDate = gson.toJson(yahooDate);
//                    YahooAPIDate yahooDate2 = gson.fromJson(response.toString(),YahooAPIDate.class);
//                    YahooAPIDate.results result = yahooDate2.new results();
//                    YahooAPIDate.results.rate rate = result.new rate();
                    YahooJsonBean bean = gson.fromJson(str, YahooJsonBean.class);
                    Query query = bean.getQuery();
                    Results results = query.getResults();
                    final List<Rate> rate = results.getRate();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"从云端更新汇率..."+"\n"
                                    +"人民币兑美元："+ rate.get(0).getRate()+"\n"
                                    +"人民币兑日元："+rate.get(1).getRate()+"\n"
                                    +"人民币兑韩元："+rate.get(2).getRate(),Toast.LENGTH_LONG).show();
                            RMB_TO_USA = Double.valueOf(rate.get(0).getRate());
                            RMB_TO_JP = Double.valueOf(rate.get(1).getRate());
                            RMB_TO_KRW = Double.valueOf(rate.get(2).getRate());
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    urlConnection.disconnect();
                }
            }
        }).start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);
    }
}
