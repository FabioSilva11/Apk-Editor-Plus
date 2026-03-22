package com.gmail.heagoo.apkeditor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ListenerList<L> {
    private List<L> listenerList = new ArrayList();

    public interface FireHandler<L> {
        void fireEvent(L l);
    }

    ListenerList() {
    }

    public void add(L l) {
        this.listenerList.add(l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void fireEvent(FireHandler<L> fireHandler) {
        Iterator it = new ArrayList(this.listenerList).iterator();
        while (it.hasNext()) {
            fireHandler.fireEvent(it.next());
        }
    }

    public List<L> getListenerList() {
        return this.listenerList;
    }

    public void remove(L l) {
        this.listenerList.remove(l);
    }
}
