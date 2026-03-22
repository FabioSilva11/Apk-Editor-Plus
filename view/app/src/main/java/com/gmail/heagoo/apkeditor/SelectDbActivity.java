package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import com.gmail.heagoo.apkeditor.FileDialog;
import com.gmail.heagoo.p054a.p059c.C0986ax;
import com.gmail.heagoo.sqliteutil.SqliteTableListActivity;
import java.io.File;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class SelectDbActivity extends Activity {
    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.mdNoActionBar(C0037k.m89a(this)));
        super.onCreate(bundle);
        FileDialog fileDialog = new FileDialog(this, new File(Environment.getExternalStorageDirectory().getPath()), ".db");
        fileDialog.addFileListener(new FileDialog.FileSelectedListener() { // from class: com.gmail.heagoo.apkeditor.SelectDbActivity.1
            @Override // com.gmail.heagoo.apkeditor.FileDialog.FileSelectedListener
            public void fileSelected(File file) {
                Intent intent = new Intent(SelectDbActivity.this.getApplicationContext(), (Class<?>) SqliteTableListActivity.class);
                C0986ax.a_001(intent, "dbFilePath", file.getAbsolutePath());
                C0986ax.a_001(intent, "isRootMode", "false");
                intent.setFlags(268435456);
                SelectDbActivity.this.getApplicationContext().startActivity(intent);
                SelectDbActivity.this.finish();
            }
        });
        fileDialog.showDialog();
    }
}
