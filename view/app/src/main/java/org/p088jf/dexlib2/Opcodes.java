package org.p088jf.dexlib2;

import com.google.common.collect.Maps;
import java.util.EnumMap;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Opcodes {
    public final int api;
    public final int artVersion;
    public final EnumMap<Opcode, Short> opcodeValues;
    public final HashMap<String, Opcode> opcodesByName;
    public final Opcode[] opcodesByValue = new Opcode[256];

    public Opcodes(int i, int i2) {
        if (i >= 21) {
            this.api = i;
            this.artVersion = VersionMap.mapApiToArtVersion(i);
        } else if (i2 < 0 || i2 >= 39) {
            this.api = i;
            this.artVersion = i2;
        } else {
            this.api = VersionMap.mapArtVersionToApi(i2);
            this.artVersion = i2;
        }
        this.opcodeValues = new EnumMap<>(Opcode.class);
        this.opcodesByName = Maps.newHashMap();
        int i3 = isArt() ? this.artVersion : this.api;
        for (Opcode opcode : Opcode.values()) {
            Short sh = (isArt() ? opcode.artVersionToValueMap : opcode.apiToValueMap).get(Integer.valueOf(i3));
            if (sh != null) {
                if (!opcode.format.isPayloadFormat) {
                    this.opcodesByValue[sh.shortValue()] = opcode;
                }
                this.opcodeValues.put(opcode, sh);
                this.opcodesByName.put(opcode.name.toLowerCase(), opcode);
            }
        }
    }

    public static Opcodes forApi(int i) {
        return new Opcodes(i, -1);
    }

    public static Opcodes forArtVersion(int i) {
        return new Opcodes(-1, i);
    }

    public static Opcodes forDexVersion(int i) {
        int iMapDexVersionToApi = VersionMap.mapDexVersionToApi(i);
        if (iMapDexVersionToApi != -1) {
            return new Opcodes(iMapDexVersionToApi, -1);
        }
        throw new RuntimeException("Unsupported dex version " + i);
    }

    public Opcode getOpcodeByName(String str) {
        return this.opcodesByName.get(str.toLowerCase());
    }

    public Opcode getOpcodeByValue(int i) {
        if (i == 256) {
            return Opcode.PACKED_SWITCH_PAYLOAD;
        }
        if (i == 512) {
            return Opcode.SPARSE_SWITCH_PAYLOAD;
        }
        if (i == 768) {
            return Opcode.ARRAY_PAYLOAD;
        }
        if (i < 0) {
            return null;
        }
        Opcode[] opcodeArr = this.opcodesByValue;
        if (i < opcodeArr.length) {
            return opcodeArr[i];
        }
        return null;
    }

    public Short getOpcodeValue(Opcode opcode) {
        return this.opcodeValues.get(opcode);
    }

    public boolean isArt() {
        return this.artVersion != -1;
    }
}
