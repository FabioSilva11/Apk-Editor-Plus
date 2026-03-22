package com.gmail.heagoo.apkeditor;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import com.gmail.heagoo.InterfaceC0968a;
import com.gmail.heagoo.apkeditor.p069ui.LayoutObListView;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.neweditor.C1511e;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hw */
/* JADX INFO: loaded from: classes.dex */
public final class C1283hw {

    /* JADX INFO: renamed from: a */
    private LayoutObListView f3655a;

    /* JADX INFO: renamed from: b */
    private C1279hs f3656b;

    /* JADX INFO: renamed from: c */
    private HandlerC1284hx f3657c = new HandlerC1284hx(this);

    public C1283hw(Context context, LayoutObListView layoutObListView) {
        this.f3655a = layoutObListView;
        this.f3656b = new C1279hs(context, layoutObListView);
        layoutObListView.setAdapter((ListAdapter) this.f3656b);
        layoutObListView.setDivider(null);
        layoutObListView.setItemsCanFocus(true);
    }

    /* JADX INFO: renamed from: a */
    public final int m3158a() {
        int selectedItemPosition = this.f3655a.getSelectedItemPosition();
        return selectedItemPosition == -1 ? this.f3655a.m3307d() : selectedItemPosition;
    }

    /* JADX INFO: renamed from: a */
    public final void m3159a(int i) {
        this.f3655a.setBackgroundColor(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m3160a(int i, float f) {
        this.f3656b.m3151a(2, f);
        this.f3656b.notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: a */
    public final void m3161a(int i, int i2, int i3) {
        int firstVisiblePosition = this.f3655a.getFirstVisiblePosition();
        int lastVisiblePosition = this.f3655a.getLastVisiblePosition();
        if (i < firstVisiblePosition || i > lastVisiblePosition) {
            m3171c(i);
            this.f3655a.requestFocus();
            this.f3657c.m3179a(i, i2, i3);
        } else {
            EditText editTextM3172d = m3172d(i);
            if (editTextM3172d != null) {
                editTextM3172d.requestFocus();
                editTextM3172d.setSelection(i2, i3);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3162a(TextWatcher textWatcher) {
        this.f3656b.m3152a(textWatcher);
    }

    /* JADX INFO: renamed from: a */
    public final void m3163a(InterfaceC0968a interfaceC0968a) {
        this.f3656b.m3153a(interfaceC0968a);
    }

    /* JADX INFO: renamed from: a */
    public final void m3164a(C1511e c1511e) {
        this.f3656b.m3154a(c1511e);
    }

    /* JADX INFO: renamed from: a */
    public final void m3165a(String str) {
        this.f3656b.m3155a(Arrays.asList(str.split("\\r?\\n")));
        this.f3656b.notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: a */
    public final void m3166a(List list) {
        this.f3656b.m3155a(list);
        this.f3656b.notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: a */
    public final void m3167a(boolean z) {
        this.f3656b.m3156a(z);
        this.f3656b.notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: b */
    public final int m3168b() {
        EditText editTextM3172d = m3172d(m3158a());
        if (editTextM3172d != null) {
            return editTextM3172d.getSelectionStart();
        }
        return 0;
    }

    /* JADX INFO: renamed from: b */
    public final void m3169b(int i) {
        this.f3656b.m3150a(i);
    }

    /* JADX INFO: renamed from: c */
    public final int m3170c() {
        EditText editTextM3172d = m3172d(m3158a());
        if (editTextM3172d != null) {
            return editTextM3172d.getSelectionEnd();
        }
        return 0;
    }

    /* JADX INFO: renamed from: c */
    public final void m3171c(int i) {
        this.f3655a.setSelection(i);
    }

    /* JADX INFO: renamed from: d */
    public final EditText m3172d(int i) {
        View view;
        if (i < 0) {
            return null;
        }
        int firstVisiblePosition = this.f3655a.getFirstVisiblePosition();
        int childCount = (this.f3655a.getChildCount() + firstVisiblePosition) - 1;
        if (i < firstVisiblePosition || i > childCount) {
            view = this.f3655a.getAdapter().getView(i, null, this.f3655a);
        } else {
            view = this.f3655a.getChildAt(i - firstVisiblePosition);
        }
        if (view != null) {
            return (EditText) view.findViewById(R.id.text);
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public final CharSequence m3173d() {
        return this.f3656b.m3149a();
    }

    /* JADX INFO: renamed from: e */
    public final List m3174e() {
        return this.f3656b.m3157b();
    }

    /* JADX INFO: renamed from: f */
    public final Editable m3175f() {
        EditText editTextM3172d = m3172d(m3158a());
        if (editTextM3172d != null) {
            return editTextM3172d.getEditableText();
        }
        return null;
    }

    /* JADX INFO: renamed from: g */
    public final void m3176g() {
        this.f3655a.requestLayout();
    }

    /* JADX INFO: renamed from: h */
    public final ViewGroup.LayoutParams m3177h() {
        return this.f3655a.getLayoutParams();
    }

    /* JADX INFO: renamed from: i */
    public final void m3178i() {
        this.f3656b.notifyDataSetChanged();
    }
}
