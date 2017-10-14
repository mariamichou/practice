import com.codepoetics.protonpack.StreamUtils;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Michou
 */
public class FunctionExercise {

    public static Stream<Integer> add(Stream<Integer> a, Stream<Integer> b, BiFunction<Integer, Integer, Integer> op) {
        return StreamUtils.zip(a, b, op);
    }


    public static Function<Integer, Integer> mult(int m) {
        return a -> mult(a,m);
    }

    public static int mult(Integer a, Integer b) {
        return a * b;
    }
}
