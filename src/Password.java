public class Password {
    String value;
    int length;

    public Password(String s)
    {
        value=s;
        length=s.length();
    }
    public int CharType(char C)
    {
        int val;
        if ((int) C >= 65 && (int) C <= 90)
            val = 1;
        else if ((int) C >= 97 && (int) C <= 122) {
            val = 2;
        }
        else if ((int) C >= 60 && (int) C <= 71) {
            val = 3;
        }
        else {
            val = 4;
        }
        return val;
    }
    @Override
    public String toString()
    {
        return value;
    }
}

