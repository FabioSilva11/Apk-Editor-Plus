package jadx.core.utils;

import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.InsnNode;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class InsnList implements Iterable {
    private final List list;

    public InsnList(List list) {
        this.list = list;
    }

    public static int getIndex(List list, InsnNode insnNode) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == insnNode) {
                return i;
            }
        }
        return -1;
    }

    public static void remove(BlockNode blockNode, InsnNode insnNode) {
        remove(blockNode.getInstructions(), insnNode);
    }

    public static void remove(List list, InsnNode insnNode) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((InsnNode) it.next()) == insnNode) {
                it.remove();
                return;
            }
        }
    }

    public final boolean contains(InsnNode insnNode) {
        return getIndex(insnNode) != -1;
    }

    public final InsnNode get(int i) {
        return (InsnNode) this.list.get(i);
    }

    public final int getIndex(InsnNode insnNode) {
        return getIndex(this.list, insnNode);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.list.iterator();
    }

    public final void remove(InsnNode insnNode) {
        remove(this.list, insnNode);
    }

    public final int size() {
        return this.list.size();
    }
}
