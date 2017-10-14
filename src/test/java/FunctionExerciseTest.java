import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Michou
 */
public class FunctionExerciseTest {

    @Test
    public void testAdd() throws Exception {

        BiFunction<Integer, Integer, Integer> m = (a, b) -> a + b;
        Function<Integer, BiFunction<Integer, Integer, Integer>> t = a -> (b, c) -> a + b + c;


        Function<Integer, Integer> mult2 = FunctionExercise.mult(2);
        Function<Integer, Integer> mult3 = FunctionExercise.mult(3);
        assertThat(m.apply(2, 4)).isEqualTo(6);
        assertThat(t.apply(2).apply(3,4)).isEqualTo(9);


        assertThat(FunctionExercise.add(
                Stream.of(1, 2),
                Stream.of(2, 3),
                (a, b) -> a + b
        ).collect(Collectors.toList())).contains(3, 5);
    }

}