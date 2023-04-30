import java.math.BigDecimal;
import java.math.BigInteger;

import static java.lang.Math.*;

public class Main {
    static String A = new BigInteger("1234567",16).toString(2);

    static String B =  new BigInteger("8910abcdef",16).toString(2);
    static String C = new BigInteger("fedcba1098",16).toString(2);
    static String D = new BigInteger("76543210",16).toString(2);

    public static String xor(String s1, String s2)
    {
        if(! (s1.length() == s2.length()))
        {

            System.out.println("S1 "+s1.length()+" S2 "+s2.length() );
        }
        int len = s1.length();
        String res = null;
        for(int i=0;i<len ; i++)
        {
            if(s1.charAt(i) == s2.charAt(i))
            {

                res+=0;
            }
            else
            {
                res+=1;
            }

        }
        res= res.substring(4);
        return res;
    }
    public static String and(String s1, String s2)
    {
        int len = s1.length();
        String res = null;
        for(int i=0;i<len ; i++)
        {

            if(s1.charAt(i) == '0' ||  s2.charAt(i)=='0')
            {
                res+=0;
            }
            else
            {
                res+=1;
            }

        }
        res= res.substring(4);
        return res;
    }
    public static String or(String s1, String s2)
    {
        int len = s1.length();
        String res = null;
        for(int i=0;i<len ; i++)
        {

            if(s1.charAt(i) == '1' ||  s2.charAt(i)=='1')
            {
                res+=1;
            }
            else
            {
                res+=0;
            }

        }
        res= res.substring(4);
        return res;
    }
    public static String not(String s1)
    {
        int len = s1.length();
        String res = null;
        for(int i=0;i<len ; i++)
        {

            if(s1.charAt(i) == '1' )
            {
                res+=0;
            }
            else
            {
                res+=1;
            }
        }
        res= res.substring(4);
        return res;
    }

