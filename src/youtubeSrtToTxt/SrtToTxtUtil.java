package youtubeSrtToTxt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanshihui on 2018/4/20.
 */
public class SrtToTxtUtil {

    private static final String DS_STORE_FILE = ".DS_Store";

    public static List<String> srtFiles(String path)
    {
        List<String> list = new ArrayList<>();
        File file = new File(path);
        File fileArray[] = file.listFiles();
        for (File itemFile : fileArray)
        {
            String itemFileName = itemFile.getName() == null ? "" : itemFile.getName();
            if(DS_STORE_FILE.equals(itemFileName) || itemFileName.length() <= 0 || itemFile.isDirectory())
            {
                System.out.println("i am " + DS_STORE_FILE);
                continue;
            }
            System.out.println(itemFile.getName());
            list.add(itemFileName);
        }
        return list;
    }

    public static String srtFileToString(String fileName)
    {
        String temp = "";
        StringBuffer buffer = new StringBuffer();
        try {

            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            int index = 0;
            while ((temp = br.readLine()) != null) {
                if(index % 4 == 2)
                {
                    if(temp != null && temp.length() > 0)
                    {
                        buffer.append(temp.trim() + " ");
                    }
                }
                System.out.println(temp + " " + index);
                index ++;
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("srtFileToString " + e.toString());
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static void WriteStringToFile(String outputPath,String fileName,String content) {
        try {
            String newFilePath = outputPath + "/" + fileName;
            System.out.println(newFilePath);
            newFilePath = newFilePath.replace(".srt",".txt");
            FileOutputStream writerStream = new FileOutputStream(newFilePath);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(writerStream, "UTF-8"));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void convertFilesToTxt(String inputPath,String outputPath,List<String> srtFileNamesList)
    {
        if(srtFileNamesList == null || srtFileNamesList.size() <= 0)
        {
            return;
        }

        for(String fileName : srtFileNamesList)
        {
            String absoluteFilePath = inputPath + "/" + fileName;
            String srtContent = srtFileToString(absoluteFilePath);
//            System.out.println(srtContent);
            WriteStringToFile(outputPath,fileName,srtContent);
        }
    }

    public static void main(String[] args) {
        //MDIyNTE2Njc4NC0zNSUyMFNhbGFtYW5jYSUyMFJvYWQlMkNTdW5ueW5vb2slMkNBdWNrbGFuZCUyMDA2MjA=
        String inputPath = "/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/youtubeSrtToTxt/youtubeSrtFile";
        String outputPath = "/Users/hanshihui/Documents/UYI_PROJECT/talentweb/SomeTest/src/youtubeSrtToTxt/youtubeTxtFile";
        List<String> srtFileNamesList = srtFiles(inputPath);
        convertFilesToTxt(inputPath,outputPath,srtFileNamesList);
    }
}
