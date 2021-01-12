package com.iblogstreet.googlepush.view.scheme;

import android.content.Context;
import android.net.Uri;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.iblogstreet.googlepush.util.RouteList;

import java.util.Set;


/**
 * @author junwang
 * @aate 2021/1/12 3:06 PM
 * @desc
 **/
public class SchemeUtil {
    public static final String SCHEME = "googlepush://com.iblogstreet";
    public static final String TEST_SCHEME = SCHEME + RouteList.APP.TEST_SCHEME;


    public static void toNative(Context context, Uri uri, NavCallback navCallback) {
        String url = uri.getScheme() + "://" + uri.getHost();

        //说明是客户端scheme
        if (url.startsWith(SchemeUtil.SCHEME)) {
            Set<String> params = uri.getQueryParameterNames();
            Postcard postcard = null;
            //拦截替换任务待指定
            if (uri.toString().startsWith(TEST_SCHEME)) {
                postcard = ARouter.getInstance().build(RouteList.APP.TEST_SCHEME);
                for (String param : params) {
                    String value = uri.getQueryParameter(param);
                    postcard.withString(param, value);
                }
            }

            postcard.navigation(context, navCallback);
        } else {
            if (navCallback != null) {
                navCallback.onLost(null);
            }
        }
    }


}
