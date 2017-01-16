package ru.IldarBiktimerov;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by User on 15.01.2017.
 */
public class FindIPTest {

    @Test
    public void enterStr() throws Exception {
        FindIP ip = new FindIP();
        String str="192.168.0.2";
        String[] expected1={"192","168","0","2"};
        //assertNotNull(ip.enterStr());


    }

    @Test
    public void checkError() throws Exception {
        FindIP ip = new FindIP();
        String[] mas1={"192","168","0","2"};
        String[] mas2={"0"};
        int[] expected1={192, 168, 0, 2};
        int[] expected2={0};
        assertArrayEquals(expected1,ip.checkError(mas1));
        assertArrayEquals(expected2,ip.checkError(mas2));


    }

    @Test
    public void result() throws Exception {
        int[] mas1={192,168,0,1};
        int[] mas2={192,168,0,5};
        int[] mas3={192,168,1,7};
        assertEquals(true,FindIP.result(mas1,mas2));
        assertEquals(false,FindIP.result(mas1,mas3));

    }

}