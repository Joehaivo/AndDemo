package com.joehaivo.anddemo.contact;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


import com.joehaivo.anddemo.R;

import java.util.ArrayList;
import java.util.List;

public class ContentActivity extends AppCompatActivity {
    ListView contactsList;
    ContentResolver contentResolver;
    ArrayAdapter<String> stringArrayAdapter;
    Cursor cursorContact;
    Cursor cursorPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        contactsList = (ListView) findViewById(R.id.contactslist);
    }

    public void btnQueryAllClick(View view) {
        contentResolver = getContentResolver();
        cursorContact = contentResolver.query(Contacts.CONTENT_URI, new String[]{Contacts._ID, Contacts.DISPLAY_NAME}, null, null, null);
        List<String> item = new ArrayList<>();
        while (cursorContact != null && cursorContact.moveToNext()) {
            //查联系人id和名字
            int id = cursorContact.getInt(cursorContact.getColumnIndex("_id"));
            String name = cursorContact.getString(cursorContact.getColumnIndex("display_name"));
            //查电话号码
            cursorPhone = contentResolver.query(Phone.CONTENT_URI, new String[]{Phone.NUMBER, Phone.TYPE}, Phone.CONTACT_ID + "=" + id, null, null);
            while (cursorPhone != null && cursorPhone.moveToNext()) {
                String phoneNumber = cursorPhone.getString(cursorPhone.getColumnIndex(Phone.NUMBER));
                item.add(name +"\t"+ phoneNumber);
            }
        }
        stringArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, item);
        contactsList.setAdapter(stringArrayAdapter);
        cursorPhone.close();
        cursorContact.close();
    }
}
