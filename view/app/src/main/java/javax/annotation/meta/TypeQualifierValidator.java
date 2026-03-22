package javax.annotation.meta;

import java.lang.annotation.Annotation;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes.dex */
public interface TypeQualifierValidator {
    @Nonnull
    When forConstantValue(@Nonnull Annotation annotation, Object obj);
}
