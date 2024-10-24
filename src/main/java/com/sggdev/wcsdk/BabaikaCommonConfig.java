package com.sggdev.wcsdk;

import static com.sggdev.wcsdk.BabaikaConfigNotif.BabaikaConfigItem.CFG_OPT_PASSWORD;
import static com.sggdev.wcsdk.BabaikaConfigNotif.BabaikaConfigItem.CFG_OPT_READONLY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BabaikaCommonConfig extends BabaikaCommonWiFiConfig {

    public final static String KEY_USER = "u";
    public final static String KEY_PASS = "p";
    public final static String KEY_HOST = "h";
    public final static String KEY_DEVICE = "d";
    public final static String KEY_USER_DEFAULT = "";
    public final static String KEY_PASS_DEFAULT = "***";
    public final static String KEY_HOST_DEFAULT = "https://";
    public final static String KEY_DEVICE_DEFAULT = "";

    BabaikaCommonConfig() {
        this("");
    }

    BabaikaCommonConfig(String chuuid) {
        super(chuuid);
        final List<BabaikaCommonConfigRecord> defaults = new ArrayList<>();
        addOriginalDefaultKeys(defaults);
        initFromList(defaults);
    }

    public static List<BabaikaCommonConfigRecord> genDefaultKeys() {
        List<BabaikaCommonConfigRecord> fields = BabaikaCommonWiFiConfig.genDefaultKeys();
        addOriginalDefaultKeys(fields);
        return  fields;
    }

    public static List<BabaikaCommonConfigRecord> genDefaultKeysWithFilter(List<String> aFilter) {
        List<BabaikaCommonConfigRecord> fields = BabaikaCommonWiFiConfig.genDefaultKeysWithFilter(aFilter);
        addOriginalDefaultKeysWithFilter(fields, aFilter);
        return fields;
    }

    public static List<BabaikaCommonConfigRecord> genDefaultKeysWithFilter(String... aFilter) {
        return genDefaultKeysWithFilter(new ArrayList<>(Arrays.asList(aFilter)));
    }

    public static void addDefaultKeys(List<BabaikaCommonConfigRecord> fields) {
        BabaikaCommonWiFiConfig.addDefaultKeys(fields);
        addOriginalDefaultKeys(fields);
    }

    public static void addOriginalDefaultKeys(List<BabaikaCommonConfigRecord> fields) {
        addOriginalDefaultKeysWithFilter(fields, new ArrayList<>(Arrays.asList(KEY_USER, KEY_PASS, KEY_HOST, KEY_DEVICE)));
    }

    public static void addOriginalDefaultKeysWithFilter(List<BabaikaCommonConfigRecord> fields, List<String> aFilter) {
        if (findInFilter(aFilter, KEY_USER)) {
            fields.add(new BabaikaCommonConfigRecord(KEY_USER, KEY_USER_DEFAULT));
        }
        if (findInFilter(aFilter, KEY_PASS)) {
            fields.add(new BabaikaCommonConfigRecord(KEY_PASS, KEY_PASS_DEFAULT));
        }
        if (findInFilter(aFilter, KEY_HOST)) {
            fields.add(new BabaikaCommonConfigRecord(KEY_HOST, KEY_HOST_DEFAULT));
        }
        if (findInFilter(aFilter, KEY_DEVICE)) {
            fields.add(new BabaikaCommonConfigRecord(KEY_DEVICE, KEY_DEVICE_DEFAULT));
        }
    }

    @Override
    protected void initFromList(List<BabaikaCommonConfigRecord> fields) {
        super.initFromList(fields);
        BabaikaCommonConfig.BabaikaCommonConfigRecord f1;
        if ((f1 = findInList(fields, KEY_USER)) != null) {
            addField(KEY_USER, "ic_user", "username_title", f1.getDefault());
        }
        if ((f1 = findInList(fields,KEY_PASS)) != null) {
            BabaikaConfigItem it = addField(KEY_PASS, "dev_cfg_password", "password_title", f1.getDefault());
            it.setOption(CFG_OPT_PASSWORD);
        }
        if ((f1 = findInList(fields,KEY_HOST)) != null) {
            addField(KEY_HOST, "ic_host", "hostname_title", f1.getDefault());
        }
        if ((f1 = findInList(fields,KEY_DEVICE)) != null) {
            addField(KEY_DEVICE, "ic_default_device", "device_name_title", f1.getDefault());
        }
    }

    BabaikaCommonConfig(String chuuid, List<BabaikaCommonConfigRecord> fields) {
        super(chuuid, fields);
        initFromList(fields);
    }
}
