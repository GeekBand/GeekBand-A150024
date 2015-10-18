package com.example.tomato.moran.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.example.tomato.moran.R;

public class BaseActivity extends AppCompatActivity {
    private ImageView mCameraButton;
    private RadioGroup mRg;
    private RadioButton squareRb;
    private RadioButton myRb;
    private Fragment fragment;
    private FragmentManager fm;

    public static final String PHOTO = "com.example.tomato.moran.ui.activity.photo";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_base);

        //默认显示广场的Fragment
        fm = getFragmentManager();
        fragment = fm.findFragmentById(R.id.fragmentContainer);
        initFragment();

        mRg = (RadioGroup) findViewById(R.id.radiogroup);
        squareRb = (RadioButton) findViewById(R.id.squareRb);
        myRb = (RadioButton) findViewById(R.id.myRb);
        //单击"我的"按钮
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = fm.beginTransaction();
                if(checkedId == squareRb.getId()) {
                    fragment = new SquareFragment();
                    transaction.replace(R.id.fragmentContainer,fragment).commit();
                }

                if(checkedId == myRb.getId()) {
                    fragment = new MyFragment();
                    transaction.replace(R.id.fragmentContainer,fragment).commit();
                }


            }
        });

        //单击照相按钮
        mCameraButton = (ImageView) findViewById(R.id.cameraButton);
        mCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });



    }

    //启动发布照片
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //获取拍好的照片
        if(requestCode == 0 && resultCode == RESULT_OK){
            Bitmap bm = (Bitmap) data.getExtras().get("data");
            if (bm != null){
                Intent intent = new Intent(this,PublishActivity.class);
                intent.putExtra(PHOTO, bm);
                startActivity(intent);
            }
        }




    }

    //默认显示的Fragment
    private void initFragment() {
        FragmentTransaction transaction = fm.beginTransaction();
            fragment = new SquareFragment();
            transaction.replace(R.id.fragmentContainer,fragment).commit();
    }


}
