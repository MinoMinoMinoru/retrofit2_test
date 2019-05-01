package com.example.http_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.http_test.Retrofit.RetrofitClient;


public class SubActivity extends Activity {
    // 追加
    RetrofitClient client = new RetrofitClient("http://192.168.1.24:5000");
    private String NAME;
    // ここまで

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_test);

        TextView URL_text = (TextView)findViewById(R.id.ip_text);
        TextView NAME_text = (TextView)findViewById(R.id.name_text);
        Button Bt = findViewById(R.id.button);

        // ここから
        Intent intent = getIntent();
        String URL = intent.getStringExtra("URL");
        NAME = intent.getStringExtra("NAME");
        Log.d("Sub",URL);Log.d("Sub",NAME);
        client.setIp(URL);
        // ここまでの処理をhitoeのアプリに追加(宣言等も)

        URL_text.setText(URL);
        NAME_text.setText(NAME);

        Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 今はRRIとしてテキトーな乱数を
                client.post(NAME,800);
            }
        });

    }




}
