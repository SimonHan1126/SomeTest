package test;

public class MergeTwoListTest {

	public static void main(String[] args) {
		int array[] = {2,4,7,9,33};
		int index = 0;
		int i = 0;
		while(i < 3)
		{
			System.out.println("1111111 i=" + i);
			while(index < array.length){
				if(array[index] > 7)
				{
					System.out.println("++++++++++++++ " + array[index]);
					break;
				}
				System.out.println("=================== " + array[index]);
				index++;
			}
			System.out.println("2222222 i=" + i);
			index = 0;
			i++;
		}
		System.out.println(System.getProperty("sun.boot.class.path"));
		System.out.println("+++++++++");
		System.out.println(System.getProperty("java.ext.dirs"));

	}
}
