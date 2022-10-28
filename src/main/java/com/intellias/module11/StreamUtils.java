package com.intellias.module11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamUtils {

  private static final String DOT = ". ";
  private static final String COMMA_DELIMITER = ",";

  //task 1
  public static String getWordsWithOddIndex(List<String> names) {
    List<String> filteredNames = IntStream.range(0, names.size())
        .filter(index -> index % 2 != 0)
        .mapToObj(index -> index + DOT + names.get(index))
        .collect(Collectors.toList());

    return String.join(COMMA_DELIMITER, filteredNames);
  }

  // task 2
  public static List<String> getSortedListInUpperCase(List<String> words) {
    return words.stream()
        .map(String::toUpperCase)
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
  }

  //task 3
  public static String getSortedNumbers(String[] numbers) {
    List<String> sortedNumbers = Arrays.stream(numbers)
        .map(number -> number.split(COMMA_DELIMITER))
        .flatMap(Arrays::stream)
        .map(String::trim)
        .sorted()
        .collect(Collectors.toList());
    return String.join(COMMA_DELIMITER, sortedNumbers);
  }

  // task 4
  public static Stream<Long> createLinearCongruentialGenerator(long seed, long a, long c, long m) {
    return Stream.iterate(seed, x -> (a * x + c) % m);
  }

  // task 5
  public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
    Iterator<T> firstIterator = first.iterator();
    Iterator<T> secondIterator = second.iterator();
    Stream<T> result = Stream.empty();

    while (firstIterator.hasNext() && secondIterator.hasNext()) {
      result = Stream.concat(result, Stream.of(firstIterator.next(), secondIterator.next()));
    }

    return result;
  }
}
