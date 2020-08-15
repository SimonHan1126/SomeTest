package execl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DisposeDataReleaseTwo 
{
	
	private static Map<String,String> getWhiteList(String fileName)
	{
		Map<String,String> whiteMap = new HashMap<String,String>();
		
		String temp = "";
		try {
			
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();

			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
			}

			JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
			Iterator<String> sIterator = jsonObject.keys();  
			while(sIterator.hasNext()){  
				
				String key = sIterator.next(); 
				whiteMap.put(key, key);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("loadViewerAndGuardData " + e.toString());
			e.printStackTrace();
		}
		return whiteMap;
	}
	
	private static void detailJSONToRoomJSON(Map<String,String> whiteMap,String fileName)
	{
		String temp = "";
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();

			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
			}

			JSONObject finalJsonObj = new JSONObject();
			JSONArray array = JSONArray.fromObject(buffer.toString());
			for(int i = 0; i < array.size(); i++)
			{
				JSONObject obj = array.getJSONObject(i);
				System.out.println(obj.toString());
				String roomid = obj.getString("roomid");
				if(roomid != null && roomid.length() > 0)
				{
					String targetRoomId = whiteMap.get(roomid);
					//需要过滤白名单时去掉if判断
//					if(targetRoomId != null && targetRoomId.length() > 0)
//					{
						JSONArray itemByRoomidArray = new JSONArray();
						System.out.println(itemByRoomidArray.toString());
						finalJsonObj.put(roomid, itemByRoomidArray);
//					}
				}
			}

			for(int i = 0; i < array.size(); i++)
			{
				JSONObject obj = array.getJSONObject(i);
				System.out.println(obj.toString());
				String roomid = obj.getString("roomid");
				if(roomid != null && roomid.length() > 0 && finalJsonObj.containsKey(roomid))
				{
					JSONArray itemByRoomidArray = finalJsonObj.getJSONArray(roomid);			
					itemByRoomidArray.add(obj);
				}
			}
			
//			Iterator<String> finalIterator = finalJsonObj.keys();  
//			while(finalIterator.hasNext()){  
//			    // 鑾峰緱key  
//				long dateMicroTotalTime = 0;
//			    String key = finalIterator.next();  
//			    JSONArray itemByRoomidArray = finalJsonObj.getJSONArray(roomid);			
//				itemByRoomidArray.add(obj);
//			} 
			
			
			System.out.println("+++++++++++++++++++++++++++++++++++");
//			System.out.println(finalJsonObj.toString());
			BufferedWriter out=new BufferedWriter(new FileWriter("/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/execl/newGenJSON.txt"));
			out.write(finalJsonObj.toString());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void getFinalJSON()
	{
		String temp = "";
		try {
			
			File file = new File("/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/execl/newGenJSON.txt");
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();

			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
			}

			long ONE_HOUR = 3600;
			JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
			JSONObject finalExportJsonObj = new JSONObject();
			Iterator<String> sIterator = jsonObject.keys();  
			while(sIterator.hasNext()){  
//			     鑾峰緱key  
//				String str = jsonObject.getString("21061790");
//				System.out.println(str);
//				
//				JSONArray arrayJson = jsonObject.getJSONArray("21061790");
				
				String key = sIterator.next();  
			    JSONArray arrayJson = jsonObject.getJSONArray(key);
			    
			    int jsonObjectSize = arrayJson.size();
			    if(jsonObjectSize > 0)
			    {
			    	JSONObject lastMicroInfo = arrayJson.getJSONObject(0);
			    	String lastMicType = lastMicroInfo.getString("mictype");
			    	if("1".equals(lastMicType))
				    {
				    	JSONObject lastJObj = new JSONObject();
//				    	"id": "4369359",
//			            "roomid": "14997",
//			            "message": "down mic",
//			            "adddate": "2018-03-22 01:59:53",
//			            "datelong": "1521655193",
//			            "mictype": "0"
				    	lastJObj.put("id", lastMicroInfo.get("id"));
				    	lastJObj.put("roomid", lastMicroInfo.get("roomid"));
				    	lastJObj.put("message", lastMicroInfo.get("message"));
				    	lastJObj.put("adddate", lastMicroInfo.get("adddate"));
				    	lastJObj.put("datelong", 1521665100);
				    	lastJObj.put("mictype", 0);
				    	arrayJson.add(lastJObj);
				    }
			    	System.out.println("####" + arrayJson.toString());
			    }
			    
			    
			    JSONObject firstMicroInfo = arrayJson.getJSONObject(0);
			    String firstMicType = firstMicroInfo.getString("mictype");
			    if("0".equals(firstMicType))
			    {
			    	JSONObject firstJObj = new JSONObject();
//			    	"id": "4369359",
//		            "roomid": "14997",
//		            "message": "down mic",
//		            "adddate": "2018-03-22 01:59:53",
//		            "datelong": "1521655193",
//		            "mictype": "0"
			    	firstJObj.put("id", firstMicroInfo.get("id"));
			    	firstJObj.put("roomid", firstMicroInfo.get("roomid"));
			    	firstJObj.put("message", firstMicroInfo.get("message"));
			    	firstJObj.put("adddate", firstMicroInfo.get("adddate"));
			    	firstJObj.put("datelong", 1521651600L);
			    	firstJObj.put("mictype", 1);
			    	arrayJson.add(0, firstJObj);
			    }
				
				for(int i = 0; i < (arrayJson.size() - 1);)
				{
					JSONObject currentMicroInfo = arrayJson.getJSONObject(i);
					JSONObject nextMicroInfo = null;
					String currentMicType = currentMicroInfo.getString("mictype");
					
					if(!"1".equals(currentMicType))
					{
						i++;
						continue;
					}
					long currentMicroTime = currentMicroInfo.getLong("datelong");
					
					int nextIndex = i++;
					String nextMicType = arrayJson.getJSONObject(nextIndex).getString("mictype");
					while("1".equals(arrayJson.getJSONObject(nextIndex).getString("mictype")))
					{
						
						nextIndex++;
					}
					
					nextMicroInfo = arrayJson.getJSONObject(nextIndex);
					
					if(null == nextMicroInfo)
					{
						i++;
						continue;
					}
					
					
					long nextMicroTime = nextMicroInfo.getLong("datelong");
					
					long currentDuringTime = nextMicroTime - currentMicroTime;
					if(currentDuringTime <= 0)
					{
						i++;
						continue;
					}

					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					currentMicroTime *= 1000L;
			        Date date = new Date(currentMicroTime);
					currentMicroInfo.put("microDuringTime", currentDuringTime);
					currentMicroInfo.put("dateByDay", simpleDateFormat.format(date));
					
					i = nextIndex;
				}
				
				JSONObject dateKeyMicroInfo = new JSONObject();
				
				for(int i = 0; i < arrayJson.size(); i++)
				{
					JSONObject currentMicroInfo = arrayJson.getJSONObject(i);
					if(currentMicroInfo.has("microDuringTime"))
					{
						System.out.println(currentMicroInfo.toString() + " ------------------ " + i);
						String dateByDay = currentMicroInfo.getString("dateByDay");
						JSONArray itemJsonArray;
						if(dateKeyMicroInfo.containsKey(dateByDay))
						{
							itemJsonArray = dateKeyMicroInfo.getJSONArray(dateByDay);
							itemJsonArray.add(currentMicroInfo);
						}
						else
						{
							itemJsonArray = new JSONArray();
							itemJsonArray.add(currentMicroInfo);
							dateKeyMicroInfo.put(dateByDay, itemJsonArray);
						}
						
					}
				}
				System.out.println("+++++++++++++++++++++++++++++++" + key);
				System.out.println(dateKeyMicroInfo.toString());
				
				JSONObject dateToMicroTimeJson = new JSONObject();
				Iterator<String> dateToMicroIterator = dateKeyMicroInfo.keys();  
				while(dateToMicroIterator.hasNext()){  
				    // 鑾峰緱key  
					long dateMicroTotalTime = 0;
				    String dateToMicroKey = dateToMicroIterator.next();  
				    JSONArray dateToMicroJsonArray = dateKeyMicroInfo.getJSONArray(dateToMicroKey);
				    for(int i = 0; i < dateToMicroJsonArray.size(); i++)
				    {
				    	JSONObject dateMicroItemJsonObj = dateToMicroJsonArray.getJSONObject(i);
				    	long itemMicroDuringTime = dateMicroItemJsonObj.getLong("microDuringTime");
				    	dateMicroTotalTime += itemMicroDuringTime;
				    }
				    
				    dateToMicroTimeJson.put(dateToMicroKey, dateMicroTotalTime);
				} 
				
				System.out.println(dateToMicroTimeJson.toString());
				finalExportJsonObj.put(key, dateToMicroTimeJson);
			} 
			System.out.println("FINAL==============================");
			System.out.println(finalExportJsonObj.toString());
			BufferedWriter out=new BufferedWriter(new FileWriter("/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/execl/newGenFinalJSON.txt"));
			out.write(finalExportJsonObj.toString());
			out.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("loadViewerAndGuardData " + e.toString());
			e.printStackTrace();
		}
	}
	
	public static void jsonToExcel() throws Exception {
		String temp = "";
		try {

			File file = new File("/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/execl/newGenFinalJSON.txt");
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();

			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
			}

			// 鍒涘缓HSSFWorkbook瀵硅薄
			HSSFWorkbook wb = new HSSFWorkbook();
			// 鍒涘缓HSSFSheet瀵硅薄
			HSSFSheet sheet = wb.createSheet("sheet0");

			int roleNo = 0;
			int rowNo = 0;
			HSSFRow firstRow = sheet.createRow(roleNo++);
			for(int i = 0; i < 29; i++)
			{
				
				HSSFCell cellTitle = firstRow.createCell(rowNo++);
				if(i == 0)
				{
					
					cellTitle.setCellValue("主播ID");
				}
				else
				{
					cellTitle.setCellValue("2018年3月" + (i + 0) + "日");
				}
			}
			rowNo = 0;
			JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
			long ONE_HOUR = 3600;
			Iterator<String> anchorIterator = jsonObject.keys();
			while (anchorIterator.hasNext()) {
				String anchorId = anchorIterator.next();
				JSONObject achorMicroInfo = jsonObject.getJSONObject(anchorId);
				System.out.println("anchorId " + anchorId + " achorMicroInfo " + achorMicroInfo.toString());

				HSSFRow row = sheet.createRow(roleNo++);
				HSSFCell cellAncorId = row.createCell(rowNo++);
				cellAncorId.setCellValue(anchorId);

				Iterator<String> dateToTimeIterator = achorMicroInfo.keys();
				while (dateToTimeIterator.hasNext()) {
					String date = dateToTimeIterator.next();
					long secondTime = achorMicroInfo.getLong(date);
					long minuteTime = secondTime / 60;
//					long hourTime = secondTime;
					
					String rowNoStr = date.substring(date.length()-2,date.length());
				        
				    rowNo = Integer.valueOf(rowNoStr) - 0;
					
					HSSFCell itemAnchorTimeCell = row.createCell(rowNo);
					itemAnchorTimeCell.setCellValue(minuteTime);
					System.out.println("date " + date + " secondTime " + secondTime + " minuteTime " + minuteTime + " rowNo " + rowNo);
				}
				rowNo = 0;
				System.out.println(rowNo);
			}
			
			FileOutputStream output = new FileOutputStream("/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/execl/20180322麦时精到分钟.xls");
			wb.write(output);
			wb.close();
			output.flush();
			output.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("loadViewerAndGurdData " + e.toString());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
//		Map<String,String> whiteMap = getWhiteList("/Users/hanshihui/Desktop/code/ZZZnewGenJson.txt");
//		System.out.println(whiteMap.toString());
//		System.out.println("list.size " + whiteMap.size());
		Map<String,String> whiteMap = new HashMap<>();
		detailJSONToRoomJSON(whiteMap,"/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/execl/anchorMicroInfo180322.txt");
		getFinalJSON();
		try {
			jsonToExcel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
