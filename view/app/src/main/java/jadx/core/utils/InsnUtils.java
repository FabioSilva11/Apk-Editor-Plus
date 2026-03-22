package jadx.core.utils;

import com.p016a.p019b.p033d.p034a.AbstractC0692f;
import jadx.core.dex.attributes.AType;
import jadx.core.dex.info.FieldInfo;
import jadx.core.dex.instructions.ConstClassNode;
import jadx.core.dex.instructions.ConstStringNode;
import jadx.core.dex.instructions.IndexInsnNode;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.nodes.DexNode;
import jadx.core.dex.nodes.FieldNode;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.parser.FieldInitAttr;
import jadx.core.utils.exceptions.JadxRuntimeException;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
public class InsnUtils {
    private static final InterfaceC1668b LOG = C1677c.m3845a(InsnUtils.class);

    private InsnUtils() {
    }

    public static String formatOffset(int i) {
        return i < 0 ? "?" : String.format("0x%04x", Integer.valueOf(i));
    }

    public static int getArg(AbstractC0692f abstractC0692f, int i) {
        switch (i) {
            case 0:
                return abstractC0692f.mo1265n();
            case 1:
                return abstractC0692f.mo1284o();
            case 2:
                return abstractC0692f.mo1285p();
            case 3:
                return abstractC0692f.mo1308q();
            case 4:
                return abstractC0692f.mo1309r();
            default:
                throw new JadxRuntimeException("Wrong argument number: " + i);
        }
    }

    public static Object getConstValueByInsn(DexNode dexNode, InsnNode insnNode) {
        switch (insnNode.getType()) {
            case CONST:
                return insnNode.getArg(0);
            case CONST_STR:
                return ((ConstStringNode) insnNode).getString();
            case CONST_CLASS:
                return ((ConstClassNode) insnNode).getClsType();
            case SGET:
                FieldInfo fieldInfo = (FieldInfo) ((IndexInsnNode) insnNode).getIndex();
                FieldNode fieldNodeResolveField = dexNode.resolveField(fieldInfo);
                if (fieldNodeResolveField == null) {
                    LOG.mo3821b("Field {} not found in dex {}", fieldInfo, dexNode);
                    break;
                } else {
                    FieldInitAttr fieldInitAttr = (FieldInitAttr) fieldNodeResolveField.get(AType.FIELD_INIT);
                    if (fieldInitAttr != null) {
                        return fieldInitAttr.getValue();
                    }
                }
            default:
                return null;
        }
    }

    public static String indexToString(Object obj) {
        return obj == null ? "" : obj instanceof String ? "\"" + obj + "\"" : obj.toString();
    }

    public static String insnTypeToString(InsnType insnType) {
        return insnType.toString() + "  ";
    }
}
