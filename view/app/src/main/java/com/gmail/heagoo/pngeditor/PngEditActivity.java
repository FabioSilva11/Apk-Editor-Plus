package com.gmail.heagoo.pngeditor;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.AboutModActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1474f;
import com.gmail.heagoo.common.C1480l;
import com.gmail.heagoo.pngeditor.p071a.C1534a;
import com.gmail.heagoo.pngeditor.p071a.C1535b;
import com.gmail.heagoo.pngeditor.p071a.C1536c;
import com.p050c.p051a.C0940f;
import com.p050c.p051a.InterfaceC0943i;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class PngEditActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, InterfaceC0943i {

    /* JADX INFO: renamed from: b */
    private String f4550b;

    /* JADX INFO: renamed from: c */
    private String f4551c;

    /* JADX INFO: renamed from: d */
    private TextView f4552d;

    /* JADX INFO: renamed from: e */
    private View f4553e;

    /* JADX INFO: renamed from: f */
    private View f4554f;

    /* JADX INFO: renamed from: g */
    private C0940f f4555g;

    /* JADX INFO: renamed from: h */
    private View f4556h;

    /* JADX INFO: renamed from: i */
    private View f4557i;

    /* JADX INFO: renamed from: j */
    private View f4558j;

    /* JADX INFO: renamed from: k */
    private View f4559k;

    /* JADX INFO: renamed from: l */
    private TextView f4560l;

    /* JADX INFO: renamed from: m */
    private SeekBar f4561m;

    /* JADX INFO: renamed from: n */
    private TextView f4562n;

    /* JADX INFO: renamed from: o */
    private SeekBar f4563o;

    /* JADX INFO: renamed from: p */
    private TextView f4564p;

    /* JADX INFO: renamed from: q */
    private TextView f4565q;

    /* JADX INFO: renamed from: r */
    private Bitmap f4566r;

    /* JADX INFO: renamed from: s */
    private Bitmap f4567s;

    /* JADX INFO: renamed from: u */
    private InterfaceC1533a f4569u;

    /* JADX INFO: renamed from: v */
    private PopupWindow f4570v;

    /* JADX INFO: renamed from: w */
    private PopupWindow f4571w;

    /* JADX INFO: renamed from: a */
    private int f4549a = 1;

    /* JADX INFO: renamed from: t */
    private boolean f4568t = false;

    /* JADX INFO: renamed from: a */
    private void m3697a() {
        if (this.f4569u == null) {
            return;
        }
        if (this.f4569u.mo3714a()) {
            new AlertDialog.Builder(this).setMessage(R.string.image_modified_tip).setPositiveButton(android.R.string.yes, new DialogInterfaceOnClickListenerC1539d(this)).setNegativeButton(android.R.string.no, (DialogInterface.OnClickListener) null).show();
        } else {
            m3705c();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3698a(int i) {
        View viewInflate = View.inflate(this, R.layout.pngeditor_dlg_size_input, null);
        EditText editText = (EditText) viewInflate.findViewById(R.id.et_width);
        EditText editText2 = (EditText) viewInflate.findViewById(R.id.et_height);
        editText.setText(this.f4564p.getText());
        editText2.setText(this.f4565q.getText());
        switch (i) {
            case 0:
                editText.requestFocus();
                break;
            case 1:
                editText2.requestFocus();
                break;
        }
        new AlertDialog.Builder(this).setTitle(R.string.input_new_size).setView(viewInflate).setPositiveButton(android.R.string.ok, new DialogInterfaceOnClickListenerC1542g(this, editText, editText2)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: renamed from: a */
    private static void m3699a(View view, int i, int i2, int i3, int i4) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i, 0, 0, 0);
            view.requestLayout();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3701a(InterfaceC1533a interfaceC1533a, View view) {
        this.f4569u = interfaceC1533a;
        view.setVisibility(0);
        this.f4556h.setVisibility(4);
        this.f4554f.setVisibility(0);
        this.f4553e.setVisibility(4);
        this.f4564p.setText(String.valueOf(this.f4566r.getWidth()));
        this.f4565q.setText(String.valueOf(this.f4566r.getHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m3703b() {
        if (C1480l.m3515a(this.f4566r, this.f4550b)) {
            Toast.makeText(this, R.string.image_saved, 0).show();
        } else {
            Toast.makeText(this, R.string.image_save_failed, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m3705c() {
        this.f4569u = null;
        this.f4557i.setVisibility(4);
        this.f4558j.setVisibility(4);
        this.f4559k.setVisibility(4);
        this.f4556h.setVisibility(0);
        this.f4554f.setVisibility(4);
        this.f4553e.setVisibility(0);
    }

    @Override // com.p050c.p051a.InterfaceC0943i
    @SuppressLint({"DefaultLocale"})
    /* JADX INFO: renamed from: a */
    public final void mo2079a(float f) {
        this.f4552d.setText(String.format("%d%%", Integer.valueOf((int) (100.0f * f))));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f4556h.getVisibility() != 0) {
            m3697a();
        } else if (this.f4568t) {
            new AlertDialog.Builder(this).setMessage(R.string.image_save_tip).setPositiveButton(R.string.save, new DialogInterfaceOnClickListenerC1538c(this)).setNegativeButton(R.string.discard, new DialogInterfaceOnClickListenerC1537b(this)).setNeutralButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
        } else {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_remove_bg) {
            m3701a(new C1534a(), this.f4557i);
            return;
        }
        if (id == R.id.btn_remove_it) {
            this.f4569u.mo3713a("tolerance", Integer.valueOf(this.f4561m.getProgress()));
            this.f4567s = this.f4569u.mo3712a(this.f4566r);
            if (this.f4555g == null || this.f4567s == null) {
                return;
            }
            this.f4555g.setImageBitmap(this.f4567s);
            return;
        }
        if (id == R.id.btn_confirm) {
            if (!this.f4569u.mo3714a()) {
                Toast.makeText(this, R.string.no_change, 0).show();
                return;
            }
            this.f4566r = this.f4567s;
            this.f4568t = true;
            m3705c();
            return;
        }
        if (id == R.id.btn_save) {
            if (this.f4568t) {
                m3703b();
                return;
            } else {
                Toast.makeText(this, R.string.no_change, 0).show();
                return;
            }
        }
        if (id == R.id.btn_cancel) {
            m3697a();
            return;
        }
        if (id == R.id.btn_resize) {
            m3701a(new C1535b(), this.f4558j);
            return;
        }
        if (id == R.id.btn_do_resize) {
            String string = this.f4564p.getText().toString();
            String string2 = this.f4565q.getText().toString();
            boolean zIsChecked = ((CheckBox) findViewById(R.id.cb_without_zoom)).isChecked();
            try {
                int iIntValue = Integer.valueOf(string).intValue();
                try {
                    int iIntValue2 = Integer.valueOf(string2).intValue();
                    this.f4569u.mo3713a("width", Integer.valueOf(iIntValue));
                    this.f4569u.mo3713a("height", Integer.valueOf(iIntValue2));
                    this.f4569u.mo3713a("zooming", Boolean.valueOf(!zIsChecked));
                    this.f4567s = this.f4569u.mo3712a(this.f4566r);
                    if (this.f4555g == null || this.f4567s == null) {
                        return;
                    }
                    this.f4555g.setImageBitmap(this.f4567s);
                    return;
                } catch (Exception e) {
                    return;
                }
            } catch (Exception e2) {
                return;
            }
        }
        if (id == R.id.btn_transparency) {
            m3701a(new C1536c(), this.f4559k);
            return;
        }
        if (id == R.id.btn_transparency_preview) {
            this.f4569u.mo3713a("transparency", Integer.valueOf((this.f4563o.getProgress() * 255) / this.f4563o.getMax()));
            this.f4567s = this.f4569u.mo3712a(this.f4566r);
            if (this.f4555g == null || this.f4567s == null) {
                return;
            }
            this.f4555g.setImageBitmap(this.f4567s);
            return;
        }
        if (id == R.id.width_labelvalue) {
            m3698a(0);
            return;
        }
        if (id == R.id.height_labelvalue) {
            m3698a(1);
            return;
        }
        if (id == R.id.tv_scale) {
            if (this.f4570v == null) {
                View viewInflate = View.inflate(this, R.layout.pngeditor_scale_options, null);
                ViewOnClickListenerC1540e viewOnClickListenerC1540e = new ViewOnClickListenerC1540e(this);
                viewInflate.findViewById(R.id.btn_scale_fit).setOnClickListener(viewOnClickListenerC1540e);
                viewInflate.findViewById(R.id.btn_scale_100).setOnClickListener(viewOnClickListenerC1540e);
                viewInflate.findViewById(R.id.btn_scale_200).setOnClickListener(viewOnClickListenerC1540e);
                viewInflate.findViewById(R.id.btn_scale_400).setOnClickListener(viewOnClickListenerC1540e);
                this.f4570v = new PopupWindow(viewInflate, C1474f.m3501a(this), findViewById(R.id.btn_remove_bg).getHeight());
            }
            this.f4570v.setFocusable(true);
            this.f4570v.setOutsideTouchable(true);
            this.f4570v.showAsDropDown(view);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.m91md(C0037k.m89a(this)));
        super.onCreate(bundle);
        setContentView(R.layout.pngeditor_activity);
        this.f4550b = getIntent().getStringExtra("filePath");
        this.f4551c = this.f4550b.substring(this.f4550b.lastIndexOf(47) + 1);
        getActionBar().hide();
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.pngeditor_actionbar, (ViewGroup) null);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowTitleEnabled(false);
            supportActionBar.setDisplayShowCustomEnabled(true);
            supportActionBar.setCustomView(viewGroup);
        }
        this.f4552d = (TextView) findViewById(R.id.tv_scale);
        this.f4552d.setPaintFlags(this.f4552d.getPaintFlags() | 8);
        this.f4552d.setOnClickListener(this);
        findViewById(R.id.btn_save);
        this.f4553e = findViewById(R.id.normal_action_layout);
        this.f4554f = findViewById(R.id.edit_action_layout);
        findViewById(R.id.btn_save).setOnClickListener(this);
        findViewById(R.id.btn_confirm).setOnClickListener(this);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
        this.f4556h = findViewById(R.id.tools_layout);
        this.f4557i = findViewById(R.id.remove_bg_layout);
        this.f4558j = findViewById(R.id.resize_layout);
        this.f4559k = findViewById(R.id.transparency_layout);
        this.f4560l = (TextView) findViewById(R.id.tv_tolerance);
        this.f4561m = (SeekBar) findViewById(R.id.seekbar_tolerance);
        this.f4561m.setOnSeekBarChangeListener(this);
        this.f4562n = (TextView) findViewById(R.id.tv_transparency);
        this.f4563o = (SeekBar) findViewById(R.id.seekbar_transparency);
        this.f4563o.setOnSeekBarChangeListener(this);
        this.f4564p = (TextView) findViewById(R.id.tv_width_value);
        this.f4565q = (TextView) findViewById(R.id.tv_height_value);
        this.f4564p.setPaintFlags(this.f4564p.getPaintFlags() | 8);
        this.f4565q.setPaintFlags(this.f4565q.getPaintFlags() | 8);
        findViewById(R.id.width_labelvalue).setOnClickListener(this);
        findViewById(R.id.height_labelvalue).setOnClickListener(this);
        findViewById(R.id.btn_remove_bg).setOnClickListener(this);
        findViewById(R.id.btn_remove_it).setOnClickListener(this);
        findViewById(R.id.btn_resize).setOnClickListener(this);
        findViewById(R.id.btn_do_resize).setOnClickListener(this);
        findViewById(R.id.btn_transparency).setOnClickListener(this);
        findViewById(R.id.btn_transparency_preview).setOnClickListener(this);
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, this.f4549a);
        }
        new AsyncTaskC1543h(this).execute(new Void[0]);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pngeditor_main, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId != R.id.action_background) {
            if (itemId != R.id.action_help) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(this, (Class<?>) AboutModActivity.class));
            return true;
        }
        if (this.f4571w == null) {
            View viewInflate = View.inflate(this, R.layout.pngeditor_bgcolor, null);
            viewInflate.findViewById(R.id.btn_close).setOnClickListener(new ViewOnClickListenerC1541f(this));
            ((SeekBar) viewInflate.findViewById(R.id.seekbar_bgcolor)).setOnSeekBarChangeListener(this);
            viewInflate.measure(0, 0);
            this.f4571w = new PopupWindow(viewInflate, C1474f.m3501a(this), viewInflate.getMeasuredHeight());
        }
        this.f4571w.setFocusable(true);
        this.f4571w.setOutsideTouchable(true);
        this.f4571w.showAsDropDown(this.f4552d);
        return true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        int id = seekBar.getId();
        int paddingLeft = seekBar.getPaddingLeft();
        int width = paddingLeft + ((((seekBar.getWidth() - paddingLeft) - seekBar.getPaddingRight()) * seekBar.getProgress()) / seekBar.getMax());
        if (id == R.id.seekbar_tolerance) {
            this.f4560l.setText(String.valueOf(i));
            this.f4560l.measure(0, 0);
            m3699a(this.f4560l, width - (this.f4560l.getMeasuredWidth() / 2), 0, 0, 0);
        } else if (id == R.id.seekbar_transparency) {
            this.f4562n.setText(String.valueOf(i));
            this.f4562n.measure(0, 0);
            m3699a(this.f4562n, width - (this.f4562n.getMeasuredWidth() / 2), 0, 0, 0);
        } else if (id == R.id.seekbar_bgcolor) {
            int i2 = i >= 0 ? i : 0;
            int i3 = 255 - (i2 <= 255 ? i2 : 255);
            findViewById(R.id.overall_layout).setBackgroundColor(i3 | (-16777216) | (i3 << 16) | (i3 << 8));
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
