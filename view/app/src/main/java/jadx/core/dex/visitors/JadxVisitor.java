package jadx.core.dex.visitors;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JadxVisitor {
    String desc() default "";

    String name();

    Class[] runAfter() default {};

    Class[] runBefore() default {};
}
