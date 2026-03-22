package org.p088jf.dexlib2;

import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public enum HiddenApiRestriction {
    WHITELIST(0, "whitelist", false),
    GREYLIST(1, "greylist", false),
    BLACKLIST(2, "blacklist", false),
    GREYLIST_MAX_O(3, "greylist-max-o", false),
    GREYLIST_MAX_P(4, "greylist-max-p", false),
    GREYLIST_MAX_Q(5, "greylist-max-q", false),
    CORE_PLATFORM_API(8, "core-platform-api", true),
    TEST_API(16, "test-api", true);

    public static final HiddenApiRestriction[] domainSpecificApiFlags;
    public static final HiddenApiRestriction[] hiddenApiFlags;
    public static final Map<String, HiddenApiRestriction> hiddenApiRestrictionsByName;
    public final boolean isDomainSpecificApiFlag;
    public final String name;
    public final int value;

    static {
        HiddenApiRestriction hiddenApiRestriction = WHITELIST;
        HiddenApiRestriction hiddenApiRestriction2 = GREYLIST;
        HiddenApiRestriction hiddenApiRestriction3 = BLACKLIST;
        HiddenApiRestriction hiddenApiRestriction4 = GREYLIST_MAX_O;
        HiddenApiRestriction hiddenApiRestriction5 = GREYLIST_MAX_P;
        HiddenApiRestriction hiddenApiRestriction6 = GREYLIST_MAX_Q;
        HiddenApiRestriction hiddenApiRestriction7 = CORE_PLATFORM_API;
        HiddenApiRestriction hiddenApiRestriction8 = TEST_API;
        hiddenApiFlags = new HiddenApiRestriction[]{hiddenApiRestriction, hiddenApiRestriction2, hiddenApiRestriction3, hiddenApiRestriction4, hiddenApiRestriction5, hiddenApiRestriction6};
        domainSpecificApiFlags = new HiddenApiRestriction[]{hiddenApiRestriction7, hiddenApiRestriction8};
        hiddenApiRestrictionsByName = new HashMap();
        for (HiddenApiRestriction hiddenApiRestriction9 : values()) {
            hiddenApiRestrictionsByName.put(hiddenApiRestriction9.toString(), hiddenApiRestriction9);
        }
    }

    HiddenApiRestriction(int i, String str, boolean z) {
        this.value = i;
        this.name = str;
        this.isDomainSpecificApiFlag = z;
    }

    public static int combineFlags(Iterable<HiddenApiRestriction> iterable) {
        int i;
        int i2 = 0;
        boolean z = false;
        for (HiddenApiRestriction hiddenApiRestriction : iterable) {
            if (hiddenApiRestriction.isDomainSpecificApiFlag) {
                i = hiddenApiRestriction.value;
            } else {
                if (z) {
                    throw new IllegalArgumentException("Cannot combine multiple flags for hidden api restrictions");
                }
                z = true;
                i = hiddenApiRestriction.value;
            }
            i2 += i;
        }
        return i2;
    }

    public static HiddenApiRestriction forName(String str) {
        return hiddenApiRestrictionsByName.get(str);
    }

    public static Set<HiddenApiRestriction> getAllFlags(int i) {
        HiddenApiRestriction hiddenApiRestriction = hiddenApiFlags[i & 7];
        if ((i & (-8)) == 0) {
            return ImmutableSet.m3783of(hiddenApiRestriction);
        }
        ImmutableSet.Builder builder = ImmutableSet.builder();
        builder.add(hiddenApiRestriction);
        for (HiddenApiRestriction hiddenApiRestriction2 : domainSpecificApiFlags) {
            if (hiddenApiRestriction2.isSet(i)) {
                builder.add(hiddenApiRestriction2);
            }
        }
        return builder.build();
    }

    public int getValue() {
        return this.value;
    }

    public boolean isDomainSpecificApiFlag() {
        return this.isDomainSpecificApiFlag;
    }

    public boolean isSet(int i) {
        return this.isDomainSpecificApiFlag ? (i & this.value) != 0 : (i & 7) == this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
