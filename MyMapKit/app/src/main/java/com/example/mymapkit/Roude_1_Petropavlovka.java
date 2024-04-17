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
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.runtime.image.ImageProvider;

public class Roude_1_Petropavlovka extends Activity {

    TextView textView_text_Hare, textView_text_Memorial, textView_text_House, textView_text_Peter, textView_text_Fortress,
    textView_text_Cathedral, textView_text_Money_yard, textView_text_Boathouse;

    ImageView imageView_img_Hare, imageView_img_Memorial, imageView_img_House, imageView_img_Peter, imageView_img_Fortress, imageView_img_Cathedral,
            imageView_img_Money_yard, imageView_img_Boathouse;

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.route_1_petropavlovka);
        super.onCreate(savedInstanceState);

        textView_text_Hare = (TextView) findViewById(R.id.text_Hare);
        textView_text_Memorial= (TextView) findViewById(R.id.text_Memorial);
        textView_text_House= (TextView) findViewById(R.id.text_House);
        textView_text_Peter= (TextView) findViewById(R.id.text_Peter);
        textView_text_Fortress= (TextView) findViewById(R.id.text_Fortress);
        textView_text_Cathedral= (TextView) findViewById(R.id.text_Cathedral);
        textView_text_Money_yard= (TextView) findViewById(R.id.text_Money_yard);
        textView_text_Boathouse= (TextView) findViewById(R.id.text_Boathouse);

        imageView_img_Hare = (ImageView) findViewById(R.id.img_Hare);
        imageView_img_Memorial = (ImageView) findViewById(R.id.img_Memorial);
        imageView_img_House = (ImageView) findViewById(R.id.img_House);
        imageView_img_Peter = (ImageView) findViewById(R.id.img_Peter);
        imageView_img_Fortress = (ImageView) findViewById(R.id.img_Fortress);
        imageView_img_Cathedral = (ImageView) findViewById(R.id.img_Cathedral);
        imageView_img_Money_yard = (ImageView) findViewById(R.id.img_Money_yard);
        imageView_img_Boathouse = (ImageView) findViewById(R.id.img_Boathouse);

        button1 = (Button)findViewById(R.id.nb_go_roude);

        Intent intent = getIntent();
        String Name_key = intent.getStringExtra("Name_key");

        int Name_Mus_point_5 = 34;
        int Name_Mus_point_6 = 35;
        int Name_Mus_point_8 = 36;
        int Name_Mus_point_7 = 37;
        int Name_Mus_point_3 = 38;
        int Name_Mus_point_2 = 39;
        int Name_Mus_point_1 = 40;
        int Name_Mus_point_4 = 41;

        DBManager dbManager = new DBManager(this);
        dbManager.Open_Db();


        String query = "SELECT " + DBHelper.Mus_ID + ", "
                + DBHelper.Museum_NAME +  ", "
                + DBHelper.Museum_INFO +  ", "
                + DBHelper.Museum_ADDRESS +  ", "
                + DBHelper.Museum_LATITUDE +  ", "
                + DBHelper.Museum_LONGITUDE +  ", "
                + DBHelper.Museum_IMG_SOURCE + " FROM " + DBHelper.TABLE_MUSEUMS + " WHERE " + DBHelper.Mus_ID + " = " + Name_Mus_point_1 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_2 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_3 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_4 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_5 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_6 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_7 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_8;

        Cursor cursor2 = dbManager.db.rawQuery(query, null);
        if (cursor2.moveToFirst()){

            int Mus_id = cursor2.getColumnIndex(DBHelper.Mus_ID);
            int Mus_Name = cursor2.getColumnIndex(DBHelper.Museum_NAME);
            int Museum_Info = cursor2.getColumnIndex(DBHelper.Museum_INFO);
            int Img_Source = cursor2.getColumnIndex(DBHelper.Museum_IMG_SOURCE);

            do {
                int Mus_id_counter = cursor2.getInt(Mus_id);
                Log.d("mLog",Mus_id_counter +"Кааааааааааааааааааааунтер");

//                if(Mus_id_counter == Name_Mus_point_1){
//
//                    String MUSInfo = cursor2.getString(Museum_Info);
//                        textView_text_Hare.setText(MUSInfo);
//
//                        String iimg1 = cursor2.getString(Img_Source);
//                        Log.d("mLog",iimg1 +"Нашееееееееееееееееееееееееел");
//                        int startS =  getResources().getIdentifier(iimg1, "drawable","com.example.mymapkit");
//                        imageView_img_Hare.setImageResource(startS);
//                }
//                if(Mus_id_counter == Name_Mus_point_2){
//                    String MUSInfo2 = cursor2.getString(Museum_Info);
//                        textView_text_Memorial.setText(MUSInfo2);
//
//                        String iimg2 = cursor2.getString(Img_Source);
//                        Log.d("mLog",iimg2 +"Нашееееееееееееееееееееееееел");
//                        int startS2 =  getResources().getIdentifier(iimg2, "drawable","com.example.mymapkit");
//                        imageView_img_Memorial.setImageResource(startS2);
//                }

                switch (Mus_id_counter){

                    case 40 :
                        String MUSInfo = cursor2.getString(Museum_Info);
                        textView_text_Hare.setText(MUSInfo);

                        String iimg1 = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg1 +"Нашееееееееееееееееееееееееел");
                        int startS =  getResources().getIdentifier(iimg1, "drawable","com.example.mymapkit");
                        imageView_img_Hare.setImageResource(startS);
                        break;
                    case 39 :
                        String MUSInfo2 = cursor2.getString(Museum_Info);
                        textView_text_Memorial.setText(MUSInfo2);

                        String iimg2 = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg2 +"Нашееееееееееееееееееееееееел");
                        int startS2 =  getResources().getIdentifier(iimg2, "drawable","com.example.mymapkit");
                        imageView_img_Memorial.setImageResource(startS2);
                        break;
                    case 38 :
                        String MUSInfo3 = cursor2.getString(Museum_Info);
                        textView_text_House.setText(MUSInfo3);

                        String iimg3 = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg3 +"Нашееееееееееееееееееееееееел");
                        int startS3 =  getResources().getIdentifier(iimg3, "drawable","com.example.mymapkit");
                        imageView_img_House.setImageResource(startS3);
                        break;
                    case 41 :
                        String MUSInfo4 = cursor2.getString(Museum_Info);
                        textView_text_Peter.setText(MUSInfo4);

                        String iimg4 = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg4 +"Нашееееееееееееееееееееееееел");
                        int startS4 =  getResources().getIdentifier(iimg4, "drawable","com.example.mymapkit");
                        imageView_img_Peter.setImageResource(startS4);
                        break;
                    case 34 :
                        String MUSInfo5 = cursor2.getString(Museum_Info);
                        textView_text_Fortress.setText(MUSInfo5);
                        Log.d("mLog",MUSInfo5 +" cnhjrffffff");
                        String iimg5 = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg5 +"Нашееееееееееееееееееееееееел");
                        int startS5 =  getResources().getIdentifier(iimg5, "drawable","com.example.mymapkit");
                        imageView_img_Fortress.setImageResource(startS5);
                        break;
                    case 35 :
                        String MUSInfo6 = cursor2.getString(Museum_Info);
                        textView_text_Cathedral.setText(MUSInfo6);

                        String iimg6 = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg6 +"Нашееееееееееееееееееееееееел");
                        int startS6 =  getResources().getIdentifier(iimg6, "drawable","com.example.mymapkit");
                        imageView_img_Cathedral.setImageResource(startS6);
                        break;
                    case 37 :
                        String MUSInfo7 = cursor2.getString(Museum_Info);
                        textView_text_Money_yard.setText(MUSInfo7);

                        String iimg7 = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg7 +"Нашееееееееееееееееееееееееел");
                        int startS7 =  getResources().getIdentifier(iimg7, "drawable","com.example.mymapkit");
                        imageView_img_Money_yard.setImageResource(startS7);
                        break;
                    case 36 :
                        String MUSInfo8 = cursor2.getString(Museum_Info);
                        textView_text_Boathouse.setText(MUSInfo8);

                        String iimg8 = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg8 +"Нашееееееееееееееееееееееееел");
                        int startS8 =  getResources().getIdentifier(iimg8, "drawable","com.example.mymapkit");
                        imageView_img_Boathouse.setImageResource(startS8);
                        break;
                }

            } while (cursor2.moveToNext());
        } else Log.d("mLog","0 rows");

        cursor2.close();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                double latitude = Double.parseDouble(cursor.getString(Museum_Latitude));
//                double longitude = Double.parseDouble(cursor.getString(Museum_Longitude));
//                Log.d("mLog","Широта "+ latitude + "Долгота " + longitude);
//                Point point = new Point(latitude, longitude);

                Intent intent = new Intent();
                intent.putExtra("Name_Mus_point_1", Name_Mus_point_1);
                intent.putExtra("Name_Mus_point_2", Name_Mus_point_2);
                intent.putExtra("Name_Mus_point_3", Name_Mus_point_3);
                intent.putExtra("Name_Mus_point_4", Name_Mus_point_4);
                intent.putExtra("Name_Mus_point_5", Name_Mus_point_5);
                intent.putExtra("Name_Mus_point_6", Name_Mus_point_6);
                intent.putExtra("Name_Mus_point_7", Name_Mus_point_7);
                intent.putExtra("Name_Mus_point_8", Name_Mus_point_8);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
