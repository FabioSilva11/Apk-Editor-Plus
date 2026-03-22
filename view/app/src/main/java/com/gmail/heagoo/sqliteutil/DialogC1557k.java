package com.gmail.heagoo.sqliteutil;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.sqliteutil.k */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1557k extends Dialog {

    /* JADX INFO: renamed from: a */
    private WeakReference f4665a;

    /* JADX INFO: renamed from: b */
    private int f4666b;

    /* JADX INFO: renamed from: c */
    private List f4667c;

    /* JADX INFO: renamed from: d */
    private List f4668d;

    /* JADX INFO: renamed from: e */
    private List f4669e;

    /* JADX INFO: renamed from: f */
    private List f4670f;

    /* JADX INFO: renamed from: g */
    private TextView f4671g;

    /* JADX INFO: renamed from: h */
    private TextView f4672h;

    /* JADX INFO: renamed from: i */
    private EditText f4673i;

    /* JADX INFO: renamed from: j */
    private EditText f4674j;

    /* JADX INFO: renamed from: k */
    private View f4675k;

    /* JADX INFO: renamed from: l */
    private View f4676l;

    /* JADX INFO: renamed from: m */
    private Button f4677m;

    /* JADX INFO: renamed from: n */
    private Button f4678n;

    /* JADX INFO: renamed from: o */
    private boolean f4679o;

    public DialogC1557k(SqliteRowViewActivity sqliteRowViewActivity, List list, List list2, List list3, List list4, int i, boolean z, int i2) {
        super(sqliteRowViewActivity);
        this.f4665a = new WeakReference(sqliteRowViewActivity);
        this.f4666b = i;
        this.f4667c = list;
        this.f4668d = list2;
        this.f4669e = list4;
        this.f4670f = list3;
        this.f4679o = z;
        View viewInflate = getLayoutInflater().inflate(R.layout.sql_dialog_tablerecord, (ViewGroup) null);
        this.f4671g = (TextView) viewInflate.findViewById(R.id.tv_type);
        this.f4673i = (EditText) viewInflate.findViewById(R.id.et_name);
        this.f4674j = (EditText) viewInflate.findViewById(R.id.et_valuey);
        this.f4675k = viewInflate.findViewById(R.id.image_next);
        this.f4676l = viewInflate.findViewById(R.id.image_prev);
        this.f4672h = (TextView) viewInflate.findViewById(R.id.tv_pkflag);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_noteditable);
        if (this.f4679o) {
            textView.setVisibility(4);
        } else {
            textView.setVisibility(0);
            this.f4674j.setEnabled(false);
        }
        this.f4675k.setClickable(true);
        this.f4675k.setOnClickListener(new ViewOnClickListenerC1558l(this));
        this.f4676l.setClickable(true);
        this.f4676l.setOnClickListener(new ViewOnClickListenerC1559m(this));
        this.f4677m = (Button) viewInflate.findViewById(R.id.btn_save);
        if (this.f4679o) {
            this.f4677m.setOnClickListener(new ViewOnClickListenerC1560n(this));
        } else {
            this.f4677m.setVisibility(8);
        }
        this.f4678n = (Button) viewInflate.findViewById(R.id.btn_cancel);
        this.f4678n.setOnClickListener(new ViewOnClickListenerC1561o(this));
        m3770b(this.f4666b);
        super.setContentView(viewInflate);
    }

    /* JADX INFO: renamed from: a */
    private boolean m3769a(int i) {
        return !"0".equals(this.f4670f.get(i));
    }

    /* JADX INFO: renamed from: b */
    private void m3770b(int i) {
        boolean zM3769a = m3769a(i);
        this.f4671g.setText("Type: " + ((String) this.f4667c.get(i)));
        this.f4672h.setText("Primary Key: " + zM3769a);
        this.f4673i.setText((CharSequence) this.f4668d.get(i));
        this.f4674j.setText((CharSequence) this.f4669e.get(i));
        if (this.f4679o) {
            return;
        }
        if (zM3769a) {
            this.f4674j.setEnabled(false);
            this.f4677m.setVisibility(8);
        } else {
            this.f4674j.setEnabled(true);
            this.f4677m.setVisibility(0);
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* JADX INFO: renamed from: a */
    protected final void m3771a() {
        Object objValueOf;
        try {
            if (m3769a(this.f4666b)) {
                throw new Exception("Can not edit primary key!");
            }
            String upperCase = ((String) this.f4667c.get(this.f4666b)).toUpperCase();
            String string = this.f4674j.getText().toString();
            if (SqliteTableViewActivity.m3737f(upperCase)) {
                objValueOf = string;
            } else if (SqliteTableViewActivity.m3734c(upperCase)) {
                objValueOf = Long.valueOf(string);
            } else if (SqliteTableViewActivity.m3735d(upperCase)) {
                objValueOf = Boolean.valueOf(string);
            } else if (SqliteTableViewActivity.m3733b(upperCase)) {
                objValueOf = Float.valueOf(string);
            } else if (SqliteTableViewActivity.m3730a(upperCase)) {
                objValueOf = Double.valueOf(string);
            } else {
                if (SqliteTableViewActivity.m3736e(upperCase)) {
                    throw new Exception("Value type not supported!");
                }
                objValueOf = string;
            }
            ((SqliteRowViewActivity) this.f4665a.get()).m3719a(this.f4666b, objValueOf);
            Toast.makeText((Context) this.f4665a.get(), "Succeed!", 0).show();
        } catch (Exception e) {
            Toast.makeText((Context) this.f4665a.get(), e.getMessage(), 0).show();
        }
    }

    /* JADX INFO: renamed from: b */
    protected final void m3772b() {
        if (this.f4666b <= 0) {
            Toast.makeText((Context) this.f4665a.get(), R.string.toast_no_values, 0).show();
        } else {
            m3770b(this.f4666b - 1);
            this.f4666b--;
        }
    }

    /* JADX INFO: renamed from: c */
    protected final void m3773c() {
        if (this.f4666b + 1 >= this.f4669e.size()) {
            Toast.makeText((Context) this.f4665a.get(), R.string.toast_no_values, 0).show();
        } else {
            m3770b(this.f4666b + 1);
            this.f4666b++;
        }
    }
}
