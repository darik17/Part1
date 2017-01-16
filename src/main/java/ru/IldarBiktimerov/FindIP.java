package ru.IldarBiktimerov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * Created by B on 13.01.2017.
 */
public class FindIP {
    public int[] mas;


    public String[] enterStr() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tempVar=reader.readLine();
        tempVar=tempVar.trim();
        String[] arrString=tempVar.split("\\.");
        return arrString;
    }
    public int[] checkError(String[] masStr){
        int masChis [] =new int[masStr.length];
        for(int i=0; i<masStr.length;i++){
           try {
               masChis[i] = Integer.parseInt(masStr[i]);
           }catch (Exception e){
               System.out.println("Недопустимые символы!");
           }

        }
        if(masChis.length!=4 || masChis[0]!=192 || masChis[1]!=168 || masChis[2]>255 ||
                masChis[2]<0 || masChis[3]>255 || masChis[3]<1){
            System.out.println("Неправильно введен ip адрес");

        }

        return masChis;


    }
    public static boolean result(int[] masOne, int[] masTwo){
        if(masOne[2]!=masTwo[2])
            return false;
        else {
            for (int i = masOne[3]+1;i<masTwo[3];i++ )
                System.out.println("192.168."+masOne[2]+"."+i);

        }
        return true;
    }

     public static void main(String [] args) throws Exception {
        System.out.println("Для вычисления диапазона допустимых значений, нужно ввести два ip адреса (класс сети С)");
        System.out.println("Введите, через enter, два ip адрес, ввида 192.168.x.x, где x число от 0 до 255. ");
        FindIP ip = new FindIP();
        ip.mas=ip.checkError(ip.enterStr());
        if(ip.mas[0]!=0 && ip.mas.length==4) {

            FindIP ip2 = new FindIP();
            ip2.mas = ip2.checkError(ip2.enterStr());
            if (!result(ip.mas, ip2.mas))
                System.out.println("Указаны ip адреса из разных диапазонов!");
        }
    }


}
