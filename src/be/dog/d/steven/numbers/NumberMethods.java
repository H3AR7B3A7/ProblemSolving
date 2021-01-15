package be.dog.d.steven.numbers;

import java.util.*;

public class NumberMethods {

    /**
     * GIVEN AN ARRAY AND INTEGER K, FIND THE TOTAL NUMBER OF SUB-ARRAYS WITH SUM EQUAL TO K
     *
     * @param nums The array to check for sub-arrays
     * @param k    The sum the sub-arrays must equal to
     * @return Number of sub-arrays
     */
    public static int numberOfSubArraysEqualToAnIntegerBruteForce(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                    res++;
            }
        }
        return res;
    }

    /**
     * GIVEN AN ARRAY AND INTEGER K, FIND THE TOTAL NUMBER OF SUB-ARRAYS WITH SUM EQUAL TO K
     *
     * @param nums The array to check for sub-arrays
     * @param k    The sum the sub-arrays must equal to
     * @return Number of sub-arrays
     */
    public static int numberOfSubArraysEqualToAnInteger(int[] nums, int k) {
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        int res = 0;
        int current = 0;
        for (int num : nums) {
            current += num;
            if (current == k)
                res++;
            if (prevSum.containsKey(current - k))
                res += prevSum.get(current - k);
            prevSum.merge(current, 1, Integer::sum);
        }
        return res;
    }

    /**
     * FIND NTH NUMBER OF WHICH THE DIGITS ADD UP TO 10
     *
     * @param n Position of the number fitting requirements
     * @return The number with digits adding up to 10
     */
    public static int findNumberWithSumOfDigitsTen(int n) {
        int count = 0;
        int result = 0;
        for (int i = 0; count < n; i++) {
            String next = String.valueOf(i);
            int[] array = new int[next.length()];
            for (int j = 0; j < next.length(); j++) {
                array[j] = Integer.parseInt(String.valueOf(next.charAt(j)));
            }
            int sum = Arrays.stream(array).sum();
            if (sum == 10) {
                result = i;
                count++;
            }
        }
        return result;
    }

    public static int findNumberWithSumOfDigits10(int n) {
        int count = 0;
        for (int next = 1; ; next++) {
            int sum = 0;
            for (int x = next; x > 0; x = x / 10)
                sum = sum + x % 10;
            if (sum == 10)
                count++;
            if (count == n)
                return next;
        }
    }

    /**
     * IN AN ARRAY OF INTEGERS, FIND THE TWO INTEGERS THAT APPEAR ONLY ONCE
     *
     * @param numbers The array containing integers with only 2 appearing once
     * @return An array with the 2 unique integers
     */
    public static int[] findNumbersWithoutDouble(int[] numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum = sum ^ number;
        }
        sum = sum & -sum;
        int number1 = 0;
        int number2 = 0;
        for (Integer number : numbers) {
            if ((number & sum) > 0) {
                number1 = number1 ^ number;
            } else {
                number2 = number2 ^ number;
            }
        }
        return new int[]{number1, number2}; // T:O(n), S:O(1)
    }

    public static int[] findNumbersWithoutDouble2(int[] numbers) {
        int sum = 0;
        int memo = 0;
        for (Integer number : numbers) {
            memo = sum = sum ^ number;
        }
        sum = sum & -sum;
        int number1 = 0;
        int number2 = 0;
        for (Integer number : numbers) {
            if ((number & sum) > 0) {
                number1 = number1 ^ number;
                number2 = memo - number1;
                break;
            }
        }
        return new int[]{number1, number2}; // T:O(n), S:O(1)
    }

    /**
     * FIND TWO ADDENDS IN ARRAY OF TARGET SUM
     *
     * @param nums   Array with numbers holding one set of addends that sum up to target
     * @param target Target for the 2 addends to add up to
     * @return Array holding the positions of the 2 addends in nums
     */
    public static int[] findTwoAddendsOfTargetSum(int[] nums, int target) {
        int[] addends = new int[2];
        outer:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    addends[0] = i;
                    addends[1] = j;
                    break outer;
                }
            }
        }
        return addends;
    }

    /**
     * THE MINIMAL RAISE A COMPANY COULD GIVE IF THEY WANT NEIGHBORING WORKERS TO EARN MORE THEN THEIR
     * PEERS WHO PRODUCED LESS CODE NEXT TO THEM (Supposedly easy challenge)
     *
     * @param lines The lines of code produced by a row of worker at the company
     * @return Minimal raise for each worker
     */
    public static int[] minimalRaiseComparedToNeighborsLines(int[] lines) {
        int[] raises = new int[lines.length];

        int[][] segments = new int[lines.length - 1][];
        boolean asc = true;
        int last = 1;
        int count = 0;

        for (int i = 1; i < lines.length; i++) {
            if (asc) {
                if (lines[i] < lines[i - 1]) {
                    asc = false;
                    segments[count] = Arrays.copyOfRange(lines, last - 1, i);
                    last = i;
                    count++;
                }
            } else {
                if (lines[i] >= lines[i - 1]) {
                    asc = true;
                    segments[count] = Arrays.copyOfRange(lines, last - 1, i);
                    last = i;
                    count++;
                }
            }
        }
        segments[count] = Arrays.copyOfRange(lines, last - 1, lines.length);
        System.out.println(Arrays.deepToString(segments));

        raises[0] = 1;
        count = 0;
        asc = true;
        for (int[] segment : segments) {
            if (segment != null) {
                if (asc) {
                    for (int i = 1; i < segment.length + 1; i++) {
                        if ((i + count - 2) < 0 || lines[i + count - 1] != lines[i + count - 2]) {
                            raises[i + count - 1] = Math.max(i, raises[i + count - 1]);
                        } else {
                            raises[i + count - 1] = raises[i + count - 2];
                        }
                    }
                    count += segment.length - 1;
                    asc = false;
                } else {
                    for (int i = segment.length; i > 0; i--) {
                        raises[(segment.length - i) + count] = Math.max(i, raises[(segment.length - i) + count]);
                    }
                    count += segment.length - 1;
                    asc = true;
                }
            }
        }
        return raises;
    }

    /**
     * GIVEN A LINKED LIST, REMOVE ALL CONSECUTIVE NODES THAT SUM TO ZERO
     *
     * @param nums Linked list with positive and negative integers
     * @return Linked list with remaining numbers
     */
    public static LinkedList<Integer> removeConsecutiveNumberSumsOfZero(LinkedList<Integer> nums) {
        int sum = 0;
        List<Integer> mark = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                sum += nums.get(j);
                if (sum == 0) {
                    for (int k = i; k <= j && !mark.contains(k); k++) {
                        mark.add(k);
                    }
                }
            }
            sum = 0;
        }
        Collections.reverse(mark);
        for (int i : mark) {
            nums.remove(i);
        }
        return nums;
    }

    /**
     * REVERSE AN INTEGER
     *
     * @param toReverse The integer that is to be reversed
     * @return The reverse of a given integer
     */
    public static int reverseInteger(int toReverse) {
        long result = 0;
        while (toReverse != 0) {
            result = result * 10 + toReverse % 10;
            toReverse /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return (int) result;
    }

    /**
     * FIND MINIMAL AMOUNT OF CLASSROOMS FOR GIVEN ARRAY OF TIME INTERVALS OF COURSES
     *
     * @param timeIntervals The time intervals of courses in random order
     * @return The minimum amount of classrooms needed to hold all courses
     */
    public static int minimumClassrooms(int[][] timeIntervals) {
        Arrays.sort(timeIntervals, Comparator.comparing((int[] interval) -> interval[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int classroomCount = 0;
        for (int[] interval : timeIntervals) {
            if (heap.isEmpty()) {
                classroomCount++;
            } else {
                if (interval[0] >= heap.peek()) {
                    heap.poll();
                } else {
                    classroomCount++;
                }
            }
            heap.offer(interval[1]);
        }
        return classroomCount;
    }

    /**
     * GET THE TRIANGULAR NUMBER (NUMBER OF DOTS) FOR A GIVEN INTEGER.
     *
     * @param n The integer to look up the triangular number of.
     * @return The triangular number (number of dots) for a given n.
     */
    public static int triangleNumber(int n) {
        if (n == 0) return 0;
        int j = 1, k = 1;
        for (int i = 2; i <= n; i++) {
            j++;
            k = k + j;
        }
        return k;
    }

    public static int triangleNumber2(int n) {
        return n * (n + 1) / 2;
    }

    /**
     * GIVEN AN ARRAY OF INTEGERS, FIND HOW MANY TRIPLES SUM TO ZERO
     *
     * @param numbers The array of integers
     * @return The number of triples that sum to zero
     */
    public static int amountOfTriplesThatSumToZero(int[] numbers) {
        int n = numbers.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (numbers[i] + numbers[j] + numbers[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;  // T:O(1/2 * n³), S:O(1)
    }

    public static int amountOfTriplesThatSumToZeroImproved(int[] numbers) {
        int n = numbers.length;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            HashSet<Integer> s = new HashSet<Integer>();
            for (int j = i + 1; j < n; j++) {
                int x = -(numbers[i] + numbers[j]);
                if (s.contains(x)) {
                    count++;
                } else {
                    s.add(numbers[j]);
                }
            }
        }
        return count;  // T:O(n²), S:O(n)
    }

    public static int amountOfTriplesThatSumToZeroSorted(int[] numbers) {
        Arrays.sort(numbers);
        int n = numbers.length;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            int left = i + 1;
            int right = n - 1;
            int x = numbers[i];
            while (left < right) {
                if (x + numbers[left] + numbers[right] == 0) {
                    left++;
                    right--;
                    count++;
                } else if (x + numbers[left] + numbers[right] < 0)
                    left++;
                else
                    right--;
            }
        }
        return count;  // T:O(n²), S:O(1)
    }
}

