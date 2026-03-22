package org.p088jf.dexlib2.writer.pool;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Iterator;
import org.p088jf.dexlib2.writer.TypeListSection;

/* JADX INFO: loaded from: classes.dex */
public class TypeListPool extends BaseNullableOffsetPool<Key<? extends Collection<? extends CharSequence>>> implements TypeListSection<CharSequence, Key<? extends Collection<? extends CharSequence>>> {

    public static class Key<TypeCollection extends Collection<? extends CharSequence>> implements Comparable<Key<? extends Collection<? extends CharSequence>>> {
        public TypeCollection types;

        public Key(TypeCollection typecollection) {
            this.types = typecollection;
        }

        @Override // java.lang.Comparable
        public int compareTo(Key<? extends Collection<? extends CharSequence>> key) {
            Iterator it = key.types.iterator();
            for (CharSequence charSequence : this.types) {
                if (!it.hasNext()) {
                    return 1;
                }
                int iCompareTo = charSequence.toString().compareTo(((CharSequence) it.next()).toString());
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            return it.hasNext() ? -1 : 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.types.size() != key.types.size()) {
                return false;
            }
            Iterator it = key.types.iterator();
            Iterator it2 = this.types.iterator();
            while (it2.hasNext()) {
                if (!((CharSequence) it2.next()).toString().equals(((CharSequence) it.next()).toString())) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            Iterator it = this.types.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                iHashCode = (iHashCode * 31) + ((CharSequence) it.next()).toString().hashCode();
            }
            return iHashCode;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = this.types.iterator();
            while (it.hasNext()) {
                sb.append(((CharSequence) it.next()).toString());
            }
            return sb.toString();
        }
    }

    public TypeListPool(DexPool dexPool) {
        super(dexPool);
    }

    @Override // org.p088jf.dexlib2.writer.pool.BaseNullableOffsetPool, org.p088jf.dexlib2.writer.NullableOffsetSection
    public int getNullableItemOffset(Key<? extends Collection<? extends CharSequence>> key) {
        if (key == null || key.types.size() == 0) {
            return 0;
        }
        return super.getNullableItemOffset(key);
    }

    @Override // org.p088jf.dexlib2.writer.TypeListSection
    public Collection<? extends CharSequence> getTypes(Key<? extends Collection<? extends CharSequence>> key) {
        return key == null ? ImmutableList.m3778of() : key.types;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void intern(Collection<? extends CharSequence> collection) {
        if (collection.size() > 0) {
            if (((Integer) this.internedItems.put((Key) new Key(collection), (Value) 0)) == null) {
                Iterator<? extends CharSequence> it = collection.iterator();
                while (it.hasNext()) {
                    ((TypePool) this.dexPool.typeSection).intern(it.next());
                }
            }
        }
    }
}
