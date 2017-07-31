package com.example.czw.hellebasic.net;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.czw.hellebasic.App;
import com.example.czw.hellebasic.util.LogHelper;

/**
 * Created by czw on 2017/3/24.
 */

public class VolleyHelperApi extends VolleyHelperApiBase {
    private static final String TAG = "VolleyHelpApi";

    private static VolleyHelperApi sVolleyHelperApi;

    public static VolleyHelperApi getVolleyHApiInstance() {
        if (sVolleyHelperApi == null) {
            sVolleyHelperApi = new VolleyHelperApi();
        }
        return sVolleyHelperApi;
    }

    private VolleyHelperApi() {}



    public void getData(String url, final ApiListener apiListener) {
        LogHelper.i(TAG, "---getData()");
        StringRequest request = new StringRequest(TEST_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                LogHelper.i(TAG, response);
                apiListener.onResult(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                int type = VolleyErrorHelper.getErrType(error);
                switch (type) {
                    case 1:
                        LogHelper.i(TAG, "超时");
                        break;
                    case 2:
                        LogHelper.i(TAG, "服务器问题");
                        break;
                    case 3:
                        LogHelper.i(TAG, "网络问题");
                        break;
                    default:
                        LogHelper.i(TAG, "未知错误");
                }
            }
        });
        App.getInstance().addToRequestQueue(request, TAG);
    }


}
