package com.example.tomato.moran.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tomato.moran.R;



/**
 * Created by tomato on 2015/10/1.
 */
public class MyFragment extends Fragment{
    private ImageView mHead;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_my,container,false);

        //单击头像按钮进入登录界面
        mHead = (ImageView) v.findViewById(R.id.comment_from_image);
        mHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SignInActivity.class);
                startActivity(intent);
            }
        });

        return v;


    }
}
