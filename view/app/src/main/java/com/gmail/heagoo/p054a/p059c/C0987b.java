package com.gmail.heagoo.p054a.p059c;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.android.apksig.ApkSigner;
import com.android.apksig.apk.ApkFormatException;
import com.gmail.heagoo.apkeditor.SettingActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: com.gmail.heagoo.a.c.b */
/* JADX INFO: loaded from: classes.dex */
public class C0987b {

    /* JADX INFO: renamed from: com.gmail.heagoo.a.c.b$ProviderInstallSpec */
    private static class ProviderInstallSpec {
        String className;
        String constructorParam;
        Integer position;

        private ProviderInstallSpec() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void installProvider() throws Exception {
            Provider provider;
            String str = this.className;
            if (str == null) {
                throw new ParameterException("JCA Provider class name (--provider-class) must be specified");
            }
            Class<?> cls = Class.forName(str);
            if (!Provider.class.isAssignableFrom(cls)) {
                throw new ParameterException("JCA Provider class " + cls + " not subclass of " + Provider.class.getName());
            }
            if (this.constructorParam != null) {
                try {
                    provider = (Provider) cls.getConstructor(String.class).newInstance(this.constructorParam);
                } catch (NoSuchMethodException e) {
                    provider = (Provider) cls.getMethod("configure", String.class).invoke((Provider) cls.getConstructor(new Class[0]).newInstance(new Object[0]), this.constructorParam);
                }
            } else {
                provider = (Provider) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            Integer num = this.position;
            if (num == null) {
                Security.addProvider(provider);
            } else {
                Security.insertProviderAt(provider, num.intValue());
            }
        }

        private boolean isEmpty() {
            return this.className == null && this.constructorParam == null && this.position == null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2312a(String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        PasswordRetriever passwordRetriever;
        Throwable th;
        File file = new File(str3);
        File file2 = new File(str4);
        ArrayList arrayList = new ArrayList(1);
        SignerParams signerParams = new SignerParams();
        signerParams.setV1SigFileBasename("cert");
        signerParams.setKeyFile(str2);
        signerParams.setCertFile(str);
        arrayList.add(signerParams);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(arrayList.size());
        int i = 0;
        try {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((ProviderInstallSpec) it.next()).installProvider();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PasswordRetriever passwordRetriever2 = new PasswordRetriever();
        try {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                try {
                    SignerParams signerParams2 = (SignerParams) it2.next();
                    int i2 = i + 1;
                    Iterator it3 = it2;
                    try {
                        StringBuilder sb = new StringBuilder();
                        ArrayList arrayList4 = arrayList;
                        try {
                            sb.append("signer #");
                            sb.append(i2);
                            signerParams2.setName(sb.toString());
                            i = i2;
                            passwordRetriever = passwordRetriever2;
                        } catch (Throwable th2) {
                            passwordRetriever = passwordRetriever2;
                            th = th2;
                        }
                        try {
                            ApkSigner.SignerConfig signerConfig = getSignerConfig(signerParams2, passwordRetriever);
                            if (signerConfig == null) {
                                passwordRetriever.close();
                                return;
                            }
                            arrayList3.add(signerConfig);
                            passwordRetriever2 = passwordRetriever;
                            it2 = it3;
                            arrayList = arrayList4;
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                try {
                                    passwordRetriever.close();
                                    throw th4;
                                } catch (Throwable th5) {
                                    th.addSuppressed(th5);
                                    throw th4;
                                }
                            }
                        }
                    } catch (Throwable th6) {
                        passwordRetriever = passwordRetriever2;
                        th = th6;
                    }
                } catch (Throwable th7) {
                    passwordRetriever = passwordRetriever2;
                    th = th7;
                }
            }
            passwordRetriever2.close();
            boolean z5 = false;
            ApkSigner.Builder verityEnabled = new ApkSigner.Builder(arrayList3).setInputApk(file).setOutputApk(file2).setOtherSignersSignaturesPreserved(false).setV1SigningEnabled(z).setV2SigningEnabled(z2).setV3SigningEnabled(z3).setV4SigningEnabled(z4).setForceSourceStampOverwrite(false).setVerityEnabled(false);
            if (z4 && 0 != 0) {
                z5 = true;
            }
            ApkSigner.Builder signingCertificateLineage = verityEnabled.setV4ErrorReportingEnabled(z5).setDebuggableApkPermitted(true).setSigningCertificateLineage(null);
            if (1 != 0) {
                signingCertificateLineage.setMinSdkVersion(10);
            }
            if (z4) {
                try {
                    File file3 = new File(file2.getCanonicalPath() + ".idsig");
                    if (file3.exists()) {
                        file3.delete();
                    }
                    signingCertificateLineage.setV4SignatureOutputFile(file3);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                signingCertificateLineage.build().sign();
            } catch (ApkFormatException | IOException | InvalidKeyException | NoSuchAlgorithmException | SignatureException e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th8) {
            passwordRetriever = passwordRetriever2;
            th = th8;
        }
    }

    public static void checkSign(Context context, String str) {
        if (str.endsWith(".apk")) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(R.string.about);
                View viewInflate = LayoutInflater.from(context).inflate(R.layout.dlg_verify, (ViewGroup) null);
                ((TextView) viewInflate.findViewById(R.id.verify_text_view)).setText(Verify.verify(str));
                builder.setPositiveButton(R.string.close, (DialogInterface.OnClickListener) null);
                builder.setView(viewInflate);
                builder.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static ApkSigner.SignerConfig getSignerConfig(SignerParams signerParams, PasswordRetriever passwordRetriever) {
        String name;
        try {
            signerParams.loadPrivateKeyAndCerts(passwordRetriever);
            if (signerParams.getV1SigFileBasename() != null) {
                name = signerParams.getV1SigFileBasename();
            } else if (signerParams.getKeystoreKeyAlias() != null) {
                name = signerParams.getKeystoreKeyAlias();
            } else {
                if (signerParams.getKeyFile() == null) {
                    throw new RuntimeException("Neither KeyStore key alias nor private key file available");
                }
                name = new File(signerParams.getKeyFile()).getName();
                int iIndexOf = name.indexOf(46);
                if (iIndexOf != -1) {
                    name = name.substring(0, iIndexOf);
                }
            }
            return new ApkSigner.SignerConfig.Builder(name, signerParams.getPrivateKey(), signerParams.getCerts()).build();
        } catch (ParameterException e) {
            System.err.println("Failed to load signer \"" + signerParams.getName() + "\": " + e.getMessage());
            System.exit(2);
            return null;
        } catch (Exception e2) {
            System.err.println("Failed to load signer \"" + signerParams.getName() + "\"");
            e2.printStackTrace();
            System.exit(2);
            return null;
        }
    }

    public static void sign(Context context, String str) {
        String absolutePath;
        String absolutePath2;
        if (str.endsWith(".apk")) {
            String strM2546c = SettingActivity.m2546c(context);
            if (strM2546c.charAt(0) == 'c' && strM2546c.charAt(1) == 'u') {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                String string = defaultSharedPreferences.getString("PublicKeyPath", "");
                absolutePath2 = defaultSharedPreferences.getString("PrivateKeyPath", "");
                absolutePath = string;
            } else {
                File file = new File(context.getFilesDir(), "signing");
                File file2 = new File(file, strM2546c + ".x509.pem");
                File file3 = new File(file, strM2546c + ".pk8");
                if (file2.exists() && file3.exists()) {
                    absolutePath = file2.getAbsolutePath();
                    absolutePath2 = file3.getAbsolutePath();
                } else {
                    file.mkdir();
                    try {
                        AssetManager assets = context.getAssets();
                        C0985a.m2215a(assets.open(strM2546c + ".x509.pem"), new FileOutputStream(file2));
                        C0985a.m2215a(assets.open(strM2546c + ".pk8"), new FileOutputStream(file3));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (!file2.exists() || !file3.exists()) {
                        return;
                    }
                    absolutePath = file2.getAbsolutePath();
                    absolutePath2 = file3.getAbsolutePath();
                }
            }
            boolean[] zArrEnabledSignatureVersions = SettingActivity.enabledSignatureVersions(context);
            String str2 = Environment.getExternalStorageDirectory().getPath() + "/ApkEditor";
            File file4 = new File(str2);
            if (!file4.exists()) {
                file4.mkdir();
            }
            String str3 = str2 + str.substring(str.lastIndexOf(File.separatorChar), str.length() - 4) + "_sign.apk";
            m2312a(absolutePath, absolutePath2, str, str3, zArrEnabledSignatureVersions[0], zArrEnabledSignatureVersions[1], zArrEnabledSignatureVersions[2], zArrEnabledSignatureVersions[3]);
            Toast.makeText(context, str3, 1).show();
        }
    }
}
