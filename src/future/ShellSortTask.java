package future;

import java.util.concurrent.CountDownLatch;

public class ShellSortTask implements Runnable {
	
	int i =0;
	int h =0;
	CountDownLatch l;
	
	public ShellSortTask(int i, int h, CountDownLatch latch) {
		// TODO Auto-generated constructor stub
		this.i = i;
		this.h = h;
		this.l = latch;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		if(arr[i] , arr[i - h])
//		{
//			
//		}
	}

}
