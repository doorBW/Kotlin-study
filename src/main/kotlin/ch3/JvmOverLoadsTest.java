package ch3;

import java.util.ArrayList;

public class JvmOverLoadsTest {
    public static void main(String[] args){
        ArrayList list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(Ch3_2Kt.joinToString2(list));

        System.out.println();
    }

}
