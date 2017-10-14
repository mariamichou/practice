import com.codepoetics.protonpack.StreamUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamExercise {
    public static void main(String[] args) throws BadInputException {
        String defaultMsg = "Please provide a comma separated list";
        String myString = "car  ,    bus,,bike";
//        boolean i = StringUtils.isBlank(myString);
//        if(i) {
//            throw new BadInputException(defaultMsg);
//        }

        performSplitOperation(myString).forEach(item -> System.out.println(item));


        // optional which doesn't cover the case where myString = " ";
        /*Optional<String> myString2 = Optional.of(" ");
        Optional.ofNullable(myString2).orElseThrow(() ->
                new BadInputException(defaultMsg)
        );
        performSplitOperation(myString2.get()).forEach(item -> System.out.println(item));*/

    }

    public static List<String> performSplitOperation(String rawStr) {

        String[] stringArray = Optional.ofNullable(rawStr).filter(StringUtils::isNotBlank).orElseThrow(BadInputException::new)
//                .replaceAll("\\s","")
                .replaceAll(",+", ",")
                .split(",");

//        int i = 0;
//        Supplier<Integer> idx  = () -> i + 1;
        //Integer[] array  = Stream.generate(idx.get()).limit(stringArray.length).toArray();


        Stream<String> stringFeed = Stream.of(stringArray)
                .filter(StringUtils::isNotBlank)
                .map(String::trim);
        //Stream<String> indicesFeed = Stream.of("1", "2", "3", "4");


        /*return StreamUtils.zip(indicesFeed,
                stringFeed,
                (index, string) -> index + ". " + string)
                .collect(Collectors.toList());*/
        return StreamUtils.zip(
                IntStream.iterate(1, l -> l + 1).mapToObj(i -> i),
                stringFeed,
                (index, string) -> index + ". " + string
        ).collect(toList());


//        return StreamUtils.zipWithIndex(stringFeed)
//                .map(item -> item.getIndex() + 1 + ". " + item.getValue())
//                .collect(toList());


    }

}
