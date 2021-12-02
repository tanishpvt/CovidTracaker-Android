package com.tanish.pvt.covid_19.Data;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Data {

    private static Data instance;
    private RequestQueue requestQueue;

    private static Context ctx;

    private Data(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();

    }

    public static synchronized Data getInstance(Context context) {
        if (instance == null) {
            instance = new Data(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}
