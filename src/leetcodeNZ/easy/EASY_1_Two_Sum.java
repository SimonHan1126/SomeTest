package leetcodeNZ.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanshihui on 16/01/19.
 */
public class EASY_1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length <= 0)
        {
            return new int[0];
        }
        int count = 0;

        for (int item_num : nums)
        {
            target -= item_num;
            count++;
            if(target < 0)
            {
                return new int[0];
            }

            if(target == 0)
            {
                break;
            }
        }

        int[] array = new int[count];
        for (int i = 0; i < count; i++)
        {
            array[i] = nums[i];
        }
        return array;
    }

    public int[] twoSumFirstAccepted(int[] nums, int target) {

        int[] array = new int[2];

        if(nums == null || nums.length <= 0)
        {
            return array;
        }

        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++)
        {
            for (int k = 1; k < numsLength; k++)
            {
                if(i == k)
                {
                    continue;
                }
                if(target == (nums[i] + nums[k]))
                {
                    array[0] = i;
                    array[1] = k;
                    return array;
                }
            }
        }

        return array;
    }

    public int[] twoSumSecondAccepted(int[] nums, int target) {
        int[] array = new int[2];
        if(nums == null || nums.length <= 0)
        {
            return array;
        }
        int numsLength = nums.length;
        int fisrtIndex = 0;
        int secondIndex = 1;
        for (;fisrtIndex < numsLength - 1;)
        {
            if(target == (nums[fisrtIndex] + nums[secondIndex]))
            {
                array[0] = fisrtIndex;
                array[1] = secondIndex;
                return array;
            }
            else
            {
                if(secondIndex >= numsLength - 1)
                {
                    fisrtIndex++;
                    secondIndex = fisrtIndex + 1;
                }
                else
                {
                    secondIndex++;
                }
            }
        }

        return array;
    }

    public int[] twoSumThirdAccepted(int[] nums, int target) {
        int[] solution = new int[2];
        Map<Integer, Integer> sumMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(sumMap.get(nums[i]) != null) {
                solution[0] = sumMap.get(nums[i]);
                solution[1] = i;
                break;
            }
            sumMap.put(target - nums[i], i);
        }
        return solution;
    }

    public static void main(String[] args) {
        EASY_1_Two_Sum e = new EASY_1_Two_Sum();
        int[] localArray =  {2,5,1,1,5};
        int[] resultArray = e.twoSumThirdAccepted(localArray,10);
        for (int itemArray : resultArray)
        {
            System.out.print(itemArray + " ");
        }
    }
}
