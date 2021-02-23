package com.example.httpurl;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.httpurl.databinding.ActivityMainBinding;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private ImageView img;
    URL url;
    AsyncTask mMyTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        img = binding.img;
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAcunc myAcunc = new MyAcunc();
                myAcunc.execute(stringToURL("https://firebasestorage.googleapis.com/v0/b/restaurant-application-21a47.appspot.com/o/%D9%83%D9%86%D8%AA%D8%A7%D9%83%D9%8A.jpg?alt=media&token=0e9baf55-26b6-4dc5-9d38-6aef9b06d035"));


            }
        });

        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAcunc myAcunc = new MyAcunc();
                myAcunc.execute(stringToURL("https://firebasestorage.googleapis.com/v0/b/restaurant-application-21a47.appspot.com/o/%D8%B4%D8%A7%D9%88%D8%B1%D9%85%D8%A7%20%D9%84%D8%AD%D9%85%20%D8%B9%D8%AC%D9%84.jpg?alt=media&token=8a9bed1f-4b81-4532-b9f2-c331a912fdba"));



            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAcunc myAcunc = new MyAcunc();
                myAcunc.execute(stringToURL("https://firebasestorage.googleapis.com/v0/b/restaurant-application-21a47.appspot.com/o/%D8%B5%D8%AF%D8%B1%20%D8%AF%D8%AC%D8%A7%D8%AC.jpg?alt=media&token=12334e7d-629d-4c2d-8d19-558734877ffc"));


            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Glide.with(MainActivity.this).load("http://goo.gl/gEgYUd").into(binding.img);
                MyAcunc myAcunc = new MyAcunc();
                myAcunc.execute(stringToURL("https://firebasestorage.googleapis.com/v0/b/restaurant-application-21a47.appspot.com/o/IMG-20180719-WA0022.jpg?alt=media&token=db840376-9091-4a3b-8c0d-f0d55b3e7bd3"));


            }
        });
    }

    private class MyAcunc extends AsyncTask<URL,Void,Bitmap>{

        protected Bitmap doInBackground(URL...urls){
            URL url = urls[0];
            HttpURLConnection connection = null;
            try{
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                return BitmapFactory.decodeStream(bufferedInputStream);
            }catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }
        // When all async task done
        protected void onPostExecute(Bitmap result){
            if(result!=null){
                img.setImageBitmap(result);
            } else {
                Toast.makeText(MainActivity.this, "الصورة غير موجودة", Toast.LENGTH_SHORT).show();
            }
        }
    }

    protected URL stringToURL(String urlStr) {
        try {
            url = new URL(urlStr);
            return url;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
