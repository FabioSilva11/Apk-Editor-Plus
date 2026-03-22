package com.gmail.heagoo.apkeditor.p068se;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.DialogC1115cn;
import com.gmail.heagoo.apkeditor.InterfaceC1122cu;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000a.p001a.p003b.p004a.p005a.C0027x;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.c */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC1347c extends BaseAdapter implements MediaPlayer.OnCompletionListener, View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, InterfaceC1122cu {

    /* JADX INFO: renamed from: a */
    private Activity f3875a;

    /* JADX INFO: renamed from: b */
    private C1370z f3876b;

    /* JADX INFO: renamed from: c */
    private List f3877c;

    /* JADX INFO: renamed from: f */
    private String f3880f;

    /* JADX INFO: renamed from: g */
    private MediaPlayer f3881g;

    /* JADX INFO: renamed from: i */
    private String f3883i;

    /* JADX INFO: renamed from: d */
    private Set f3878d = new HashSet();

    /* JADX INFO: renamed from: e */
    private Map f3879e = new HashMap();

    /* JADX INFO: renamed from: h */
    private int f3882h = -1;

    /* JADX INFO: renamed from: j */
    private int f3884j = R.layout.item_zipfile;

    public ViewOnClickListenerC1347c(Activity activity, C1370z c1370z) {
        this.f3875a = activity;
        this.f3876b = c1370z;
        this.f3877c = c1370z.f3945d;
    }

    /* JADX INFO: renamed from: a */
    private static String m3264a(String str) {
        return str.substring(str.lastIndexOf(47) + 1);
    }

    /* JADX INFO: renamed from: a */
    private void m3265a(int i) throws IOException {
        String str = (String) this.f3877c.get(i);
        if (this.f3881g == null) {
            this.f3880f = C0985a.m2263d(this.f3875a, "tmp");
            this.f3881g = new MediaPlayer();
            this.f3881g.setOnCompletionListener(this);
        } else {
            this.f3881g.reset();
        }
        if (!this.f3878d.contains(str)) {
            C0027x.m34b(this.f3876b.m3294b(), str, this.f3880f + m3264a(str));
            this.f3878d.add(str);
        }
        if (str.equals(this.f3883i)) {
            this.f3881g.stop();
            this.f3883i = null;
            this.f3882h = -1;
            return;
        }
        String str2 = (String) this.f3879e.get(str);
        if (str2 != null) {
            this.f3881g.setDataSource(str2);
        } else {
            this.f3881g.setDataSource(this.f3880f + m3264a(str));
        }
        this.f3881g.prepare();
        this.f3881g.start();
        this.f3883i = str;
        this.f3882h = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m3267b(int i) {
        new DialogC1115cn(this.f3875a, this, "", (String) this.f3877c.get(i), this.f3875a.getString(R.string.select_file_replace)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m3269c(int i) {
        String str = (String) this.f3877c.get(i);
        ViewOnClickListenerC1365u.m3282a(this.f3875a, this.f3876b.m3294b(), str);
    }

    /* JADX INFO: renamed from: a */
    public final void m3270a() {
        if (this.f3881g != null) {
            if (this.f3881g.isPlaying()) {
                this.f3881g.stop();
            }
            this.f3881g.release();
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final void mo2502a(String str, String str2, boolean z) {
        this.f3879e.put(str2, str);
        ((SimpleEditActivity) this.f3875a).m3253a();
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final boolean mo2503a(String str, String str2) {
        return C1370z.m3291a(str);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: b */
    public final String mo2504b(String str, String str2) {
        return null;
    }

    /* JADX INFO: renamed from: b */
    public final Map m3271b() {
        return this.f3879e;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3877c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f3877c.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1364t c1364t;
        String str = (String) this.f3877c.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.f3875a).inflate(this.f3884j, (ViewGroup) null);
            C1364t c1364t2 = new C1364t();
            c1364t2.f3914a = (ImageView) view.findViewById(R.id.file_icon);
            c1364t2.f3915b = (TextView) view.findViewById(R.id.filename);
            c1364t2.f3916c = (TextView) view.findViewById(R.id.detail1);
            c1364t2.f3917d = view.findViewById(R.id.menu_edit);
            c1364t2.f3918e = view.findViewById(R.id.menu_save);
            view.setTag(c1364t2);
            c1364t = c1364t2;
        } else {
            c1364t = (C1364t) view.getTag();
        }
        int iLastIndexOf = str.lastIndexOf(47);
        String strSubstring = str.substring(iLastIndexOf + 1);
        String strSubstring2 = str.substring(0, iLastIndexOf + 1);
        c1364t.f3914a.setId(i);
        c1364t.f3914a.setOnClickListener(this);
        c1364t.f3917d.setId(this.f3877c.size() + i);
        c1364t.f3917d.setOnClickListener(this);
        c1364t.f3918e.setId((this.f3877c.size() * 2) + i);
        c1364t.f3918e.setOnClickListener(this);
        if (i != this.f3882h) {
            c1364t.f3914a.setImageResource(R.drawable.play);
        } else {
            c1364t.f3914a.setImageResource(R.drawable.pause);
        }
        c1364t.f3915b.setText(strSubstring);
        c1364t.f3916c.setText(strSubstring2);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id < this.f3877c.size()) {
            try {
                m3265a(id);
                notifyDataSetChanged();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (id < this.f3877c.size() * 2) {
            m3267b(id - this.f3877c.size());
        } else if (id < this.f3877c.size() * 3) {
            m3269c(id - (this.f3877c.size() * 2));
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        this.f3883i = null;
        this.f3882h = -1;
        notifyDataSetChanged();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        try {
            m3265a(i);
            notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        adapterView.setOnCreateContextMenuListener(new ViewOnCreateContextMenuListenerC1348d(this, i));
        return false;
    }
}
