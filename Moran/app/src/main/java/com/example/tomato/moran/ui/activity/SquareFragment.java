package com.example.tomato.moran.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.tomato.moran.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomato on 2015/9/29.
 */
public class SquareFragment extends Fragment {
    private Spinner mSpinner;
    private View v;
    private ImageView mPhoto;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        JSONObject object = new JSONObject();
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_square, container, false);
        addItemOnSpinner();
        mPhoto = (ImageView) v.findViewById(R.id.photos);

        //把照片显示在BaseActivity
        if(PublishActivity.bmp != null){
            mPhoto.setImageBitmap(PublishActivity.bmp);
            PublishActivity.bmp = null;//释放内存
        }


        return v;
    }

    //给下拉列表添加选项
    private void addItemOnSpinner() {
        mSpinner = (Spinner) v.findViewById(R.id.spinner);
        List<String> list = new ArrayList<>();
        list.add("附近500米");
        list.add("附近1000米");
        list.add("附近2000米");
        list.add("附近5000米");
        list.add("全市");

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (getActivity(),android.R.layout.simple_spinner_dropdown_item,list);

        mSpinner.setAdapter(adapter);
    }


}
