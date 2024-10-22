package com.sggdev.wcsdk;

import static com.sggdev.wcsdk.BabaikaConfigNotif.BabaikaConfigItem.CFG_OPT_PASSWORD;
import static com.sggdev.wcsdk.BabaikaConfigNotif.BabaikaConfigItem.CFG_OPT_READONLY;

public class BabaikaCommonConfig extends BabaikaCommonWiFiConfig {

    public final static String KEY_USER = "u";
    public final static String KEY_PASS = "p";
    public final static String KEY_HOST = "h";
    public final static String KEY_DEVICE = "d";

    BabaikaCommonConfig() {
        this("");
    }

    BabaikaCommonConfig(String chuuid) {
        super(chuuid);
        addField(KEY_USER, "ic_user", "username_title", "");
        BabaikaConfigItem it = addField(KEY_PASS, "dev_cfg_password", "password_title", "***");
        it.setOption(CFG_OPT_PASSWORD);
        addField(KEY_HOST, "ic_host", "hostname_title", "https://");
        addField(KEY_DEVICE, "ic_default_device", "device_name_title", "");
    }
}
