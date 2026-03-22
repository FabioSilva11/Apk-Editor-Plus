package com.p052d.p053a;

import com.p016a.p019b.p020a.p025e.InterfaceC0515j;
import com.p016a.p019b.p026b.C0532b;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.d.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0953a {

    /* JADX INFO: renamed from: b */
    private final Set f2414b = new HashSet();

    /* JADX INFO: renamed from: c */
    private final Set f2415c = new HashSet();

    /* JADX INFO: renamed from: d */
    private final Set f2416d = new HashSet();

    /* JADX INFO: renamed from: e */
    private final Map f2417e = new HashMap();

    /* JADX INFO: renamed from: f */
    private final Map f2418f = new IdentityHashMap();

    /* JADX INFO: renamed from: g */
    private final ConcurrentHashMap f2419g = new ConcurrentHashMap();

    /* JADX INFO: renamed from: h */
    private InterfaceC0515j f2420h = null;

    /* JADX INFO: renamed from: i */
    private boolean f2421i = true;

    /* JADX INFO: renamed from: j */
    private boolean f2422j = false;

    /* JADX INFO: renamed from: k */
    private boolean f2423k = true;

    /* JADX INFO: renamed from: l */
    private InterfaceC0962j f2424l = new C0954b(this);

    /* JADX INFO: renamed from: m */
    private final ConcurrentHashMap f2425m = new ConcurrentHashMap();

    /* JADX INFO: renamed from: n */
    private boolean f2426n = true;

    /* JADX INFO: renamed from: a */
    private final InterfaceC0965m f2413a = C0967o.m2115a();

    public C0953a() {
        m2105d(String.class);
        m2105d(Integer.class);
        m2105d(Long.class);
        m2105d(Boolean.class);
        m2105d(Class.class);
        m2105d(Float.class);
        m2105d(Double.class);
        m2105d(Character.class);
        m2105d(Byte.class);
        m2105d(Short.class);
        m2105d(Void.class);
        m2105d(BigDecimal.class);
        m2105d(BigInteger.class);
        m2105d(URI.class);
        m2105d(URL.class);
        m2105d(UUID.class);
        m2105d(Pattern.class);
        m2104c(TreeSet.class, HashSet.class, HashMap.class, TreeMap.class);
        this.f2417e.put(GregorianCalendar.class, new C0956d());
        this.f2417e.put(ArrayList.class, new C0955c());
        this.f2417e.put(LinkedList.class, new C0960h());
        this.f2417e.put(HashSet.class, new C0959g());
        this.f2417e.put(HashMap.class, new C0958f());
        this.f2417e.put(TreeMap.class, new C0961i());
        this.f2417e.put(ConcurrentHashMap.class, new C0957e());
    }

    /* JADX INFO: renamed from: a */
    private List m2102a(Class cls) {
        List list = (List) this.f2419g.get(cls);
        if (list != null) {
            return list;
        }
        LinkedList linkedList = new LinkedList();
        m2103a(linkedList, cls.getDeclaredFields());
        Class superclass = cls;
        while (true) {
            superclass = superclass.getSuperclass();
            if (superclass == Object.class || superclass == null) {
                break;
            }
            m2103a(linkedList, superclass.getDeclaredFields());
        }
        this.f2419g.putIfAbsent(cls, linkedList);
        return linkedList;
    }

    /* JADX INFO: renamed from: a */
    private static void m2103a(List list, Field[] fieldArr) {
        for (Field field : fieldArr) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            list.add(field);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m2104c(Class... clsArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 4) {
                return;
            }
            Class cls = clsArr[i2];
            for (Field field : m2102a(cls)) {
                if (Modifier.isStatic(field.getModifiers()) && !field.getType().isPrimitive()) {
                    try {
                        Field declaredField = cls.getDeclaredField(field.getName());
                        declaredField.setAccessible(true);
                        this.f2418f.put(declaredField.get(null), true);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalArgumentException e2) {
                        throw new RuntimeException(e2);
                    } catch (NoSuchFieldException e3) {
                        throw new RuntimeException(e3);
                    } catch (SecurityException e4) {
                        throw new RuntimeException(e4);
                    }
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m2105d(Class... clsArr) {
        for (int i = 0; i <= 0; i++) {
            this.f2414b.add(clsArr[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public final Object m2106a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!this.f2421i) {
            return obj;
        }
        try {
            return m2107a(obj, new IdentityHashMap(16));
        } catch (IllegalAccessException e) {
            throw new C0532b("error during cloning of " + obj, e);
        }
    }

    /* JADX INFO: renamed from: a */
    protected final Object m2107a(Object obj, Map map) throws IllegalAccessException {
        boolean zBooleanValue;
        if (obj != null && obj != this) {
            if (this.f2418f.containsKey(obj) || (obj instanceof Enum)) {
                return obj;
            }
            Class<?> cls = obj.getClass();
            if (this.f2416d.contains(cls)) {
                return null;
            }
            if (this.f2414b.contains(cls)) {
                return obj;
            }
            Iterator it = this.f2415c.iterator();
            while (it.hasNext()) {
                if (((Class) it.next()).isAssignableFrom(cls)) {
                    return obj;
                }
            }
            Boolean bool = (Boolean) this.f2425m.get(cls);
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
                int length = declaredAnnotations.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        loop4: for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                            for (Annotation annotation : superclass.getDeclaredAnnotations()) {
                                if (annotation.annotationType() == InterfaceC0966n.class && ((InterfaceC0966n) annotation).m2114a()) {
                                    this.f2425m.put(cls, Boolean.TRUE);
                                    zBooleanValue = true;
                                    break loop4;
                                }
                            }
                        }
                        this.f2425m.put(cls, Boolean.FALSE);
                        zBooleanValue = false;
                    } else {
                        if (declaredAnnotations[i].annotationType() == InterfaceC0966n.class) {
                            this.f2425m.put(cls, Boolean.TRUE);
                            zBooleanValue = true;
                            break;
                        }
                        i++;
                    }
                }
            }
            if (zBooleanValue) {
                return obj;
            }
            if ((obj instanceof InterfaceC0964l) && ((InterfaceC0964l) obj).m2112a()) {
                return obj;
            }
            Object obj2 = map != null ? map.get(obj) : null;
            if (obj2 != null) {
                return obj2;
            }
            InterfaceC0963k interfaceC0963k = (InterfaceC0963k) this.f2417e.get(obj.getClass());
            Object objMo2111a = interfaceC0963k != null ? interfaceC0963k.mo2111a(obj, this.f2424l, map) : null;
            if (objMo2111a != null) {
                if (map != null) {
                    map.put(obj, objMo2111a);
                }
                return objMo2111a;
            }
            if (cls.isArray()) {
                Class<?> cls2 = obj.getClass();
                int length2 = Array.getLength(obj);
                Object objNewInstance = Array.newInstance(cls2.getComponentType(), length2);
                if (map != null) {
                    map.put(obj, objNewInstance);
                }
                for (int i2 = 0; i2 < length2; i2++) {
                    Object objM2107a = Array.get(obj, i2);
                    if (map != null) {
                        objM2107a = m2107a(objM2107a, map);
                    }
                    Array.set(objNewInstance, i2, objM2107a);
                }
                return objNewInstance;
            }
            Object objMo2113a = this.f2413a.mo2113a(cls);
            if (map != null) {
                map.put(obj, objMo2113a);
            }
            for (Field field : m2102a((Class) cls)) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    Object objM2107a2 = field.get(obj);
                    boolean z = (this.f2423k || !(this.f2423k || field.isSynthetic())) && (this.f2426n || !(this.f2426n || "this$0".equals(field.getName())));
                    if (map != null && z) {
                        objM2107a2 = m2107a(objM2107a2, map);
                    }
                    field.set(objMo2113a, objM2107a2);
                }
            }
            return objMo2113a;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final void m2108a(Class... clsArr) {
        for (int i = 0; i < 4; i++) {
            this.f2414b.add(clsArr[i]);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m2109b(Class... clsArr) {
        for (int i = 0; i <= 0; i++) {
            this.f2415c.add(clsArr[0]);
        }
    }
}
