package com.gmail.heagoo.sqliteutil;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TableLayout;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0986ax;
import com.gmail.heagoo.sqliteutil.p072a.InterfaceC1547c;
import com.gmail.heagoo.sqliteutil.p072a.ViewOnClickListenerC1546b;
import java.util.ArrayList;
import java.util.List;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class SqliteTableViewActivity extends Activity implements InterfaceC1547c {

    /* JADX INFO: renamed from: a */
    private String f4606a;

    /* JADX INFO: renamed from: b */
    private String f4607b;

    /* JADX INFO: renamed from: c */
    private String f4608c;

    /* JADX INFO: renamed from: d */
    private ArrayList f4609d;

    /* JADX INFO: renamed from: e */
    private ArrayList f4610e;

    /* JADX INFO: renamed from: f */
    private ArrayList f4611f;

    /* JADX INFO: renamed from: g */
    private List f4612g;

    /* JADX INFO: renamed from: h */
    private TableLayout f4613h;

    /* JADX INFO: renamed from: i */
    private ViewOnClickListenerC1546b f4614i;

    /* JADX INFO: renamed from: j */
    private int f4615j = 0;

    /* JADX INFO: renamed from: k */
    private int f4616k;

    /* JADX INFO: renamed from: l */
    private Button f4617l;

    /* JADX INFO: renamed from: m */
    private Button f4618m;

    /* JADX INFO: renamed from: n */
    private int f4619n;

    /* JADX INFO: renamed from: a */
    private String m3726a(Cursor cursor, int i) {
        try {
            String str = (String) this.f4610e.get(i);
            if (m3737f(str)) {
                return cursor.getString(i);
            }
            if (m3734c(str)) {
                return new StringBuilder().append(cursor.getLong(i)).toString();
            }
            if (str.equalsIgnoreCase("DATE") || str.equalsIgnoreCase("DATETIME")) {
                return cursor.getString(i);
            }
            if (m3733b(str)) {
                return new StringBuilder().append(cursor.getFloat(i)).toString();
            }
            if (m3730a(str)) {
                return new StringBuilder().append(cursor.getDouble(i)).toString();
            }
            if (str.startsWith("BLOB")) {
                byte[] blob = cursor.getBlob(i);
                return blob.length > 64 ? "(Too big, first 64 byte): \n" + C0986ax.a_014(blob, 0, 64) : C0986ax.a_014(blob, 0, blob.length);
            }
            try {
                return cursor.getString(i);
            } catch (Exception e) {
                return "(un-supported type)";
            }
        } catch (Exception e2) {
            return "(error to parse)";
        }
    }

    /* JADX INFO: renamed from: a */
    private List m3727a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + this.f4608c + " limit 30 offset " + i, null);
        while (cursorRawQuery.moveToNext()) {
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < this.f4609d.size(); i3++) {
                arrayList2.add(m3726a(cursorRawQuery, i3));
            }
            arrayList.add(arrayList2);
        }
        cursorRawQuery.close();
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private void m3728a() {
        this.f4614i.m3759a(this.f4612g);
        this.f4614i.m3757a();
        this.f4614i.m3760b();
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m3729a(SqliteTableViewActivity sqliteTableViewActivity) {
        sqliteTableViewActivity.f4615j -= 30;
        if (sqliteTableViewActivity.f4615j < 0) {
            sqliteTableViewActivity.f4615j = 0;
        }
        sqliteTableViewActivity.m3731b();
        if (sqliteTableViewActivity.f4615j > 0) {
            sqliteTableViewActivity.f4617l.setVisibility(0);
        } else {
            sqliteTableViewActivity.f4617l.setVisibility(8);
        }
        if (sqliteTableViewActivity.f4615j + sqliteTableViewActivity.f4612g.size() < sqliteTableViewActivity.f4616k) {
            sqliteTableViewActivity.f4618m.setVisibility(0);
        } else {
            sqliteTableViewActivity.f4618m.setVisibility(8);
        }
        sqliteTableViewActivity.m3728a();
    }

    /* JADX INFO: renamed from: a */
    protected static boolean m3730a(String str) {
        return str.equalsIgnoreCase("DOUBLE") || str.equalsIgnoreCase("DOUBLE PRECISION");
    }

    /* JADX INFO: renamed from: b */
    private void m3731b() {
        SQLiteDatabase sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(this.f4607b, null, 1);
        this.f4612g = m3727a(sQLiteDatabaseOpenDatabase, this.f4615j, 30);
        sQLiteDatabaseOpenDatabase.close();
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ void m3732b(SqliteTableViewActivity sqliteTableViewActivity) {
        sqliteTableViewActivity.f4615j += 30;
        sqliteTableViewActivity.m3731b();
        if (sqliteTableViewActivity.f4615j > 0) {
            sqliteTableViewActivity.f4617l.setVisibility(0);
        } else {
            sqliteTableViewActivity.f4617l.setVisibility(8);
        }
        if (sqliteTableViewActivity.f4615j + sqliteTableViewActivity.f4612g.size() < sqliteTableViewActivity.f4616k) {
            sqliteTableViewActivity.f4618m.setVisibility(0);
        } else {
            sqliteTableViewActivity.f4618m.setVisibility(8);
        }
        sqliteTableViewActivity.m3728a();
    }

    /* JADX INFO: renamed from: b */
    protected static boolean m3733b(String str) {
        return str.equalsIgnoreCase("REAL") || str.equalsIgnoreCase("FLOAT");
    }

    /* JADX INFO: renamed from: c */
    protected static boolean m3734c(String str) {
        return str.equalsIgnoreCase("INTEGER") || str.equalsIgnoreCase("LONG") || str.equalsIgnoreCase("TINYINT") || str.equalsIgnoreCase("SMALLINT") || str.equalsIgnoreCase("MEDIUMINT") || str.equalsIgnoreCase("BIGINT") || str.equalsIgnoreCase("UNSIGNED BIG INT") || str.startsWith("INT") || str.startsWith("BOOL");
    }

    /* JADX INFO: renamed from: d */
    protected static boolean m3735d(String str) {
        return str.startsWith("BOOL");
    }

    /* JADX INFO: renamed from: e */
    protected static boolean m3736e(String str) {
        return str.startsWith("BLOB");
    }

    /* JADX INFO: renamed from: f */
    protected static boolean m3737f(String str) {
        return str.equalsIgnoreCase("TEXT") || str.equalsIgnoreCase("NCHAR") || str.equalsIgnoreCase("CLOB") || str.endsWith("VARCHAR") || str.endsWith("CHARACTER") || str.startsWith("NUMERIC") || str.startsWith("DECIMAL");
    }

    @Override // com.gmail.heagoo.sqliteutil.p072a.InterfaceC1547c
    /* JADX INFO: renamed from: a */
    public final void mo3388a(int i, boolean z) {
        Intent intent = new Intent(this, (Class<?>) SqliteRowViewActivity.class);
        C0986ax.a_001(intent, "originDbFilePath", this.f4606a);
        C0986ax.a_001(intent, "dbFilePath", this.f4607b);
        C0986ax.a_001(intent, "tableName", this.f4608c);
        C0986ax.a_015(intent, "columnNames", this.f4609d);
        C0986ax.a_015(intent, "columnTypes", this.f4610e);
        C0986ax.a_015(intent, "columnIsPKs", this.f4611f);
        C0986ax.a_015(intent, "rowData", (ArrayList) this.f4612g.get(i));
        C0986ax.a_002(intent, "themeId", this.f4619n);
        startActivityForResult(intent, 0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && i2 == 1) {
            m3731b();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.mdNoActionBar(C0037k.m89a(this)));
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.f4619n = C0986ax.c_006(getIntent(), "themeId");
        setContentView(R.layout.sql_activity_tableview);
        this.f4606a = C0986ax.a_008(getIntent(), "originDbFilePath");
        this.f4607b = C0986ax.a_008(getIntent(), "dbFilePath");
        this.f4608c = C0986ax.a_008(getIntent(), "tableName");
        this.f4615j = 0;
        SQLiteDatabase sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(this.f4607b, null, 1);
        if (this.f4609d == null) {
            this.f4609d = new ArrayList();
            this.f4610e = new ArrayList();
            this.f4611f = new ArrayList();
            Cursor cursorRawQuery = sQLiteDatabaseOpenDatabase.rawQuery("PRAGMA table_info(" + this.f4608c + ")", null);
            if (cursorRawQuery.moveToFirst()) {
                int columnIndex = cursorRawQuery.getColumnIndex("pk");
                do {
                    String string = cursorRawQuery.getString(1);
                    String string2 = cursorRawQuery.getString(2);
                    int i = cursorRawQuery.getInt(columnIndex);
                    this.f4609d.add(string);
                    if (string2 != null) {
                        string2 = string2.toUpperCase();
                    }
                    this.f4610e.add(string2);
                    this.f4611f.add(new StringBuilder().append(i).toString());
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        }
        Cursor cursorRawQuery2 = sQLiteDatabaseOpenDatabase.rawQuery("SELECT COUNT(*) FROM " + this.f4608c, null);
        if (cursorRawQuery2.moveToFirst()) {
            this.f4616k = cursorRawQuery2.getInt(0);
        }
        cursorRawQuery2.close();
        this.f4612g = m3727a(sQLiteDatabaseOpenDatabase, this.f4615j, 30);
        sQLiteDatabaseOpenDatabase.close();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f4613h = (TableLayout) findViewById(R.id.valueTable);
        this.f4614i = new ViewOnClickListenerC1546b(this, null, this.f4613h, this, this.f4619n != 0);
        this.f4614i.m3758a(this.f4609d);
        this.f4614i.m3759a(this.f4612g);
        this.f4614i.m3757a();
        this.f4614i.m3760b();
        this.f4617l = (Button) findViewById(R.id.button_prepage);
        this.f4618m = (Button) findViewById(R.id.button_nextpage);
        if (this.f4616k < 30) {
            this.f4618m.setVisibility(8);
        } else {
            this.f4617l.setOnClickListener(new ViewOnClickListenerC1555i(this));
            this.f4618m.setOnClickListener(new ViewOnClickListenerC1556j(this));
        }
    }
}
