package org.p088jf.baksmali;

import java.util.HashMap;
import java.util.Map;
import org.p088jf.dexlib2.analysis.ClassPath;
import org.p088jf.dexlib2.analysis.InlineMethodResolver;
import org.p088jf.dexlib2.util.SyntheticAccessorResolver;

/* JADX INFO: loaded from: classes.dex */
public class BaksmaliOptions {
    public ClassPath classPath;
    public InlineMethodResolver inlineResolver;
    public SyntheticAccessorResolver syntheticAccessorResolver;
    public int apiLevel = 15;
    public boolean parameterRegisters = true;
    public boolean localsDirective = false;
    public boolean sequentialLabels = false;
    public boolean debugInfo = true;
    public boolean codeOffsets = false;
    public boolean accessorComments = true;
    public boolean allowOdex = false;
    public boolean deodex = false;
    public boolean implicitReferences = false;
    public boolean normalizeVirtualMethods = false;
    public int registerInfo = 0;
    public Map<Integer, String> resourceIds = new HashMap();
}
