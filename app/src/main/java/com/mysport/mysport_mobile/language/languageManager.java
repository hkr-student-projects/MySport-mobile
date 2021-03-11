package com.mysport.mysport_mobile.language;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;
import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

public class languageManager {
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({ENGLISH, SWEDISH, NORWEGIAN})
    public @interface languageDefiner {
        String[] SUPPORTED_LANGUAGES = {ENGLISH, SWEDISH, NORWEGIAN};
    }

    static final String ENGLISH = "en";
    static final String SWEDISH = "se";
    static final String NORWEGIAN = "no";

    private static final String LANGUAGE_KEY = "language_key";


    public static Context setLocale(Context mContext) {
        return updateResources(mContext, getLanguagePref(mContext));
    }


    public static Context setNewLocale(Context mContext, @languageDefiner String language) {
        setLanguagePref(mContext, language);
        return updateResources(mContext, language);
    }

    public static String getLanguagePref(Context mContext) {
        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        return mPreferences.getString(LANGUAGE_KEY, ENGLISH);
    }

    private static void setLanguagePref(Context mContext, String localeKey) {
        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        mPreferences.edit().putString(LANGUAGE_KEY, localeKey).apply();
    }

    private static Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        if (Build.VERSION.SDK_INT >= 17) {
            config.setLocale(locale);
            context = context.createConfigurationContext(config);
        } else {
            config.locale = locale;
            res.updateConfiguration(config, res.getDisplayMetrics());
        }
        return context;
    }

    public static Locale getLocale(Resources res) {
        Configuration config = res.getConfiguration();
        return Build.VERSION.SDK_INT >= 24 ? config.getLocales().get(0) : config.locale;
    }
}
