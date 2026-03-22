package jadx.api;

import com.android.apksig.apk.ApkUtils;

/* JADX INFO: loaded from: classes.dex */
public enum ResourceType {
    CODE(".dex", ".class"),
    MANIFEST(ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME),
    XML(".xml"),
    ARSC(".arsc"),
    FONT(".ttf"),
    IMG(".png", ".gif", ".jpg"),
    LIB(".so"),
    UNKNOWN(new String[0]);

    private final String[] exts;

    ResourceType(String... strArr) {
        this.exts = strArr;
    }

    public static ResourceType getFileType(String str) {
        for (ResourceType resourceType : values()) {
            for (String str2 : resourceType.getExts()) {
                if (str.endsWith(str2)) {
                    return resourceType;
                }
            }
        }
        return UNKNOWN;
    }

    public static boolean isSupportedForUnpack(ResourceType resourceType) {
        switch (resourceType) {
            case CODE:
            case LIB:
            case FONT:
            case IMG:
            case UNKNOWN:
            default:
                return false;
            case MANIFEST:
            case XML:
            case ARSC:
                return true;
        }
    }

    public final String[] getExts() {
        return this.exts;
    }
}
