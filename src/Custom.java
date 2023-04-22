import java.util.*;
public class Custom {
    public static final String Symbols="!@#$%";
    StringBuilder CA=new StringBuilder();
    public static Scanner sc;
    boolean n;
    public Custom(String x,String y,boolean a,boolean aa)
    {
        CA.append(x);
        CA.append(y);
        if(a)
        {
            CA.append(Symbols);
        }
        if(aa)
        {
            CA.append("&");
            CA.append("^");
        }
        System.out.println(CA.toString());
    }

    public String getCData()
    {
        return CA.toString();
    }
    private boolean isInclude(String xx)
    {
        return xx.equalsIgnoreCase("yes");
    }
}
