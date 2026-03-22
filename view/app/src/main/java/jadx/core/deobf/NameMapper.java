package jadx.core.deobf;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class NameMapper {
    private static final Pattern VALID_JAVA_IDENTIFIER = Pattern.compile("\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*");
    private static final Pattern VALID_JAVA_FULL_IDENTIFIER = Pattern.compile("(" + VALID_JAVA_IDENTIFIER + "\\.)*" + VALID_JAVA_IDENTIFIER);
    private static final Set RESERVED_NAMES = new HashSet(Arrays.asList("abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "false", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while"));

    public static boolean isAllCharsPrintable(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!isPrintableChar(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrintableChar(int i) {
        return 32 <= i && i <= 126;
    }

    public static boolean isReserved(String str) {
        return RESERVED_NAMES.contains(str);
    }

    public static boolean isValidFullIdentifier(String str) {
        return VALID_JAVA_FULL_IDENTIFIER.matcher(str).matches() && isAllCharsPrintable(str);
    }

    public static boolean isValidIdentifier(String str) {
        return VALID_JAVA_IDENTIFIER.matcher(str).matches() && isAllCharsPrintable(str);
    }
}
