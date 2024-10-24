package com.sggdev.wcsdk;

import static com.sggdev.wcsdk.BabaikaConfigNotif.BabaikaConfigItem.CFG_OPT_PASSWORD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kotlin.Pair;

public class BabaikaCommonWiFiConfig extends BabaikaConfigNotif {
    public final static String KEY_SSID = "s";
    public final static String KEY_SSID_PASS = "k";
    public final static String KEY_SSID_DEFAULT = "ssid";
    public final static String KEY_SSID_PASS_DEFAULT = "**";

    BabaikaCommonWiFiConfig() {
        this("");
    }

    public static class BabaikaCommonConfigRecord {
        private final String key;
        private final String def;

        BabaikaCommonConfigRecord(String aKey, String aDefValue) {
            key = aKey;
            def = aDefValue;
        }

        String getKey() { return key; }
        String getDefault() { return def; }
    }

    public List<BabaikaCommonConfigRecord> genFields(Pair<String, String>... args) {
        List<BabaikaCommonConfigRecord> fields = new ArrayList<>();
        for (Pair<String, String> arg : args) {
            fields.add(new BabaikaCommonConfigRecord(arg.getFirst(), arg.getSecond()));
        }
        return  fields;
    }

    BabaikaCommonWiFiConfig(String chuuid) {
        super(chuuid);
        final List<BabaikaCommonConfigRecord> defaults = new ArrayList<>();
        addOriginalDefaultKeys(defaults);
        initFromList(defaults);
    }

    public static List<BabaikaCommonConfigRecord> genDefaultKeys() {
        List<BabaikaCommonConfigRecord> fields = new ArrayList<>();
        addOriginalDefaultKeys(fields);
        return fields;
    }

    public static List<BabaikaCommonConfigRecord> genDefaultKeysWithFilter(List<String> aFilter) {
        List<BabaikaCommonConfigRecord> fields = new ArrayList<>();
        addOriginalDefaultKeysWithFilter(fields, aFilter);
        return fields;
    }

    public static List<BabaikaCommonConfigRecord> genDefaultKeysWithFilter(String... aFilter) {
        return genDefaultKeysWithFilter(new ArrayList<>(Arrays.asList(aFilter)));
    }

    public static void addDefaultKeys(List<BabaikaCommonConfigRecord> fields) {
        addOriginalDefaultKeys(fields);
    }

    public static void addOriginalDefaultKeys(List<BabaikaCommonConfigRecord> fields) {
        addOriginalDefaultKeysWithFilter(fields, new ArrayList<>(Arrays.asList(KEY_SSID, KEY_SSID_PASS)));
    }

    public static void addOriginalDefaultKeysWithFilter(List<BabaikaCommonConfigRecord> fields, List<String> aFilter) {
        if (findInFilter(aFilter, KEY_SSID)) {
            fields.add(new BabaikaCommonConfigRecord(KEY_SSID, KEY_SSID_DEFAULT));
        }
        if (findInFilter(aFilter, KEY_SSID_PASS)) {
            fields.add(new BabaikaCommonConfigRecord(KEY_SSID_PASS, KEY_SSID_PASS_DEFAULT));
        }
    }

    public static void removeKey(List<BabaikaCommonConfigRecord> fields, String aKey) {
        for (int i = fields.size()-1; i >= 0; i--) {
            if(fields.get(i).getKey().equals(aKey)){
                fields.remove(i);
            }
        }
    }

    BabaikaCommonWiFiConfig(String chuuid, List<BabaikaCommonConfigRecord> fields) {
        super(chuuid);
        initFromList(fields);
    }

    protected static BabaikaCommonConfigRecord findInList(List<BabaikaCommonConfigRecord> fields, String record) {
        for (BabaikaCommonConfigRecord field : fields) {
            if(field.getKey().equals(record)){
                return field;
            }
        }
        return null;
    }

    protected static boolean findInFilter(List<String> filter, String record) {
        for (String field : filter) {
            if(field.equals(record)){
                return true;
            }
        }
        return false;
    }

    protected void initFromList(List<BabaikaCommonConfigRecord> fields) {
        BabaikaCommonConfigRecord f1;
        if ((f1 = findInList(fields, KEY_SSID)) != null) {
            addField(KEY_SSID, "ic_cfg_wifi_ssid", "ssid_title", f1.getDefault());
        }
        if ((f1 = findInList(fields,KEY_SSID_PASS)) != null) {
            BabaikaConfigItem it = addField(KEY_SSID_PASS, "dev_cfg_password", "ssid_password_title", f1.getDefault());
            it.setOption(CFG_OPT_PASSWORD);
        }
    }
}
