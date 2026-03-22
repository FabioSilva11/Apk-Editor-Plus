package com.gmail.heagoo.sqliteutil.p072a;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.gmail.heagoo.sqliteutil.C1544a;
import java.util.ArrayList;
import java.util.List;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: renamed from: com.gmail.heagoo.sqliteutil.a.b */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC1546b implements View.OnClickListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a */
    private Context f4634a;

    /* JADX INFO: renamed from: b */
    private TableLayout f4635b;

    /* JADX INFO: renamed from: c */
    private ArrayList f4636c;

    /* JADX INFO: renamed from: d */
    private List f4637d;

    /* JADX INFO: renamed from: e */
    private TableRow f4638e;

    /* JADX INFO: renamed from: f */
    private C1544a f4639f = null;

    /* JADX INFO: renamed from: g */
    private InterfaceC1547c f4640g;

    /* JADX INFO: renamed from: h */
    private TableLayout.LayoutParams f4641h;

    /* JADX INFO: renamed from: i */
    private TableRow.LayoutParams f4642i;

    /* JADX INFO: renamed from: j */
    private TableRow[] f4643j;

    /* JADX INFO: renamed from: k */
    private View[] f4644k;

    /* JADX INFO: renamed from: l */
    private boolean f4645l;

    /* JADX INFO: renamed from: m */
    private int f4646m;

    /* JADX INFO: renamed from: n */
    private int f4647n;

    /* JADX INFO: renamed from: o */
    private int f4648o;

    /* JADX INFO: renamed from: p */
    private int f4649p;

    /* JADX INFO: renamed from: q */
    private int f4650q;

    /* JADX INFO: renamed from: r */
    private int f4651r;

    public ViewOnClickListenerC1546b(Context context, C1544a c1544a, TableLayout tableLayout, InterfaceC1547c interfaceC1547c, boolean z) {
        this.f4646m = -1;
        this.f4647n = -13421773;
        this.f4648o = -1445124;
        this.f4649p = -3355444;
        this.f4650q = -1;
        this.f4651r = -8409217;
        this.f4634a = context;
        this.f4635b = tableLayout;
        this.f4640g = interfaceC1547c;
        if (z) {
            this.f4646m = -13421773;
            this.f4647n = -3355444;
            this.f4648o = ViewCompat.MEASURED_STATE_MASK;
            this.f4649p = -8355712;
            this.f4650q = -1;
            this.f4651r = -8409217;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3757a() {
        this.f4641h = new TableLayout.LayoutParams(-2, -2);
        this.f4642i = new TableRow.LayoutParams(-2, -2);
        this.f4642i.setMargins(8, 0, 8, 0);
        int size = this.f4637d.size();
        int size2 = this.f4636c.size();
        this.f4643j = new TableRow[size];
        TextView[] textViewArr = new TextView[size2];
        this.f4644k = new View[size];
        for (int i = 0; i < size; i++) {
            List list = (List) this.f4637d.get(i);
            this.f4643j[i] = new TableRow(this.f4634a);
            this.f4643j[i].setId(i);
            for (int i2 = 0; i2 < size2; i2++) {
                textViewArr[i2] = new TextView(this.f4634a);
                textViewArr[i2].setTextSize(1, 12.0f);
                textViewArr[i2].setTextColor(ContextCompat.getColor(this.f4634a, C0037k.mdTextMedium(C0037k.m89a(this.f4634a))));
                textViewArr[i2].setText((CharSequence) list.get(i2));
            }
            for (int i3 = 0; i3 < size2; i3++) {
                this.f4643j[i].addView(textViewArr[i3], i3, this.f4642i);
            }
            this.f4644k[i] = new View(this.f4634a);
            this.f4644k[i].setBackgroundColor(ContextCompat.getColor(this.f4634a, C0037k.mdTextSmall(C0037k.m89a(this.f4634a))));
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3758a(ArrayList arrayList) {
        this.f4636c = arrayList;
    }

    /* JADX INFO: renamed from: a */
    public final void m3759a(List list) {
        this.f4637d = list;
    }

    /* JADX INFO: renamed from: b */
    public final void m3760b() {
        this.f4635b.removeAllViews();
        this.f4645l = true;
        this.f4638e = new TableRow(this.f4634a);
        for (int i = 0; i < this.f4636c.size(); i++) {
            TextView textView = new TextView(this.f4634a);
            textView.setTextSize(1, 12.0f);
            textView.setTextColor(ContextCompat.getColor(this.f4634a, C0037k.mdTextMedium(C0037k.m89a(this.f4634a))));
            textView.setText((CharSequence) this.f4636c.get(i));
            this.f4638e.addView(textView, this.f4642i);
        }
        this.f4638e.setBackgroundColor(ContextCompat.getColor(this.f4634a, C0037k.mdAccent(C0037k.m89a(this.f4634a))));
        this.f4635b.addView(this.f4638e, this.f4641h);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(-1, -2);
        TableRow.LayoutParams layoutParams2 = new TableRow.LayoutParams(-1, 1);
        for (int i2 = 0; i2 < this.f4637d.size(); i2++) {
            this.f4635b.addView(this.f4643j[i2], (i2 * 2) + 1, layoutParams);
            this.f4643j[i2].setOnClickListener(this);
            this.f4643j[i2].setOnTouchListener(this);
            this.f4635b.addView(this.f4644k[i2], (i2 * 2) + 2, layoutParams2);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m3761b(List list) {
        int size = list.size();
        int size2 = this.f4636c.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) list.get(i);
            for (int i2 = 0; i2 < size2; i2++) {
                ((TextView) this.f4643j[i].getChildAt(i2)).setText((CharSequence) arrayList.get(i2));
            }
            this.f4643j[i].setVisibility(0);
            this.f4644k[i].setVisibility(0);
        }
        for (int i3 = size; i3 < this.f4637d.size(); i3++) {
            this.f4643j[i3].setVisibility(8);
            this.f4644k[i3].setVisibility(8);
        }
        this.f4645l = false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (this.f4640g != null) {
            this.f4640g.mo3388a(id, this.f4645l);
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            view.setBackgroundColor(ContextCompat.getColor(this.f4634a, C0037k.mdRipple(C0037k.m89a(this.f4634a))));
        } else if (action == 1) {
            view.setBackgroundColor(0);
            view.performClick();
        } else if ((action & 1) != 0 || (action & 4) != 0) {
            view.setBackgroundColor(0);
        }
        return true;
    }
}
