package com.sggdev.wcsdk;

import static com.sggdev.wcsdk.SampleGattAttributes.BT_WIFI_RELOAD_NOTI_CHAR1;

public class BabaikaWiFiReload extends BabaikaBLEDevice {
    static String uuid = "d07fd9eb-3677-4125-b28e-2b6f0265dcae";
    static String BT_WEBCAM_ICO = "ic_wifi_error_device";

    BabaikaWiFiReload() {
        putCommNotification(new BabaikaCommonWiFiConfig(BT_WIFI_RELOAD_NOTI_CHAR1));
    }

    String getPictureName() {
        return BT_WEBCAM_ICO;
    }
}
