package leetcodeNZ.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanshihui on 17/01/19.
 */
public class Medium_6_zigzag_coversion {
    public String convert(String s, int numRows) {

        if(numRows <= 1)
        {
            return s;
        }

        String resultStr = "";
        char[] cArray = s.toCharArray();
        boolean isVertical = true;
        Map<Integer,String> map = new HashMap<>();
        int key = 0;

        for (int i = 0; i < cArray.length; i++) {
            String itemC = cArray[i] + "";
            map.put(key,map.get(key)==null ? "" + itemC : map.get(key) + itemC);
            if(isVertical)
            {
                if(key >= (numRows - 1))
                {
                    key = numRows - 2;
                    isVertical = false;
                }
                else
                {
                    key++;
                }
            }
            else
            {
                if(key<=0)
                {
                    key = 1;
                    isVertical = true;
                }
                else
                {
                    key--;
                }
            }
        }

        for (int i = 0; i < numRows; i++) {
            resultStr += map.get(i)==null ? "" : map.get(i);
        }

        return resultStr;
    }

    public static void main(String[] args) {
        Medium_6_zigzag_coversion m = new Medium_6_zigzag_coversion();
        System.out.println(m.convert("SUPPORT",2));
//        System.out.println(m.convert("AB",1));
    }
}
