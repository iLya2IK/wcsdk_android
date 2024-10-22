package com.sggdev.wcsdk;

import static com.sggdev.wcsdk.BabaikaConfigNotif.BabaikaConfigItem.CFG_OPT_PASSWORD;
import static com.sggdev.wcsdk.BabaikaConfigNotif.BabaikaConfigItem.CFG_OPT_READONLY;

public class BabaikaCommonWiFiConfig extends BabaikaConfigNotif {
    public final static String KEY_SSID = "s";
    public final static String KEY_SSID_PASS = "k";

    BabaikaCommonWiFiConfig() {
        this("");
    }

    BabaikaCommonWiFiConfig(String chuuid) {
        super(chuuid);
        addField(KEY_SSID, "ic_cfg_wifi_ssid", "ssid_title", "");
        BabaikaConfigItem it = addField(KEY_SSID_PASS, "dev_cfg_password", "ssid_password_title", "***");
        it.setOption(CFG_OPT_PASSWORD);
    }
}
