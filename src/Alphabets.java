public class Alphabets {
    public static final String UCAlphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LCAlphabets="abcdefghijklmonpqrstuvwxyz";
    public static final String Numbers="0123456789";
    public static final String Symbols="!@#$%^&*()_<>.?/";
    private final StringBuilder ReqAlphabets;

    public Alphabets(boolean UC,boolean LC,boolean Num,boolean Symb)
    {
        ReqAlphabets=new StringBuilder();
        if(UC)
            ReqAlphabets.append(UCAlphabets);
        if(LC)
            ReqAlphabets.append(LCAlphabets);
        if(Num)
            ReqAlphabets.append(Numbers);
        if(Symb)
            ReqAlphabets.append(Symbols);
    }

    public String getAlphabets()
    {
        return ReqAlphabets.toString();
    }

}
