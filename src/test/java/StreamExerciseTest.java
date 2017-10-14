import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Michou
 */
public class StreamExerciseTest {
    @Test
    public void test2() throws Exception {

        assertThat(StreamExercise.performSplitOperation("a, b, test me, c"))
                .contains("1. a", "3. test me")
        ;

    }

    @Test(expected = BadInputException.class)
    public void checkStreamMethods() {


        assertThat(StreamExercise.performSplitOperation("")).isEmpty();



        /*String rawString = "car  ,    bus,,bike";
        List<String> list = rawString.split()

        Stream<String> infiniteInts = Stream.iterate(0, str -> i + 1);
        Stream<Integer> finiteInts = StreamUtils.takeWhile(infiniteInts, i -> i < 10);
        // assert statements
        assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 0));
        assertEquals("0 x 10 must be 0", 0, tester.multiply(0, 10));
        assertEquals("0 x 0 must be 0", 0, tester.multiply(0, 0));*/
    }

}