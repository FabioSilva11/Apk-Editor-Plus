package com.gmail.heagoo.apkeditor.p068se;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.s */
/* JADX INFO: loaded from: classes.dex */
public final class C1363s extends PagerAdapter {

    /* JADX INFO: renamed from: a */
    private List f3913a;

    public C1363s(SimpleEditActivity simpleEditActivity, List list) {
        this.f3913a = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) this.f3913a.get(i));
    }

    @Override // android.support.v4.view.PagerAdapter
    public final int getCount() {
        return this.f3913a.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView((View) this.f3913a.get(i), 0);
        return this.f3913a.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
