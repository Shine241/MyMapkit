package com.example.mymapkit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Third_Activity extends Activity {

    TextView textView;
    private  static final String TAG = "ThirdACT";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        textView = (TextView) findViewById(R.id.Hi);
        Log.d(TAG, "onCreate: Все четко");
        Bundle arguments = getIntent().getExtras();
        String nameA = arguments.get("NameActor").toString();
        textView.setText("Hello "+nameA);
            init();
    }


    //метод инициализации
    private void init(){
        Button btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Third_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
