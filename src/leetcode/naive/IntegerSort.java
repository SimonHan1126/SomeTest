package leetcode.naive;

public class IntegerSort {
	public void printArray(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}
	
	public int[] sortIntegers(int[] A) {
        // write your code here
		if(A.length <= 1)
		{
			return A;
		}
		int index = 0;
		int temp = 0;
		int minNum = 0;
		for(int i = 0; i < A.length; i++)
		{
			minNum = A[i];
			for(int j = i; j < A.length; j++)
			{
				if(minNum > A[j])
				{
					minNum = A[j];
					index = j;
				}
			}
			
			if(minNum != A[i])
			{
				temp = A[i];
				A[i] = A[index];
				A[index] = temp;
			}
		}
		return A;
    }
	public static void main(String[] args) {
		IntegerSort is = new IntegerSort();
		int[] oldArray = {5,1,8,3,6,9,2};
//		int[] newArray = is.sortIntegers(oldArray);
		is.printArray(oldArray);
	}
}
