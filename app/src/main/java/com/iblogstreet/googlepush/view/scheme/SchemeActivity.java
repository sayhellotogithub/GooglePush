package com.iblogstreet.googlepush.view.scheme;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;


public class SchemeActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = getIntent().getData();
        Log.e("SchemeActivity", uri.toString());
        if (uri != null) {
            SchemeUtil.toNative(this, uri, new NavCallback() {
                @Override
                public void onArrival(Postcard postcard) {
                    finish();
                }

                @Override
                public void onLost(Postcard postcard) {
                    finish();
                }
            });
        } else {
            finish();
        }
    }
}
