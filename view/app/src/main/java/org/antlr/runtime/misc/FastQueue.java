package org.antlr.runtime.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class FastQueue<T> {
    public List<T> data = new ArrayList();

    /* JADX INFO: renamed from: p */
    public int f4708p = 0;
    public int range = -1;

    public void add(T t) {
        this.data.add(t);
    }

    public void clear() {
        this.f4708p = 0;
        this.data.clear();
    }

    public T elementAt(int i) {
        int i2 = this.f4708p + i;
        if (i2 >= this.data.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("queue index ");
            sb.append(i2);
            sb.append(" > last index ");
            sb.append(this.data.size() - 1);
            throw new NoSuchElementException(sb.toString());
        }
        if (i2 >= 0) {
            if (i2 > this.range) {
                this.range = i2;
            }
            return this.data.get(i2);
        }
        throw new NoSuchElementException("queue index " + i2 + " < 0");
    }

    public T remove() {
        T tElementAt = elementAt(0);
        int i = this.f4708p + 1;
        this.f4708p = i;
        if (i == this.data.size()) {
            clear();
        }
        return tElementAt;
    }

    public int size() {
        return this.data.size() - this.f4708p;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        int i = 0;
        while (i < size) {
            sb.append(elementAt(i));
            i++;
            if (i < size) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
