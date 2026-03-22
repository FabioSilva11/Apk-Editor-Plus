package com.gmail.heagoo.apkeditor;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.support.v7.appcompat.C0299R;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1473e;
import com.gmail.heagoo.common.C1487s;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class SettingActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener, View.OnLongClickListener {
    /* JADX INFO: renamed from: AB */
    private void m2536AB() {
        ActionBar actionBar = getActionBar();
        View viewInflate = getLayoutInflater().inflate(R.layout.mtrl_toolbar, (ViewGroup) null);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(-2, -1, 17);
        TextView textView = (TextView) viewInflate.findViewById(android.R.id.title);
        textView.setText(R.string.action_sett);
        textView.setOnLongClickListener(this);
        actionBar.setCustomView(viewInflate, layoutParams);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    /* JADX INFO: renamed from: D1 */
    private void m2537D1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm_title);
        builder.setMessage(R.string.confirm_message_str);
        builder.setPositiveButton(R.string.yes, new DialogInterfaceOnClickListenerC1324na(this));
        builder.setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: renamed from: D2 */
    private void m2538D2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm_title);
        builder.setMessage(R.string.confirm_message_res);
        builder.setPositiveButton(R.string.yes, new DialogInterfaceOnClickListenerC1325nb(this));
        builder.setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: renamed from: D3 */
    private void m2539D3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm_title);
        builder.setMessage(R.string.confirm_message_mf);
        builder.setPositiveButton(R.string.yes, new DialogInterfaceOnClickListenerC1326nc(this));
        builder.setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: renamed from: D4 */
    private void m2540D4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm_title);
        builder.setMessage(R.string.confirm_message_clean);
        builder.setPositiveButton(R.string.yes, new DialogInterfaceOnClickListenerC1327nd(this));
        builder.setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: renamed from: a */
    private static int m2541a(String str) {
        return "0".equals(str) ? R.string.summary_decode_all_files : "1".equals(str) ? R.string.summary_decode_partial_files : R.string.summary_decide_at_decoding;
    }

    /* JADX INFO: renamed from: a */
    public static String m2542a(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("AppListOrder", "");
        String[] stringArray = context.getResources().getStringArray(R.array.order_value);
        for (String str : stringArray) {
            if (string.equals(str)) {
                return string;
            }
        }
        return stringArray[0];
    }

    /* JADX INFO: renamed from: a */
    private void m2543a(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    m2543a(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m2544b(Context context) {
        int iIntValue;
        try {
            iIntValue = Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString("CompressionLevel", "9")).intValue();
        } catch (Exception e) {
            iIntValue = 9;
        }
        if (iIntValue < 0) {
            return 0;
        }
        if (iIntValue <= 9) {
            return iIntValue;
        }
        return 9;
    }

    /* JADX INFO: renamed from: b */
    private static boolean m2545b(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File file2 = new File(file, C1487s.m3525a(8));
        boolean zMkdir = file2.mkdir();
        if (!zMkdir) {
            return zMkdir;
        }
        file2.delete();
        return zMkdir;
    }

    /* JADX INFO: renamed from: c */
    public static String m2546c(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("SignApkWith", "testkey");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private String changeSignatureVersion(Set<String> set) {
        boolean[] zArr = new boolean[4];
        if (set != null) {
            for (String str : set) {
                byte b2 = -1;
                switch (str.hashCode()) {
                    case C0299R.styleable.AppCompatTheme_spinnerDropDownItemStyle /* 49 */:
                        if (str.equals("1")) {
                            b2 = 0;
                        }
                        break;
                    case 50:
                        if (str.equals("2")) {
                            b2 = 1;
                        }
                        break;
                    case C0299R.styleable.AppCompatTheme_actionButtonStyle /* 51 */:
                        if (str.equals("3")) {
                            b2 = 2;
                        }
                        break;
                    case C0299R.styleable.AppCompatTheme_buttonBarStyle /* 52 */:
                        if (str.equals("4")) {
                            b2 = 3;
                        }
                        break;
                }
                if (b2 == 0) {
                    zArr[0] = true;
                } else if (b2 == 1) {
                    zArr[1] = true;
                } else if (b2 == 2) {
                    zArr[2] = true;
                } else if (b2 == 3) {
                    zArr[3] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (zArr[i]) {
                sb.append("v");
                sb.append(i + 1);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: d */
    public static int m2547d(Context context) {
        try {
            return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString("OutputApkName", "2")).intValue();
        } catch (Exception e) {
            return 2;
        }
    }

    /* JADX INFO: renamed from: e */
    public static boolean m2548e(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("SmaliEditingEnabled", true);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean[] enabledSignatureVersions(Context context) {
        boolean[] zArr = new boolean[4];
        for (String str : PreferenceManager.getDefaultSharedPreferences(context).getStringSet("SignatureVersion", new HashSet(Arrays.asList("1", "2")))) {
            byte b2 = -1;
            switch (str.hashCode()) {
                case C0299R.styleable.AppCompatTheme_spinnerDropDownItemStyle /* 49 */:
                    if (str.equals("1")) {
                        b2 = 0;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        b2 = 1;
                    }
                    break;
                case C0299R.styleable.AppCompatTheme_actionButtonStyle /* 51 */:
                    if (str.equals("3")) {
                        b2 = 2;
                    }
                    break;
                case C0299R.styleable.AppCompatTheme_buttonBarStyle /* 52 */:
                    if (str.equals("4")) {
                        b2 = 3;
                    }
                    break;
            }
            if (b2 == 0) {
                zArr[0] = true;
            } else if (b2 == 1) {
                zArr[1] = true;
            } else if (b2 == 2) {
                zArr[2] = true;
            } else if (b2 == 3) {
                zArr[3] = true;
            }
        }
        if (zArr[3] && (!zArr[2] || !zArr[1])) {
            zArr[2] = true;
        }
        return zArr;
    }

    public static boolean extEditor(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("ExternalEditor", false);
    }

    /* JADX INFO: renamed from: f */
    public static boolean m2549f(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("RebuildConfirmation", false);
    }

    /* JADX INFO: renamed from: g */
    public static int m2550g(Context context) {
        try {
            return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString("FileRenameOption", "1")).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: h */
    public static String m2551h(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("DecodeDirectory", null);
        if (string != null) {
            if (string.endsWith("/")) {
                string = string.substring(0, string.length() - 1);
            }
            if (m2545b(string)) {
                return string;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: i */
    public static String m2552i(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("DecodeMode", "2");
        return (string.equals("0") || string.equals("1") || string.equals("2")) ? string : "2";
    }

    public static void lang(SettingActivity settingActivity) {
        C1473e.m3500l(settingActivity);
    }

    public static int smaliApiLevel(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("SmaliApiLevel", "15");
        return (string == null || "".equals(string.trim())) ? Integer.parseInt("15") : Integer.parseInt(string);
    }

    /* JADX INFO: renamed from: a */
    protected final void m2553a() {
        boolean z;
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/ApkEditor");
        if (file.exists() && file.isDirectory()) {
            String[] strArr = {"backups", ".projects"};
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        String name = file2.getName();
                        int i = 0;
                        while (true) {
                            if (i >= 2) {
                                z = false;
                                break;
                            } else {
                                if (name.equals(strArr[i])) {
                                    z = true;
                                    break;
                                }
                                i++;
                            }
                        }
                        if (!z) {
                            m2543a(file2);
                            file2.delete();
                        }
                    } else {
                        file2.delete();
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: d1 */
    public void m2554d1() {
        SharedPreferences.Editor editorEdit = getSharedPreferences("com.gmail.heagoo.apkeditor.pro_preferences", 0).edit();
        editorEdit.putString("string_keywords", "");
        editorEdit.apply();
        Toast.makeText(this, R.string.toast_clean_str, 0).show();
    }

    /* JADX INFO: renamed from: d2 */
    public void m2555d2() {
        SharedPreferences.Editor editorEdit = getSharedPreferences("com.gmail.heagoo.apkeditor.pro_preferences", 0).edit();
        editorEdit.putString("res_keywords", "");
        editorEdit.apply();
        Toast.makeText(this, R.string.toast_clean_res, 0).show();
    }

    /* JADX INFO: renamed from: d3 */
    public void m2556d3() {
        SharedPreferences.Editor editorEdit = getSharedPreferences("com.gmail.heagoo.apkeditor.pro_preferences", 0).edit();
        editorEdit.putString("mf_keywords", "");
        editorEdit.apply();
        Toast.makeText(this, R.string.toast_clean_mf, 0).show();
    }

    /* JADX INFO: renamed from: d4 */
    public void m2557d4() {
        new DialogC1201ey(this, new C1243gj(this, getFilesDir().getAbsolutePath()), R.string.temp_file_cleaned).show();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.m91md(C0037k.m89a(this)));
        super.onCreate(bundle);
        lang(this);
        addPreferencesFromResource(R.xml.settings);
        m2536AB();
        PreferenceManager preferenceManager = getPreferenceManager();
        ListPreference listPreference = (ListPreference) preferenceManager.findPreference("DecodeMode");
        listPreference.setSummary(m2541a(m2552i(this)));
        listPreference.setOnPreferenceChangeListener(this);
        ListPreference listPreference2 = (ListPreference) preferenceManager.findPreference("AppListOrder");
        String string = PreferenceManager.getDefaultSharedPreferences(this).getString("AppListOrder", getResources().getStringArray(R.array.order_value)[0]);
        listPreference2.setValue(string);
        listPreference2.setSummary(string);
        listPreference2.setOnPreferenceChangeListener(this);
        ListPreference listPreference3 = (ListPreference) preferenceManager.findPreference("SignApkWith");
        listPreference3.setValue(PreferenceManager.getDefaultSharedPreferences(this).getString("SignApkWith", "testkey"));
        listPreference3.setOnPreferenceChangeListener(this);
        ListPreference listPreference4 = (ListPreference) preferenceManager.findPreference("OutputApkName");
        listPreference4.setValue(PreferenceManager.getDefaultSharedPreferences(this).getString("OutputApkName", "2"));
        listPreference4.setOnPreferenceChangeListener(this);
        ListPreference listPreference5 = (ListPreference) findPreference("md_lang");
        listPreference5.setValue(PreferenceManager.getDefaultSharedPreferences(this).getString("md_lang", ""));
        listPreference5.setOnPreferenceChangeListener(this);
        SwitchPreference switchPreference = (SwitchPreference) findPreference("SmaliEditingEnabled");
        boolean zM2548e = m2548e(this);
        switchPreference.setChecked(zM2548e);
        switchPreference.setSummary(zM2548e ? R.string.smali_edit_summary : R.string.smali_edit_disabled_summary);
        switchPreference.setOnPreferenceChangeListener(new C1241gh(this));
        SwitchPreference switchPreference2 = (SwitchPreference) findPreference("RebuildConfirmation");
        boolean zM2549f = m2549f(this);
        switchPreference2.setChecked(zM2549f);
        switchPreference2.setSummary(zM2549f ? R.string.rebuild_confirm_e_summary : R.string.rebuild_confirm_d_summary);
        switchPreference2.setOnPreferenceChangeListener(new C1242gi(this));
        findPreference("clean_str").setOnPreferenceClickListener(this);
        findPreference("clean_res").setOnPreferenceClickListener(this);
        findPreference("clean_mf").setOnPreferenceClickListener(this);
        findPreference("CleanGarbage").setOnPreferenceClickListener(this);
        Preference preferenceFindPreference = findPreference("md_theme");
        preferenceFindPreference.setSummary(C0037k.mdNames(C0037k.m89a(this)));
        preferenceFindPreference.setOnPreferenceClickListener(this);
        ((ListPreference) preferenceManager.findPreference("FileRenameOption")).setValue(new StringBuilder().append(m2550g(this)).toString());
        EditTextPreference editTextPreference = (EditTextPreference) preferenceManager.findPreference("DecodeDirectory");
        editTextPreference.setOnPreferenceChangeListener(this);
        String strM2551h = m2551h(this);
        if (strM2551h != null) {
            editTextPreference.setSummary(strM2551h);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Preference preferenceFindPreference2 = findPreference("SignatureVersion");
        preferenceFindPreference2.setSummary(changeSignatureVersion(defaultSharedPreferences.getStringSet("SignatureVersion", null)));
        preferenceFindPreference2.setOnPreferenceChangeListener(this);
        Preference preferenceFindPreference3 = findPreference("SmaliApiLevel");
        String string2 = getString(R.string.smali_api_summary);
        String string3 = defaultSharedPreferences.getString("SmaliApiLevel", string2);
        if (string3 != null && !"".equals(string3)) {
            string2 = string3;
        }
        preferenceFindPreference3.setSummary(string2);
        preferenceFindPreference3.setOnPreferenceChangeListener(this);
        SwitchPreference switchPreference3 = (SwitchPreference) findPreference("ExternalEditor");
        boolean zExtEditor = extEditor(this);
        switchPreference3.setChecked(zExtEditor);
        switchPreference3.setSummary(zExtEditor ? R.string.external_editor_e_summary : R.string.external_editor_d_summary);
        switchPreference3.setOnPreferenceChangeListener(new ExtEditor(this));
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        switch (view.getId()) {
            case android.R.id.title:
                startActivity(new Intent(this, (Class<?>) SettingHideActivity.class));
                return true;
            default:
                return false;
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return false;
        }
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        boolean z = false;
        String key = preference.getKey();
        if ("AppListOrder".equals(key)) {
            String str = (String) obj;
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(this).edit();
            editorEdit.putString("AppListOrder", str);
            editorEdit.apply();
            preference.setSummary(str);
        } else if ("md_lang".equals(key)) {
            C0037k.f92md = true;
            finish();
            overridePendingTransition(R.anim.abc_fade_in_out, R.anim.abc_fade_out);
            startActivity(new Intent(this, (Class<?>) SettingActivity.class));
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_in_out);
        } else if ("DecodeDirectory".equals(key)) {
            String str2 = (String) obj;
            if (str2 != null && !"".equals(str2.trim())) {
                if (m2545b(str2)) {
                    preference.setSummary(str2);
                    z = true;
                } else {
                    Toast.makeText(this, String.format(getString(R.string.invalid_directory), str2), 1).show();
                }
            }
            if (!z) {
                preference.setSummary(R.string.decode_dir_summary_may_change);
            }
        } else if ("DecodeMode".equals(key)) {
            preference.setSummary(m2541a((String) obj));
        } else if ("SignatureVersion".equals(key)) {
            preference.setSummary(changeSignatureVersion((Set) obj));
        } else if ("SmaliApiLevel".equals(key)) {
            String str3 = (String) obj;
            if (str3 == null || "".equals(str3.trim())) {
                preference.setSummary(R.string.smali_api_summary);
            } else {
                preference.setSummary(String.valueOf(obj));
            }
        }
        return true;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (preference.getKey().equals("clean_str")) {
            m2537D1();
        } else if (preference.getKey().equals("clean_res")) {
            m2538D2();
        } else if (preference.getKey().equals("clean_mf")) {
            m2539D3();
        } else if (preference.getKey().equals("CleanGarbage")) {
            m2540D4();
        } else if (preference.getKey().equals("md_theme")) {
            C0037k.f92md = true;
            new C0037k().m92f(this, R.string.theme_title, new C1317jc(this));
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        ImageView imageView = (ImageView) findViewById(R.id.title_icon);
        if (imageView != null) {
            imageView.setImageResource(((Integer) C0985a.m2190a("com.gmail.heagoo.seticon.SetIcon", "getSelectedIcon", new Class[]{Activity.class}, new Object[]{this})).intValue());
        }
    }
}
