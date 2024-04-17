package com.example.mymapkit;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymapkit.DB.DBHelper;
import com.example.mymapkit.DB.DBManager;
import com.yandex.mapkit.geometry.Point;

public class Museum_Point extends Activity {

    TextView textView1, textView2, textView3;
    ImageView imageView;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.museum_point);
        textView1 = (TextView) findViewById(R.id.pointt);
        textView2 = (TextView) findViewById(R.id.pointt2);
        textView3 = (TextView) findViewById(R.id.pointt3);
        imageView = (ImageView) findViewById(R.id.img1);
        button1 = (Button)findViewById(R.id.nb_go);


        Intent intent = getIntent();
        String Name_key = intent.getStringExtra("Name_key");
        Log.d("mLog",Name_key +" имя точки!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        textView1.setText(Name_key);
        DBManager dbManager = new DBManager(this);
        dbManager.Open_Db();

        String selection = "MUSEUM_NAME = ?";
        String[] selectionArgs = new String[] {Name_key};

        Cursor cursor_p = dbManager.db.query(DBHelper.TABLE_MUSEUMS, null, selection , selectionArgs, null, null, null);
        int Mus_id = cursor_p.getColumnIndex(DBHelper.Mus_ID);
        int Mus_Name = cursor_p.getColumnIndex(DBHelper.Museum_NAME);
        int Museum_Info = cursor_p.getColumnIndex(DBHelper.Museum_INFO);
        int Museum_Address = cursor_p.getColumnIndex(DBHelper.Museum_ADDRESS);
        int Museum_Latitude = cursor_p.getColumnIndex(DBHelper.Museum_LATITUDE);
        int Museum_Longitude = cursor_p.getColumnIndex(DBHelper.Museum_LONGITUDE);
        int Img_Source = cursor_p.getColumnIndex(DBHelper.Museum_IMG_SOURCE);


        cursor_p.moveToFirst();
        String MUSInfo = cursor_p.getString(Museum_Info);
        textView2.setText(MUSInfo);

        String iimg = cursor_p.getString(Img_Source);
        Log.d("mLog",iimg +"Нашееееееееееееееееееееееееел");
        int startS =  getResources().getIdentifier(iimg, "drawable","com.example.mymapkit");
        imageView.setImageResource(startS);
        Log.d("mLog",startS +"картинкаааааааааааа");
        String MuseumAddress = cursor_p.getString(Museum_Address);
        textView3.setText(MuseumAddress);
        Log.d("mLog",MuseumAddress +"Адресс");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double latitude = Double.parseDouble(cursor_p.getString(Museum_Latitude));
                double longitude = Double.parseDouble(cursor_p.getString(Museum_Longitude));
                Log.d("mLog","Широта "+ latitude + "Долгота " + longitude);
                Point point = new Point(latitude, longitude);

                Intent intent = new Intent();
                intent.putExtra("Mus_point_Lat", latitude);
                intent.putExtra("Mus_point_Long", longitude);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

//        int MUS_ID = cursor.getInt(Mus_id);
//
//        switch (MUS_ID){
//
//            case 1:
//                imageView.setImageResource(R.drawable.museum_push);
//                break;
//            case 2:
//                imageView.setImageResource(R.drawable.cherkov_spasa);
//                break;
//        }

    }
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        finish();
    }
}
