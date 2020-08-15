package leetcode.easy;

public class RemoveDuplicatesFromSortedArray {
	public void pringArray(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}
	
	public int removeDuplicates2(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	            pringArray(nums);
	            System.out.println();
	        }
	    }
	    return i + 1;
	}
	
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length <= 0)
		{
			return 0;
		}
		int arrayLength = nums.length;
		int unDuplicateArrayLength = arrayLength;
		int index = 0;
		for(int i = 0; i < arrayLength - 1;i++)
		{
			if(nums[index] == nums[index + 1])
			{
				
				for(int j = index; j < arrayLength - 1; j++)
				{
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
				unDuplicateArrayLength--;
			}
			else
			{
				index++;
			}
		}
		return unDuplicateArrayLength;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray rDupArray = new RemoveDuplicatesFromSortedArray();
		int array[] = {1,2,2};
		int arrayLength = rDupArray.removeDuplicates2(array);
		System.out.println("arrayLength " + arrayLength);
		for(int i = 0 ; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}
}
