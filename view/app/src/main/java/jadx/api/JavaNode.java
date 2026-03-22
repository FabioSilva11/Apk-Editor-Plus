package jadx.api;

/* JADX INFO: loaded from: classes.dex */
public interface JavaNode {
    JavaClass getDeclaringClass();

    int getDecompiledLine();

    String getFullName();

    String getName();

    JavaClass getTopParentClass();
}
