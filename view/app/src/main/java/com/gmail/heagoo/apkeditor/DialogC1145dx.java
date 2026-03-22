package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.app.Dialog;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.dx */
/* JADX INFO: loaded from: classes.dex */
final class DialogC1145dx extends Dialog {

    /* JADX INFO: renamed from: a */
    private WeakReference f3236a;

    /* JADX INFO: renamed from: b */
    private String f3237b;

    /* JADX INFO: renamed from: c */
    private C1135dj f3238c;

    /* JADX INFO: renamed from: d */
    private InterfaceC1126cz f3239d;

    DialogC1145dx(Activity activity, String str, C1135dj c1135dj, InterfaceC1126cz interfaceC1126cz) {
        super(activity);
        requestWindowFeature(1);
        this.f3236a = new WeakReference(activity);
        this.f3237b = str;
        this.f3238c = c1135dj;
        this.f3239d = interfaceC1126cz;
        View viewInflate = ((Activity) this.f3236a.get()).getLayoutInflater().inflate(R.layout.dlg_manifestline, (ViewGroup) null, false);
        ((TextView) viewInflate.findViewById(R.id.content)).setText(this.f3238c.f3210b);
        TextView textView = (TextView) viewInflate.findViewById(R.id.description);
        textView.setMovementMethod(new ScrollingMovementMethod());
        String strM2865a = this.f3238c.m2865a();
        String strM2869a = strM2865a != null ? C1140ds.m2869a(activity, strM2865a) : null;
        textView.setText(strM2869a == null ? "" : strM2869a);
        Button button = (Button) viewInflate.findViewById(R.id.delete);
        button.setClickable(true);
        button.setOnClickListener(new ViewOnClickListenerC1146dy(this));
        ((RelativeLayout) viewInflate.findViewById(R.id.extract)).setOnClickListener(new ViewOnClickListenerC1147dz(this));
        ((RelativeLayout) viewInflate.findViewById(R.id.replace)).setOnClickListener(new ViewOnClickListenerC1180eb(this));
        ((RelativeLayout) viewInflate.findViewById(R.id.open_in_new_window)).setOnClickListener(new ViewOnClickListenerC1182ed(this));
        ((Button) viewInflate.findViewById(R.id.close)).setOnClickListener(new ViewOnClickListenerC1183ee(this));
        setContentView(viewInflate);
    }

    /* JADX INFO: renamed from: f */
    static /* synthetic */ boolean m2883f(DialogC1145dx dialogC1145dx) {
        return true;
    }
}
