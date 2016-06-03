package org.sentsov.net;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Stream.of;

/**
 * Created by Vladimir_Sentso on 02.06.2016.
 */
public class BetterProgrammerTask {

    public static int getSumOfNumbers(String s) {
        /*
          Please implement this method to
          return the sum of all integers found in the parameter String. You can assume that
          integers are separated from other parts with one or more spaces (' ' symbol).
          For example, s="12 some text 3  7", result: 22 (12+3+7=22)
         */
        if (s == null) throw new IllegalArgumentException();
        int sum = 0;
        String[] strings = s.split(" ");
        for (String mayBeDigit : strings) {
            if (mayBeDigit.matches("^-?\\d+$")) sum += Integer.valueOf(mayBeDigit);
        }
        return sum;
    }

    public static int getSumOfNumbersJava8Variant(String s) {
        /*
          Please implement this method to
          return the sum of all integers found in the parameter String. You can assume that
          integers are separated from other parts with one or more spaces (' ' symbol).
          For example, s="12 some text 3  7", result: 22 (12+3+7=22)
         */
        if (s == null) throw new IllegalArgumentException();
        return of(s.split(" "))
                .filter(s1 -> s1.matches("^-?\\d+$"))
                .map(Integer::valueOf)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static List<Integer> getPrimeNumbers(int from, int to) {
        /*
          Please implement this method to
          return a list of all prime numbers in the given range (inclusively).
          A prime number is a natural number that has exactly two distinct natural number divisors, which are 1 and the prime number itself.
          The first prime numbers are: 2, 3, 5, 7, 11, 13
         */
        List<Integer> primeNumbers = new ArrayList<Integer>();

        boolean[] isPrime = new boolean[to];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j < isPrime.length; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        for (int i = from; i < isPrime.length; i++) {
            if (isPrime[i]) primeNumbers.add(i);
        }

        return primeNumbers;
    }

    public static int getLargestRootToLeafSum(Node root) {
        /*
          A root-to-leaf path in a tree is a path from a leaf node through all its ancestors
          to the root node inclusively.
          A "root-to-leaf sum" is a sum of the node values in a root-to-leaf path.

          Please implement this method to
          return the largest root-to-leaf sum in the tree.
         */
        int largestRootToLeafSum = 0;

        largestRootToLeafSum = getMaxSum(root, largestRootToLeafSum);
        return largestRootToLeafSum;
    }

    private static int getMaxSum(Node root, int sum) {
        sum += root.getValue();
        if (root.getChildren() == null)
            return sum;
        int maxSum = Integer.MIN_VALUE;
        for (Node child : root.getChildren()) {
            if (child != null)
                maxSum = Math.max(maxSum, getMaxSum(child, sum));
        }
        return maxSum;
    }

    public static int countWaysToProduceGivenAmountOfMoney(int cents) {
        /*
          Please implement this method to
          return the number of different combinations of US coins
          (penny: 1c, nickel: 5c, dime: 10c, quarter: 25c, half-dollar: 50c)
          which may be used to produce a given amount of money.

          For example, 11 cents can be produced with
          one 10-cent coin and one 1-cent coin,
          two 5-cent coins and one 1-cent coin,
          one 5-cent coin and six 1-cent coins,
          or eleven 1-cent coins.
          So there are four unique ways to produce 11 cents.
          Assume that the cents parameter is always positive.
         */
        int[] moneys = {1, 5, 10, 25, 50};
        int combinations = 0;
        for (int i = 0; i <= cents; i++) {
            for (int j = 0; j <= cents; j++) {
                for (int k = 0; k <= cents; k++) {
                    for (int l = 0; l <= cents; l++) {
                        for (int m = 0; m <= cents; m++) {
                            if (moneys[0] * i + moneys[1] * j + moneys[2] * k + moneys[3] * l + moneys[4] * m == cents)
                                combinations++;
                        }
                    }
                }
            }
        }
        return combinations;
    }

    // Please do not change this interface
    public static interface Node {
        int getValue();

        List<Node> getChildren();
    }
}
