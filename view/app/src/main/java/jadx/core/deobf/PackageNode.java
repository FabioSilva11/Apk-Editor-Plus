package jadx.core.deobf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class PackageNode {
    private static final char SEPARATOR_CHAR = '.';
    private String cachedPackageFullAlias;
    private String cachedPackageFullName;
    private String packageAlias;
    private final String packageName;
    private List innerPackages = Collections.emptyList();
    private PackageNode parentPackage = this;

    public PackageNode(String str) {
        this.packageName = str;
    }

    private Stack getParentPackages() {
        Stack stack = new Stack();
        for (PackageNode parentPackage = getParentPackage(); this != parentPackage; parentPackage = parentPackage.getParentPackage()) {
            stack.push(this);
            this = parentPackage;
        }
        return stack;
    }

    public void addInnerPackage(PackageNode packageNode) {
        if (this.innerPackages.isEmpty()) {
            this.innerPackages = new ArrayList();
        }
        this.innerPackages.add(packageNode);
        packageNode.parentPackage = this;
    }

    public String getAlias() {
        return this.packageAlias != null ? this.packageAlias : this.packageName;
    }

    public String getFullAlias() {
        if (this.cachedPackageFullAlias == null) {
            Stack parentPackages = getParentPackages();
            StringBuilder sb = new StringBuilder();
            if (parentPackages.size() > 0) {
                sb.append(((PackageNode) parentPackages.pop()).getAlias());
                while (parentPackages.size() > 0) {
                    sb.append(SEPARATOR_CHAR);
                    sb.append(((PackageNode) parentPackages.pop()).getAlias());
                }
            } else {
                sb.append(getAlias());
            }
            this.cachedPackageFullAlias = sb.toString();
        }
        return this.cachedPackageFullAlias;
    }

    public String getFullName() {
        if (this.cachedPackageFullName == null) {
            Stack parentPackages = getParentPackages();
            StringBuilder sb = new StringBuilder();
            sb.append(((PackageNode) parentPackages.pop()).getName());
            while (parentPackages.size() > 0) {
                sb.append(SEPARATOR_CHAR);
                sb.append(((PackageNode) parentPackages.pop()).getName());
            }
            this.cachedPackageFullName = sb.toString();
        }
        return this.cachedPackageFullName;
    }

    public PackageNode getInnerPackageByName(String str) {
        for (PackageNode packageNode : this.innerPackages) {
            if (packageNode.getName().equals(str)) {
                return packageNode;
            }
        }
        return null;
    }

    public List getInnerPackages() {
        return this.innerPackages;
    }

    public String getName() {
        return this.packageName;
    }

    public PackageNode getParentPackage() {
        return this.parentPackage;
    }

    public boolean hasAlias() {
        return this.packageAlias != null;
    }

    public void setAlias(String str) {
        this.packageAlias = str;
    }
}
