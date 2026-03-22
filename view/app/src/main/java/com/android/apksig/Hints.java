package com.android.apksig;

import android.annotation.TargetApi;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class Hints {

    public static final class ByteRange {
        public final long end;
        public final long start;

        public ByteRange(long j, long j2) {
            this.start = j;
            this.end = j2;
        }
    }

    public static final class PatternWithRange {
        public final long offset;
        public final Pattern pattern;
        public final long size;

        public PatternWithRange(String str) {
            this.pattern = Pattern.compile(str);
            this.offset = 0L;
            this.size = Long.MAX_VALUE;
        }

        public PatternWithRange(String str, long j, long j2) {
            this.pattern = Pattern.compile(str);
            this.offset = j;
            this.size = j2;
        }

        public ByteRange ClampToAbsoluteByteRange(ByteRange byteRange) {
            long j = byteRange.end;
            long j2 = byteRange.start;
            long j3 = j - j2;
            long j4 = this.offset;
            if (j3 < j4) {
                return null;
            }
            long j5 = j2 + j4;
            return new ByteRange(j5, Math.min(j - j5, this.size) + j5);
        }

        public Matcher matcher(CharSequence charSequence) {
            return this.pattern.matcher(charSequence);
        }
    }

    public static int clampToInt(long j) {
        return (int) Math.max(0L, Math.min(j, 2147483647L));
    }

    @TargetApi(19)
    public static byte[] encodeByteRangeList(List<ByteRange> list) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(list.size() * 8);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            for (ByteRange byteRange : list) {
                dataOutputStream.writeInt(clampToInt(byteRange.start));
                dataOutputStream.writeInt(clampToInt(byteRange.end - byteRange.start));
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            AssertionError assertionError = new AssertionError("impossible");
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public static ArrayList<PatternWithRange> parsePinPatterns(byte[] bArr) {
        ArrayList<PatternWithRange> arrayList = new ArrayList<>();
        try {
            for (String str : new String(bArr, "UTF-8").split("\n")) {
                String strReplaceFirst = str.replaceFirst("#.*", "");
                String[] strArrSplit = strReplaceFirst.split(" ");
                if (strArrSplit.length == 1) {
                    arrayList.add(new PatternWithRange(strArrSplit[0]));
                } else {
                    if (strArrSplit.length != 3) {
                        throw new AssertionError("bad pin pattern line " + strReplaceFirst);
                    }
                    long j = Long.parseLong(strArrSplit[1]);
                    arrayList.add(new PatternWithRange(strArrSplit[0], j, Long.parseLong(strArrSplit[2]) - j));
                }
            }
            return arrayList;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 must be supported", e);
        }
    }
}
