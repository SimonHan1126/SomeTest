package execl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanshihui on 2017/12/25.
 */
public class CalCount {

    public static void main(String[] args) throws IOException {

        String temp;
        File file = new File("/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/execl/getCount.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer buffer = new StringBuffer();

        while ((temp = br.readLine()) != null) {
            buffer.append(temp);
        }

        JSONArray jsonArray = JSONArray.fromObject(buffer.toString());
        double totalCount = 21462367.79;
        List<Double> list = new ArrayList<Double>();
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        nf.setGroupingUsed(false);

        for (int i = 0; i < jsonArray.size() - 1; i++) {
            JSONObject jsonObjct = jsonArray.getJSONObject(i);
//            double itemCount = jsonObjct.getDouble("1071000");
//            System.out.print((i + 1) + " " + nf.format(itemCount) + " + " + nf.format(totalCount));
//            totalCount += itemCount;
//            System.out.print(" = " + nf.format(totalCount));
//            System.out.println();
            list.add(jsonObjct.getDouble("1071000"));
        }

    }
}
