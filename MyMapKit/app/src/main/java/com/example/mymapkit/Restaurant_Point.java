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

public class Restaurant_Point extends Activity {
    TextView textView1, textView2, textView3;
    ImageView imageView;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_point);
        textView1 = (TextView) findViewById(R.id.point_rest);
        textView2 = (TextView) findViewById(R.id.point_rest2);
        textView3 = (TextView) findViewById(R.id.point_rest3);
        imageView = (ImageView) findViewById(R.id.img1_1);
        button1 = (Button)findViewById(R.id.nb_go_);


        Intent intent = getIntent();
        String Name_key_res = intent.getStringExtra("Name_key_res");
        Log.d("mLog",Name_key_res +" имя точки!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        textView1.setText(Name_key_res);
        DBManager dbManager = new DBManager(this);
        dbManager.Open_Db();

        String selection = "Restaurant_NAME = ?";
        String[] selectionArgs = new String[] {Name_key_res};

        Cursor cursor_rest = dbManager.db.query(DBHelper.TABLE_RESTAURANTS_BARS, null, selection , selectionArgs, null, null, null);
        int Res_id = cursor_rest.getColumnIndex(DBHelper.Restaurant_ID);
        int Res_Name = cursor_rest.getColumnIndex(DBHelper.Restaurant_NAME);
        int Res_Info = cursor_rest.getColumnIndex(DBHelper.Restaurant_INFO);
        int Res_Address = cursor_rest.getColumnIndex(DBHelper.Restaurant_ADDRESS);
        int Res_Latitude = cursor_rest.getColumnIndex(DBHelper.Restaurant_LATITUDE);
        int Res_Longitude = cursor_rest.getColumnIndex(DBHelper.Restaurant_LONGITUDE);
        int Res_Source = cursor_rest.getColumnIndex(DBHelper.Restaurant_IMG_SOURCE);


        cursor_rest.moveToFirst();
        String MUSInfo = cursor_rest.getString(Res_Info);
        textView2.setText(MUSInfo);

        String iimg = cursor_rest.getString(Res_Source);
        Log.d("mLog",iimg +"Нашееееееееееееееееееееееееел");
        int startS =  getResources().getIdentifier(iimg, "drawable","com.example.mymapkit");
        imageView.setImageResource(startS);
        Log.d("mLog",startS +"картинкаааааааааааа");
        String RestAddress = cursor_rest.getString(Res_Address);
        textView3.setText(RestAddress);
        Log.d("mLog",RestAddress +"Адресс");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double latitude = Double.parseDouble(cursor_rest.getString(Res_Latitude));
                double longitude = Double.parseDouble(cursor_rest.getString(Res_Longitude));
                Log.d("mLog","Широта "+ latitude + "Долгота " + longitude);
                Point point = new Point(latitude, longitude);

                Intent intent = new Intent();
                intent.putExtra("Res_point_Lat", latitude);
                intent.putExtra("Res_point_Long", longitude);
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
