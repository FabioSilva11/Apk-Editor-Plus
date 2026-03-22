package com.p052d.p053a;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: renamed from: com.d.a.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0956d implements InterfaceC0963k {
    @Override // com.p052d.p053a.InterfaceC0963k
    /* JADX INFO: renamed from: a */
    public final Object mo2111a(Object obj, InterfaceC0962j interfaceC0962j, Map map) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        Calendar calendar = (Calendar) obj;
        gregorianCalendar.setTimeInMillis(calendar.getTimeInMillis());
        gregorianCalendar.setTimeZone((TimeZone) calendar.getTimeZone().clone());
        return gregorianCalendar;
    }
}
