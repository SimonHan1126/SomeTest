package word;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;


public class ReadWordDoc {
    /**
     * 读取doc文件内容
     *
     * @param
     * @return 返回文件内容
     * @throws IOException
     */

    private static Map<String, String> subCharacteristicsMap;
    private static Map<String, String> mainCharacteristicsMap;
    private static List<String> listMainCharacteristics;
    private static List<String> listFourViews;

    public static String doc2String(String path) {
        String result = "";
        try {
            OPCPackage opcPackage = POIXMLDocument.openPackage(path);
            POIXMLTextExtractor extractor = null;
            extractor = new XWPFWordExtractor(opcPackage);
            result = extractor.getText();
            extractor.close();
        } catch (XmlException e) {
            e.printStackTrace();
        } catch (OpenXML4JException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void testWord(String filePath){
        try{
            FileInputStream in = new FileInputStream(filePath);//载入文档 //如果是office2007  docx格式
            if(filePath.toLowerCase().endsWith("docx")){
                //word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后
                XWPFDocument xwpf = new XWPFDocument(in);//得到word文档的信息
//             List<XWPFParagraph> listParagraphs = xwpf.getParagraphs();//得到段落信息
                Iterator<XWPFTable> it = xwpf.getTablesIterator();//得到word中的表格

                while(it.hasNext()){

                    XWPFTable table = it.next();
                    List<XWPFTableRow> rows=table.getRows();
                    //读取每一行数据
                    for (int i = 1; i < rows.size(); i++) {
                        XWPFTableRow  row = rows.get(i);
                        //读取每一列数据
                        List<XWPFTableCell> cells = row.getTableCells();
                        for (int j = 0; j < cells.size(); j++) {
                            XWPFTableCell cell=cells.get(j);
                            //输出当前的单元格的数据
                            System.out.println("i " + i + " j " + j + " " + cell.getText());
                        }
                    }
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void init()
    {
        subCharacteristicsMap = new HashMap();
//        mainCharacteristicsMap = new HashMap<>();
        listMainCharacteristics = new ArrayList<>();
        subCharacteristicsMap.put("functional completeness","functional suitability");
        subCharacteristicsMap.put("functional correctness","functional suitability");
        subCharacteristicsMap.put("functional appropriateness","functional suitability");
        listMainCharacteristics.add("functional suitability");

        subCharacteristicsMap.put("time behaviour","performance efficiency");
        subCharacteristicsMap.put("resource utilization","performance efficiency");
        subCharacteristicsMap.put("capacity","performance efficiency");
        listMainCharacteristics.add("performance efficiency");

        subCharacteristicsMap.put("co-existence","compatibility");
        subCharacteristicsMap.put("interoperability","compatibility");
        listMainCharacteristics.add("compatibility");

        subCharacteristicsMap.put("appropriateness recognizability","usability");
        subCharacteristicsMap.put("learnability","usability");
        subCharacteristicsMap.put("operability","usability");
        subCharacteristicsMap.put("user error protection","usability");
        subCharacteristicsMap.put("user interface aesthetics","usability");
        subCharacteristicsMap.put("accessibility","usability");
        listMainCharacteristics.add("usability");

        subCharacteristicsMap.put("maturity","reliability");
        subCharacteristicsMap.put("availability","reliability");
        subCharacteristicsMap.put("fault tolerance","reliability");
        subCharacteristicsMap.put("recoverability","reliability");
        listMainCharacteristics.add("reliability");

        subCharacteristicsMap.put("confidentiality","security");
        subCharacteristicsMap.put("integrity","security");
        subCharacteristicsMap.put("non-repudiation","security");
        subCharacteristicsMap.put("accountability","security");
        subCharacteristicsMap.put("authenticity","security");
        listMainCharacteristics.add("security");

        subCharacteristicsMap.put("modularity","maintainability");
        subCharacteristicsMap.put("reusability","maintainability");
        subCharacteristicsMap.put("analysability","maintainability");
        subCharacteristicsMap.put("modifiability","maintainability");
        subCharacteristicsMap.put("testability","maintainability");
        listMainCharacteristics.add("maintainability");

        subCharacteristicsMap.put("adaptability","portability");
        subCharacteristicsMap.put("installability","portability");
        subCharacteristicsMap.put("replaceability","portability");
        listMainCharacteristics.add("portability");

        listFourViews = new ArrayList<>();
        listFourViews.add("logical view");
        listFourViews.add("development view");
        listFourViews.add("physical view");
        listFourViews.add("process view");
    }

    static class RequirementInfo
    {
        private String mainChar;
        private String subChar;
        private String requirement_code;
        private String view;

        public String getMainChar() {
            return mainChar;
        }

        public void setMainChar(String mainChar) {
            this.mainChar = mainChar;
        }

        public String getSubChar() {
            return subChar;
        }

        public void setSubChar(String subChar) {
            this.subChar = subChar;
        }

        public String getRequirement_code() {
            return requirement_code;
        }

        public void setRequirement_code(String requirement_code) {
            this.requirement_code = requirement_code;
        }

        public String getView() {
            return view;
        }

        public void setView(String view) {
            this.view = view;
        }
    }

    static class NewRequirementInfo
    {
        private String characteristic;
        private int numberOfRequirements;
        private String architecturalView;

        public NewRequirementInfo(String characteristic, int numberOfRequirements, String architecturalView) {
            this.characteristic = characteristic;
            this.numberOfRequirements = numberOfRequirements;
            this.architecturalView = architecturalView;
        }
    }

    private static String captureName(String str) {
        // 进行字母的ascii编码前移，效率要高于截取字符串进行转换的操作
        if(str == null || str.length() <= 0)
        {
            return "";
        }
        char[] cs=str.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }
    // ISO 13485 --> 134       https://drive.google.com/file/d/1Q6DL-Y-VULgELOK-eYH-nCvFzYBmP9hp/view?usp=sharing
    // ISO 14971 --> 44        https://drive.google.com/file/d/1Ee7sKO5fYtWLZzTR-9cZ9VqCEpyqSc-I/view?usp=sharing
    // IEC 62304 --> 127       https://drive.google.com/file/d/11xFXk0Uq0Tfm62CkwGLDX4rQGa_s8LUt/view?usp=sharing
    // ISO 62366 --> 54        https://drive.google.com/file/d/1b6CpCjjRcIKb9Pp8rlGU1uSyjs3rJ5fF/view?usp=sharing
    public static void main(String[] args) {
        String path = "/Users/hanshihui/Documents/AUT/SRAA/team_download/ISO13485.docx";
        init();
        String result = doc2String(path);
//        System.out.println(result);
        Map<String,String> requirementsMap = new HashMap<>();
        String[] stArry = result.split("\n");
        int index = 1;
        for(int i = 0; i < stArry.length; i++)
        {
            String key = "R" + index;
            if(stArry[i].contains(key))
            {
                index++;
                System.out.println(key + " " + stArry[i]);
                requirementsMap.put(key, stArry[i]);
            }
        }
        System.out.println("***********************");
        System.out.println("***********************");
        System.out.println("***********************");
        System.out.println("***********************");

        System.out.println("requirementMap.size() " + requirementsMap.size());
        Gson gson = new Gson();
        Map<String, List<String>> mainStringSubListCharMap = new HashMap<>();
        for (Map.Entry<String, String> entry : subCharacteristicsMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(mainStringSubListCharMap.get(value) == null)
            {
                List<String> list = new ArrayList<>();
                mainStringSubListCharMap.put(value,list);
            }
            List<String> gotList = mainStringSubListCharMap.get(value);
            gotList.add(key);
            mainStringSubListCharMap.put(value, gotList);
        }

        //not architectural
        List<RequirementInfo> requirementList = new ArrayList<>();

        for (Map.Entry<String, String> entry : requirementsMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
//            System.out.println("------" + value);
            boolean is_find = false;
            String targetMainChar = "";
            for(String main_char : listMainCharacteristics)
            {
                if(value.contains(main_char)) {
                    is_find = true;
                    targetMainChar = main_char;
                    break;
                }
            }

            if(!is_find)
            {
                if(value.contains("not architectural"))
                {

                }
                else {

                }
            }
            else
            {
                RequirementInfo requirementInfo = new RequirementInfo();
                requirementInfo.mainChar = targetMainChar;
                requirementInfo.requirement_code = key;
                for(String view : listFourViews)
                {
                    if(value.contains(view))
                    {
                        requirementInfo.view = view;
                        break;
                    }
                }

                for(String subChar : mainStringSubListCharMap.get(targetMainChar))
                {
                    if(value.contains(subChar))
                    {
                        requirementInfo.subChar = subChar;
                        break;
                    }
                }

                requirementList.add(requirementInfo);
            }
        }
        System.out.println("requirementList " + gson.toJson(requirementList));
        System.out.println("requirementList size " + requirementList.size());
        Map<String, RequirementInfo> rMap = new HashMap<>();
        for(int i = 0; i < requirementList.size(); i++)
        {
            RequirementInfo listRInfo = requirementList.get(i);
            String key = listRInfo.mainChar + listRInfo.subChar;
            RequirementInfo mapRInfo = rMap.get(key);
            if(mapRInfo == null) {
                rMap.put(key,listRInfo);
            } else {
                String requirement_code = listRInfo.getRequirement_code();
                mapRInfo.setRequirement_code(mapRInfo.getRequirement_code() + "," + requirement_code);
                rMap.put(key,mapRInfo);
            }
        }
        System.out.println("rMap " + gson.toJson(rMap));
        List<RequirementInfo> finalList = new ArrayList<>();
        Set<String> set = rMap.keySet();
        System.out.println(gson.toJson(set));
        for(String key : set)
        {
            RequirementInfo r = rMap.get(key);
            String codes = r.getRequirement_code();
            String sortedCodes = Sort.sort(codes);
            System.out.println(key + " " + sortedCodes);
            r.setRequirement_code(sortedCodes);
            finalList.add(r);
        }

        System.out.println(gson.toJson(finalList));

        List<Map<String, String>> newFinalList = new ArrayList<>();
        for (int i = 0; i < finalList.size(); i++)
        {
            RequirementInfo r = finalList.get(i);
            String[] codeArray = r.getRequirement_code().split(",");
            String mainChar = captureName(r.getMainChar()) ;
            String subChar = captureName(r.getSubChar());
            if(mainChar.length() < 0 || subChar.length() <= 0) {
                continue;
            }
            else {
                String characteristic = mainChar + "-" + subChar;
                String view = captureName(r.getView());
                String architecturalView = view.substring(0, view.length() - 5);
                Map<String, String> map = new HashMap<>();
                map.put("Characteristic", characteristic);
                map.put("Number of requirements", codeArray.length + "");
                map.put("Architectural view", architecturalView);
                newFinalList.add(map);
            }
        }
        System.out.println("newFinalList " + gson.toJson(newFinalList));
    }
}
