package com.example.mymapkit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    Button btnN;
    EditText editText;
    int Count =1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        btnN = (Button) findViewById(R.id.btnN);
        editText = (EditText) findViewById(R.id.ed);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count = 0;
                btnN.setEnabled(true);
            }
        });
        if(Count == 1){
            btnN.setEnabled(false);
        }

            btnN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SecondActivity.this, Third_Activity.class);
                    String nameA = editText.getText().toString();
                    intent.putExtra("NameActor",  nameA);
                    startActivity(intent);
                }
            });

    }
}
