package com.example.czw.hellebasic;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.czw.hellebasic.net.ApiListener;
import com.example.czw.hellebasic.net.VolleyHelperApi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener{

    private TextView mTextView;
    private Button button1;
    private Button button2;
    private TextView textView1;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mTextView = (TextView) view.findViewById(R.id.tv);



        return view;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onResume() {
        super.onResume();
        //getNetData();
    }

    private void getNetData() {
        VolleyHelperApi.getVolleyHApiInstance().getData(null, new ApiListener() {
            @Override
            public void onResult(Object result) {
                mTextView.setText((String) result);
            }

            @Override
            public void onError(Object e) {

            }
        });
    }



}
