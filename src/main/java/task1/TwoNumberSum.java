package task1;

import java.util.*;

public class TwoNumberSum {
    public static void main(String[] args) {
        int targetSum = 10;
        //valid bunch of numbers where we can get a tuple of correct values [11, -1]
        List<Integer> numbers = Arrays.asList(3, 5, -4, 8, 11, 1, -1, 6);

        //invalid bunch of numbers where we cannot get a tuple of correct values.
        //So, each solution will return an empty list
//        List<Integer> numbers = Arrays.asList(3, 5, -4, 8, 10, 1, -1, 6);

        List<Integer> resultTuple;

        resultTuple = twoNumberSumSolution1(numbers, targetSum);
        System.out.println(resultTuple);

        resultTuple = twoNumberSumSolution2(numbers, targetSum);
        System.out.println(resultTuple);

        resultTuple = twoNumberSumSolution3(numbers, targetSum);
        System.out.println(resultTuple);
    }

    //O(n^2) time | O(1) space
    // 2 <for> loops | no temporary storage
    public static List<Integer> twoNumberSumSolution1(List<Integer> numbers, int targetSum) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            int leftPointer = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) {
                int rightPointer = numbers.get(j);
                if (leftPointer + rightPointer == targetSum) {
                    return List.of(leftPointer, rightPointer);
                }
            }
        }
        return List.of();
    }

    //O(n) time | O(n) space
    // 1 <for> loop | 1 temporary storage
    public static List<Integer> twoNumberSumSolution2(List<Integer> numbers, int targetSum) {
        Set<Integer> temporaryStorage = new HashSet<>();
        for (Integer number : numbers) {
            int potentialMatch = targetSum - number;
            //search operation complexity in HashSet is constant and equals O(1)
            if (temporaryStorage.contains(potentialMatch)) {
                return List.of(potentialMatch, number);
            } else {
                //add operation complexity in HashSet is constant and equals O(1)
                temporaryStorage.add(number);
            }
        }

        return List.of();
    }

    public static List<Integer> twoNumberSumSolution3(List<Integer> numbers, int targetSum) {
        Collections.sort(numbers);
        System.out.println("Sorted ArrayList: " + numbers);
        int leftPointer = 0;
        int rightPointer = numbers.size() - 1;
        while (leftPointer < rightPointer) {
            int leftPointerValue = numbers.get(leftPointer);
            int rightPointerValue = numbers.get(rightPointer);
            int currentSum = leftPointerValue + rightPointerValue;

            if (currentSum < targetSum) {
                leftPointer += 1;
            } else if (currentSum > targetSum) {
                rightPointer -= 1;
            } else {
                // when currentSum == targetSum
                return List.of(leftPointerValue, rightPointerValue);
            }
        }
        return List.of();
    }
}
