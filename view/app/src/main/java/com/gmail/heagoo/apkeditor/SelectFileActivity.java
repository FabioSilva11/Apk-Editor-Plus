package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.FileDialog;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;
import java.util.Map;
import java.util.Set;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class SelectFileActivity extends Activity {
    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.mdNoActionBar(C0037k.m89a(this)));
        super.onCreate(bundle);
        FileDialog fileDialog = new FileDialog(this, new File(Environment.getExternalStorageDirectory().getPath()), ".apk");
        fileDialog.addFileListener(new FileDialog.FileSelectedListener() { // from class: com.gmail.heagoo.apkeditor.SelectFileActivity.1
            @Override // com.gmail.heagoo.apkeditor.FileDialog.FileSelectedListener
            public void fileSelected(File file) {
                String str = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(46)) + "_sign.apk";
                C0985a.m2205a(SelectFileActivity.this.getApplicationContext(), file.getAbsolutePath(), str, (Map<String, String>) null, (Map<String, String>) null, (Set<String>) null);
                Toast.makeText(SelectFileActivity.this.getApplicationContext(), "Signed apk -> " + str, 1).show();
                SelectFileActivity.this.finish();
            }
        });
        fileDialog.showDialog();
    }
}
