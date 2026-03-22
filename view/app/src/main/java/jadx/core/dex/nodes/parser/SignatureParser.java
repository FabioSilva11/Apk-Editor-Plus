package jadx.core.dex.nodes.parser;

import android.support.v7.appcompat.C0299R;
import jadx.core.Consts;
import jadx.core.dex.attributes.IAttributeNode;
import jadx.core.dex.attributes.annotations.Annotation;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.utils.exceptions.JadxRuntimeException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
public class SignatureParser {
    private static final InterfaceC1668b LOG = C1677c.m3845a(SignatureParser.class);
    private static final char STOP_CHAR = 0;
    private final int end;
    private final String sign;
    private int pos = -1;
    private int mark = 0;

    public SignatureParser(String str) {
        this.sign = str;
        this.end = this.sign.length();
    }

    private void consume(char c) {
        char next = next();
        if (c != next) {
            throw new JadxRuntimeException("Consume wrong char: '" + next + "' != '" + c + "', sign: " + debugString());
        }
    }

    private List consumeExtendsTypesList() {
        boolean zLookAhead;
        List listEmptyList = Collections.emptyList();
        do {
            ArgType argTypeConsumeType = consumeType();
            if (!argTypeConsumeType.equals(ArgType.OBJECT)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new LinkedList();
                }
                listEmptyList.add(argTypeConsumeType);
            }
            zLookAhead = lookAhead(':');
            if (zLookAhead) {
                consume(':');
            }
        } while (zLookAhead);
        return listEmptyList;
    }

    private ArgType[] consumeGenericArgs() {
        ArgType argTypeConsumeType;
        LinkedList linkedList = new LinkedList();
        do {
            if (lookAhead('*')) {
                next();
                argTypeConsumeType = ArgType.wildcard();
            } else if (lookAhead('+')) {
                next();
                argTypeConsumeType = ArgType.wildcard(consumeType(), 1);
            } else if (lookAhead('-')) {
                next();
                argTypeConsumeType = ArgType.wildcard(consumeType(), -1);
            } else {
                argTypeConsumeType = consumeType();
            }
            if (argTypeConsumeType != null) {
                linkedList.add(argTypeConsumeType);
            }
            if (argTypeConsumeType == null) {
                break;
            }
        } while (!lookAhead('>'));
        return (ArgType[]) linkedList.toArray(new ArgType[linkedList.size()]);
    }

    private ArgType consumeObjectType(boolean z) {
        char next;
        mark();
        do {
            next = next();
            if (next != 0) {
                if (next == '<') {
                    break;
                }
            } else {
                return null;
            }
        } while (next != ';');
        if (next == ';') {
            return ArgType.object(z ? slice().replace('/', '.') : inclusiveSlice());
        }
        String strSlice = slice();
        if (!z) {
            strSlice = strSlice + ";";
        }
        ArgType[] argTypeArrConsumeGenericArgs = consumeGenericArgs();
        consume('>');
        ArgType argTypeGeneric = ArgType.generic(strSlice, argTypeArrConsumeGenericArgs);
        if (!lookAhead('.')) {
            consume(';');
            return argTypeGeneric;
        }
        consume('.');
        next();
        ArgType argTypeConsumeObjectType = consumeObjectType(true);
        return ArgType.genericInner(argTypeGeneric, argTypeConsumeObjectType.getObject(), argTypeConsumeObjectType.getGenericTypes());
    }

    private String consumeUntil(char c) {
        mark();
        if (forwardTo(c)) {
            return slice();
        }
        return null;
    }

    private String debugString() {
        return this.sign + " at position " + this.pos + " ('" + this.sign.charAt(this.pos) + "')";
    }

    private boolean forwardTo(char c) {
        char next;
        int i = this.pos;
        do {
            next = next();
            if (next == 0) {
                this.pos = i;
                return false;
            }
        } while (next != c);
        return true;
    }

    public static SignatureParser fromNode(IAttributeNode iAttributeNode) {
        Annotation annotation = iAttributeNode.getAnnotation(Consts.DALVIK_SIGNATURE);
        if (annotation == null) {
            return null;
        }
        return new SignatureParser(mergeSignature((List) annotation.getDefaultValue()));
    }

    private String inclusiveSlice() {
        return this.mark >= this.pos ? "" : this.sign.substring(this.mark, this.pos + 1);
    }

    private boolean lookAhead(char c) {
        int i = this.pos + 1;
        return i < this.end && this.sign.charAt(i) == c;
    }

    private void mark() {
        this.mark = this.pos;
    }

    private static String mergeSignature(List list) {
        if (list.size() == 1) {
            return (String) list.get(0);
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        return sb.toString();
    }

    private char next() {
        this.pos++;
        if (this.pos >= this.end) {
            return (char) 0;
        }
        return this.sign.charAt(this.pos);
    }

    private String slice() {
        return this.mark >= this.pos ? "" : this.sign.substring(this.mark, this.pos);
    }

    private boolean tryConsume(char c) {
        if (!lookAhead(c)) {
            return false;
        }
        next();
        return true;
    }

    public Map consumeGenericMap() {
        if (!lookAhead('<')) {
            return Collections.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(2);
        consume('<');
        while (!lookAhead('>') && next() != 0) {
            String strConsumeUntil = consumeUntil(':');
            if (strConsumeUntil == null) {
                LOG.mo3827d("Can't parse generic map: {}", this.sign);
                return Collections.emptyMap();
            }
            tryConsume(':');
            linkedHashMap.put(ArgType.genericType(strConsumeUntil), consumeExtendsTypesList());
        }
        consume('>');
        return linkedHashMap;
    }

    public List consumeMethodArgs() {
        consume('(');
        if (lookAhead(')')) {
            consume(')');
            return Collections.emptyList();
        }
        LinkedList linkedList = new LinkedList();
        do {
            linkedList.add(consumeType());
        } while (!lookAhead(')'));
        consume(')');
        return linkedList;
    }

    public ArgType consumeType() {
        char next = next();
        mark();
        switch (next) {
            case 0:
                return null;
            case C0299R.styleable.AppCompatTheme_dropDownListViewStyle /* 76 */:
                ArgType argTypeConsumeObjectType = consumeObjectType(false);
                if (argTypeConsumeObjectType != null) {
                    return argTypeConsumeObjectType;
                }
                break;
            case C0299R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /* 84 */:
                next();
                mark();
                if (forwardTo(';')) {
                    return ArgType.genericType(slice());
                }
                break;
            case C0299R.styleable.AppCompatTheme_colorButtonNormal /* 91 */:
                return ArgType.array(consumeType());
            default:
                ArgType argType = ArgType.parse(next);
                if (argType != null) {
                    return argType;
                }
                break;
        }
        throw new JadxRuntimeException("Can't parse type: " + debugString());
    }

    public String toString() {
        return this.pos == -1 ? this.sign : this.sign.substring(0, this.mark) + '{' + this.sign.substring(this.mark, this.pos) + '}' + this.sign.substring(this.pos);
    }
}
