package leetcodeNZ.hard;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by hanshihui on 26/08/19.
 */
public class HARD_140_Word_Break_II {

//    public List<String> wordBreak2(String s, List<String> wordDict) {
//        List<String> resultList = new ArrayList<>();
//
//        if(wordDict == null || wordDict.size() <= 0)
//        {
//            return resultList;
//        }
//
//        for(int i = 0; i < wordDict.size(); i++)
//        {
//            String itemResult = "";
//            String copiedString = s;
//            for(String itemWord : wordDict)
//            {
//                int index = copiedString.indexOf(itemWord);
//                if(index > -1)
//                {
////                    System.out.println("index " + index);
//                    String frontSubStr = "";
//                    if(index > 0)
//                    {
//                        frontSubStr = copiedString.substring(0, index);
//                    }
////                    System.out.println("index " + index + " itemWord " + itemWord + " " + copiedString);
//                    String backSubStr = copiedString.substring(index + itemWord.length(), copiedString.length());
////                    System.out.println("**************************** frontSubStr " + frontSubStr + " backSubStr " + backSubStr);
//                    copiedString = frontSubStr + backSubStr;
//                    itemResult += " " + itemWord;
////                    System.out.println(copiedString + " **** " + itemResult);
//                    if(copiedString.length() <= 0)
//                    {
//                        break;
//                    }
//                }
//            }
//
//            if(copiedString.length() <= 0)
//            {
//                resultList.add(itemResult);
//            }
//
//            wordDict.add(wordDict.remove(0));
//        }
//
//        return resultList;
//    }

    public boolean isStringContainKeywords(String content, Map<String, Integer> map)
    {
        boolean b = true;
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if(content.indexOf(entry.getKey()) > -1)
            {
                return false;
            }
        }
        return b;
    }


    public List<String> wordBreak3(String s, List<String> wordDict) {
        List<String> resultList = new ArrayList<>();

        if(wordDict == null || wordDict.size() <= 0)
        {
            return resultList;
        }

        Map<String,Integer> mapWordDict = new HashMap<String,Integer>();

        for(String itemWordDict : wordDict)
        {
            if(s.indexOf(itemWordDict) > -1)
            {
                mapWordDict.put(itemWordDict, 1);
            }
        }

//        while (isAllKeyWordBeFound(mapWordDict))
//        {
//            String itemResult = "";
//            String copiedString = s;
//            Iterator<Map.Entry<String, Integer>> iterator = mapWordDict.entrySet().iterator();
//            while (iterator.hasNext()) {
//                Map.Entry<String, Integer> entry = iterator.next();
//                String key = entry.getKey();
//                int index = copiedString.indexOf(key);
//                if(index > -1)
//                {
//                    String frontSubStr = "";
//                    if(index > 0)
//                    {
//                        frontSubStr = copiedString.substring(0, index);
//                    }
//                    String backSubStr = copiedString.substring(index + itemWord.length(), copiedString.length());
//                    copiedString = frontSubStr + backSubStr;
//                    itemResult += " " + itemWord;
//
//                    if(copiedString.length() <= 0)
//                    {
//                        break;
//                    }
//                }
//            }
//        }

//        for(int i = 0; i < wordDict.size(); i++)
//        {
//            String itemResult = "";
//            String copiedString = s;
//            for(String itemWord : wordDict)
//            {
//                int index = copiedString.indexOf(itemWord);
//                if(index > -1)
//                {
//                    String frontSubStr = "";
//                    if(index > 0)
//                    {
//                        frontSubStr = copiedString.substring(0, index);
//                    }
//                    String backSubStr = copiedString.substring(index + itemWord.length(), copiedString.length());
//                    copiedString = frontSubStr + backSubStr;
//                    itemResult += " " + itemWord;
//
//                    if(copiedString.length() <= 0)
//                    {
//                        break;
//                    }
//                }
//            }
//
//            if(copiedString.length() <= 0)
//            {
//                resultList.add(itemResult);
//            }
//
//            wordDict.add(wordDict.remove(0));
//        }

        return resultList;
    }

    public boolean isAllKeyWordBeFound(Map<String, Integer> map)
    {
        boolean b = true;
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if(entry.getValue() > -1)
            {
                return false;
            }
        }
        return b;
    }

    private List<String> wordBreak4(String content, List<String> wordDictList)
    {
        List<String> resultList = new ArrayList<String>();

        if(content.length() <= 0 || wordDictList.size() <= 0)
        {
            return resultList;
        }

        Map<String, Integer> mapWordDict = new HashMap<String, Integer>();

        for (String itemWordDict : wordDictList)
        {
            mapWordDict.put(itemWordDict, content.indexOf(itemWordDict));
        }

        while (isAllKeyWordBeFound(mapWordDict))
        {
            String copiedContent = content;
            for(int i = 0; i < copiedContent.length();)
            {

            }
        }

        return resultList;
    }


    public static void main(String[] args) {
        HARD_140_Word_Break_II hard = new HARD_140_Word_Break_II();
        String[] strArrOne = {"cat", "cats", "and", "sand", "dog"};
        String[] strArrTwo = {"apple", "pen", "applepen", "pine", "pineapple"};
        String[] strArrThree = {"cats", "dog", "sand", "and", "cat"};
        List<String> listOne   = new ArrayList<String>(Arrays.asList(strArrOne));
        List<String> listTwo   = new ArrayList<String>(Arrays.asList(strArrTwo));
        List<String> listThree = new ArrayList<String>(Arrays.asList(strArrThree));
        String str1 = "catsanddog";
        String str2 = "pineapplepenapple";
        String str3 = "catsandog";



//        System.out.println(hard.wordBreak3(str1, listOne));
//        System.out.println(hard.wordBreak3(str2, listTwo);
//        System.out.println(hard.wordBreak3(str3, listThree);

        for(String itemWordDict : listTwo)
        {
            System.out.println(itemWordDict + " " + itemWordDict.length() + " " + str2.indexOf(itemWordDict));
        }
    }
}
