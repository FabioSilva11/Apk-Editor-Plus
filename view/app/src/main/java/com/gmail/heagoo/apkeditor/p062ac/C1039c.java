package com.gmail.heagoo.apkeditor.p062ac;

import android.widget.Filter;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ac.c */
/* JADX INFO: loaded from: classes.dex */
final class C1039c extends Filter {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C1037a f2991a;

    private C1039c(C1037a c1037a) {
        this.f2991a = c1037a;
    }

    /* synthetic */ C1039c(C1037a c1037a, byte b2) {
        this(c1037a);
    }

    @Override // android.widget.Filter
    protected final Filter.FilterResults performFiltering(CharSequence charSequence) {
        int i = 0;
        if (charSequence == null) {
            ArrayList arrayList = new ArrayList(this.f2991a.f2988d.length);
            String[] strArr = this.f2991a.f2988d;
            int length = strArr.length;
            while (i < length) {
                arrayList.add(strArr[i]);
                i++;
            }
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }
        String lowerCase = charSequence.toString().toLowerCase();
        Filter.FilterResults filterResults2 = new Filter.FilterResults();
        int length2 = this.f2991a.f2988d.length;
        ArrayList arrayList2 = new ArrayList(length2);
        while (i < length2) {
            String str = this.f2991a.f2988d[i];
            if (str.toLowerCase().contains(lowerCase)) {
                arrayList2.add(str);
            }
            i++;
        }
        filterResults2.values = arrayList2;
        filterResults2.count = arrayList2.size();
        return filterResults2;
    }

    @Override // android.widget.Filter
    protected final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        this.f2991a.f2985a = (ArrayList) filterResults.values;
        this.f2991a.notifyDataSetChanged();
    }
}
