package jadx.core.utils;

import android.support.v7.appcompat.C0299R;

/* JADX INFO: loaded from: classes.dex */
public class StringUtils {
    private StringUtils() {
    }

    public static String escape(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            switch (cCharAt) {
                case ' ':
                case '$':
                case ',':
                case '.':
                case '/':
                case C0299R.styleable.AppCompatTheme_activityChooserViewStyle /* 59 */:
                case C0299R.styleable.AppCompatTheme_toolbarStyle /* 60 */:
                    sb.append('_');
                    break;
                case '*':
                case C0299R.styleable.AppCompatTheme_popupMenuStyle /* 62 */:
                case '?':
                case C0299R.styleable.AppCompatTheme_controlBackground /* 93 */:
                    break;
                case C0299R.styleable.AppCompatTheme_colorButtonNormal /* 91 */:
                    sb.append('A');
                    break;
                default:
                    sb.append(cCharAt);
                    break;
            }
        }
        return sb.toString();
    }

    public static String escapeResValue(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            switch (cCharAt) {
                case '\b':
                    sb.append("\\b");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\"':
                    sb.append("&quot;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '\'':
                    sb.append("&apos;");
                    break;
                case C0299R.styleable.AppCompatTheme_toolbarStyle /* 60 */:
                    sb.append("&lt;");
                    break;
                case C0299R.styleable.AppCompatTheme_popupMenuStyle /* 62 */:
                    sb.append("&gt;");
                    break;
                default:
                    sb.append(cCharAt);
                    break;
            }
        }
        return sb.toString();
    }

    public static String escapeXML(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            switch (cCharAt) {
                case '\"':
                    sb.append("&quot;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '\'':
                    sb.append("&apos;");
                    break;
                case C0299R.styleable.AppCompatTheme_toolbarStyle /* 60 */:
                    sb.append("&lt;");
                    break;
                case C0299R.styleable.AppCompatTheme_popupMenuStyle /* 62 */:
                    sb.append("&gt;");
                    break;
                default:
                    sb.append(cCharAt);
                    break;
            }
        }
        return sb.toString();
    }

    private static void processChar(int i, StringBuilder sb) {
        switch (i) {
            case 8:
                sb.append("\\b");
                break;
            case 9:
                sb.append("\\t");
                break;
            case 10:
                sb.append("\\n");
                break;
            case 12:
                sb.append("\\f");
                break;
            case 13:
                sb.append("\\r");
                break;
            case 34:
                sb.append("\\\"");
                break;
            case 39:
                sb.append('\'');
                break;
            case C0299R.styleable.AppCompatTheme_colorSwitchThumbNormal /* 92 */:
                sb.append("\\\\");
                break;
            default:
                if (32 <= i && i <= 126) {
                    sb.append((char) i);
                } else {
                    sb.append("\\u").append(String.format("%04x", Integer.valueOf(i)));
                }
                break;
        }
    }

    public static String unescapeChar(char c) {
        if (c == '\'') {
            return "'\\''";
        }
        StringBuilder sb = new StringBuilder();
        processChar(c, sb);
        return "'" + sb.toString() + '\'';
    }

    public static String unescapeString(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            processChar(str.charAt(i) & 65535, sb);
        }
        return "\"" + sb.toString() + '\"';
    }
}
