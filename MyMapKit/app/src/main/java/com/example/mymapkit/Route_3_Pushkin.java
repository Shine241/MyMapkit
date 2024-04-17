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

public class Route_3_Pushkin extends Activity {

    TextView text_Monument_to_Pushkin,
            text_Church_of_the_Savior,
            text_Museum_apartment_Pushkin,
            text_House_Golitsyna,
            text_Demutov_tavern,
            text_Confectionery_Wolf_and_Beranger,
            text_College_of_Foreign_Affairs,
            text_Brieskorn_House,
            text_House_in_Kolomna,
            text_Reindeer_House;


    ImageView imageView_img_Monument_to_Pushkin,
            imageView_img_Church_of_the_Savior,
            imageView_img_Museum_apartment_Pushkin,
            imageView_img_House_Golitsyna,
            img_Demutov_tavern,
            img_Confectionery_Wolf_and_Beranger,
            img_College_of_Foreign_Affairs,
            img_Brieskorn_House,
            img_House_in_Kolomna,
            img_Reindeer_House;

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.route_3_pushkin);
        super.onCreate(savedInstanceState);

        text_Monument_to_Pushkin = (TextView) findViewById(R.id.text_Monument_to_Pushkin);
        text_Church_of_the_Savior = (TextView) findViewById(R.id.text_Church_of_the_Savior);
        text_Museum_apartment_Pushkin = (TextView) findViewById(R.id.text_Museum_apartment_Pushkin);
        text_House_Golitsyna = (TextView) findViewById(R.id.text_House_Golitsyna);
        text_Demutov_tavern = (TextView) findViewById(R.id.text_Demutov_tavern);
        text_Confectionery_Wolf_and_Beranger = (TextView) findViewById(R.id.text_Confectionery_Wolf_and_Beranger);
        text_College_of_Foreign_Affairs = (TextView) findViewById(R.id.text_College_of_Foreign_Affairs);
        text_Brieskorn_House = (TextView) findViewById(R.id.text_Brieskorn_House);
        text_House_in_Kolomna = (TextView) findViewById(R.id.text_House_in_Kolomna);
        text_Reindeer_House = (TextView) findViewById(R.id.text_Reindeer_House);


        imageView_img_Monument_to_Pushkin = (ImageView) findViewById(R.id.img_Monument_to_Pushkin);
        imageView_img_Church_of_the_Savior = (ImageView) findViewById(R.id.img_Church_of_the_Savior);
        imageView_img_Museum_apartment_Pushkin = (ImageView) findViewById(R.id.img_Museum_apartment_Pushkin);
        imageView_img_House_Golitsyna = (ImageView) findViewById(R.id.img_House_Golitsyna);
        img_Demutov_tavern = (ImageView) findViewById(R.id.img_Demutov_tavern);
        img_Confectionery_Wolf_and_Beranger = (ImageView) findViewById(R.id.img_Confectionery_Wolf_and_Beranger);
        img_College_of_Foreign_Affairs = (ImageView) findViewById(R.id.img_College_of_Foreign_Affairs);
        img_Brieskorn_House = (ImageView) findViewById(R.id.img_Brieskorn_House);
        img_House_in_Kolomna = (ImageView) findViewById(R.id.img_House_in_Kolomna);
        img_Reindeer_House = (ImageView) findViewById(R.id.img_Reindeer_House);



        button1 = (Button)findViewById(R.id.nb_go_roude_3);

        Intent intent = getIntent();
        String Name_key = intent.getStringExtra("Name_key");

        DBManager dbManager = new DBManager(this);
        dbManager.Open_Db();



        int Name_Mus_point_1 = 144;
        int Name_Mus_point_2 = 2;
        int Name_Mus_point_3 = 1;
        int Name_Mus_point_4 = 141;
        int Name_Mus_point_5 = 137;
        int Name_Mus_point_6 = 143;
        int Name_Mus_point_7 = 138;
        int Name_Mus_point_8 = 142;
        int Name_Mus_point_9 = 139;
        int Name_Mus_point_10 = 140;

        String query = "SELECT " + DBHelper.Mus_ID + ", "
                + DBHelper.Museum_NAME +  ", "
                + DBHelper.Museum_INFO +  ", "
                + DBHelper.Museum_ADDRESS +  ", "
                + DBHelper.Museum_LATITUDE +  ", "
                + DBHelper.Museum_LONGITUDE +  ", "
                + DBHelper.Museum_IMG_SOURCE + " FROM " + DBHelper.TABLE_MUSEUMS + " WHERE " + DBHelper.Mus_ID + " = " + Name_Mus_point_1 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_2 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_3 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_4 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_5 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_6 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_7 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_8 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_9 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_10;

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

                    case 144 :
                        String MUSInfo = cursor2.getString(Museum_Info);
                        text_Monument_to_Pushkin.setText(MUSInfo);

                        String iimg = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg +"Нашееееееееееееееееееееееееел");
                        int startS =  getResources().getIdentifier(iimg, "drawable","com.example.mymapkit");
                        imageView_img_Monument_to_Pushkin.setImageResource(startS);
                        break;
                    case 2 :
                        String MUSInfo2 = cursor2.getString(Museum_Info);
                        text_Church_of_the_Savior.setText(MUSInfo2);

                        String iimg2 = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg2 +"Нашееееееееееееееееееееееееел");
                        int startS2 =  getResources().getIdentifier(iimg2, "drawable","com.example.mymapkit");
                        imageView_img_Church_of_the_Savior.setImageResource(startS2);
                        break;
                    case 1 :
                        String MUSInfo3 = cursor2.getString(Museum_Info);
                        text_Museum_apartment_Pushkin.setText(MUSInfo3);

                        String iimg3 = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg3 +"Нашееееееееееееееееееееееееел");
                        int startS3 =  getResources().getIdentifier(iimg3, "drawable","com.example.mymapkit");
                        imageView_img_Museum_apartment_Pushkin.setImageResource(startS3);
                        break;
                    case 141 :
                        String MUSInfo4 = cursor2.getString(Museum_Info);
                        text_House_Golitsyna.setText(MUSInfo4);

                        String iimg4 = cursor2.getString(Img_Source);
                        Log.d("mLog",iimg4 +"Нашееееееееееееееееееееееееел");
                        int startS4 =  getResources().getIdentifier(iimg4, "drawable","com.example.mymapkit");
                        imageView_img_House_Golitsyna.setImageResource(startS4);
                        break;
                    case 137 :
                        String MUSInfo5 = cursor2.getString(Museum_Info);
                        text_Demutov_tavern.setText(MUSInfo5);

                        String iimg5 = cursor2.getString(Img_Source);
                        int startS5 =  getResources().getIdentifier(iimg5, "drawable","com.example.mymapkit");
                        img_Demutov_tavern.setImageResource(startS5);
                        break;
                    case 143 :
                        String MUSInfo6 = cursor2.getString(Museum_Info);
                        text_Confectionery_Wolf_and_Beranger.setText(MUSInfo6);

                        String iimg6 = cursor2.getString(Img_Source);
                        int startS6 =  getResources().getIdentifier(iimg6, "drawable","com.example.mymapkit");
                        img_Confectionery_Wolf_and_Beranger.setImageResource(startS6);
                        break;
                    case 138 :
                        String MUSInfo7 = cursor2.getString(Museum_Info);
                        text_College_of_Foreign_Affairs.setText(MUSInfo7);

                        String iimg7 = cursor2.getString(Img_Source);
                        int startS7 =  getResources().getIdentifier(iimg7, "drawable","com.example.mymapkit");
                        img_College_of_Foreign_Affairs.setImageResource(startS7);
                        break;
                    case 142 :
                        String MUSInfo8 = cursor2.getString(Museum_Info);
                        text_Brieskorn_House.setText(MUSInfo8);

                        String iimg8 = cursor2.getString(Img_Source);
                        int startS8 =  getResources().getIdentifier(iimg8, "drawable","com.example.mymapkit");
                        img_Brieskorn_House.setImageResource(startS8);
                        break;
                    case 139 :
                        String MUSInfo9 = cursor2.getString(Museum_Info);
                        text_House_in_Kolomna.setText(MUSInfo9);

                        String iimg9 = cursor2.getString(Img_Source);
                        int startS9 =  getResources().getIdentifier(iimg9, "drawable","com.example.mymapkit");
                        img_House_in_Kolomna.setImageResource(startS9);
                        break;
                    case 140 :
                        String MUSInfo10 = cursor2.getString(Museum_Info);
                        text_Reindeer_House.setText(MUSInfo10);

                        String iimg10 = cursor2.getString(Img_Source);
                        int startS10 =  getResources().getIdentifier(iimg10, "drawable","com.example.mymapkit");
                        img_Reindeer_House.setImageResource(startS10);
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

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
