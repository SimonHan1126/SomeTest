package leetcode.easy;

public class RemoveElement {
	public void pringArray(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}
	
	public int removeElement(int[] nums, int val) {
		if(nums == null || nums.length <= 0)
		{
			return 0;
		}
		int arrayLength = nums.length;
		int unDuplicateArrayLength = arrayLength;
		int index = 0;
		for(int i = 0; i < arrayLength;i++)
		{
			if(nums[index] == val)
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
		RemoveElement rDupArray = new RemoveElement();
		int array[] = {1};
		int arrayLength = rDupArray.removeElement(array,1);
		System.out.println("arrayLength " + arrayLength);
		for(int i = 0 ; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}
}
