package com.gmail.heagoo.common;

import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: renamed from: com.gmail.heagoo.common.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1471c implements ccc {

    /* JADX INFO: renamed from: a */
    private String[] f4293a = new String[2];

    /* JADX INFO: renamed from: a */
    private static String m3490a(InputStream inputStream) throws IOException {
        int i;
        char[] cArr = new char[8192];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        do {
            i = inputStreamReader.read(cArr, 0, 8192);
            if (i > 0) {
                sb.append(cArr, 0, i);
            }
        } while (i >= 0);
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3491a(Process process) {
        try {
            process.exitValue();
            return false;
        } catch (IllegalThreadStateException e) {
            return true;
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m3492b(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    @Override // com.gmail.heagoo.common.ccc
    /* JADX INFO: renamed from: a */
    public final String mo3493a() {
        return this.f4293a[0];
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3494a(Object obj, String[] strArr, Integer num, boolean z) {
        Process processExec;
        Process process = null;
        try {
            try {
                try {
                    if (obj instanceof String) {
                        processExec = Runtime.getRuntime().exec((String) obj, strArr);
                    } else {
                        processExec = Runtime.getRuntime().exec((String[]) obj);
                    }
                    InputStream inputStream = processExec.getInputStream();
                    InputStream errorStream = processExec.getErrorStream();
                    C1472d c1472d = null;
                    C1472d c1472d2 = null;
                    if (z) {
                        c1472d = new C1472d(inputStream, this.f4293a, 0);
                        c1472d.start();
                        c1472d2 = new C1472d(errorStream, this.f4293a, 1);
                        c1472d2.start();
                    }
                    if (num != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis() + ((long) num.intValue());
                        do {
                            Thread.sleep(20L);
                            if (m3491a(processExec)) {
                            }
                        } while (System.currentTimeMillis() <= jCurrentTimeMillis);
                        Log.w("CommandRunner", "Process doesn't seem to stop on it's own, assuming it's hanging");
                        this.f4293a[1] = "Timeout!";
                        if (processExec != null) {
                            try {
                                processExec.exitValue();
                            } catch (IllegalThreadStateException e) {
                                processExec.destroy();
                            }
                        }
                        return false;
                    }
                    processExec.waitFor();
                    if (z) {
                        c1472d.m3499a();
                        c1472d2.m3499a();
                    } else {
                        this.f4293a[0] = m3490a(inputStream);
                        this.f4293a[1] = m3490a(errorStream);
                        m3492b(inputStream);
                        m3492b(errorStream);
                    }
                    if (processExec.exitValue() != 0) {
                        if (processExec != null) {
                            try {
                                processExec.exitValue();
                            } catch (IllegalThreadStateException e2) {
                                processExec.destroy();
                            }
                        }
                        return false;
                    }
                    if (processExec != null) {
                        try {
                            processExec.exitValue();
                        } catch (IllegalThreadStateException e3) {
                            processExec.destroy();
                        }
                    }
                    return true;
                } catch (FileNotFoundException e4) {
                    Log.e("DEBUG", "Failed to run command", e4);
                    if (0 != 0) {
                        try {
                            process.exitValue();
                        } catch (IllegalThreadStateException e5) {
                            process.destroy();
                        }
                    }
                    return false;
                } catch (InterruptedException e6) {
                    if (0 != 0) {
                        try {
                            process.exitValue();
                        } catch (IllegalThreadStateException e7) {
                            process.destroy();
                        }
                    }
                    return false;
                }
            } catch (IOException e8) {
                Log.e("DEBUG", "Failed to run command", e8);
                if (0 != 0) {
                    try {
                        process.exitValue();
                    } catch (IllegalThreadStateException e9) {
                        process.destroy();
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    process.exitValue();
                } catch (IllegalThreadStateException e10) {
                    process.destroy();
                }
            }
            throw th;
        }
    }

    @Override // com.gmail.heagoo.common.ccc
    /* JADX INFO: renamed from: a */
    public final boolean mo3495a(String str, String[] strArr, Integer num) {
        return m3494a((Object) str, (String[]) null, num, false);
    }

    @Override // com.gmail.heagoo.common.ccc
    /* JADX INFO: renamed from: a */
    public final boolean mo3496a(String[] strArr, Integer num, boolean z) {
        Process processExec;
        InputStream inputStream;
        InputStream errorStream;
        C1472d c1472d;
        C1472d c1472d2;
        boolean z2 = false;
        try {
            try {
                processExec = Runtime.getRuntime().exec(strArr);
                inputStream = processExec.getInputStream();
                errorStream = processExec.getErrorStream();
                if (z) {
                    C1472d c1472d3 = new C1472d(inputStream, this.f4293a, 0);
                    c1472d3.start();
                    C1472d c1472d4 = new C1472d(errorStream, this.f4293a, 1);
                    c1472d4.start();
                    c1472d = c1472d4;
                    c1472d2 = c1472d3;
                } else {
                    c1472d = null;
                    c1472d2 = null;
                }
            } catch (InterruptedException e) {
                return false;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        } catch (IOException e3) {
            e = e3;
        }
        try {
            if (num != null) {
                long jCurrentTimeMillis = System.currentTimeMillis() + ((long) num.intValue());
                do {
                    Thread.sleep(20L);
                    m3491a(processExec);
                } while (System.currentTimeMillis() <= jCurrentTimeMillis);
                Log.w("CommandRunner", "Process doesn't seem to stop on it's own, assuming it's hanging");
                this.f4293a[1] = "Timeout!";
                if (processExec == null) {
                    return false;
                }
                try {
                    processExec.exitValue();
                    return false;
                } catch (IllegalThreadStateException e4) {
                    processExec.destroy();
                    return false;
                }
            }
            processExec.waitFor();
            if (z) {
                c1472d2.m3499a();
                c1472d.m3499a();
            } else {
                this.f4293a[0] = m3490a(inputStream);
                this.f4293a[1] = m3490a(errorStream);
                m3492b(inputStream);
                m3492b(errorStream);
            }
            if (processExec.exitValue() == 0) {
                if (processExec != null) {
                    try {
                        processExec.exitValue();
                    } catch (IllegalThreadStateException e5) {
                        processExec.destroy();
                    }
                }
                return true;
            }
            if (processExec == null) {
                return false;
            }
            try {
                processExec.exitValue();
                return false;
            } catch (IllegalThreadStateException e6) {
                processExec.destroy();
                return false;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            z2 = false;
        } catch (IOException e8) {
            e = e8;
            z2 = false;
            Log.e("DEBUG", "Failed to run command", e);
            return z2;
        }
        Log.e("DEBUG", "Failed to run command", e);
        return z2;
    }

    @Override // com.gmail.heagoo.common.ccc
    /* JADX INFO: renamed from: b */
    public final String mo3497b() {
        return this.f4293a[1];
    }
}
