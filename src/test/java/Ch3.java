import ch3.KotlinList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Ch3 {
    @Test
    public void test1(){
        final EqualsClassName whosClass = new EqualsClassName();
        whosClass.test();
    }


    @Test
    public void test2(){
        final List<Integer> javaArrayList = Arrays.asList(1,2,3);
        final KotlinList kotlinList = new KotlinList();
        System.out.println(javaArrayList);
        System.out.println(kotlinList.getList());

        assertEquals(javaArrayList, kotlinList.getList());
    }
}
