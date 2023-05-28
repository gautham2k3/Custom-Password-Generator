import java.util.*;
public class Generator
{
    Alphabets A;
    Custom b;
    public static Scanner sc;

    public Generator(Scanner scanner)
    {
        sc=scanner;
    }
    public Generator(String x,String y,boolean z,boolean a)
    {
        b=new Custom(x,y,z,a);
    }
    public Generator(boolean UC,boolean LC,boolean Num,boolean Symb)
    {
        A=new Alphabets(UC,LC,Num,Symb);
    }
    public void MainMenu()
    {
        System.out.println("PASSWORD GENERATOR");
        String str,s;
        do {
            printmenu();
            str=sc.next();
            switch (str) {
                case "1": {
                    requestPassword();
                    break;
                }
                case "2": {
                    requestCP();
                    break;
                }
                case "3": {
                    requestQuit();
                }
                default: {
                    System.out.println("Incorrect Choice");
                    printmenu();
                }
            }
            System.out.println("MM-Main Menu X-EXIT");
            s=sc.next();
        }
        while(s.equalsIgnoreCase("mm"));
    }
    private Password GeneratePassword(int length) {
        int max, min, range;
        final StringBuilder pass = new StringBuilder("");
        if (length != 0) {
            final int ALength = A.getAlphabets().length();
            max = ALength - 1;
            min = 0;
            range = max - min + 1;
            for (int i = 0; i < length; i++) {
                int index = (int) (Math.random() * range) + min;
                pass.append(A.getAlphabets().charAt(index));
            }
        }
        return new Password(pass.toString());
    }
    public Password GenerateCP(int length)
    {
        final StringBuilder B=new StringBuilder("");
        int range=b.getCData().length();
        for(int i=0;i<length;i++)
        {
            int j=(int)(Math.random()*range);
            B.append(b.getCData().charAt(j));
        }
        return new Password(B.toString());
    }

    public void requestCP()
    {
        System.out.println("Welcome to Custom Password generator");
        printCM();
    }
    public void requestPassword()
    {
        boolean UC=false;
        boolean LC=false;
        boolean Num=false;
        boolean Symb=false;
        boolean cp;
        System.out.println("Password Generator");
        System.out.println("Answer the Following");
        do{
            String input;
            cp=false;
            do{
                System.out.println("DO you need Uppercase :");
                input=sc.next();
            }
            while(!input.equalsIgnoreCase("yes")&& !input.equalsIgnoreCase("no"));

            if(isInclude(input)) LC=true;

            do{
                System.out.println("DO you need Lowercase :");
                input=sc.next();
            }
            while(!input.equalsIgnoreCase("yes")&& !input.equalsIgnoreCase("no"));

            if(isInclude(input)) UC=true;

            do{
                System.out.println("DO you need Numbers :");
                input=sc.next();
            }
            while(!input.equalsIgnoreCase("yes")&& !input.equalsIgnoreCase("no"));

            if(isInclude(input)) Num=true;

            do{
                System.out.println("DO you need Symbols :");
                input=sc.next();
            }
            while(!input.equalsIgnoreCase("yes")&& !input.equalsIgnoreCase("no"));

            if(isInclude(input)) Symb=true;

            if (!UC && ! LC && !Num && !Symb) {
                System.out.println("You have selected no characters to generate your " +
                        "password, at least one of your answers should be Yes\n");
                cp = true;
            }
        }
        while(cp);
        System.out.println("Enter the length of password");
        int length=sc.nextInt();
        final Generator generator=new Generator(UC,LC,Num,Symb);
        final Password password=generator.GeneratePassword(length);
        System.out.println("Your Generated Password is "+password);
    }

    private boolean isInclude(String xx)
    {
        return xx.equalsIgnoreCase("yes");
    }
    public void printmenu()
    {
        System.out.println();
        System.out.println("1. Password Generator");
        System.out.println("2. Custom Password");
        System.out.println("3. EXIT");
        System.out.println("Choose one Option");
    }
    public void requestQuit()
    {
        System.out.println("Application Exit");
    }
    public void printCM()
    {
        String x,y,z;
        String p=" ",q=" ",s;
        boolean a = false;
        boolean aa = false;
        System.out.println("Enter First Name");
        x=sc.next();
        System.out.println("Enter last Name");
        y=sc.next();
        System.out.println("Do you want to include DOB");
        s=sc.next();
        if(isInclude(s))
        {
            aa=true;
            System.out.println("Enter your Date Of Birth");
            p=sc.next();
            System.out.println("Enter your Year of Birth");
            q=sc.next();
        }
        do {
            System.out.println("Do you need Symbols");
            z = sc.next();
        }
        while(!z.equalsIgnoreCase("yes")&&!z.equalsIgnoreCase("no"));
        if(isInclude(z)) {
            a = true;
        }
        String FName="";
        String LName="";
        int l=8;
        if(isInclude(s)) {
            System.out.println("Select Generated Password Type :");
            System.out.println("1.Easy \n2.Hard");
            System.out.println("Enter a Choice");
            int choice = sc.nextInt();
            while (choice != 1 && choice != 2) {
                System.out.println("Invalid Choice : Re_Enter");
                choice = sc.nextInt();
            }
            if (choice == 1) {
                FName = x;
                LName = y;
                x = "*";
                y = "+";
                l=4;
            }
        }
        final Generator G=new Generator(x,y,a,aa);
        final Password Pass=G.GenerateCP(l);
        String ax=Pass.toString();
        if(isInclude(s)) {
            System.out.print("Your Generated Password is : ");
            for (int i = 0; i < ax.length(); i++) {
                if(ax.charAt(i)=='*')
                    System.out.print(FName);
                else if(ax.charAt(i)=='+')
                    System.out.print(LName);
                else if (ax.charAt(i) == '&')
                    System.out.print(p);
                else if (ax.charAt(i) == '^')
                    System.out.print(q);
                else
                    System.out.print(ax.charAt(i));
            }
            System.out.println();
        }
        else {
            System.out.println("Your Generated Password is " + ax);
        }
    }
}
