import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MyTest {
    @Test
    public void test01(){
        System.out.println(045);
    }

    @Test
    public void test02(){
        String str = "101";
        String[] strs = str.split("\\|");
        for (int i=0;i<strs.length;i++){
            System.out.println(strs[i]);
        }
    }
}
