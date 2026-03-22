package com.gmail.heagoo.appdm;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.h */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1423h extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private PrefDetailActivity f4187a;

    /* JADX INFO: renamed from: b */
    private int f4188b;

    /* JADX INFO: renamed from: c */
    private List f4189c;

    /* JADX INFO: renamed from: d */
    private TextView f4190d;

    /* JADX INFO: renamed from: e */
    private EditText f4191e;

    /* JADX INFO: renamed from: f */
    private EditText f4192f;

    /* JADX INFO: renamed from: g */
    private View f4193g;

    /* JADX INFO: renamed from: h */
    private View f4194h;

    /* JADX INFO: renamed from: i */
    private boolean f4195i;

    /* JADX INFO: renamed from: j */
    private boolean f4196j;

    /* JADX INFO: renamed from: k */
    private int f4197k;

    public DialogC1423h(PrefDetailActivity prefDetailActivity, Map map, int i, boolean z, int i2) {
        super(prefDetailActivity);
        this.f4189c = new ArrayList();
        this.f4195i = false;
        this.f4187a = prefDetailActivity;
        this.f4188b = i;
        this.f4196j = true;
        this.f4197k = i2;
        m3450a(map);
        View viewInflate = getLayoutInflater().inflate(R.layout.appdm_dialog_keyvalue, (ViewGroup) null);
        this.f4190d = (TextView) viewInflate.findViewById(R.id.tv_type);
        this.f4191e = (EditText) viewInflate.findViewById(R.id.et_key);
        this.f4192f = (EditText) viewInflate.findViewById(R.id.et_valuey);
        this.f4193g = viewInflate.findViewById(R.id.image_next);
        this.f4194h = viewInflate.findViewById(R.id.image_prev);
        this.f4193g.setClickable(true);
        this.f4193g.setOnClickListener(this);
        this.f4194h.setClickable(true);
        this.f4194h.setOnClickListener(this);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_noteditable);
        Button button = (Button) viewInflate.findViewById(R.id.btn_save);
        if (this.f4196j) {
            button.setOnClickListener(this);
            textView.setVisibility(8);
        } else {
            button.setVisibility(8);
            this.f4192f.setEnabled(false);
            textView.setVisibility(0);
        }
        ((Button) viewInflate.findViewById(R.id.btn_cancel)).setOnClickListener(this);
        m3449a(this.f4188b);
        super.setContentView(viewInflate);
        super.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        super.setCancelable(false);
        super.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: renamed from: a */
    private void m3449a(int i) {
        C1424i c1424i = (C1424i) this.f4189c.get(i);
        this.f4190d.setText("Type: " + c1424i.f4200c);
        this.f4191e.setText(c1424i.f4198a);
        this.f4192f.setText(c1424i.f4199b);
    }

    /* JADX INFO: renamed from: a */
    private void m3450a(Map map) {
        for (String str : map.keySet()) {
            C1424i c1424i = new C1424i();
            c1424i.f4198a = str;
            Object obj = map.get(str);
            if (obj != null) {
                c1424i.f4199b = obj.toString();
                c1424i.f4200c = obj.getClass().getSimpleName();
            } else {
                c1424i.f4199b = "";
                c1424i.f4200c = "null";
            }
            this.f4189c.add(c1424i);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object objValueOf;
        int id = view.getId();
        if (id == R.id.image_next) {
            if (this.f4188b + 1 >= this.f4189c.size()) {
                Toast.makeText(this.f4187a, "No more values!", 0).show();
                return;
            } else {
                m3449a(this.f4188b + 1);
                this.f4188b++;
                return;
            }
        }
        if (id == R.id.image_prev) {
            if (this.f4188b <= 0) {
                Toast.makeText(this.f4187a, "No more values!", 0).show();
                return;
            } else {
                m3449a(this.f4188b - 1);
                this.f4188b--;
                return;
            }
        }
        if (id != R.id.btn_save) {
            if (id == R.id.btn_cancel) {
                cancel();
                if (this.f4195i) {
                    this.f4187a.m3387a();
                    return;
                }
                return;
            }
            return;
        }
        try {
            C1424i c1424i = (C1424i) this.f4189c.get(this.f4188b);
            String str = c1424i.f4200c;
            String string = this.f4192f.getText().toString();
            if ("Integer".equals(str)) {
                objValueOf = Integer.valueOf(string);
            } else if ("Float".equals(str)) {
                objValueOf = Float.valueOf(string);
            } else if ("Long".equals(str)) {
                objValueOf = Long.valueOf(string);
            } else {
                objValueOf = string;
                if (!"String".equals(str)) {
                    if (!"Boolean".equals(str)) {
                        throw new Exception("Value type not supported!");
                    }
                    objValueOf = Boolean.valueOf(string);
                }
            }
            c1424i.f4199b = objValueOf.toString();
            this.f4187a.m3390a(c1424i.f4198a, objValueOf);
            Toast.makeText(this.f4187a, "Succeed!", 0).show();
        } catch (Exception e) {
            Toast.makeText(this.f4187a, e.getMessage(), 0).show();
        }
        this.f4195i = true;
    }
}
