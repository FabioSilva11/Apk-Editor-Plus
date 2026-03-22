package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.p062ac.C1037a;
import com.gmail.heagoo.apkeditor.p062ac.EditTextWithTip;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ei */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1187ei extends BaseExpandableListAdapter implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private String f3342a;

    /* JADX INFO: renamed from: b */
    private String f3343b;

    /* JADX INFO: renamed from: d */
    private WeakReference f3345d;

    /* JADX INFO: renamed from: e */
    private WeakReference f3346e;

    /* JADX INFO: renamed from: f */
    private boolean[] f3347f;

    /* JADX INFO: renamed from: g */
    private boolean[] f3348g;

    /* JADX INFO: renamed from: l */
    private int f3351l;

    /* JADX INFO: renamed from: k */
    private int f3350k = 0;

    /* JADX INFO: renamed from: m */
    private boolean f3352m = false;

    /* JADX INFO: renamed from: n */
    private String f3353n = null;

    /* JADX INFO: renamed from: c */
    private ArrayList f3344c = new ArrayList();

    /* JADX INFO: renamed from: h */
    private final Map f3349h = new HashMap();

    ViewOnClickListenerC1187ei(WeakReference weakReference, ExpandableListView expandableListView, String str, List list, String str2) {
        this.f3345d = weakReference;
        this.f3346e = new WeakReference(expandableListView);
        this.f3342a = str + "/";
        this.f3343b = str2;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f3344c.add((String) it.next());
        }
        this.f3347f = new boolean[list.size()];
        this.f3348g = new boolean[list.size()];
    }

    /* JADX INFO: renamed from: a */
    private static void m2970a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m2971a(ViewOnClickListenerC1187ei viewOnClickListenerC1187ei, boolean z) {
        viewOnClickListenerC1187ei.f3352m = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m2972d(int i) throws Throwable {
        String str = (String) this.f3344c.get(i);
        try {
            m2974a(str, this.f3353n);
            ((ApkInfoActivity) this.f3345d.get()).m2433a(str, (String) null);
            ((ExpandableListView) this.f3346e.get()).collapseGroup(i);
            m2978b(i);
            Toast.makeText((Context) this.f3345d.get(), String.format(((ApkInfoActivity) this.f3345d.get()).getString(R.string.str_replaced), this.f3343b), 0).show();
        } catch (IOException e) {
            Toast.makeText((Context) this.f3345d.get(), e.getMessage(), 1).show();
        }
    }

    /* JADX INFO: renamed from: a */
    public final ArrayList m2973a() {
        return this.f3344c;
    }

    /* JADX INFO: renamed from: a */
    public final void m2974a(String str, String str2) throws Throwable {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "rw");
            try {
                byte[] bArr = new byte[(int) randomAccessFile.length()];
                int i = 0;
                while (true) {
                    int i2 = randomAccessFile.read(bArr, i, bArr.length - i);
                    if (i2 <= 0) {
                        String strReplace = new String(bArr, "UTF-8").replace(this.f3343b, str2);
                        randomAccessFile.setLength(0L);
                        randomAccessFile.write(strReplace.getBytes());
                        m2970a(randomAccessFile);
                        return;
                    }
                    i += i2;
                }
            } catch (Throwable th) {
                th = th;
                m2970a(randomAccessFile);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    /* JADX INFO: renamed from: a */
    final void m2975a(String str, List list) {
        synchronized (this.f3349h) {
            this.f3349h.put(str, list);
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m2976a(int i) {
        boolean zContainsKey;
        String str = (String) this.f3344c.get(i);
        if (str == null) {
            return false;
        }
        synchronized (this.f3349h) {
            zContainsKey = this.f3349h.containsKey(str);
        }
        return zContainsKey;
    }

    /* JADX INFO: renamed from: b */
    public final String m2977b() {
        return this.f3343b;
    }

    /* JADX INFO: renamed from: b */
    public final void m2978b(int i) {
        String str = (String) this.f3344c.get(i);
        if (str != null) {
            synchronized (this.f3349h) {
                this.f3349h.remove(str);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m2979c(int i) {
        if (i < this.f3344c.size()) {
            this.f3349h.remove((String) this.f3344c.remove(i));
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i, int i2) {
        List list = (List) this.f3349h.get((String) this.f3344c.get(i));
        if (list == null || i2 >= list.size()) {
            return null;
        }
        return list.get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getChildId(int i, int i2) {
        return (i << 16) + i2;
    }

    @Override // android.widget.ExpandableListAdapter
    @SuppressLint({"InflateParams"})
    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C1191em c1191em;
        String str;
        int i3;
        int i4 = 0;
        C1186eh c1186eh = (C1186eh) getChild(i, i2);
        if (view == null) {
            view = ((LayoutInflater) ((ApkInfoActivity) this.f3345d.get()).getSystemService("layout_inflater")).inflate(R.layout.item_matchedline, (ViewGroup) null);
            C1191em c1191em2 = new C1191em((byte) 0);
            c1191em2.f3364a = (TextView) view.findViewById(R.id.tv_line);
            view.setTag(c1191em2);
            c1191em = c1191em2;
        } else {
            c1191em = (C1191em) view.getTag();
        }
        if (c1186eh != null) {
            Paint paint = new Paint();
            paint.setTextSize(c1191em.f3364a.getTextSize());
            if (this.f3350k == 0) {
                this.f3350k = c1191em.f3364a.getWidth();
                this.f3351l = (int) paint.measureText(this.f3343b);
            }
            String str2 = c1186eh.f3339a + ": ";
            int iMeasureText = (int) paint.measureText(str2);
            if (this.f3350k < ((int) paint.measureText(str2 + c1186eh.f3341c)) && c1186eh.f3340b > 0) {
                int i5 = ((int) paint.measureText(c1186eh.f3341c.substring(0, c1186eh.f3340b))) > ((this.f3350k - iMeasureText) - this.f3351l) / 2 ? c1186eh.f3340b - (((r5 * c1186eh.f3340b) / r1) - 2) : 0;
                i4 = i5 > c1186eh.f3340b ? c1186eh.f3340b : i5;
            }
            int length = str2.length() + c1186eh.f3340b;
            if (i4 > 0) {
                String str3 = str2 + "..." + c1186eh.f3341c.substring(i4);
                i3 = length - (i4 - 3);
                str = str3;
            } else {
                str = str2 + c1186eh.f3341c;
                i3 = length;
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(-16746497), i3, this.f3343b.length() + i3, 34);
            c1191em.f3364a.setText(spannableString);
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i) {
        List list = (List) this.f3349h.get((String) this.f3344c.get(i));
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i) {
        return this.f3344c.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        return this.f3344c.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    @SuppressLint({"InflateParams"})
    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C1190el c1190el;
        String strSubstring = ((String) this.f3344c.get(i)).substring(this.f3342a.length());
        if (view == null) {
            view = ((LayoutInflater) ((ApkInfoActivity) this.f3345d.get()).getSystemService("layout_inflater")).inflate(R.layout.item_matchedfile, (ViewGroup) null);
            C1190el c1190el2 = new C1190el((byte) 0);
            c1190el2.f3359a = (TextView) view.findViewById(R.id.tv_filepath);
            c1190el2.f3361c = view.findViewById(R.id.menu_edit);
            c1190el2.f3360b = view.findViewById(R.id.menu_replace);
            c1190el2.f3363e = (ImageView) view.findViewById(R.id.image_edit);
            c1190el2.f3362d = (ImageView) view.findViewById(R.id.image_replace);
            view.setTag(c1190el2);
            c1190el = c1190el2;
        } else {
            c1190el = (C1190el) view.getTag();
        }
        c1190el.f3363e.setImageResource(this.f3348g[i] ? R.drawable.ic_eye_accent : R.drawable.ic_eye);
        c1190el.f3362d.setImageResource(this.f3347f[i] ? R.drawable.ic_replace_accent : R.drawable.ic_replace);
        TextView textView = c1190el.f3359a;
        textView.setTypeface(null, 0);
        textView.setText(strSubstring);
        c1190el.f3361c.setTag(Integer.valueOf(i));
        c1190el.f3361c.setOnClickListener(this);
        c1190el.f3360b.setTag(Integer.valueOf(i));
        c1190el.f3360b.setOnClickListener(this);
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        Intent intentM2177a;
        int id = view.getId();
        if (id == R.id.menu_edit) {
            Integer num = (Integer) view.getTag();
            if (num.intValue() < this.f3344c.size()) {
                if (!this.f3348g[num.intValue()]) {
                    this.f3348g[num.intValue()] = true;
                    notifyDataSetChanged();
                }
                if (this.f3344c.size() <= 100) {
                    intentM2177a = C0985a.m2178a((Context) this.f3345d.get(), this.f3344c, num.intValue(), ((ApkInfoActivity) this.f3345d.get()).m2464l());
                } else {
                    ApkInfoActivity apkInfoActivity = (ApkInfoActivity) this.f3345d.get();
                    intentM2177a = C0985a.m2177a(apkInfoActivity, (String) this.f3344c.get(num.intValue()), apkInfoActivity.m2464l());
                }
                C0985a.m2180a(intentM2177a, "searchString", this.f3343b);
                ((ApkInfoActivity) this.f3345d.get()).startActivityForResult(intentM2177a, 0);
                return;
            }
            return;
        }
        if (id == R.id.menu_replace) {
            Integer num2 = (Integer) view.getTag();
            if (!this.f3347f[num2.intValue()]) {
                this.f3347f[num2.intValue()] = true;
                notifyDataSetChanged();
            }
            if (num2.intValue() < this.f3344c.size()) {
                if (this.f3352m) {
                    m2972d(num2.intValue());
                    return;
                }
                int iIntValue = num2.intValue();
                float f = ((ApkInfoActivity) this.f3345d.get()).getResources().getDisplayMetrics().density;
                int i = (int) ((18.0f * f) + 0.5f);
                int i2 = (int) ((20.0f * f) + 0.5f);
                int i3 = (int) ((f * 24.0f) + 0.5f);
                AlertDialog.Builder builder = new AlertDialog.Builder((Context) this.f3345d.get());
                builder.setTitle(R.string.replace);
                LinearLayout linearLayout = new LinearLayout((Context) this.f3345d.get());
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(i3, (int) ((12.0f * f) + 0.5f), i3, 0);
                TextView textView = new TextView((ApkInfoActivity) this.f3345d.get());
                textView.setText(String.format(((ApkInfoActivity) this.f3345d.get()).getString(R.string.str_replace_with), this.f3343b));
                textView.setTextColor(ContextCompat.getColor((ApkInfoActivity) this.f3345d.get(), C0037k.mdTextSmall(C0037k.m89a((ApkInfoActivity) this.f3345d.get()))));
                textView.setTextSize(1, 12);
                textView.setLayoutParams(layoutParams);
                linearLayout.addView(textView);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.setMargins(i2, 0, i2, 0);
                C1037a c1037a = new C1037a((ApkInfoActivity) this.f3345d.get(), "search_replace_with");
                EditTextWithTip editTextWithTip = new EditTextWithTip((ApkInfoActivity) this.f3345d.get());
                editTextWithTip.setTextColor(ContextCompat.getColor((ApkInfoActivity) this.f3345d.get(), C0037k.mdTextMedium(C0037k.m89a((ApkInfoActivity) this.f3345d.get()))));
                editTextWithTip.setTextSize(1, 14);
                editTextWithTip.setAdapter(c1037a);
                editTextWithTip.setLayoutParams(layoutParams2);
                linearLayout.addView(editTextWithTip);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.setMargins(i, 0, i, 0);
                CheckBox checkBox = new CheckBox((Context) this.f3345d.get());
                checkBox.setText(R.string.label_replace_with_same_setting);
                checkBox.setLayoutParams(layoutParams3);
                linearLayout.addView(checkBox);
                builder.setView(linearLayout);
                builder.setPositiveButton(android.R.string.ok, new DialogInterfaceOnClickListenerC1188ej(this, editTextWithTip, checkBox, c1037a, iIntValue));
                builder.setNegativeButton(android.R.string.cancel, new DialogInterfaceOnClickListenerC1189ek(this));
                builder.show();
            }
        }
    }
}
