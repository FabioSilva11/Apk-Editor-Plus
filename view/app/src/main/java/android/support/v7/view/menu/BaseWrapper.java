package android.support.v7.view.menu;

/* JADX INFO: loaded from: classes.dex */
class BaseWrapper {
    final Object mWrappedObject;

    BaseWrapper(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.mWrappedObject = obj;
    }

    public Object getWrappedObject() {
        return this.mWrappedObject;
    }
}