    public static String padding(String s)
    {
        String result = s;
        int len=s.length();
        int i=1;
        while (len>512*i-64)
        {
            i++;
        }
        int padding = 512*i-64-len;

        for(i=0;i<padding;i++)
        {
            if(i==0)
            {
                result+=1;
                continue;
            }
            result+="0";
        }

        return result;
    }
    public static String strtobin(String s)
    {
        String result = "1";
        for(int i =0 ; i<s.length();i++)
        {
            int t=Integer.valueOf(s.charAt(i));
            String s1=Integer.toBinaryString(t);
            result+= String.format("%8s", s1).replaceAll(" ", "0");

        }
        StringBuilder tempS= new StringBuilder(result);
        tempS.deleteCharAt(0);
        result=tempS.toString();
        return result;
    }
    public static String add_len(String s)
    {
        BigInteger len = new BigInteger(""+s.length()*8);
        BigInteger t1 = new BigInteger("2");
        t1 = t1.pow(64);
        len= len.mod(t1);

        String t2 = String.format("%64s", len.toString(2)).replaceAll(" ", "0");
        //t2= t2.substring(52,60)+t2.substring(0,52);

        s=s+t2;

        return s;
    }
    public static String F()
    {
        String res = and(or(B,C),and(not(B),D));
        return res;
    }
    public static String G()
    {
        String res = or(or(B,D),and(not(D),C));
        return res;
    }
    public static String H()
    {
        String res = xor(B,xor(C,D));
        return res;
    }
    public static String I()
    {
        String res = xor(C,or(B,not(D)));
        return res;
    }
    public static String rotate(BigInteger big, int shift)
    {

        String res= big.toString(2);
        res=String.format("%32s", res).replaceAll(" ", "0");
        res = res.substring(shift)+res.substring(0,shift);

        return res;

    }
    public static void main(String[] args) {
        String s="f";
        s = strtobin(s);
        s=padding(s);
        s=add_len(s);
        int round=3;
        for(int i=0;i<round;i++)
        {
            int op=16;
            int start=0,end=31;
            for(int j=0;j<op;j++)
            {
                if(round == 0)
                {
                    String CC=B, DD=C,AA=D, BB=A;
                    C=CC;
                    D=DD;
                    A=AA;
                    BigInteger mes = new BigInteger(s.substring(start,end),2);
                    BigInteger buff= new BigInteger(BB,2);
                    buff = buff.add(new BigInteger(F(),2));
                    buff= buff.mod(new BigInteger("2").pow(32));
                    mes = (mes.add(buff)).mod(new BigInteger("2").pow(32));

                    BigDecimal k1 = (new BigDecimal("2").pow(32));
                    k1= k1.multiply(new BigDecimal(""+sin(1)));
                    BigInteger k = k1.toBigInteger();
                    mes=(mes.add(k)).mod(new BigInteger("2").pow(32));



                    if(j==0 || j==4 || j == 8 || j==12)
                    {
                        B=rotate(mes,7);
                    }
                    else if(j==1 || j==5 || j == 9 || j==13)
                    {
                        B=rotate(mes,12);
                    }
                    else if(j==2 || j==6 || j == 11 || j==14)
                    {
                        B=rotate(mes,17);
                    }
                    else if(j==3 || j==7 || j == 15 || j==22)
                    {
                        B=rotate(mes,22);
                    }
                    start=end+1;
                    end=end+17;

                }
                else if(round == 1)
                {
                    String CC=B, DD=C,AA=D, BB=A;
                    C=CC;
                    D=DD;
                    A=AA;
                    BigInteger mes = new BigInteger(s.substring(start,end),2);
                    BigInteger buff= new BigInteger(BB,2);
                    buff = buff.add(new BigInteger(G(),2));
                    buff= buff.mod(new BigInteger("2").pow(32));
                    mes = (mes.add(buff)).mod(new BigInteger("2").pow(32));

                    BigDecimal k1 = (new BigDecimal("2").pow(32));
                    k1= k1.multiply(new BigDecimal(""+sin(1)));
                    BigInteger k = k1.toBigInteger();
                    mes=(mes.add(k)).mod(new BigInteger("2").pow(32));



                    if(j==0 || j==4 || j == 8 || j==12)
                    {
                        B=rotate(mes,5);
                    }
                    else if(j==1 || j==5 || j == 9 || j==13)
                    {
                        B=rotate(mes,9);
                    }
                    else if(j==2 || j==6 || j == 11 || j==14)
                    {
                        B=rotate(mes,14);
                    }
                    else if(j==3 || j==7 || j == 15 || j==22)
                    {
                        B=rotate(mes,20);
                    }
                    start=end+1;
                    end=end+17;

                }
                else if(round == 2)
                {
                    String CC=B, DD=C,AA=D, BB=A;
                    C=CC;
                    D=DD;
                    A=AA;
                    BigInteger mes = new BigInteger(s.substring(start,end),2);
                    BigInteger buff= new BigInteger(BB,2);
                    buff = buff.add(new BigInteger(H(),2));
                    buff= buff.mod(new BigInteger("2").pow(32));
                    mes = (mes.add(buff)).mod(new BigInteger("2").pow(32));

                    BigDecimal k1 = (new BigDecimal("2").pow(32));
                    k1= k1.multiply(new BigDecimal(""+sin(1)));
                    BigInteger k = k1.toBigInteger();
                    mes=(mes.add(k)).mod(new BigInteger("2").pow(32));



                    if(j==0 || j==4 || j == 8 || j==12)
                    {
                        B=rotate(mes,4);
                    }
                    else if(j==1 || j==5 || j == 9 || j==13)
                    {
                        B=rotate(mes,11);
                    }
                    else if(j==2 || j==6 || j == 11 || j==14)
                    {
                        B=rotate(mes,16);
                    }
                    else if(j==3 || j==7 || j == 15 || j==22)
                    {
                        B=rotate(mes,13);
                    }
                    start=end+1;
                    end=end+17;

                }
                else if(round == 3)
                {
                    String CC=B, DD=C,AA=D, BB=A;
                    C=CC;
                    D=DD;
                    A=AA;
                    BigInteger mes = new BigInteger(s.substring(start,end),2);
                    BigInteger buff= new BigInteger(BB,2);
                    buff = buff.add(new BigInteger(I(),2));
                    buff= buff.mod(new BigInteger("2").pow(32));
                    mes = (mes.add(buff)).mod(new BigInteger("2").pow(32));

                    BigDecimal k1 = (new BigDecimal("2").pow(32));
                    k1= k1.multiply(new BigDecimal(""+sin(1)));
                    BigInteger k = k1.toBigInteger();
                    mes=(mes.add(k)).mod(new BigInteger("2").pow(32));

                    if(j==0 || j==4 || j == 8 || j==12)
                    {
                        B=rotate(mes,6);
                    }
                    else if(j==1 || j==5 || j == 9 || j==13)
                    {
                        B=rotate(mes,10);
                    }
                    else if(j==2 || j==6 || j == 11 || j==14)
                    {
                        B=rotate(mes,15);
                    }
                    else if(j==3 || j==7 || j == 15 || j==22)
                    {
                        B=rotate(mes,21);
                    }
                    start=end+1;
                    end=end+17;
                }
            }
            String final_res = A+B+C+D;
            BigInteger f=new BigInteger(final_res,2);

            System.out.println(f);
        }

        String final_res = A+B+C+D;
        BigInteger f=new BigInteger(final_res,2);

        System.out.println(f.toString(16));

    }
}