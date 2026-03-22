package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class MfSearchRetActivity extends Activity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private String f2721a;

    /* JADX INFO: renamed from: b */
    private ArrayList f2722b;

    /* JADX INFO: renamed from: c */
    private ArrayList f2723c;

    /* JADX INFO: renamed from: d */
    private ArrayList f2724d = new ArrayList();

    /* JADX INFO: renamed from: a */
    private static String m2532a(String str) {
        char cCharAt;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t'); i++) {
            stringBuffer.append(cCharAt);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    private boolean m2533a() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.f2721a + ".tmp");
            FileInputStream fileInputStream = new FileInputStream(this.f2721a);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            ArrayList arrayList = new ArrayList();
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                arrayList.add(line);
            }
            for (int i = 0; i < this.f2722b.size(); i++) {
                int iIntValue = ((Integer) this.f2722b.get(i)).intValue() - 1;
                arrayList.set(iIntValue, m2532a((String) arrayList.get(iIntValue)) + ((String) this.f2723c.get(i)).trim());
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                fileOutputStream.write(((String) it.next()).getBytes());
                fileOutputStream.write(10);
            }
            bufferedReader.close();
            fileInputStream.close();
            fileOutputStream.close();
            new File(this.f2721a + ".tmp").renameTo(new File(this.f2721a));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), 0).show();
            return false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_close) {
            finish();
            return;
        }
        if (id == R.id.btn_save) {
            boolean z = false;
            for (int i = 0; i < this.f2724d.size(); i++) {
                String string = ((EditText) this.f2724d.get(i)).getText().toString();
                if (!((String) this.f2723c.get(i)).equals(string)) {
                    this.f2723c.set(i, string);
                    z = true;
                }
            }
            if (!z) {
                Toast.makeText(this, R.string.no_change_detected, 0).show();
            } else if (m2533a()) {
                Toast.makeText(this, R.string.succeed, 0).show();
                setResult(1);
                finish();
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.mdNoActionBar(C0037k.m89a(this)));
        super.onCreate(bundle);
        setContentView(R.layout.activity_mf_searchret);
        Bundle extras = getIntent().getExtras();
        this.f2721a = extras.getString("xmlPath");
        this.f2722b = extras.getIntegerArrayList("lineIndexs");
        this.f2723c = extras.getStringArrayList("lineContents");
        ((TextView) findViewById(R.id.title)).setText(String.format(getResources().getString(R.string.mf_search_ret), Integer.valueOf(this.f2722b.size())));
        ((Button) findViewById(R.id.btn_save)).setOnClickListener(this);
        findViewById(R.id.btn_close).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.result_layout);
        for (int i = 0; i < this.f2723c.size(); i++) {
            View viewInflate = LayoutInflater.from(this).inflate(R.layout.item_mf_search, (ViewGroup) null);
            EditText editText = (EditText) viewInflate.findViewById(R.id.edittext_mf);
            editText.setText((CharSequence) this.f2723c.get(i));
            linearLayout.addView(viewInflate, 0);
            this.f2724d.add(editText);
        }
    }
}
