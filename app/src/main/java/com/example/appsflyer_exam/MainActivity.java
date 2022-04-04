package com.example.appsflyer_exam;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AFInAppEventType; // Predefined event names
import com.appsflyer.AFInAppEventParameterName; // Predefined parameter names

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.appsflyer.attribution.AppsFlyerRequestListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView link;
    Map<String, Object> eventValues = new HashMap<String, Object>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppsFlyerLib.getInstance().init("gJE2umzLmBQn8zW4rLQKbK", null, this);
        AppsFlyerLib.getInstance().start(getApplicationContext(), "gJE2umzLmBQn8zW4rLQKbK", new AppsFlyerRequestListener() {
            @Override
            public void onSuccess() {
                Log.d("LOG_TAG", "Launch sent successfully, got 200 response code from server");
            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d("LOG_TAG", "Launch failed to be sent:\n" +
                        "Error code: " + i + "\n"
                        + "Error description: " + s);
            }
        });
        eventValues.put(AFInAppEventParameterName.PRICE, 1234.56);
        eventValues.put(AFInAppEventParameterName.CONTENT_ID,"1234567");

    AppsFlyerLib.getInstance().setDebugLog(true);
    setContentView(R.layout.activity_main);
    link = findViewById(R.id.link);
    link.setMovementMethod(LinkMovementMethod.getInstance());
        AppsFlyerLib.getInstance().logEvent(getApplicationContext(), AFInAppEventType.ADD_TO_WISH_LIST , eventValues);

    }

}


