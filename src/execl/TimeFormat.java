package execl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class TimeFormat {
	public static void main(String[] args) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		long lt = Long.valueOf("1509534257") * 1000L;
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		System.out.println(res);

		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd
		// HH:mm:ss");
		// Long time=new Long(445555555);
		// String d = format.format(time);
		// Date date;
		// try {
		// date = format.parse(d);
		// System.out.println("Format To String(Date):"+d);
		// System.out.println("Format To Date:"+date);
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

//		String time = "02";
		// int value = Integer.valueOf(time);
		String kkkk = "2017-11-05";
		String iiii = kkkk.substring(kkkk.length() - 2, kkkk.length());
		System.out.println(iiii);

//		int value = Integer.valueOf(iiii);
//		System.out.println(value);

//		Integer i = new Integer(1);
//		int sldkfj = Integer.MAX_VALUE;
//		char value[] = {'1','2'};
//		value = "".value;
//		System.out.println("".value);
		
//		boolean b1 = (0.99999999f==1f); //true 
//		boolean b1 = (0.999999998f==1f); //true
//		boolean b2 = (0.9f==1f); //false
//		System.out.println(b1 + " " + b2);
		
		HashMap<String, String> map = new HashMap<>();
		map.put("11", "22");
	}
}
