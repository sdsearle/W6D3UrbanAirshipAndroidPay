package com.example.admin.w6d3urbanairshipandroidpay;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;

import android.support.v4.content.ContextCompat;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Autopilot;
import com.urbanairship.UAirship;

import static java.security.AccessController.getContext;

/**
 * Created by admin on 10/4/2017.
 */

public class MyAutoPilot extends Autopilot{

    @Override
    public void onAirshipReady(@NonNull UAirship airship) {
        airship.getPushManager().setUserNotificationsEnabled(true);

        // Android O
        if (Build.VERSION.SDK_INT >= 26) {
            Context context = UAirship.getApplicationContext();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            NotificationChannel channel = new NotificationChannel("customChannel",
                    context.getString(R.string.custom_channel_name),
                            NotificationManager.IMPORTANCE_DEFAULT);

            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public AirshipConfigOptions createAirshipConfigOptions(@NonNull Context context) {
        AirshipConfigOptions options = new AirshipConfigOptions.Builder()
                .setDevelopmentAppKey("cMrW06cdRh6lf9aOgf5Nqw")
                .setDevelopmentAppSecret("PKGJ9cZEQx2NAcXTw0fQlw")
                .setProductionAppKey("Your Production App Key")
                .setProductionAppSecret("Your Production App Secret")
                .setInProduction(!BuildConfig.DEBUG)
                .setGcmSender("Your Google API Project Number") // FCM/GCM sender ID
                .setNotificationIcon(R.drawable.common_full_open_on_phone)
                //.setNotificationAccentColor(ContextCompat.getColor(getA, R.color.colorAccent))
                .setNotificationChannel("customChannel")
                .build();

        return options;
    }

}
