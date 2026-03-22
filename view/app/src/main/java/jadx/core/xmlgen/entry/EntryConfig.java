package jadx.core.xmlgen.entry;

/* JADX INFO: loaded from: classes.dex */
public class EntryConfig {
    private String country;
    private String language;

    public String getCountry() {
        return this.country;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getLocale() {
        StringBuilder sb = new StringBuilder();
        if (this.language != null) {
            sb.append(this.language);
        }
        if (this.country != null) {
            sb.append("-r").append(this.country);
        }
        return sb.toString();
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getLocale());
        if (sb.length() != 0) {
            sb.insert(0, " [");
            sb.append(']');
        }
        return sb.toString();
    }
}
