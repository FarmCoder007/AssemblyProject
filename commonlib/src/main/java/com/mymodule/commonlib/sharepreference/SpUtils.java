package com.mymodule.commonlib.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


import static android.content.Context.MODE_PRIVATE;

/**
 * 配置文件操作
 * SharedPreferences 作为dao层
 */
public class SpUtils {

    private static SpUtils sInstance;
    private SharedPreferences sharedReadable;
    private Editor sharedWritable;

    private SpUtils(Context context) {
        sharedReadable = context.getSharedPreferences(ConfigKey.CONFIG_FILE_NAME, MODE_PRIVATE);
        sharedWritable = sharedReadable.edit();
    }

    public static SpUtils getInstance(Context context) {
        if (sInstance == null) {
            synchronized (SpUtils.class) {
                if (sInstance == null) {
                    sInstance = new SpUtils(context);
                }
            }
        }
        return sInstance;
    }

    public String getStringValue(String key, String defValue) {
        return sharedReadable.getString(key, defValue);
    }

    public String getStringValue(String key) {
        return sharedReadable.getString(key, null);
    }

    public int getIntValue(String key, int defValue) {
        return sharedReadable.getInt(key, defValue);
    }

    public int getIntValue(String key) {
        return sharedReadable.getInt(key, 0);
    }

    public boolean getBooleanValue(String key, boolean defValue) {
        return sharedReadable.getBoolean(key, defValue);
    }

    public boolean getBooleanValue(String key) {
        return sharedReadable.getBoolean(key, false);
    }

    public long getLongValue(String key) {
        return sharedReadable.getLong(key, 0);
    }

    public void saveValue(String key, Object value) {
        if (value instanceof Integer) {
            sharedWritable.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            sharedWritable.putLong(key, (Long) value);
        } else if (value instanceof Boolean) {
            sharedWritable.putBoolean(key, (Boolean) value);
        } else if (value instanceof Float) {
            sharedWritable.putFloat(key, (Float) value);
        } else {
            sharedWritable.putString(key, (String) value);
        }
        sharedWritable.commit();
    }

    public void remove(String... keys) {
        for (String key : keys) {
            sharedWritable.remove(key);
        }
        sharedWritable.commit();
    }
}
