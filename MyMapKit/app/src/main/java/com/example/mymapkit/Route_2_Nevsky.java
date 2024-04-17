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

public class Route_2_Nevsky extends Activity {

    TextView text_Bel_Bel_Palace,
            text_Eliseevsky_shop,
            text_Anichkov_Palace,
            text_Anichkov_bridge,
            text_Monument_to_Catherine_2,
            text_Passage,
            text_Gostiny_Dvor,
            text_Church_of_Saint_Catherine,
            text_City_Council_building,
            text_Basilica_of_Saint_Catherine_of_Alexandria,
            text_Singer_Company,
            text_Ma_Cathedral,
            text_Lutheran_Church_of_Saints_Peter_and_Paul,
            text_Mertens_Trading_House,
            text_Stroganov_Palace,
            text_Home_of_the_Dutch_Reformed_Church,
            text_Green_bridge;


    ImageView imageView_img_Bel_Bel_Palace,
            imageView_img_Eliseevsky_shop,
            imageView_img_Anichkov_Palace,
            imageView_img_Anichkov_bridge,
            img_Monument_to_Catherine_2,
            img_Passage,
            img_Gostiny_Dvor,
            img_Church_of_Saint_Catherine,
            img_City_Council_building,
            img_Basilica_of_Saint_Catherine_of_Alexandria,
            img_Singer_Company,
            img_Ma_Cathedral,
            img_Lutheran_Church_of_Saints_Peter_and_Paul,
            img_Mertens_Trading_House,
            img_Stroganov_Palace,
            img_Home_of_the_Dutch_Reformed_Church,
            img_Green_bridge;

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.route_2_nevsky);
        super.onCreate(savedInstanceState);

        text_Bel_Bel_Palace = (TextView) findViewById(R.id.text_Bel_Bel_Palace);
        text_Anichkov_bridge= (TextView) findViewById(R.id.text_Anichkov_bridge);
        text_Anichkov_Palace= (TextView) findViewById(R.id.text_Anichkov_Palace);
        text_Eliseevsky_shop= (TextView) findViewById(R.id.text_Eliseevsky_shop);
        text_Monument_to_Catherine_2= (TextView) findViewById(R.id.text_Monument_to_Catherine_2);
        text_Passage= (TextView) findViewById(R.id.text_Passage);
        text_Gostiny_Dvor= (TextView) findViewById(R.id.text_Gostiny_Dvor);
        text_Church_of_Saint_Catherine= (TextView) findViewById(R.id.text_Church_of_Saint_Catherine);
        text_City_Council_building= (TextView) findViewById(R.id.text_City_Council_building);
        text_Basilica_of_Saint_Catherine_of_Alexandria= (TextView) findViewById(R.id.text_Basilica_of_Saint_Catherine_of_Alexandria);
        text_Singer_Company= (TextView) findViewById(R.id.text_Singer_Company);
        text_Ma_Cathedral= (TextView) findViewById(R.id.text_Ma_Cathedral);
        text_Lutheran_Church_of_Saints_Peter_and_Paul= (TextView) findViewById(R.id.text_Lutheran_Church_of_Saints_Peter_and_Paul);
        text_Mertens_Trading_House= (TextView) findViewById(R.id.text_Mertens_Trading_House);
        text_Stroganov_Palace= (TextView) findViewById(R.id.text_Stroganov_Palace);
        text_Home_of_the_Dutch_Reformed_Church= (TextView) findViewById(R.id.text_Home_of_the_Dutch_Reformed_Church);
        text_Green_bridge= (TextView) findViewById(R.id.text_Green_bridge);


        imageView_img_Bel_Bel_Palace = (ImageView) findViewById(R.id.img_Bel_Bel_Palace);
        imageView_img_Anichkov_bridge = (ImageView) findViewById(R.id.img_Anichkov_bridge);
        imageView_img_Anichkov_Palace = (ImageView) findViewById(R.id.img_Anichkov_Palace);
        imageView_img_Eliseevsky_shop = (ImageView) findViewById(R.id.img_Eliseevsky_shop);
        img_Monument_to_Catherine_2 = (ImageView) findViewById(R.id.img_Monument_to_Catherine_2);
        img_Passage = (ImageView) findViewById(R.id.img_Passage);
        img_Gostiny_Dvor = (ImageView) findViewById(R.id.img_Gostiny_Dvor);
        img_Church_of_Saint_Catherine = (ImageView) findViewById(R.id.img_Church_of_Saint_Catherine);
        img_City_Council_building = (ImageView) findViewById(R.id.img_City_Council_building);
        img_Basilica_of_Saint_Catherine_of_Alexandria = (ImageView) findViewById(R.id.img_Basilica_of_Saint_Catherine_of_Alexandria);
        img_Singer_Company = (ImageView) findViewById(R.id.img_Singer_Company);
        img_Ma_Cathedral = (ImageView) findViewById(R.id.img_Ma_Cathedral);
        img_Lutheran_Church_of_Saints_Peter_and_Paul = (ImageView) findViewById(R.id.img_Lutheran_Church_of_Saints_Peter_and_Paul);
        img_Mertens_Trading_House = (ImageView) findViewById(R.id.img_Mertens_Trading_House);
        img_Stroganov_Palace = (ImageView) findViewById(R.id.img_Stroganov_Palace);
        img_Home_of_the_Dutch_Reformed_Church = (ImageView) findViewById(R.id.img_Home_of_the_Dutch_Reformed_Church);
        img_Green_bridge = (ImageView) findViewById(R.id.img_Green_bridge);


        button1 = (Button)findViewById(R.id.nb_go_roude_2);

        Intent intent = getIntent();
        String Name_key = intent.getStringExtra("Name_key");

        DBManager dbManager = new DBManager(this);
        dbManager.Open_Db();


        int Name_Mus_point_1 = 100;
        int Name_Mus_point_2 = 101;
        int Name_Mus_point_3 = 78;
        int Name_Mus_point_4 = 77;
        int Name_Mus_point_5 = 76;
        int Name_Mus_point_6 = 69;
        int Name_Mus_point_7 = 73;
        int Name_Mus_point_8 = 68;
        int Name_Mus_point_9 = 72;
        int Name_Mus_point_10 = 67;
        int Name_Mus_point_11 = 9;
        int Name_Mus_point_12 = 13;
        int Name_Mus_point_13 = 6;
        int Name_Mus_point_14 = 14;
        int Name_Mus_point_15 = 15;
        int Name_Mus_point_16 = 8;
        int Name_Mus_point_17 = 26;

        String query = "SELECT " + DBHelper.Mus_ID + ", "
                + DBHelper.Museum_NAME +  ", "
                + DBHelper.Museum_INFO +  ", "
                + DBHelper.Museum_ADDRESS +  ", "
                + DBHelper.Museum_LATITUDE +  ", "
                + DBHelper.Museum_LONGITUDE +  ", "
                + DBHelper.Museum_IMG_SOURCE + " FROM " + DBHelper.TABLE_MUSEUMS + " WHERE " + DBHelper.Mus_ID + " = " + Name_Mus_point_1 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_2 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_3 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_4 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_5 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_6 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_7 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_8 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_9 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_10 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_11 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_12 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_13 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_14 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_15 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_16 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_17;

        Cursor cursor2 = dbManager.db.rawQuery(query, null);
        if (cursor2.moveToFirst()){

            int Mus_id = cursor2.getColumnIndex(DBHelper.Mus_ID);
            int Mus_Name = cursor2.getColumnIndex(DBHelper.Museum_NAME);
            int Museum_Info = cursor2.getColumnIndex(DBHelper.Museum_INFO);
            int Img_Source = cursor2.getColumnIndex(DBHelper.Museum_IMG_SOURCE);

            do {
                int Mus_id_counter = cursor2.getInt(Mus_id);
                Log.d("mLog",Mus_id_counter +"Кааааааааааааааааааааунтер");

                switch (Mus_id_counter){

                    case 100 :
                        String MUSInfo = cursor2.getString(Museum_Info);
                        text_Bel_Bel_Palace.setText(MUSInfo);

                        String iimg = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg +"Нашееееееееееееееееееееееееел");
                        int startS =  getResources().getIdentifier(iimg, "drawable","com.example.mymapkit");
                        imageView_img_Bel_Bel_Palace.setImageResource(startS);
                        break;
                    case 101 :
                        String MUSInfo2 = cursor2.getString(Museum_Info);
                        text_Anichkov_bridge.setText(MUSInfo2);

                        String iimg2 = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg2 +"Нашееееееееееееееееееееееееел");
                        int startS2 =  getResources().getIdentifier(iimg2, "drawable","com.example.mymapkit");
                        imageView_img_Anichkov_bridge.setImageResource(startS2);
                        break;
                    case 78 :
                        String MUSInfo3 = cursor2.getString(Museum_Info);
                        text_Anichkov_Palace.setText(MUSInfo3);

                        String iimg3 = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg3 +"Нашееееееееееееееееееееееееел");
                        int startS3 =  getResources().getIdentifier(iimg3, "drawable","com.example.mymapkit");
                        imageView_img_Anichkov_Palace.setImageResource(startS3);
                        break;
                    case 77 :
                        String MUSInfo4 = cursor2.getString(Museum_Info);
                        text_Eliseevsky_shop.setText(MUSInfo4);

                        String iimg4 = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg4 +"Нашееееееееееееееееееееееееел");
                        int startS4 =  getResources().getIdentifier(iimg4, "drawable","com.example.mymapkit");
                        imageView_img_Eliseevsky_shop.setImageResource(startS4);
                        break;
                    case 76 :
                        String MUSInfo5 = cursor2.getString(Museum_Info);
                        text_Monument_to_Catherine_2.setText(MUSInfo5);

                        String iimg5 = cursor2.getString(Img_Source);
                        int startS5 =  getResources().getIdentifier(iimg5, "drawable","com.example.mymapkit");
                        img_Monument_to_Catherine_2.setImageResource(startS5);
                        break;
                    case 69 :
                        String MUSInfo6 = cursor2.getString(Museum_Info);
                        text_Passage.setText(MUSInfo6);

                        String iimg6 = cursor2.getString(Img_Source);
                        int startS6 =  getResources().getIdentifier(iimg6, "drawable","com.example.mymapkit");
                        img_Passage.setImageResource(startS6);
                        break;
                    case 73 :
                        String MUSInfo7 = cursor2.getString(Museum_Info);
                        text_Gostiny_Dvor.setText(MUSInfo7);

                        String iimg7 = cursor2.getString(Img_Source);
                        int startS7 =  getResources().getIdentifier(iimg7, "drawable","com.example.mymapkit");
                        img_Gostiny_Dvor.setImageResource(startS7);
                        break;
                    case 68 :
                        String MUSInfo8 = cursor2.getString(Museum_Info);
                        text_Church_of_Saint_Catherine.setText(MUSInfo8);

                        String iimg8 = cursor2.getString(Img_Source);
                        int startS8 =  getResources().getIdentifier(iimg8, "drawable","com.example.mymapkit");
                        img_Church_of_Saint_Catherine.setImageResource(startS8);
                        break;
                    case 72 :
                        String MUSInfo9 = cursor2.getString(Museum_Info);
                        text_City_Council_building.setText(MUSInfo9);

                        String iimg9 = cursor2.getString(Img_Source);
                        int startS9 =  getResources().getIdentifier(iimg9, "drawable","com.example.mymapkit");
                        img_City_Council_building.setImageResource(startS9);
                        break;
                    case 67 :
                        String MUSInfo10 = cursor2.getString(Museum_Info);
                        text_Basilica_of_Saint_Catherine_of_Alexandria.setText(MUSInfo10);

                        String iimg10 = cursor2.getString(Img_Source);
                        int startS10 =  getResources().getIdentifier(iimg10, "drawable","com.example.mymapkit");
                        img_Basilica_of_Saint_Catherine_of_Alexandria.setImageResource(startS10);
                        break;
                    case 9 :
                        String MUSInfo11 = cursor2.getString(Museum_Info);
                        text_Singer_Company.setText(MUSInfo11);

                        String iimg11 = cursor2.getString(Img_Source);
                        int startS11 =  getResources().getIdentifier(iimg11, "drawable","com.example.mymapkit");
                        img_Singer_Company.setImageResource(startS11);
                        break;
                    case 13 :
                        String MUSInfo12 = cursor2.getString(Museum_Info);
                        text_Ma_Cathedral.setText(MUSInfo12);

                        String iimg12 = cursor2.getString(Img_Source);
                        int startS12 =  getResources().getIdentifier(iimg12, "drawable","com.example.mymapkit");
                        img_Ma_Cathedral.setImageResource(startS12);
                        break;
                    case 6 :
                        String MUSInfo13 = cursor2.getString(Museum_Info);
                        text_Lutheran_Church_of_Saints_Peter_and_Paul.setText(MUSInfo13);

                        String iimg13 = cursor2.getString(Img_Source);
                        int startS13 =  getResources().getIdentifier(iimg13, "drawable","com.example.mymapkit");
                        img_Lutheran_Church_of_Saints_Peter_and_Paul.setImageResource(startS13);
                        break;
                    case 14 :
                        String MUSInfo14 = cursor2.getString(Museum_Info);
                        text_Mertens_Trading_House.setText(MUSInfo14);

                        String iimg14 = cursor2.getString(Img_Source);
                        int startS14 =  getResources().getIdentifier(iimg14, "drawable","com.example.mymapkit");
                        img_Mertens_Trading_House.setImageResource(startS14);
                        break;
                    case 15 :
                        String MUSInfo15 = cursor2.getString(Museum_Info);
                        text_Stroganov_Palace.setText(MUSInfo15);

                        String iimg15 = cursor2.getString(Img_Source);
                        int startS15 =  getResources().getIdentifier(iimg15, "drawable","com.example.mymapkit");
                        img_Stroganov_Palace.setImageResource(startS15);
                        break;
                    case 8 :
                        String MUSInfo16 = cursor2.getString(Museum_Info);
                        text_Home_of_the_Dutch_Reformed_Church.setText(MUSInfo16);

                        String iimg16 = cursor2.getString(Img_Source);
                        int startS16 =  getResources().getIdentifier(iimg16, "drawable","com.example.mymapkit");
                        img_Home_of_the_Dutch_Reformed_Church.setImageResource(startS16);
                        break;
                    case 26 :
                        String MUSInfo17 = cursor2.getString(Museum_Info);
                        text_Green_bridge.setText(MUSInfo17);

                        String iimg17 = cursor2.getString(Img_Source);
                        int startS17 =  getResources().getIdentifier(iimg17, "drawable","com.example.mymapkit");
                        img_Green_bridge.setImageResource(startS17);
                        break;
                }

            } while (cursor2.moveToNext());
        } else Log.d("mLog","0 rows");

        cursor2.close();

        ////////////////////////////////////////////////

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
                intent.putExtra("Name_Mus_point_9", Name_Mus_point_9);
                intent.putExtra("Name_Mus_point_10", Name_Mus_point_10);
                intent.putExtra("Name_Mus_point_11", Name_Mus_point_11);
                intent.putExtra("Name_Mus_point_12", Name_Mus_point_12);
                intent.putExtra("Name_Mus_point_13", Name_Mus_point_13);
                intent.putExtra("Name_Mus_point_14", Name_Mus_point_14);
                intent.putExtra("Name_Mus_point_15", Name_Mus_point_15);
                intent.putExtra("Name_Mus_point_16", Name_Mus_point_16);
                intent.putExtra("Name_Mus_point_116", Name_Mus_point_17);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
