package jadx.core.dex.instructions.args;

import android.support.v7.appcompat.C0299R;
import jadx.core.Consts;
import jadx.core.deobf.Deobfuscator;
import jadx.core.dex.nodes.DexNode;
import jadx.core.dex.nodes.parser.SignatureParser;
import jadx.core.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class ArgType {
    protected int hash;
    public static final ArgType INT = primitive(PrimitiveType.INT);
    public static final ArgType BOOLEAN = primitive(PrimitiveType.BOOLEAN);
    public static final ArgType BYTE = primitive(PrimitiveType.BYTE);
    public static final ArgType SHORT = primitive(PrimitiveType.SHORT);
    public static final ArgType CHAR = primitive(PrimitiveType.CHAR);
    public static final ArgType FLOAT = primitive(PrimitiveType.FLOAT);
    public static final ArgType DOUBLE = primitive(PrimitiveType.DOUBLE);
    public static final ArgType LONG = primitive(PrimitiveType.LONG);
    public static final ArgType VOID = primitive(PrimitiveType.VOID);
    public static final ArgType OBJECT = object(Consts.CLASS_OBJECT);
    public static final ArgType CLASS = object(Consts.CLASS_CLASS);
    public static final ArgType STRING = object(Consts.CLASS_STRING);
    public static final ArgType ENUM = object(Consts.CLASS_ENUM);
    public static final ArgType THROWABLE = object(Consts.CLASS_THROWABLE);
    public static final ArgType UNKNOWN = unknown(PrimitiveType.values());
    public static final ArgType UNKNOWN_OBJECT = unknown(PrimitiveType.OBJECT, PrimitiveType.ARRAY);
    public static final ArgType NARROW = unknown(PrimitiveType.INT, PrimitiveType.FLOAT, PrimitiveType.BOOLEAN, PrimitiveType.SHORT, PrimitiveType.BYTE, PrimitiveType.CHAR, PrimitiveType.OBJECT, PrimitiveType.ARRAY);
    public static final ArgType NARROW_NUMBERS = unknown(PrimitiveType.INT, PrimitiveType.FLOAT, PrimitiveType.BOOLEAN, PrimitiveType.SHORT, PrimitiveType.BYTE, PrimitiveType.CHAR);
    public static final ArgType WIDE = unknown(PrimitiveType.LONG, PrimitiveType.DOUBLE);

    final class ArrayArg extends KnownType {
        public static final PrimitiveType[] ARRAY_POSSIBLES = {PrimitiveType.ARRAY};
        private final ArgType arrayElement;

        public ArrayArg(ArgType argType) {
            super();
            this.arrayElement = argType;
            this.hash = argType.hashCode();
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final int getArrayDimension() {
            return this.arrayElement.getArrayDimension() + 1;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final ArgType getArrayElement() {
            return this.arrayElement;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final ArgType getArrayRootElement() {
            return this.arrayElement.getArrayRootElement();
        }

        @Override // jadx.core.dex.instructions.args.ArgType.KnownType, jadx.core.dex.instructions.args.ArgType
        public final PrimitiveType[] getPossibleTypes() {
            return ARRAY_POSSIBLES;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final PrimitiveType getPrimitiveType() {
            return PrimitiveType.ARRAY;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        final boolean internalEquals(Object obj) {
            return this.arrayElement.equals(((ArrayArg) obj).arrayElement);
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final boolean isArray() {
            return true;
        }

        @Override // jadx.core.dex.instructions.args.ArgType.KnownType, jadx.core.dex.instructions.args.ArgType
        public final boolean isTypeKnown() {
            return this.arrayElement.isTypeKnown();
        }

        @Override // jadx.core.dex.instructions.args.ArgType.KnownType, jadx.core.dex.instructions.args.ArgType
        public final ArgType selectFirst() {
            return array(this.arrayElement.selectFirst());
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final String toString() {
            return this.arrayElement + "[]";
        }
    }

    class GenericObject extends ObjectType {
        private final ArgType[] generics;
        private final GenericObject outerType;

        public GenericObject(GenericObject genericObject, String str, ArgType[] argTypeArr) {
            super(genericObject.getObject() + Deobfuscator.INNER_CLASS_SEPARATOR + str);
            this.outerType = genericObject;
            this.generics = argTypeArr;
            this.hash = genericObject.hashCode() + (str.hashCode() * 31) + (Arrays.hashCode(argTypeArr) * 961);
        }

        public GenericObject(String str, ArgType[] argTypeArr) {
            super(str);
            this.outerType = null;
            this.generics = argTypeArr;
            this.hash = str.hashCode() + (Arrays.hashCode(argTypeArr) * 31);
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public ArgType[] getGenericTypes() {
            return this.generics;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public ArgType getOuterType() {
            return this.outerType;
        }

        @Override // jadx.core.dex.instructions.args.ArgType.ObjectType, jadx.core.dex.instructions.args.ArgType
        boolean internalEquals(Object obj) {
            return super.internalEquals(obj) && Arrays.equals(this.generics, ((GenericObject) obj).generics);
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public boolean isGeneric() {
            return true;
        }

        @Override // jadx.core.dex.instructions.args.ArgType.ObjectType, jadx.core.dex.instructions.args.ArgType
        public String toString() {
            return super.toString() + "<" + Utils.arrayToString(this.generics) + ">";
        }
    }

    final class GenericType extends ObjectType {
        public GenericType(String str) {
            super(str);
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final boolean isGenericType() {
            return true;
        }
    }

    abstract class KnownType extends ArgType {
        private static final PrimitiveType[] EMPTY_POSSIBLES = new PrimitiveType[0];

        private KnownType() {
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public boolean contains(PrimitiveType primitiveType) {
            return getPrimitiveType() == primitiveType;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public PrimitiveType[] getPossibleTypes() {
            return EMPTY_POSSIBLES;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public boolean isTypeKnown() {
            return true;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public ArgType selectFirst() {
            return null;
        }
    }

    class ObjectType extends KnownType {
        private final String object;

        public ObjectType(String str) {
            super();
            this.object = Utils.cleanObjectName(str);
            this.hash = this.object.hashCode();
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public String getObject() {
            return this.object;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public PrimitiveType getPrimitiveType() {
            return PrimitiveType.OBJECT;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        boolean internalEquals(Object obj) {
            return this.object.equals(((ObjectType) obj).object);
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public boolean isObject() {
            return true;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public String toString() {
            return this.object;
        }
    }

    final class PrimitiveArg extends KnownType {
        private final PrimitiveType type;

        public PrimitiveArg(PrimitiveType primitiveType) {
            super();
            this.type = primitiveType;
            this.hash = primitiveType.hashCode();
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final PrimitiveType getPrimitiveType() {
            return this.type;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        final boolean internalEquals(Object obj) {
            return this.type == ((PrimitiveArg) obj).type;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final boolean isPrimitive() {
            return true;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final String toString() {
            return this.type.toString();
        }
    }

    final class UnknownArg extends ArgType {
        private final PrimitiveType[] possibleTypes;

        public UnknownArg(PrimitiveType[] primitiveTypeArr) {
            this.possibleTypes = primitiveTypeArr;
            this.hash = Arrays.hashCode(this.possibleTypes);
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final boolean contains(PrimitiveType primitiveType) {
            for (PrimitiveType primitiveType2 : this.possibleTypes) {
                if (primitiveType2 == primitiveType) {
                    return true;
                }
            }
            return false;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final PrimitiveType[] getPossibleTypes() {
            return this.possibleTypes;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        final boolean internalEquals(Object obj) {
            return Arrays.equals(this.possibleTypes, ((UnknownArg) obj).possibleTypes);
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final boolean isTypeKnown() {
            return false;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final ArgType selectFirst() {
            return contains(PrimitiveType.OBJECT) ? OBJECT : contains(PrimitiveType.ARRAY) ? array(OBJECT) : ArgType.primitive(this.possibleTypes[0]);
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final String toString() {
            return this.possibleTypes.length == PrimitiveType.values().length ? "?" : "?" + Arrays.toString(this.possibleTypes);
        }
    }

    final class WildcardType extends ObjectType {
        private final int bounds;
        private final ArgType type;

        public WildcardType(ArgType argType, int i) {
            super(OBJECT.getObject());
            this.type = argType;
            this.bounds = i;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final int getWildcardBounds() {
            return this.bounds;
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final ArgType getWildcardType() {
            return this.type;
        }

        @Override // jadx.core.dex.instructions.args.ArgType.ObjectType, jadx.core.dex.instructions.args.ArgType
        final boolean internalEquals(Object obj) {
            return super.internalEquals(obj) && this.bounds == ((WildcardType) obj).bounds && this.type.equals(((WildcardType) obj).type);
        }

        @Override // jadx.core.dex.instructions.args.ArgType
        public final boolean isGeneric() {
            return true;
        }

        @Override // jadx.core.dex.instructions.args.ArgType.ObjectType, jadx.core.dex.instructions.args.ArgType
        public final String toString() {
            if (this.bounds == 0) {
                return "?";
            }
            return "? " + (this.bounds == -1 ? "super" : "extends") + " " + this.type;
        }
    }

    public static ArgType array(ArgType argType) {
        return new ArrayArg(argType);
    }

    public static ArgType generic(String str) {
        return new SignatureParser(str).consumeType();
    }

    public static ArgType generic(String str, ArgType[] argTypeArr) {
        return new GenericObject(str, argTypeArr);
    }

    public static ArgType genericInner(ArgType argType, String str, ArgType[] argTypeArr) {
        return new GenericObject((GenericObject) argType, str, argTypeArr);
    }

    public static ArgType genericType(String str) {
        return new GenericType(str);
    }

    public static boolean isCastNeeded(DexNode dexNode, ArgType argType, ArgType argType2) {
        if (argType.equals(argType2)) {
            return false;
        }
        return (argType.isObject() && argType2.isObject() && dexNode.root().getClsp().isImplements(argType.getObject(), argType2.getObject())) ? false : true;
    }

    public static boolean isInstanceOf(DexNode dexNode, ArgType argType, ArgType argType2) {
        if (argType.equals(argType2)) {
            return true;
        }
        if (argType.isObject() && argType2.isObject()) {
            return dexNode.root().getClsp().isImplements(argType.getObject(), argType2.getObject());
        }
        return false;
    }

    public static ArgType merge(DexNode dexNode, ArgType argType, ArgType argType2) {
        if (argType == null || argType2 == null) {
            return null;
        }
        if (argType.equals(argType2)) {
            return argType;
        }
        ArgType argTypeMergeInternal = mergeInternal(dexNode, argType, argType2);
        if (argTypeMergeInternal == null) {
            argTypeMergeInternal = mergeInternal(dexNode, argType2, argType);
        }
        return argTypeMergeInternal;
    }

    private static ArgType mergeArrays(DexNode dexNode, ArrayArg arrayArg, ArgType argType) {
        if (!argType.isArray()) {
            if (argType.contains(PrimitiveType.ARRAY)) {
                return arrayArg;
            }
            if (argType.equals(OBJECT)) {
                return OBJECT;
            }
            return null;
        }
        ArgType arrayElement = arrayArg.getArrayElement();
        ArgType arrayElement2 = argType.getArrayElement();
        if (arrayElement.isPrimitive() && arrayElement2.isPrimitive()) {
            return OBJECT;
        }
        ArgType argTypeMerge = merge(dexNode, arrayElement, arrayElement2);
        if (argTypeMerge == null) {
            return null;
        }
        return array(argTypeMerge);
    }

    private static ArgType mergeInternal(DexNode dexNode, ArgType argType, ArgType argType2) {
        String commonAncestor;
        if (argType == UNKNOWN) {
            return argType2;
        }
        if (argType.isArray()) {
            return mergeArrays(dexNode, (ArrayArg) argType, argType2);
        }
        if (argType2.isArray()) {
            return mergeArrays(dexNode, (ArrayArg) argType2, argType);
        }
        if (!argType.isTypeKnown()) {
            if (argType2.isTypeKnown()) {
                if (argType.contains(argType2.getPrimitiveType())) {
                    return argType2;
                }
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (PrimitiveType primitiveType : argType.getPossibleTypes()) {
                if (argType2.contains(primitiveType)) {
                    arrayList.add(primitiveType);
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            if (arrayList.size() != 1) {
                return unknown((PrimitiveType[]) arrayList.toArray(new PrimitiveType[arrayList.size()]));
            }
            PrimitiveType primitiveType2 = (PrimitiveType) arrayList.get(0);
            return (primitiveType2 == PrimitiveType.OBJECT || primitiveType2 == PrimitiveType.ARRAY) ? unknown(primitiveType2) : primitive(primitiveType2);
        }
        if (argType.isGenericType()) {
            return argType;
        }
        if (argType2.isGenericType()) {
            return argType2;
        }
        if (!argType.isObject() || !argType2.isObject()) {
            if (argType.isPrimitive() && argType2.isPrimitive() && argType.getRegCount() == argType2.getRegCount()) {
                return primitive(PrimitiveType.getSmaller(argType.getPrimitiveType(), argType2.getPrimitiveType()));
            }
            return null;
        }
        String object = argType.getObject();
        String object2 = argType2.getObject();
        if (object.equals(object2)) {
            return argType.getGenericTypes() != null ? argType : argType2;
        }
        if (object.equals(Consts.CLASS_OBJECT)) {
            return argType2;
        }
        if (object2.equals(Consts.CLASS_OBJECT)) {
            return argType;
        }
        if (dexNode != null && (commonAncestor = dexNode.root().getClsp().getCommonAncestor(object, object2)) != null) {
            return object(commonAncestor);
        }
        return null;
    }

    public static ArgType object(String str) {
        return new ObjectType(str);
    }

    public static ArgType parse(char c) {
        switch (c) {
            case C0299R.styleable.AppCompatTheme_imageButtonStyle /* 66 */:
                return BYTE;
            case C0299R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /* 67 */:
                return CHAR;
            case C0299R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle /* 68 */:
                return DOUBLE;
            case C0299R.styleable.AppCompatTheme_searchViewStyle /* 70 */:
                return FLOAT;
            case C0299R.styleable.AppCompatTheme_listPreferredItemHeightLarge /* 73 */:
                return INT;
            case C0299R.styleable.AppCompatTheme_listPreferredItemPaddingLeft /* 74 */:
                return LONG;
            case C0299R.styleable.AppCompatTheme_panelMenuListTheme /* 83 */:
                return SHORT;
            case C0299R.styleable.AppCompatTheme_colorPrimaryDark /* 86 */:
                return VOID;
            case C0299R.styleable.AppCompatTheme_colorControlHighlight /* 90 */:
                return BOOLEAN;
            default:
                return null;
        }
    }

    public static ArgType parse(String str) {
        char cCharAt = str.charAt(0);
        switch (cCharAt) {
            case C0299R.styleable.AppCompatTheme_dropDownListViewStyle /* 76 */:
                return object(str);
            case C0299R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /* 84 */:
                return genericType(str.substring(1, str.length() - 1));
            case C0299R.styleable.AppCompatTheme_colorButtonNormal /* 91 */:
                return array(parse(str.substring(1)));
            default:
                return parse(cCharAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArgType primitive(PrimitiveType primitiveType) {
        return new PrimitiveArg(primitiveType);
    }

    public static ArgType unknown(PrimitiveType... primitiveTypeArr) {
        return new UnknownArg(primitiveTypeArr);
    }

    public static ArgType wildcard() {
        return new WildcardType(OBJECT, 0);
    }

    public static ArgType wildcard(ArgType argType, int i) {
        return new WildcardType(argType, i);
    }

    public abstract boolean contains(PrimitiveType primitiveType);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && this.hash == obj.hashCode() && getClass() == obj.getClass()) {
            return internalEquals(obj);
        }
        return false;
    }

    public int getArrayDimension() {
        return 0;
    }

    public ArgType getArrayElement() {
        return null;
    }

    public ArgType getArrayRootElement() {
        return this;
    }

    public ArgType[] getGenericTypes() {
        return null;
    }

    public String getObject() {
        throw new UnsupportedOperationException("ArgType.getObject(), call class: " + getClass());
    }

    public ArgType getOuterType() {
        return null;
    }

    public abstract PrimitiveType[] getPossibleTypes();

    public PrimitiveType getPrimitiveType() {
        return null;
    }

    public int getRegCount() {
        if (!isPrimitive()) {
            return !isTypeKnown() ? 0 : 1;
        }
        PrimitiveType primitiveType = getPrimitiveType();
        return (primitiveType == PrimitiveType.LONG || primitiveType == PrimitiveType.DOUBLE) ? 2 : 1;
    }

    public int getWildcardBounds() {
        return 0;
    }

    public ArgType getWildcardType() {
        return null;
    }

    public int hashCode() {
        return this.hash;
    }

    abstract boolean internalEquals(Object obj);

    public boolean isArray() {
        return false;
    }

    public boolean isGeneric() {
        return false;
    }

    public boolean isGenericType() {
        return false;
    }

    public boolean isObject() {
        return false;
    }

    public boolean isPrimitive() {
        return false;
    }

    public boolean isTypeKnown() {
        return false;
    }

    public abstract ArgType selectFirst();

    public String toString() {
        return "ARG_TYPE";
    }
}
