package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.FileDialog;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.Verify;
import java.io.File;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class VerifyActivity extends Activity {
    String response = "response";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.mdNoActionBar(C0037k.m89a(this)));
        super.onCreate(bundle);
        setContentView(R.layout.activity_verify);
        final TextView textView = (TextView) findViewById(R.id.verify_text_view);
        if (bundle == null) {
            FileDialog fileDialog = new FileDialog(this, new File(Environment.getExternalStorageDirectory().getPath()), ".apk");
            fileDialog.addFileListener(new FileDialog.FileSelectedListener() { // from class: com.gmail.heagoo.apkeditor.VerifyActivity.1
                @Override // com.gmail.heagoo.apkeditor.FileDialog.FileSelectedListener
                public void fileSelected(File file) {
                    try {
                        VerifyActivity.this.response = Verify.verify(file.getAbsolutePath());
                        textView.setText(VerifyActivity.this.response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            fileDialog.showDialog();
        }
    }
}
