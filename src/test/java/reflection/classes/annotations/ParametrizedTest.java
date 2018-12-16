package reflection.classes.annotations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(value = Parameterized.class)
public class ParametrizedTest {

    @Parameterized.Parameters
    public static List<Integer[]> data() {
        Integer[][] data = new Integer[][]{{1}, {2}, {3}, {4}};
        return Arrays.asList(data);
    }

    private int number;

    public ParametrizedTest(int number) {
        this.number = number;
    }

    @Test
    public void some_test() {
        System.out.println("Test with number = " + number);
    }


}