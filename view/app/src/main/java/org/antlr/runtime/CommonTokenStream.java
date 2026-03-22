package org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class CommonTokenStream extends BufferedTokenStream {
    public int channel;

    public CommonTokenStream(TokenSource tokenSource) {
        super(tokenSource);
        this.channel = 0;
    }

    /* JADX INFO: renamed from: LB */
    public Token m3789LB(int i) {
        if (i != 0) {
            int iSkipOffTokenChannelsReverse = this.f4706p;
            if (iSkipOffTokenChannelsReverse - i >= 0) {
                for (int i2 = 1; i2 <= i; i2++) {
                    iSkipOffTokenChannelsReverse = skipOffTokenChannelsReverse(iSkipOffTokenChannelsReverse - 1);
                }
                if (iSkipOffTokenChannelsReverse < 0) {
                    return null;
                }
                return this.tokens.get(iSkipOffTokenChannelsReverse);
            }
        }
        return null;
    }

    @Override // org.antlr.runtime.BufferedTokenStream, org.antlr.runtime.TokenStream
    /* JADX INFO: renamed from: LT */
    public Token mo3788LT(int i) {
        if (this.f4706p == -1) {
            setup();
        }
        if (i == 0) {
            return null;
        }
        if (i < 0) {
            return m3789LB(-i);
        }
        int iSkipOffTokenChannels = this.f4706p;
        for (int i2 = 1; i2 < i; i2++) {
            iSkipOffTokenChannels = skipOffTokenChannels(iSkipOffTokenChannels + 1);
        }
        if (iSkipOffTokenChannels > this.range) {
            this.range = iSkipOffTokenChannels;
        }
        return this.tokens.get(iSkipOffTokenChannels);
    }

    @Override // org.antlr.runtime.IntStream
    public void consume() {
        if (this.f4706p == -1) {
            setup();
        }
        int i = this.f4706p + 1;
        this.f4706p = i;
        sync(i);
        while (this.tokens.get(this.f4706p).getChannel() != this.channel) {
            int i2 = this.f4706p + 1;
            this.f4706p = i2;
            sync(i2);
        }
    }

    @Override // org.antlr.runtime.BufferedTokenStream
    public void setup() {
        int i = 0;
        this.f4706p = 0;
        sync(0);
        while (this.tokens.get(i).getChannel() != this.channel) {
            i++;
            sync(i);
        }
        this.f4706p = i;
    }

    public int skipOffTokenChannels(int i) {
        sync(i);
        while (this.tokens.get(i).getChannel() != this.channel) {
            i++;
            sync(i);
        }
        return i;
    }

    public int skipOffTokenChannelsReverse(int i) {
        while (i >= 0 && this.tokens.get(i).getChannel() != this.channel) {
            i--;
        }
        return i;
    }
}
