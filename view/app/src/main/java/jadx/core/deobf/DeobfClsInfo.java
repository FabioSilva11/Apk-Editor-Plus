package jadx.core.deobf;

import jadx.core.dex.nodes.ClassNode;

/* JADX INFO: loaded from: classes.dex */
class DeobfClsInfo {
    private final String alias;
    private final ClassNode cls;
    private final Deobfuscator deobfuscator;
    private final PackageNode pkg;

    public DeobfClsInfo(Deobfuscator deobfuscator, ClassNode classNode, PackageNode packageNode, String str) {
        this.deobfuscator = deobfuscator;
        this.cls = classNode;
        this.pkg = packageNode;
        this.alias = str;
    }

    public String getAlias() {
        return this.alias;
    }

    public ClassNode getCls() {
        return this.cls;
    }

    public String getFullName() {
        return this.pkg.getFullAlias() + Deobfuscator.CLASS_NAME_SEPARATOR + makeNameWithoutPkg();
    }

    public PackageNode getPkg() {
        return this.pkg;
    }

    public String makeNameWithoutPkg() {
        String str;
        ClassNode parentClass = this.cls.getParentClass();
        if (parentClass != this.cls) {
            DeobfClsInfo deobfClsInfo = (DeobfClsInfo) this.deobfuscator.getClsMap().get(parentClass.getClassInfo());
            str = (deobfClsInfo != null ? deobfClsInfo.makeNameWithoutPkg() : this.deobfuscator.getNameWithoutPackage(parentClass.getClassInfo())) + Deobfuscator.INNER_CLASS_SEPARATOR;
        } else {
            str = "";
        }
        return str + (this.alias != null ? this.alias : this.cls.getShortName());
    }
}
