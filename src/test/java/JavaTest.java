import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by GaoXiang on 2016/1/29 0029.
 */
public class JavaTest {
    public static void main(String[] args) {
        Random rand = new Random();

        for(int i = 0 ;i < 50 ; i++){
            int randNum = rand.nextInt(10)+1;
            System.out.println(randNum);
        }

    }
}
