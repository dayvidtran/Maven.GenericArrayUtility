package com.zipcodewilmington.arrayutility;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    public ArrayList<T> inputArray = new ArrayList<>();

    public T[] input;

    public ArrayUtility(T[] inputArray){
        this.inputArray.addAll(Arrays.asList(inputArray));
        this.input = inputArray;
    }


    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        this.inputArray.addAll(Arrays.asList(arrayToMerge));
        return countDuplicates(valueToEvaluate);
    }
    private Integer countDuplicates(T item){
        int count = 0;
        for (T element : this.input){
            if (item.equals(element)){
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        this.inputArray.addAll(Arrays.asList(arrayToMerge));
        Map<T, Long> occurences = Arrays.stream(arrayToMerge)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return occurences.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        return (int)inputArray.stream()
                .filter(element -> valueToEvaluate == element)
                .count();
    }

    public T[] removeValue(T valueToRemove) {
        List<T> processedList = inputArray.stream()
                .filter(element -> valueToRemove != element)
                .collect(Collectors.toList());
        return (T[]) processedList.toArray(new Object[processedList.size()]);
    }
}
