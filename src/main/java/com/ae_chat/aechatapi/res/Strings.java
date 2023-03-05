package com.ae_chat.aechatapi.res;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import com.ae_chat.aechatapi.entity.enum_model.Locale;

public class Strings {
    private Properties p;

    public Strings(Locale locale) throws UnsupportedEncodingException, IOException {
        AppLocalizations appLocalizations = new AppLocalizations();
        System.setProperty("file.encoding", "UTF-8");
        p = new Properties();
        switch (locale) {
            case EN:
                p.load(new InputStreamReader(appLocalizations.en, "UTF-8"));
                break;
            case VI:
                p.load(new InputStreamReader(appLocalizations.vi, "UTF-8"));
                break;
            default:
                p.load(new InputStreamReader(appLocalizations.vi, "UTF-8"));
                break;
        }
    }

    public String trans(String key) {
        try {
            return p.getProperty(key);
        } catch (Exception e) {
            return e.toString();
        }
    }
}
