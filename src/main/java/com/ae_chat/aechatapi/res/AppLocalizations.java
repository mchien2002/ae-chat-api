package com.ae_chat.aechatapi.res;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AppLocalizations {
    private final String FILE_PATH = "src/main/java/com/ae_chat/aechatapi/res/l10n";
    public FileInputStream vi;
    public FileInputStream en;

    public AppLocalizations() throws FileNotFoundException {
        vi = new FileInputStream(FILE_PATH + "/intl_vi.properties");
        en = new FileInputStream(FILE_PATH + "/intl_en.properties");
    }
}