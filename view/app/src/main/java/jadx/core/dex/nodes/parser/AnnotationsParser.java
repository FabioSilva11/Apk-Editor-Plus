package jadx.core.dex.nodes.parser;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.C0416o;
import jadx.core.dex.attributes.annotations.Annotation;
import jadx.core.dex.attributes.annotations.AnnotationsList;
import jadx.core.dex.attributes.annotations.MethodParameters;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.DexNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.utils.exceptions.DecodeException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class AnnotationsParser {
    private static final Annotation.Visibility[] VISIBILITIES = {Annotation.Visibility.BUILD, Annotation.Visibility.RUNTIME, Annotation.Visibility.SYSTEM};
    private final ClassNode cls;
    private final DexNode dex;

    public AnnotationsParser(ClassNode classNode) {
        this.cls = classNode;
        this.dex = classNode.dex();
    }

    public static Annotation readAnnotation(DexNode dexNode, C0416o c0416o, boolean z) throws DecodeException {
        EncValueParser encValueParser = new EncValueParser(dexNode, c0416o);
        Annotation.Visibility visibility = z ? VISIBILITIES[c0416o.mo306d()] : null;
        int iM2232b = C0985a.m2232b(c0416o);
        int iM2232b2 = C0985a.m2232b(c0416o);
        LinkedHashMap linkedHashMap = new LinkedHashMap(iM2232b2);
        for (int i = 0; i < iM2232b2; i++) {
            linkedHashMap.put(dexNode.getString(C0985a.m2232b(c0416o)), encValueParser.parseValue());
        }
        ArgType type = dexNode.getType(iM2232b);
        Annotation annotation = new Annotation(visibility, type, linkedHashMap);
        if (type.isObject()) {
            return annotation;
        }
        throw new DecodeException("Incorrect type for annotation: " + annotation);
    }

    private AnnotationsList readAnnotationSet(int i) {
        C0416o c0416oOpenSection;
        int iM385b;
        if (i != 0 && (iM385b = (c0416oOpenSection = this.dex.openSection(i)).m385b()) != 0) {
            ArrayList arrayList = new ArrayList(iM385b);
            for (int i2 = 0; i2 < iM385b; i2++) {
                arrayList.add(readAnnotation(this.dex, this.dex.openSection(c0416oOpenSection.m385b()), true));
            }
            return new AnnotationsList(arrayList);
        }
        return AnnotationsList.EMPTY;
    }

    public void parse(int i) {
        C0416o c0416oOpenSection = this.dex.openSection(i);
        int iM385b = c0416oOpenSection.m385b();
        int iM385b2 = c0416oOpenSection.m385b();
        int iM385b3 = c0416oOpenSection.m385b();
        int iM385b4 = c0416oOpenSection.m385b();
        if (iM385b != 0) {
            this.cls.addAttr(readAnnotationSet(iM385b));
        }
        for (int i2 = 0; i2 < iM385b2; i2++) {
            this.cls.searchFieldById(c0416oOpenSection.m385b()).addAttr(readAnnotationSet(c0416oOpenSection.m385b()));
        }
        for (int i3 = 0; i3 < iM385b3; i3++) {
            this.cls.searchMethodById(c0416oOpenSection.m385b()).addAttr(readAnnotationSet(c0416oOpenSection.m385b()));
        }
        for (int i4 = 0; i4 < iM385b4; i4++) {
            MethodNode methodNodeSearchMethodById = this.cls.searchMethodById(c0416oOpenSection.m385b());
            C0416o c0416oOpenSection2 = this.dex.openSection(c0416oOpenSection.m385b());
            int iM385b5 = c0416oOpenSection2.m385b();
            MethodParameters methodParameters = new MethodParameters(iM385b5);
            for (int i5 = 0; i5 < iM385b5; i5++) {
                methodParameters.getParamList().add(readAnnotationSet(c0416oOpenSection2.m385b()));
            }
            methodNodeSearchMethodById.addAttr(methodParameters);
        }
    }
}
