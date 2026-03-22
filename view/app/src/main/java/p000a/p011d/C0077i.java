package p000a.p011d;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: a.d.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0077i {

    /* JADX INFO: renamed from: a */
    private static LinkedHashMap f215a;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f215a = linkedHashMap;
        linkedHashMap.put("-aa", "Afar");
        f215a.put("-ab", "Abkhazian");
        f215a.put("-af", "Afrikaans");
        f215a.put("-ak", "Akan");
        f215a.put("-sq", "Albanian");
        f215a.put("-am", "Amharic");
        f215a.put("-ar", "Arabic");
        f215a.put("-an", "Aragonese");
        f215a.put("-hy", "Armenian");
        f215a.put("-as", "Assamese");
        f215a.put("-av", "Avaric");
        f215a.put("-ae", "Avestan");
        f215a.put("-ay", "Aymara");
        f215a.put("-az", "Azerbaijani");
        f215a.put("-ba", "Bashkir");
        f215a.put("-bm", "Bambara");
        f215a.put("-eu", "Basque");
        f215a.put("-be", "Belarusian");
        f215a.put("-bn", "Bengali");
        f215a.put("-bh", "Bihari languages+B372");
        f215a.put("-bi", "Bislama");
        f215a.put("-bo", "Tibetan");
        f215a.put("-bs", "Bosnian");
        f215a.put("-br", "Breton");
        f215a.put("-bg", "Bulgarian");
        f215a.put("-my", "Burmese");
        f215a.put("-ca", "Catalan; Valencian");
        f215a.put("-cs", "Czech");
        f215a.put("-ch", "Chamorro");
        f215a.put("-ce", "Chechen");
        f215a.put("-zh", "Chinese");
        f215a.put("cu", "Church Slavic; Old Slavonic; Church Slavonic; Old Bulgarian; Old Church Slavonic");
        f215a.put("-cv", "Chuvash");
        f215a.put("-kw", "Cornish");
        f215a.put("-co", "Corsican");
        f215a.put("-cr", "Cree");
        f215a.put("-cy", "Welsh");
        f215a.put("-cs", "Czech");
        f215a.put("-da", "Danish");
        f215a.put("-de", "German");
        f215a.put("-dv", "Divehi; Dhivehi; Maldivian");
        f215a.put("-nl", "Dutch; Flemish");
        f215a.put("-dz", "Dzongkha");
        f215a.put("-el", "Greek, Modern (1453-)");
        f215a.put("-en", "English");
        f215a.put("-eo", "Esperanto");
        f215a.put("-et", "Estonian");
        f215a.put("-eu", "Basque");
        f215a.put("-ee", "Ewe");
        f215a.put("-fo", "Faroese");
        f215a.put("-fa", "Persian");
        f215a.put("-fj", "Fijian");
        f215a.put("-fi", "Finnish");
        f215a.put("-fr", "French");
        f215a.put("-fy", "Western Frisian");
        f215a.put("-ff", "Fulah");
        f215a.put("-ka", "Georgian");
        f215a.put("-de", "German");
        f215a.put("-gd", "Gaelic; Scottish Gaelic");
        f215a.put("-ga", "Irish");
        f215a.put("-gl", "Galician");
        f215a.put("-gv", "Manx");
        f215a.put("-el", "Greek, Modern");
        f215a.put("-gn", "Guarani");
        f215a.put("-gu", "Gujarati");
        f215a.put("-ht", "Haitian; Haitian Creole");
        f215a.put("-ha", "Hausa");
        f215a.put("-iw", "Hebrew");
        f215a.put("-he", "Hebrew");
        f215a.put("-hz", "Herero");
        f215a.put("-hi", "Hindi");
        f215a.put("-ho", "Hiri Motu");
        f215a.put("-hr", "Croatian");
        f215a.put("-hu", "Hungarian");
        f215a.put("-hy", "Armenian");
        f215a.put("-ig", "Igbo");
        f215a.put("-is", "Icelandic");
        f215a.put("-io", "Ido");
        f215a.put("-ii", "Sichuan Yi; Nuosu");
        f215a.put("-iu", "Inuktitut");
        f215a.put("-ie", "Interlingue; Occidental");
        f215a.put("-ia", "Interlingua (International Auxiliary Language Association)");
        f215a.put("-in", "Indonesian");
        f215a.put("-id", "Indonesian");
        f215a.put("-ik", "Inupiaq");
        f215a.put("-is", "Icelandic");
        f215a.put("-it", "Italian");
        f215a.put("-jv", "Javanese");
        f215a.put("-ja", "Japanese");
        f215a.put("-kl", "Kalaallisut; Greenlandic");
        f215a.put("-kn", "Kannada");
        f215a.put("-ks", "Kashmiri");
        f215a.put("-ka", "Georgian");
        f215a.put("-kr", "Kanuri");
        f215a.put("-kk", "Kazakh");
        f215a.put("-km", "Central Khmer");
        f215a.put("-ki", "Kikuyu; Gikuyu");
        f215a.put("-rw", "Kinyarwanda");
        f215a.put("-ky", "Kirghiz; Kyrgyz");
        f215a.put("-kv", "Komi");
        f215a.put("-kg", "Kongo");
        f215a.put("-ko", "Korean");
        f215a.put("-kj", "Kuanyama; Kwanyama");
        f215a.put("-ku", "Kurdish");
        f215a.put("-lo", "Lao");
        f215a.put("-la", "Latin");
        f215a.put("-lv", "Latvian");
        f215a.put("-li", "Limburgan; Limburger; Limburgish");
        f215a.put("-ln", "Lingala");
        f215a.put("-lt", "Lithuanian");
        f215a.put("-lb", "Luxembourgish; Letzeburgesch");
        f215a.put("-lu", "Luba-Katanga");
        f215a.put("-lg", "Ganda");
        f215a.put("-mk", "Macedonian");
        f215a.put("-mh", "Marshallese");
        f215a.put("-ml", "Malayalam");
        f215a.put("-mi", "Maori");
        f215a.put("-mr", "Marathi");
        f215a.put("-ms", "Malay");
        f215a.put("-mk", "Macedonian");
        f215a.put("-mg", "Malagasy");
        f215a.put("-mt", "Maltese");
        f215a.put("-mn", "Mongolian");
        f215a.put("-mi", "Maori");
        f215a.put("-ms", "Malay");
        f215a.put("-my", "Burmese");
        f215a.put("-na", "Nauru");
        f215a.put("-nv", "Navajo; Navaho");
        f215a.put("-nr", "Ndebele, South; South Ndebele");
        f215a.put("-nd", "Ndebele, North; North Ndebele");
        f215a.put("-ng", "Ndonga");
        f215a.put("-ne", "Nepali");
        f215a.put("-nl", "Dutch; Flemish");
        f215a.put("-nn", "Norwegian Nynorsk; Nynorsk, Norwegian");
        f215a.put("-nb", "Bokmål, Norwegian; Norwegian Bokmål");
        f215a.put("-no", "Norwegian");
        f215a.put("-ny", "Chichewa; Chewa; Nyanja");
        f215a.put("-oc", "Occitan (post 1500)");
        f215a.put("-oj", "Ojibwa");
        f215a.put("-or", "Oriya");
        f215a.put("-om", "Oromo");
        f215a.put("-os", "Ossetian; Ossetic");
        f215a.put("-pa", "Panjabi; Punjabi");
        f215a.put("-fa", "Persian");
        f215a.put("-pi", "Pali");
        f215a.put("-pl", "Polish");
        f215a.put("-pt", "Portuguese");
        f215a.put("-ps", "Pushto; Pashto");
        f215a.put("-qu", "Quechua");
        f215a.put("-rm", "Romansh");
        f215a.put("-ro", "Romanian; Moldavian; Moldovan");
        f215a.put("-ro", "Romanian; Moldavian; Moldovan");
        f215a.put("-rn", "Rundi");
        f215a.put("-ru", "Russian");
        f215a.put("-sg", "Sango");
        f215a.put("-sa", "Sanskrit");
        f215a.put("-si", "Sinhala; Sinhalese");
        f215a.put("-sk", "Slovak");
        f215a.put("-sk", "Slovak");
        f215a.put("-sl", "Slovenian");
        f215a.put("-se", "Northern Sami");
        f215a.put("-sm", "Samoan");
        f215a.put("-sn", "Shona");
        f215a.put("-sd", "Sindhi");
        f215a.put("-so", "Somali");
        f215a.put("-st", "Sotho, Southern");
        f215a.put("-es", "Spanish; Castilian");
        f215a.put("-sq", "Albanian");
        f215a.put("-sc", "Sardinian");
        f215a.put("-sr", "Serbian");
        f215a.put("-ss", "Swati");
        f215a.put("-su", "Sundanese");
        f215a.put("-sw", "Swahili");
        f215a.put("-sv", "Swedish");
        f215a.put("-ty", "Tahitian");
        f215a.put("-ta", "Tamil");
        f215a.put("-tt", "Tatar");
        f215a.put("-te", "Telugu");
        f215a.put("-tg", "Tajik");
        f215a.put("-tl", "Tagalog");
        f215a.put("-th", "Thai");
        f215a.put("-bo", "Tibetan");
        f215a.put("-ti", "Tigrinya");
        f215a.put("-to", "Tonga (Tonga Islands)");
        f215a.put("-tn", "Tswana");
        f215a.put("-ts", "Tsonga");
        f215a.put("-tk", "Turkmen");
        f215a.put("-tr", "Turkish");
        f215a.put("-tw", "Twi");
        f215a.put("-ug", "Uighur; Uyghur");
        f215a.put("-uk", "Ukrainian");
        f215a.put("-ur", "Urdu");
        f215a.put("-uz", "Uzbek");
        f215a.put("-ve", "Venda");
        f215a.put("-vi", "Vietnamese");
        f215a.put("-vo", "Volapük");
        f215a.put("-cy", "Welsh");
        f215a.put("-wa", "Walloon");
        f215a.put("-wo", "Wolof");
        f215a.put("-xh", "Xhosa");
        f215a.put("-ji", "Yiddish");
        f215a.put("-yi", "Yiddish");
        f215a.put("-yo", "Yoruba");
        f215a.put("-za", "Zhuang; Chuang");
        f215a.put("-zh", "Chinese");
        f215a.put("-zu", "Zulu");
    }

    /* JADX INFO: renamed from: a */
    public static int m199a() {
        return f215a.size();
    }

    /* JADX INFO: renamed from: a */
    public static String m200a(String str) {
        if (str.equals("")) {
            return "[ Default ]";
        }
        int iIndexOf = str.indexOf(45, 1);
        String str2 = (String) f215a.get(iIndexOf != -1 ? str.substring(0, iIndexOf) : str);
        return str2 != null ? str2 + " (" + str + ")" : " (" + str + ")";
    }

    /* JADX INFO: renamed from: a */
    public static void m201a(String[] strArr, String[] strArr2) {
        int i = 0;
        Iterator it = f215a.entrySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return;
            }
            Map.Entry entry = (Map.Entry) it.next();
            strArr[i2] = (String) entry.getKey();
            strArr2[i2] = (String) entry.getValue();
            i = i2 + 1;
        }
    }
}
