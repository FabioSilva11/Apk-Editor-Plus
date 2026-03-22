package jadx.core.dex.info;

import com.gmail.heagoo.p054a.p059c.C0985a;

/* JADX INFO: loaded from: classes.dex */
public class AccessInfo {
    private final int accFlags;
    private final AFType type;

    public enum AFType {
        CLASS,
        FIELD,
        METHOD
    }

    public AccessInfo(int i, AFType aFType) {
        this.accFlags = i;
        this.type = aFType;
    }

    public boolean containsFlag(int i) {
        return (this.accFlags & i) != 0;
    }

    public AFType getType() {
        return this.type;
    }

    public AccessInfo getVisibility() {
        return new AccessInfo((this.accFlags & 1) | (this.accFlags & 4) | (this.accFlags & 2), this.type);
    }

    public boolean isAbstract() {
        return (this.accFlags & 1024) != 0;
    }

    public boolean isAnnotation() {
        return (this.accFlags & 8192) != 0;
    }

    public boolean isBridge() {
        return (this.accFlags & 64) != 0;
    }

    public boolean isConstructor() {
        return (this.accFlags & 65536) != 0;
    }

    public boolean isEnum() {
        return (this.accFlags & 16384) != 0;
    }

    public boolean isFinal() {
        return (this.accFlags & 16) != 0;
    }

    public boolean isInterface() {
        return (this.accFlags & 512) != 0;
    }

    public boolean isNative() {
        return (this.accFlags & 256) != 0;
    }

    public boolean isPrivate() {
        return (this.accFlags & 2) != 0;
    }

    public boolean isProtected() {
        return (this.accFlags & 4) != 0;
    }

    public boolean isPublic() {
        return (this.accFlags & 1) != 0;
    }

    public boolean isStatic() {
        return (this.accFlags & 8) != 0;
    }

    public boolean isSynchronized() {
        return (this.accFlags & 131104) != 0;
    }

    public boolean isSynthetic() {
        return (this.accFlags & 4096) != 0;
    }

    public boolean isTransient() {
        return (this.accFlags & 128) != 0;
    }

    public boolean isVarArgs() {
        return (this.accFlags & 128) != 0;
    }

    public boolean isVolatile() {
        return (this.accFlags & 64) != 0;
    }

    public String makeString() {
        StringBuilder sb = new StringBuilder();
        if (isPublic()) {
            sb.append("public ");
        }
        if (isPrivate()) {
            sb.append("private ");
        }
        if (isProtected()) {
            sb.append("protected ");
        }
        if (isStatic()) {
            sb.append("static ");
        }
        if (isFinal()) {
            sb.append("final ");
        }
        if (isAbstract()) {
            sb.append("abstract ");
        }
        if (isNative()) {
            sb.append("native ");
        }
        switch (this.type) {
            case METHOD:
                if (isSynchronized()) {
                    sb.append("synchronized ");
                }
                if (isBridge()) {
                    sb.append("/* bridge */ ");
                }
                break;
            case FIELD:
                if (isVolatile()) {
                    sb.append("volatile ");
                }
                if (isTransient()) {
                    sb.append("transient ");
                }
                break;
            case CLASS:
                if ((this.accFlags & 2048) != 0) {
                    sb.append("strict ");
                }
                break;
        }
        if (isSynthetic()) {
            sb.append("/* synthetic */ ");
        }
        return sb.toString();
    }

    public String rawString() {
        switch (this.type) {
            case METHOD:
                return C0985a.m2281j(this.accFlags);
            case FIELD:
                return C0985a.m2278i(this.accFlags);
            case CLASS:
                return C0985a.m2274g(this.accFlags);
            default:
                return "?";
        }
    }

    public AccessInfo remove(int i) {
        return containsFlag(i) ? new AccessInfo(this.accFlags & (i ^ (-1)), this.type) : this;
    }

    public String toString() {
        return "AccessInfo: " + this.type + " 0x" + Integer.toHexString(this.accFlags) + " (" + rawString() + ")";
    }
}
