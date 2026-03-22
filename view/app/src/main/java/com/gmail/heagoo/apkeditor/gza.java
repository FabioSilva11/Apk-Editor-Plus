package com.gmail.heagoo.apkeditor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class gza extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "templates_db";
    private static final int DATABASE_VERSION = 1;
    private String LOG_TAG;

    public gza(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        this.LOG_TAG = "DatabaseHelper";
    }

    public void deleteImages(gzd gzdVar) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT id, name, images, content FROM news", (String[]) null);
        while (cursorRawQuery.moveToNext()) {
            cursorRawQuery.getInt(0);
            cursorRawQuery.getString(1);
            String string = cursorRawQuery.getString(2);
            cursorRawQuery.getString(3);
            Log.d(this.LOG_TAG, new StringBuffer().append("images delete :").append(string).toString());
        }
        cursorRawQuery.close();
        readableDatabase.close();
    }

    public void deleteTabble() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete(gzd.TABLE_NAME, (String) null, (String[]) null);
        writableDatabase.close();
    }

    public void deleteTemplates(gzd gzdVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete(gzd.TABLE_NAME, new StringBuffer().append(gzd.COLUMN_ID).append(" = ?").toString(), new String[]{String.valueOf(gzdVar.getId())});
        writableDatabase.close();
    }

    public List getAllTemplates() {
        ArrayList arrayList = new ArrayList();
        String string = new StringBuffer().append("SELECT  * FROM ").append(gzd.TABLE_NAME).toString();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursorRawQuery = writableDatabase.rawQuery(string, (String[]) null);
        if (cursorRawQuery.moveToFirst()) {
            do {
                arrayList.add(new gzd(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(gzd.COLUMN_ID)), cursorRawQuery.getString(cursorRawQuery.getColumnIndex(gzd.COLUMN_TITLE)), cursorRawQuery.getString(cursorRawQuery.getColumnIndex(gzd.COLUMN_CONTENT))));
            } while (cursorRawQuery.moveToNext());
        }
        writableDatabase.close();
        return arrayList;
    }

    public int getTemplatesCount() {
        Cursor cursorRawQuery = getReadableDatabase().rawQuery(new StringBuffer().append("SELECT  * FROM ").append(gzd.TABLE_NAME).toString(), (String[]) null);
        int count = cursorRawQuery.getCount();
        cursorRawQuery.close();
        return count;
    }

    public gzd getText(long j) {
        Cursor cursorQuery = getReadableDatabase().query(gzd.TABLE_NAME, new String[]{gzd.COLUMN_ID, gzd.COLUMN_TITLE, gzd.COLUMN_CONTENT}, new StringBuffer().append(gzd.COLUMN_ID).append("=?").toString(), new String[]{String.valueOf(j)}, (String) null, (String) null, (String) null, (String) null);
        if (cursorQuery != null) {
            cursorQuery.moveToFirst();
        }
        gzd gzdVar = new gzd(cursorQuery.getInt(cursorQuery.getColumnIndex(gzd.COLUMN_ID)), cursorQuery.getString(cursorQuery.getColumnIndex(gzd.COLUMN_TITLE)), cursorQuery.getString(cursorQuery.getColumnIndex(gzd.COLUMN_CONTENT)));
        Log.d(this.LOG_TAG, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("ID = ").append(cursorQuery.getInt(cursorQuery.getColumnIndex(gzd.COLUMN_ID))).toString()).append(", name = ").toString()).append(cursorQuery.getString(cursorQuery.getColumnIndex(gzd.COLUMN_TITLE))).toString()).append(", content = ").toString()).append(cursorQuery.getString(cursorQuery.getColumnIndex(gzd.COLUMN_CONTENT))).toString());
        cursorQuery.close();
        return gzdVar;
    }

    public long insertTemplates(String str, String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(gzd.COLUMN_TITLE, str);
        contentValues.put(gzd.COLUMN_CONTENT, str2);
        long jInsert = writableDatabase.insert(gzd.TABLE_NAME, (String) null, contentValues);
        Log.d(this.LOG_TAG, new StringBuffer().append(" ID = ").append(jInsert).toString());
        writableDatabase.close();
        return jInsert;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(gzd.CREATE_TABLE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(new StringBuffer().append("DROP TABLE IF EXISTS ").append(gzd.TABLE_NAME).toString());
        onCreate(sQLiteDatabase);
    }

    public int updateTemplates(gzd gzdVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(gzd.COLUMN_TITLE, gzdVar.getTitle());
        contentValues.put(gzd.COLUMN_CONTENT, gzdVar.getContent());
        return writableDatabase.update(gzd.TABLE_NAME, contentValues, new StringBuffer().append(gzd.COLUMN_ID).append(" = ?").toString(), new String[]{String.valueOf(gzdVar.getId())});
    }
}
