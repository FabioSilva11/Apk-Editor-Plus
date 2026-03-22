package org.p088jf.dexlib2.base.reference;

import org.p088jf.dexlib2.iface.reference.StringReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseStringReference extends BaseReference implements StringReference {
    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return getString().charAt(i);
    }

    @Override // java.lang.Comparable
    public int compareTo(CharSequence charSequence) {
        return getString().compareTo(charSequence.toString());
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof StringReference)) {
            return false;
        }
        return getString().equals(((StringReference) obj).getString());
    }

    public int hashCode() {
        return getString().hashCode();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return getString().length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return getString().subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return getString();
    }
}
