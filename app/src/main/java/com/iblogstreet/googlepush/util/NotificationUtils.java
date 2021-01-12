package com.iblogstreet.googlepush.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

import androidx.core.app.NotificationCompat;

import com.iblogstreet.googlepush.R;
import com.iblogstreet.googlepush.bean.NotifyBean;


/**
 * @author junwang
 * @aate 2020/11/23 5:49 PM
 * @desc
 **/
public class NotificationUtils {
    private static final String ID = "com.iblogstreet.googlepush.push";
    private static final String NAME = "push";

    public static void sendNotification(Context context, NotifyBean bean) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager == null) {
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(ID, NAME, NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }

        Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.push);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification notification = new NotificationCompat.Builder(context, ID)
                .setContentTitle(bean.title)
                .setContentText(bean.content)
                .setSmallIcon(R.drawable.push_small)
                .setLargeIcon(bmp)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)

                .setDefaults(Notification.DEFAULT_ALL)
                .build();

        notification.flags = Notification.FLAG_AUTO_CANCEL;

        if (!TextUtils.isEmpty(bean.link)) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(bean.link));
            notification.contentIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        }
        manager.notify(1, notification);
    }
}
