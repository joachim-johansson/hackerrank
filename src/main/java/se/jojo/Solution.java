package se.jojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Java 1D Array (Part 2)
 */
public class Solution {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            printAnswer(getValues(br), getQuestions(br));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printAnswer(Map<Integer, List<Integer>> values, List<List<Integer>> questions) {
        questions.forEach(entry -> {
            try {
                System.out.println(values.get(entry.get(0)).get(entry.get(1)));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        });
    }

    private static List<List<Integer>> getQuestions(BufferedReader br) throws IOException {
        Integer sizeOfQuestions = getSize(br);
        List<List<Integer>> questions = new ArrayList<>(sizeOfQuestions);
        for (int index=0; index < sizeOfQuestions; index++) {
            questions.add(getValue(br));
        }
        return questions;
    }

    private static Map<Integer, List<Integer>> getValues(BufferedReader br) throws IOException {
        Integer sizeOfValues = getSize(br);
        Map<Integer, List<Integer>> values = new HashMap<>(sizeOfValues);
        for (int index=1; index <= sizeOfValues; index++) {
            values.put(index, getValue(br));
        }
        return values;
    }

    private static int getSize(BufferedReader br) throws IOException {
        return Integer.valueOf(br.readLine());
    }

    private static List<Integer> getValue(BufferedReader br) throws IOException {
        String[] arr = br.readLine().split(" ");
        return Arrays.stream(arr).map(Integer::valueOf).collect(Collectors.toList());
    }


}
