package com.gmail.heagoo.apkeditor;

import android.view.View;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: loaded from: classes.dex */
class gzc {
    TextView itemDescription;
    TextView itemTitle;
    private final gzb this$0;

    public gzc(gzb gzbVar, View view) {
        this.this$0 = gzbVar;
        this.itemTitle = (TextView) view.findViewById(R.id.templates_item_tilte);
        this.itemDescription = (TextView) view.findViewById(R.id.templates_item_content);
    }
}
