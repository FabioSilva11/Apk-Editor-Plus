package jadx.core;

import jadx.api.IJadxArgs;
import jadx.core.dex.visitors.ClassModifier;
import jadx.core.dex.visitors.CodeShrinker;
import jadx.core.dex.visitors.ConstInlineVisitor;
import jadx.core.dex.visitors.DebugInfoVisitor;
import jadx.core.dex.visitors.DependencyCollector;
import jadx.core.dex.visitors.DotGraphVisitor;
import jadx.core.dex.visitors.EnumVisitor;
import jadx.core.dex.visitors.ExtractFieldInit;
import jadx.core.dex.visitors.FallbackModeVisitor;
import jadx.core.dex.visitors.MethodInlineVisitor;
import jadx.core.dex.visitors.ModVisitor;
import jadx.core.dex.visitors.PrepareForCodeGen;
import jadx.core.dex.visitors.ReSugarCode;
import jadx.core.dex.visitors.RenameVisitor;
import jadx.core.dex.visitors.SimplifyVisitor;
import jadx.core.dex.visitors.blocksmaker.BlockExceptionHandler;
import jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract;
import jadx.core.dex.visitors.blocksmaker.BlockFinish;
import jadx.core.dex.visitors.blocksmaker.BlockProcessor;
import jadx.core.dex.visitors.blocksmaker.BlockSplitter;
import jadx.core.dex.visitors.regions.CheckRegions;
import jadx.core.dex.visitors.regions.IfRegionVisitor;
import jadx.core.dex.visitors.regions.LoopRegionVisitor;
import jadx.core.dex.visitors.regions.ProcessVariables;
import jadx.core.dex.visitors.regions.RegionMakerVisitor;
import jadx.core.dex.visitors.regions.ReturnVisitor;
import jadx.core.dex.visitors.ssa.EliminatePhiNodes;
import jadx.core.dex.visitors.ssa.SSATransform;
import jadx.core.dex.visitors.typeinference.FinishTypeInference;
import jadx.core.dex.visitors.typeinference.TypeInference;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.Manifest;

/* JADX INFO: loaded from: classes.dex */
public class Jadx {
    public static List getPassesList(IJadxArgs iJadxArgs, File file) {
        ArrayList arrayList = new ArrayList();
        if (iJadxArgs.isFallbackMode()) {
            arrayList.add(new FallbackModeVisitor());
        } else {
            arrayList.add(new BlockSplitter());
            arrayList.add(new BlockProcessor());
            arrayList.add(new BlockExceptionHandler());
            arrayList.add(new BlockFinallyExtract());
            arrayList.add(new BlockFinish());
            arrayList.add(new SSATransform());
            arrayList.add(new DebugInfoVisitor());
            arrayList.add(new TypeInference());
            if (iJadxArgs.isRawCFGOutput()) {
                arrayList.add(DotGraphVisitor.dumpRaw(file));
            }
            arrayList.add(new ConstInlineVisitor());
            arrayList.add(new FinishTypeInference());
            arrayList.add(new EliminatePhiNodes());
            arrayList.add(new ModVisitor());
            arrayList.add(new CodeShrinker());
            arrayList.add(new ReSugarCode());
            if (iJadxArgs.isCFGOutput()) {
                arrayList.add(DotGraphVisitor.dump(file));
            }
            arrayList.add(new RegionMakerVisitor());
            arrayList.add(new IfRegionVisitor());
            arrayList.add(new ReturnVisitor());
            arrayList.add(new CodeShrinker());
            arrayList.add(new SimplifyVisitor());
            arrayList.add(new CheckRegions());
            if (iJadxArgs.isCFGOutput()) {
                arrayList.add(DotGraphVisitor.dumpRegions(file));
            }
            arrayList.add(new MethodInlineVisitor());
            arrayList.add(new ExtractFieldInit());
            arrayList.add(new ClassModifier());
            arrayList.add(new EnumVisitor());
            arrayList.add(new PrepareForCodeGen());
            arrayList.add(new LoopRegionVisitor());
            arrayList.add(new ProcessVariables());
            arrayList.add(new DependencyCollector());
            arrayList.add(new RenameVisitor());
        }
        return arrayList;
    }

    public static String getVersion() {
        try {
            ClassLoader classLoader = Jadx.class.getClassLoader();
            if (classLoader != null) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/MANIFEST.MF");
                while (resources.hasMoreElements()) {
                    String value = new Manifest(resources.nextElement().openStream()).getMainAttributes().getValue("jadx-version");
                    if (value != null) {
                        return value;
                    }
                }
            }
        } catch (Exception e) {
        }
        return "dev";
    }
}
