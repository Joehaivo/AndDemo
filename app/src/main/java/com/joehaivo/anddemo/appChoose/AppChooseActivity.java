package com.joehaivo.anddemo.appChoose;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.Toolbar;

import com.joehaivo.anddemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by haivo on 2016/5/15.
 */
public class AppChooseActivity  extends Activity implements AdapterView.OnItemClickListener{
    private GridView gridView;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>> sourceList;
    private int[] icon = {R.drawable.alipay, R.drawable.baidu_yun,R.drawable.dangdang,
                            R.drawable.douban,R.drawable.jd,R.drawable.qq,
                            R.drawable.qzone,R.drawable.renren,R.drawable.taobao,
                            R.drawable.wangyi_yunyinyue,R.drawable.wechat,
                            R.drawable.weibo,R.drawable.xunlei,R.drawable.zhihu};
    private String[] iconName = {"支付宝","百度云","当当","豆瓣","京东","QQ","QQ空间","人人","淘宝","网易云音乐","微信","微博","迅雷","知乎"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appchoose_grid);

        gridView = (GridView) findViewById(R.id.appGridView);
        sourceList = new ArrayList<>();
        simpleAdapter = new SimpleAdapter(this,getSourceList(),R.layout.item_gridview,new String[]{"icon","iconName"},
                new int[]{R.id.iconInGrid,R.id.textInGrid});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(this);
    }

    private List<Map<String,Object>>  getSourceList() {
        for (int i = 0; i < icon.length; i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("icon",icon[i]);
            map.put("iconName",iconName[i]);
            sourceList.add(map);

        }
        return sourceList;
    }
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:Toast.makeText(this,"支付宝",Toast.LENGTH_SHORT).show();
                openApp("com.eg.android.AlipayGphone"); break;
            case 1:
                Toast.makeText(this,"网盘",Toast.LENGTH_SHORT).show();
                openApp("com.baidu.netdisk"); break;
            case 2: break;
            case 3: break;
            case 4:Toast.makeText(this,"京东",Toast.LENGTH_SHORT).show();
                openApp("com.jingdong.app.mall"); break;
            case 5:Toast.makeText(this,"QQ",Toast.LENGTH_SHORT).show();
                openApp("com.tencent.mobileqq"); break;
            case 6: break;
            case 7: break;
            case 8:Toast.makeText(this,"淘宝",Toast.LENGTH_SHORT).show();
                openApp("com.taobao.taobao"); break;
            case 9:Toast.makeText(this,"云村",Toast.LENGTH_SHORT).show();
                openApp("com.netease.cloudmusic"); break;
            case 10:Toast.makeText(this,"WeChat",Toast.LENGTH_SHORT).show();
                openApp("com.tencent.mm"); break;
            case 11:Toast.makeText(this,"围脖",Toast.LENGTH_SHORT).show();
                openApp("com.sina.weibo"); break;
            case 12: break;
            case 13:Toast.makeText(this,"知乎",Toast.LENGTH_SHORT).show();
                openApp("com.zhihu.android"); break;
        }
    }
    private void openApp(String packageName) {
        PackageInfo pi = null;
        try {
            pi = getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(pi.packageName);
        resolveIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        List<ResolveInfo> apps = getPackageManager().queryIntentActivities(resolveIntent, 0);
        ResolveInfo ri = apps.iterator().next();
        if (ri != null ) {
            packageName = ri.activityInfo.packageName;
            String className = ri.activityInfo.name;

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);

            ComponentName cn = new ComponentName(packageName, className);

            intent.setComponent(cn);
            startActivity(intent);
        }
    }
}
