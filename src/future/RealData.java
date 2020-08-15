package future;

import java.util.concurrent.Callable;

public class RealData implements Callable<String> {
	
	private String para;
	public RealData(String para) {
		// TODO Auto-generated constructor stub
		this.para = para;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(para);
			Thread.sleep(100);
			
		}
		return sb.toString();
	}

}
