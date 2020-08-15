package execl;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import net.sf.json.JSONArray;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import net.sf.json.JSONObject;

/**
 * @author hanshihui
 */
public class DisposeData {

    private static final String VIDEO_BEGIN = "1";
    private static final String VIDEO_END = "0";
//    private static final long ONE_HOUR = 3600;

    private static String getContentFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer buffer = new StringBuffer();
        String temp;
        while ((temp = br.readLine()) != null) {
            buffer.append(temp);
        }
        br.close();
        return buffer.toString();
    }

//    @SuppressWarnings("deprecation")
//	private static void genExecel() throws IOException {
//        HSSFWorkbook wb = new HSSFWorkbook();
//        // 鍒涘缓HSSFSheet瀵硅薄
//        HSSFSheet sheet = wb.createSheet("sheet0");
//
//        int roleNo = 0;
//        int rowNo = 0;
//        HSSFRow firstRow = sheet.createRow(roleNo++);
//        String title[]= {"日期","渠道名","新增用户","单次使用时长","次日留存率"};
//        for (int i = 0; i < title.length; i++) {
//
//            HSSFCell cellTitle = firstRow.createCell(rowNo++);
//            cellTitle.setCellValue(title[i]);
//        }
//        rowNo = 0;
//        String contentArr[][] = {
//                {"1/1/18","30007","0"   ,"1:00:58","0%"},
//                {"1/1/18","52025","1030","0:10:28","20.68%"},
//                {"1/1/18","63324","433" ,"0:55:12","64.33%"},
//                {"1/2/18","30007","0"   ,"1:00:58","0%"},
//                {"1/2/18","52025","1030","0:10:28","20.68%"},
//                {"1/2/18","63324","433" ,"0:55:12","64.33%"},
//                {"1/3/18","30007","0"   ,"1:00:58","0%"},
//                {"1/3/18","52025","1030","0:10:28","20.68%"},
//                {"1/3/18","63324","433" ,"0:55:12","64.33%"},
//                {"1/4/18","30007","0"   ,"1:00:58","0%"},
//                {"1/4/18","52025","1030","0:10:28","20.68%"},
//                {"1/4/18","63324","433" ,"0:55:12","64.33%"},
//        };
//        for (int i = 0; i < contentArr.length; i++) {
//            String itemContentArray[] = contentArr[i];
//            HSSFRow row = sheet.createRow(roleNo++);
//            System.out.println("contentArr[" + i + "]");
//            for (int j = 0; j < itemContentArray.length ; j++) {
//                HSSFCell cellAncorId = row.createCell(rowNo++);
//                if(j == 1)
//                {
//                    Date date = new Date(itemContentArray[j]);
//
//                    cellAncorId.setCellValue(date);
//                }
//                else
//                {
//                    cellAncorId.setCellValue(itemContentArray[j]);
//                }
//            }
//            rowNo = 0;
//        }
//
//        FileOutputStream output = new FileOutputStream("/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/execl/channelImport181137.xls");
//        wb.write(output);
//        wb.close();
//        output.flush();
//        output.close();
//    }

    @SuppressWarnings("unchecked")
	private static void jsonToExcel() throws Exception {

        String jsonStr = getContentFromFile("/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/execl/newGenFinalJSON.txt");
        JSONObject jsonPreObject = JSONObject.fromObject(jsonStr);
        JSONObject totalTimeObject = new JSONObject();
        Iterator<String> anchorPreIterator = jsonPreObject.keys();
        while (anchorPreIterator.hasNext()) {
            String anchorId = anchorPreIterator.next();
            JSONObject achorMicroInfo = jsonPreObject.getJSONObject(anchorId);
            System.out.println("anchorId " + anchorId + " achorMicroInfo " + achorMicroInfo.toString());
            long totalTime = 0;
            Iterator<String> dateToTimeIterator = achorMicroInfo.keys();
            while (dateToTimeIterator.hasNext()) {
                String date = dateToTimeIterator.next();
                long secondTime = achorMicroInfo.getLong(date);
                totalTime += secondTime;
            }
            totalTimeObject.put(anchorId, totalTime);
        }
        System.out.println(totalTimeObject.toString());
        // 鍒涘缓HSSFWorkbook瀵硅薄
        HSSFWorkbook wb = new HSSFWorkbook();
        // 鍒涘缓HSSFSheet瀵硅薄
        HSSFSheet sheet = wb.createSheet("sheet0");

        int roleNo = 0;
        int rowNo = 0;
        HSSFRow firstRow = sheet.createRow(roleNo++);
        for (int i = 0; i < 1; i++) {

            HSSFCell cellTitle = firstRow.createCell(rowNo++);
            if (i == 0) {

                cellTitle.setCellValue("主播ID");
            } else {
                cellTitle.setCellValue("12月8日");
            }
        }
        rowNo = 0;
        JSONObject jsonObject = totalTimeObject;
        Iterator<String> anchorIterator = jsonObject.keys();
        while (anchorIterator.hasNext()) {
            String anchorId = anchorIterator.next();

            HSSFRow row = sheet.createRow(roleNo++);
            HSSFCell cellAncorId = row.createCell(rowNo++);
            cellAncorId.setCellValue(anchorId);

            long secondTime = jsonObject.getLong(anchorId);

            HSSFCell itemAnchorTimeCell = row.createCell(1);
            itemAnchorTimeCell.setCellValue(secondTime);

            rowNo = 0;
            System.out.println(rowNo);
        }

        FileOutputStream output = new FileOutputStream("/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/execl/12月8日总麦时精确秒.xls");
        wb.write(output);
        wb.close();
        output.flush();
        output.close();
    }

    private static void fixMicroInfo() throws IOException {
        JSONObject finalJsonObj = new JSONObject();
        String jsonStr = getContentFromFile("/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/execl/anchorMicroInfo171211.txt");
        JSONArray array = JSONArray.fromObject(jsonStr);
        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = array.getJSONObject(i);

            String roomid = obj.getString("roomid");

            System.out.println(roomid + " " + obj.toString());
            if (roomid != null && roomid.length() > 0) {
                JSONArray itemByRoomidArray;
                if (!finalJsonObj.has(roomid)) {
                    System.out.println("not finalJsonObj.has(" + roomid + ")");
                    itemByRoomidArray = new JSONArray();
                    itemByRoomidArray.add(obj);
                    finalJsonObj.put(roomid, itemByRoomidArray);
                } else {
                    System.out.println("finalJsonObj.has(" + roomid + ")");
                    itemByRoomidArray = finalJsonObj.getJSONArray(roomid);
                    itemByRoomidArray.add(obj);
                }

            }
        }

        System.out.println("------");
        System.out.println(finalJsonObj.toString());

        getFinalJSON(finalJsonObj);
    }

    @SuppressWarnings("unchecked")
	private static void getFinalJSON(JSONObject jsonObject) throws IOException {
        JSONObject startTempJson = new JSONObject();
        startTempJson.put("roomid", "");
        startTempJson.put("mictype", "1");
        startTempJson.put("time", "1512729132");
        startTempJson.put("create_time", "");

        JSONObject endTempJson = new JSONObject();
        endTempJson.put("roomid", "");
        endTempJson.put("mictype", "0");
        endTempJson.put("time", "1512739393");
        endTempJson.put("create_time", "");

        Iterator<String> sIterator = jsonObject.keys();
        while (sIterator.hasNext()) {

            String key = sIterator.next();
            JSONArray arrayJson = jsonObject.getJSONArray(key);

            startTempJson.replace("roomid", key);
            endTempJson.replace("roomid", key);

            for (int i = 0; i < (arrayJson.size()); ) {
                JSONObject currentMicroInfo = arrayJson.getJSONObject(i);
                String currentMicType = currentMicroInfo.getString("mictype");
                if (VIDEO_END.equals(currentMicType) && i == 0) {
                    System.out.println("11111 key " + key + " " + arrayJson.size());
                    arrayJson.add(0, startTempJson);
                    System.out.println("22222 key " + key + " " + arrayJson.size());
                }
//                else if (VIDEO_END.equals(currentMicType) && i > 0 && !VIDEO_BEGIN.equals(arrayJson.getJSONObject(i - 1).getString("mictype"))) {
//                    System.out.println("33333 key " + key + " " + arrayJson.size());
//                    arrayJson.add(i, startTempJson);
//                    System.out.println("44444 key " + key + " " + arrayJson.size());
//                } else if (VIDEO_BEGIN.equals(currentMicType) && i < (arrayJson.size() - 1) && !VIDEO_END.equals(arrayJson.getJSONObject(i + 1).getString("mictype"))) {
//                    System.out.println("555555 key " + key + " " + arrayJson.size());
//                    arrayJson.add(i + 1, endTempJson);
//                    System.out.println("666666 key " + key + " " + arrayJson.size());
//                }
                else if (VIDEO_BEGIN.equals(currentMicType) && i == (arrayJson.size() - 1)) {
                    System.out.println("77777 key " + key + " " + arrayJson.size());
                    arrayJson.add(endTempJson);
                    System.out.println("88888 key " + key + " " + arrayJson.size());
                }
                i++;
            }
        }
        System.out.println("FINAL==============================");
        System.out.println(jsonObject.toString());
        BufferedWriter out = new BufferedWriter(new FileWriter("/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/execl/newGenJSON.txt"));
        out.write(jsonObject.toString());
        out.close();
    }

    @SuppressWarnings("unchecked")
	private static void getFinalJSON() throws IOException {

        String jsonStr = getContentFromFile("/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/execl/newGenJSON.txt");
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        JSONObject finalExportJsonObj = new JSONObject();
        Iterator<String> sIterator = jsonObject.keys();
        while (sIterator.hasNext()) {
            String key = sIterator.next();
            JSONArray arrayJson = jsonObject.getJSONArray(key);

            for (int i = 0; i < (arrayJson.size() - 1); ) {
                JSONObject currentMicroInfo = arrayJson.getJSONObject(i);
                JSONObject nextMicroInfo = null;
                String currentMicType = currentMicroInfo.getString("mictype");
                if (!"1".equals(currentMicType)) {
                    i++;
                    continue;
                }
                long currentMicroTime = currentMicroInfo.getLong("time");

                int nextIndex = i++;
//                String nextMicType = arrayJson.getJSONObject(nextIndex).getString("mictype");
                while ("1".equals(arrayJson.getJSONObject(nextIndex).getString("mictype"))) {

                    nextIndex++;
                }

                nextMicroInfo = arrayJson.getJSONObject(nextIndex);

                if (null == nextMicroInfo) {
                    i++;
                    continue;
                }


                long nextMicroTime = nextMicroInfo.getLong("time");

                long currentDuringTime = nextMicroTime - currentMicroTime;
                if (currentDuringTime <= 0) {
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

            for (int i = 0; i < arrayJson.size(); i++) {
                JSONObject currentMicroInfo = arrayJson.getJSONObject(i);
                if (currentMicroInfo.has("microDuringTime")) {
                    System.out.println(currentMicroInfo.toString() + " ------------------ " + i);
                    String dateByDay = currentMicroInfo.getString("dateByDay");
                    JSONArray itemJsonArray;
                    if (dateKeyMicroInfo.containsKey(dateByDay)) {
                        itemJsonArray = dateKeyMicroInfo.getJSONArray(dateByDay);
                        itemJsonArray.add(currentMicroInfo);
                    } else {
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
            while (dateToMicroIterator.hasNext()) {
                // 鑾峰緱key
                long dateMicroTotalTime = 0;
                String dateToMicroKey = dateToMicroIterator.next();
                JSONArray dateToMicroJsonArray = dateKeyMicroInfo.getJSONArray(dateToMicroKey);
                for (int i = 0; i < dateToMicroJsonArray.size(); i++) {
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
        BufferedWriter out = new BufferedWriter(new FileWriter("/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/execl/newGenFinalJSON.txt"));
        out.write(finalExportJsonObj.toString());
        out.close();
    }

    public static void main(String[] args) {
        try {
            fixMicroInfo();
            getFinalJSON();
            jsonToExcel();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

//        try {
//            genExecel();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
