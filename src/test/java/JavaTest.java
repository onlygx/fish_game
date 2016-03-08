import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by GaoXiang on 2016/1/29 0029.
 */
public class JavaTest {
    public static void main(String[] args) {
        long start = 100;
        for(int i = 1 ;i <= 52 ;i++){
            start += start * 0.3;
            System.out.println("第"+i+"周:"+start);
        }
    }
}
