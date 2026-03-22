package com.gmail.heagoo.apkeditor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.gmail.heagoo.common.C1474f;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ep */
/* JADX INFO: loaded from: classes.dex */
final class C1192ep extends BaseExpandableListAdapter {

    /* JADX INFO: renamed from: a */
    private Context f3365a;

    /* JADX INFO: renamed from: b */
    private List f3366b;

    public C1192ep(Context context, List list) {
        this.f3365a = context;
        this.f3366b = list;
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i, int i2) {
        return ((C1193eq) this.f3366b.get(i)).m2980a(this.f3365a, i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getChildId(int i, int i2) {
        return (i << 16) | i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        String strM2980a = ((C1193eq) this.f3366b.get(i)).m2980a(this.f3365a, i2);
        View textView = view == null ? new TextView(this.f3365a) : view;
        ((TextView) textView).setPadding(C1474f.m3502a(this.f3365a, 48.0f), 0, 0, 0);
        ((TextView) textView).setText(strM2980a);
        return textView;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i) {
        C1193eq c1193eq = (C1193eq) this.f3366b.get(i);
        if (c1193eq.f3368b < 0 && c1193eq.f3369c < 0 && c1193eq.f3370d < 0) {
            return 1;
        }
        if (c1193eq.f3368b == 0 && c1193eq.f3369c == 0 && c1193eq.f3370d == 0) {
            return 1;
        }
        int i2 = c1193eq.f3368b <= 0 ? 0 : 1;
        if (c1193eq.f3369c > 0) {
            i2++;
        }
        return c1193eq.f3370d > 0 ? i2 + 1 : i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i) {
        return this.f3366b.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        return this.f3366b.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        String str = ((C1193eq) this.f3366b.get(i)).f3367a;
        View textView = view == null ? new TextView(this.f3365a) : view;
        int iM3502a = C1474f.m3502a(this.f3365a, 32.0f);
        ((TextView) textView).setPadding(iM3502a, iM3502a / 8, 0, 0);
        ((TextView) textView).setTypeface(null, 1);
        ((TextView) textView).setText(str);
        return textView;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i, int i2) {
        return false;
    }
}
