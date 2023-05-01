import java.math.BigDecimal;
import java.math.BigInteger;

import static java.lang.Math.*;

public class Main {

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
    public static String add_len(String s, BigInteger len)
    {

        BigInteger t1 = new BigInteger("2");
        t1 = t1.pow(64);
        len= len.mod(t1);

        String t2 = String.format("%64s", len.toString(2)).replaceAll(" ", "0");
        //t2= t2.substring(52,60)+t2.substring(0,52);

        s=s+t2;

        return s;
    }
    public static BigInteger F(BigInteger B, BigInteger C, BigInteger D)
    {
        BigInteger res = (B.and(C)).or(B.not().and(D));

        //String a =or(and(B.toString(2),C.toString(2)),(and(not(B.toString(2)),D.toString(2))));
        return res;
        //return new BigInteger(a);
    }
    public static BigInteger G(BigInteger B, BigInteger C, BigInteger D)
    {
        BigInteger res = (B.and(D)).or(C.and(D.not()));
        return res;
    }
    public static BigInteger H(BigInteger B, BigInteger C, BigInteger D)
    {
        BigInteger res = (B.xor(C)).xor(D);
        return res;
    }
    public static BigInteger I(BigInteger B, BigInteger C, BigInteger D)
    {
        BigInteger res = C.xor(B.or(D.not()));
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

        BigInteger A = new BigInteger("1234567",16);
        BigInteger B =  new BigInteger("89abcdef",16);
        BigInteger C = new BigInteger("fedcba98",16);
        BigInteger D = new BigInteger("76543210",16);

        String s="Abrar";

        BigInteger lenth = new BigInteger(""+s.length()*8);

        s = strtobin(s);
        s=padding(s);
        s=add_len(s,lenth);


        BigInteger [] m1 = new BigInteger[16];

        int s1=0,e1=32;
        for(int i=0;i<16;i++)
        {
            m1[i]=new BigInteger(s.substring(s1,e1),2);
            s1=e1+1;
            e1=e1+32;
        }

        BigInteger [] k = new BigInteger[65];
        k[1]= new BigInteger("D76AA478",16);
        k[2]= new BigInteger("E8C7B756",16);
        k[3]= new BigInteger("242070DB",16);
        k[4]= new BigInteger("C1BDCEEE",16);
        k[5]= new BigInteger("0F57C0FA",16);
        k[6]= new BigInteger("4787C62A",16);
        k[7]= new BigInteger("A8304613",16);
        k[8]= new BigInteger("FD469501",16);
        k[9]= new BigInteger("698098D8",16);
        k[10]= new BigInteger("8B44F7AF",16);
        k[11]= new BigInteger("FFFF5BB1",16);
        k[12]= new BigInteger("895CD7BE",16);
        k[13]= new BigInteger("6B901122",16);
        k[14]= new BigInteger("FD987193",16);
        k[15]= new BigInteger("A679438E",16);
        k[16]= new BigInteger("49B40821",16);
        k[17]= new BigInteger("F61E2562",16);
        k[18]= new BigInteger("C040B340",16);
        k[19]= new BigInteger("265E5A51",16);
        k[20]= new BigInteger("E9B6C7AA",16);
        k[21]= new BigInteger("D62F105D",16);
        k[22]= new BigInteger("02441453",16);
        k[23]= new BigInteger("D8A1E681",16);
        k[24]= new BigInteger("E7D3FBC8",16);
        k[25]= new BigInteger("21E1CDE6",16);
        k[26]= new BigInteger("C33707D6",16);
        k[27]= new BigInteger("F4D50D87",16);
        k[28]= new BigInteger("455A14ED",16);
        k[29]= new BigInteger("A9E3E905",16);
        k[30]= new BigInteger("FCEFA3F8",16);
        k[31]= new BigInteger("676F02D9",16);
        k[32]= new BigInteger("8D2A4C8A",16);
        k[33]= new BigInteger("FFFA3942",16);
        k[34]= new BigInteger("8771F681",16);
        k[35]= new BigInteger("699D6122",16);
        k[36]= new BigInteger("FDE5380C",16);
        k[37]= new BigInteger("A4BEEA44",16);
        k[38]= new BigInteger("4BDECFA9",16);
        k[39]= new BigInteger("F6BB4B60",16);
        k[40]= new BigInteger("BEBFBC70",16);
        k[41]= new BigInteger("289B7EC6",16);
        k[42]= new BigInteger("EAA127FA",16);
        k[43]= new BigInteger("D4EF3085",16);
        k[44]= new BigInteger("04881D05",16);
        k[45]= new BigInteger("D9D4D039",16);
        k[46]= new BigInteger("E6DB99E5",16);
        k[47]= new BigInteger("1FA27CF8",16);
        k[48]= new BigInteger("C4AC5665",16);
        k[49]= new BigInteger("F4292244",16);
        k[50]= new BigInteger("432AFF97",16);
        k[50]= new BigInteger("4787C62A",16);
        k[51]= new BigInteger("AB9423A7",16);
        k[52]= new BigInteger("FC93A039",16);
        k[53]= new BigInteger("655B59C3",16);
        k[54]= new BigInteger("8F0CCC92",16);
        k[55]= new BigInteger("FFEFF47D",16);
        k[56]= new BigInteger("85845DD1",16);
        k[57]= new BigInteger("6FA87E4F",16);
        k[58]= new BigInteger("FE2CE6E0",16);
        k[59]= new BigInteger("A3014314",16);
        k[60]= new BigInteger("4E0811A1",16);
        k[61]= new BigInteger("F7537E82",16);
        k[62]= new BigInteger("BD3AF235",16);
        k[63]= new BigInteger("2AD7D2BB",16);
        k[64]= new BigInteger("EB86D391",16);

        int k_indx=1;
        int round=4;



        for(int i=0;i<round;i++)
        {
            int op=16;
            for(int j=0;j<op;j++)
            {

                if(i == 0)
                {
                    BigInteger CC=B, DD=C,AA=D, BB=A;
                    C=CC;
                    D=DD;
                    A=AA;

                    BigInteger t1 = A.add(F(BB,CC,DD));
                    BigInteger modv= new BigInteger("100000000",16);
                    t1.mod(modv);
                    t1=(t1.add(m1[j])).mod(modv);
                    t1=(t1.add(k[k_indx++])).mod(modv);

                    if(j==0 || j==4 || j == 8 || j==12)
                    {
                        t1= new BigInteger(rotate(t1,7),2);
                        B=(t1.add(CC)).mod(modv);
                    }
                    else if(j==1 || j==5 || j == 9 || j==13)
                    {
                        t1= new BigInteger(rotate(t1,12),2);
                        B=(t1.add(CC)).mod(modv);
                    }
                    else if(j==2 || j==6 || j == 11 || j==14)
                    {
                        t1= new BigInteger(rotate(t1,17),2);
                        B=(t1.add(CC)).mod(modv);
                    }
                    else if(j==3 || j==7 || j == 15 || j==22)
                    {
                        t1= new BigInteger(rotate(t1,22),2);
                        B=(t1.add(CC)).mod(modv);
                    }

                }
                else if(i == 1)
                {
                    BigInteger CC=B, DD=C,AA=D, BB=A;
                    C=CC;
                    D=DD;
                    A=AA;

                    BigInteger modv= new BigInteger("100000000",16);

                    BigInteger t1 = (A.add(G(BB,CC,DD))).mod(modv);
                    t1=(t1.add(m1[j])).mod(modv);
                    t1=(t1.add(k[k_indx++])).mod(modv);


                    if(j==0 || j==4 || j == 8 || j==12)
                    {
                        t1= new BigInteger(rotate(t1,5),2);
                        B=(t1.add(CC)).mod(modv);
                    }
                    else if(j==1 || j==5 || j == 9 || j==13)
                    {
                        t1= new BigInteger(rotate(t1,9),2);
                        B=(t1.add(CC)).mod(modv);
                    }
                    else if(j==2 || j==6 || j == 11 || j==14)
                    {
                        t1= new BigInteger(rotate(t1,14),2);
                        B=(t1.add(CC)).mod(modv);
                    }
                    else if(j==3 || j==7 || j == 12 || j==15)
                    {
                        t1= new BigInteger(rotate(t1,20),2);
                        B=(t1.add(CC)).mod(modv);
                    }

                }
                else if(i == 2)
                {
                    BigInteger CC=B, DD=C,AA=D, BB=A;
                    C=CC;
                    D=DD;
                    A=AA;

                    BigInteger modv= new BigInteger("100000000",16);

                    BigInteger t1 = (A.add(H(BB,CC,DD))).mod(modv);
                    t1=(t1.add(m1[j])).mod(modv);
                    t1=(t1.add(k[k_indx++])).mod(modv);


                    if(j==0 || j==4 || j == 8 || j==12)
                    {
                        t1= new BigInteger(rotate(t1,4),2);
                        B=(t1.add(CC)).mod(modv);
                    }
                    else if(j==1 || j==5 || j == 9 || j==13)
                    {
                        t1= new BigInteger(rotate(t1,11),2);
                        B=(t1.add(CC)).mod(modv);
                    }
                    else if(j==2 || j==6 || j == 11 || j==14)
                    {
                        t1= new BigInteger(rotate(t1,16),2);
                        B=(t1.add(CC)).mod(modv);
                    }
                    else if(j==3 || j==7 || j == 12 || j==15)
                    {
                        t1= new BigInteger(rotate(t1,13),2);
                        B=(t1.add(CC)).mod(modv);
                    }

                }
                else if(i == 3)
                {
                    BigInteger CC=B, DD=C,AA=D, BB=A;
                    C=CC;
                    D=DD;
                    A=AA;

                    BigInteger modv= new BigInteger("100000000",16);

                    BigInteger t1 = (A.add(I(BB,CC,DD))).mod(modv);
                    t1=(t1.add(m1[j])).mod(modv);
                    t1=(t1.add(k[k_indx++])).mod(modv);


                    if(j==0 || j==4 || j == 8 || j==12)
                    {
                        t1= new BigInteger(rotate(t1,6),2);
                        B=(t1.add(CC)).mod(modv);
                    }
                    else if(j==1 || j==5 || j == 9 || j==13)
                    {
                        t1= new BigInteger(rotate(t1,10),2);
                        B=(t1.add(CC)).mod(modv);
                    }
                    else if(j==2 || j==6 || j == 11 || j==14)
                    {
                        t1= new BigInteger(rotate(t1,15),2);
                        B=(t1.add(CC)).mod(modv);
                    }
                    else if(j==3 || j==7 || j == 12 || j==15)
                    {
                        t1= new BigInteger(rotate(t1,21),2);
                        B=(t1.add(CC)).mod(modv);
                    }
                }
            }

        }
        System.out.println((""+A.toString(16)+""+B.toString(16)+""+C.toString(16)+""+D.toString(16)));

    }
}