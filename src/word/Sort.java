package word;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static String sort(String str)
    {
        String rCodeArr[] = str.split(",");
        List<Integer> codeNumberList = new ArrayList<>();
        for(String code : rCodeArr)
        {
            code = code.replace("R","");
            codeNumberList.add(new Integer(code));
        }

        String result = "";
        for (int loopCount = 0; loopCount < codeNumberList.size() - 1; loopCount++)
        {
            int minNumIndex = 0;
            int minNum = codeNumberList.get(loopCount);
            boolean isFind = false;
            for(int i = loopCount; i < codeNumberList.size(); i++)
            {
                int curNum = codeNumberList.get(i);
                if(curNum < minNum)
                {
                    minNum = curNum;
                    minNumIndex = i;
                    isFind = true;
                }
            }
            if(isFind)
            {
                int temp = codeNumberList.get(loopCount);
                codeNumberList.set(minNumIndex, temp);
                codeNumberList.set(loopCount, minNum);
            }
        }
        for(int i : codeNumberList)
        {
            result += "R" + i + ",";
        }
        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        String str = "R23,R25,R24,R27,R26,R28,R1,R2,R3,R4,R7,R8,R9,R30,R31,R34,R36,R35,R37,R39,R42,R45,R44,R47,R46,R49,R48,R50,R52,R51,R10,R54,R53,R12,R11,R14,R13,R16,R15,R18,R17";
        sort(str);
    }
}
