package com.h6ah4i.example.animatedvectordrawablecompatproguardissue;

import android.graphics.drawable.Animatable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateVectorImage();
            }
        });
    }

    void animateVectorImage() {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Animatable animatableDrawable = (Animatable) imageView.getDrawable();
        animatableDrawable.start();
    }
}
