package com.kenzie.twopointer.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Contains a problem that can be solved using the Two-Pointer Technique.
 */
public class ThreeSumUnique {
    /**
     * Given an unsorted integer array nums, where each element is unique, return all the triplets
     * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Example:
     *  nums = [-1,0,1,3,2,-4]
     *  result = [[-4,1,3],[-1,0,1]]
     *
     * @param nums an unsorted integer array where each element is unique.
     * @return all triplets that sum to 0
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        // Sort the array first so that we can discard parts of the problem.
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // Try using each number as a fixed value, then running a two-sum algorithm on the remainder of the array.
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int currentSum = nums[start] + nums[end] + nums[i];
                if (currentSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                } else if (currentSum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;

    }
}
