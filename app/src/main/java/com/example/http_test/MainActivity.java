package com.example.http_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;
import android.content.Intent;

import com.example.http_test.Retrofit.RetrofitClient;

public class MainActivity extends AppCompatActivity{

    private String BASE_URL= "http://192.168.1.24:8000";
    private String IP = "";
    private String PORT = "";
    private String NAME = "";
    Random r = new Random();
//    Intent intent;

    RetrofitClient client = new RetrofitClient(BASE_URL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_ip);

        // set Button
        Button getIPBt = findViewById(R.id.setIP_button);
        Button PostBt = findViewById(R.id.post_button);
        Button NextBt = findViewById(R.id.next_button);
        // setEditor
        final EditText ip_text = findViewById(R.id.ip_editor);
        final EditText port_text = findViewById(R.id.port_editor);
        final EditText name_text = findViewById(R.id.name_editor);

        // Set Listener
        getIPBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IP = ip_text.getText().toString();
                PORT = port_text.getText().toString();
                BASE_URL="http://"+IP+":"+PORT+"/";
                NAME = name_text.getText().toString();
                Toast.makeText(MainActivity.this, "Interface Recreate ! New URL is "+BASE_URL, Toast.LENGTH_SHORT).show();
                client.setIp(BASE_URL);
            }
        });

        PostBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Post", Toast.LENGTH_SHORT).show();
//                BASE_URL=BASE_URL+"/test";
//                client.setIp(BASE_URL);
                // 今はRRIとしてテキトーな乱数を
//                client.postTest("Taro",r.nextInt(400)+700);
                client.post(NAME,r.nextInt(400)+700);
//                BASE_URL="http://"+IP+":"+PORT+"/";
//                client.setIp(BASE_URL);
            }
        });

        NextBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // インテントへのインスタンス生成
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                //　インテントに値をセット
                intent.putExtra("URL", BASE_URL);
                intent.putExtra("NAME", NAME);
                // サブ画面の呼び出し
                startActivity(intent);
            }
        });


    }


}