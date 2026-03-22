package com.p016a.p019b.p028c.p029a;

import com.p016a.p019b.p028c.p030b.C0585j;
import com.p016a.p019b.p036f.p038b.C0772x;
import java.io.PrintStream;

/* JADX INFO: renamed from: com.a.b.c.a.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0536c {

    /* JADX INFO: renamed from: a */
    private static int f691a = 0;

    /* JADX INFO: renamed from: b */
    private static int f692b = 0;

    /* JADX INFO: renamed from: c */
    private static int f693c = 0;

    /* JADX INFO: renamed from: d */
    private static int f694d = 0;

    /* JADX INFO: renamed from: e */
    private static int f695e = 0;

    /* JADX INFO: renamed from: f */
    private static int f696f = 0;

    /* JADX INFO: renamed from: g */
    private static int f697g = 0;

    /* JADX INFO: renamed from: a */
    public static void m836a(int i) {
        f697g += i;
    }

    /* JADX INFO: renamed from: a */
    public static void m837a(C0585j c0585j, C0585j c0585j2) {
        f695e += c0585j2.m947f().m971e() - c0585j.m947f().m971e();
        f694d += c0585j2.m947f().m972f() - c0585j.m947f().m972f();
        f696f += c0585j2.m947f().m971e();
    }

    /* JADX INFO: renamed from: a */
    public static void m838a(C0772x c0772x, C0772x c0772x2) {
        int iM1481g = c0772x.m1582a().m1481g();
        int iM1479e = c0772x.m1582a().m1479e();
        int iM1481g2 = c0772x2.m1582a().m1481g();
        f692b = (iM1481g2 - iM1481g) + f692b;
        f691a += c0772x2.m1582a().m1479e() - iM1479e;
        f693c += iM1481g2;
    }

    /* JADX INFO: renamed from: a */
    public static void m839a(PrintStream printStream) {
        printStream.printf("Optimizer Delta Rop Insns: %d total: %d (%.2f%%) Delta Registers: %d\n", Integer.valueOf(f692b), Integer.valueOf(f693c), Double.valueOf(((double) (f692b / (f693c + Math.abs(f692b)))) * 100.0d), Integer.valueOf(f691a));
        printStream.printf("Optimizer Delta Dex Insns: Insns: %d total: %d (%.2f%%) Delta Registers: %d\n", Integer.valueOf(f695e), Integer.valueOf(f696f), Double.valueOf(((double) (f695e / (f696f + Math.abs(f695e)))) * 100.0d), Integer.valueOf(f694d));
        printStream.printf("Original bytecode byte count: %d\n", Integer.valueOf(f697g));
    }
}
