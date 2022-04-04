package com.example.appsflyer_exam;

import androidx.annotation.NonNull;

public interface AppsFlyerRequestListener {
    void onSuccess();
    void onError(int code, @NonNull String error);
}
