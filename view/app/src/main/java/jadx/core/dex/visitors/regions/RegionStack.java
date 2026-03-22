package jadx.core.dex.visitors.regions;

import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.utils.exceptions.JadxOverflowException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class RegionStack {
    private static final boolean DEBUG = false;
    private static final int REGIONS_STACK_LIMIT = 1000;
    private final Deque stack = new ArrayDeque();
    private State curState = new State();

    final class State {
        final Set exits;
        IRegion region;

        public State() {
            this.exits = new HashSet(4);
        }

        private State(State state) {
            this.exits = new HashSet(state.exits);
        }

        public final State copy() {
            return new State(this);
        }

        public final String toString() {
            return "Region: " + this.region + ", exits: " + this.exits;
        }
    }

    public RegionStack(MethodNode methodNode) {
    }

    public final void addExit(BlockNode blockNode) {
        if (blockNode != null) {
            this.curState.exits.add(blockNode);
        }
    }

    public final void addExits(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            addExit((BlockNode) it.next());
        }
    }

    public final boolean containsExit(BlockNode blockNode) {
        return this.curState.exits.contains(blockNode);
    }

    public final IRegion peekRegion() {
        return this.curState.region;
    }

    public final void pop() {
        this.curState = (State) this.stack.pop();
    }

    public final void push(IRegion iRegion) {
        this.stack.push(this.curState);
        if (this.stack.size() > 1000) {
            throw new JadxOverflowException("Regions stack size limit reached");
        }
        this.curState = this.curState.copy();
        this.curState.region = iRegion;
    }

    public final void removeExit(BlockNode blockNode) {
        if (blockNode != null) {
            this.curState.exits.remove(blockNode);
        }
    }

    public final int size() {
        return this.stack.size();
    }

    public final String toString() {
        return "Region stack size: " + size() + ", last: " + this.curState;
    }
}
