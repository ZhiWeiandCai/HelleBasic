package com.example.czw.hellebasic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.czw.hellebasic.net.ApiListener;
import com.example.czw.hellebasic.net.VolleyHelperApi;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener{

    private TextView mTextView;
    private ChartView mChartView1;
    private ChartView mChartView2;
    private Button mButton;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mTextView = (TextView) view.findViewById(R.id.tv);

        init(view);

        return view;
    }

    private void init(View view) {
        mButton = (Button) view.findViewById(R.id.bt);
        mButton.setOnClickListener(this);
        mChartView1 = (ChartView) view.findViewById(R.id.chart_view_1);
        mChartView2 = (ChartView) view.findViewById(R.id.chart_view_2);
        setData();
    }

    private void setData() {
        String title = "7日年化收益率(%)";
        String[] xLabel1 = {"12-11", "12-12", "12-13", "12-14", "12-15", "12-16", "12-17"};
        String[] xLabel2 = {"2-13", "2-14", "2-15", "2-16", "2-17", "2-18", "2-19"};
        String[] data1 = {"2.92", "2.99", "3.20", "2.98", "2.92", "2.94", "2.90"};
        String[] data2 = {"2.50", "2.50", "2.50", "2.50", "2.50", "2.50", "2.50"};
        mChartView1.setTitle(title);
        mChartView1.setxLabel(xLabel1);
        mChartView1.setData(data1);
        mChartView1.fresh();
        mChartView2.setTitle(title);
        mChartView2.setxLabel(xLabel2);
        mChartView2.setData(data2);
        mChartView2.fresh();
    }

    public void load(View view) {
        Toast.makeText(getActivity(), "正在加载数据...", Toast.LENGTH_SHORT).show();
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), "数据加载成功", Toast.LENGTH_SHORT).show();
                setData();
            }
        }, 2000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                load(mButton);
                break;
        }
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
