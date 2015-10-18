package com.example.tomato.moran.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tomato.moran.R;

import org.w3c.dom.Text;

import java.io.Serializable;

/**
 * Created by tomato on 2015/10/3.
 */
public class PublishActivity extends AppCompatActivity {
    private ImageButton mButton;
    private ImageView mImageView;
    private TextView mText;
    private Button mPublish;

    public static Bitmap bmp = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_photo);

        //得到相机得到BaseActivity传过来的照片
        bmp = getIntent().getParcelableExtra(BaseActivity.PHOTO);
        mImageView = (ImageView) findViewById(R.id.imageView);

        if(bmp != null){
            mImageView.setImageBitmap(bmp);//把得到的照片给ImageView
        }


        //跳转到父Activity
        mButton = (ImageButton) findViewById(R.id.backButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PublishActivity.this, BaseActivity.class);
                startActivity(intent);
            }
        });

        //重新拍摄
        mText = (TextView) findViewById(R.id.againText);
        mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

        //发布照片
        mPublish = (Button) findViewById(R.id.publishButton);
        mPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PublishActivity.this,BaseActivity.class);

//                mImageView.setDrawingCacheEnabled(true);
//                bmp = Bitmap.createBitmap(mImageView.getDrawingCache());


//                intent.putExtra("image",bmp);
                finish();
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //获取拍好的照片
        bmp = (Bitmap) data.getExtras().get("data");
        if (bmp != null){
            mImageView.setImageBitmap(bmp);
        }
    }

    //放大bitmap
    private Bitmap Big(Bitmap bm){
        int rawHeight = bm.getHeight();
        int rawWidth = bm.getWidth();

        int newHeight = 150;
        int newWidth = 200;

        return bm;
    }
}
