package leetcodeNZ.tags.topInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class TIQ_118_Pascal_s_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> mainList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> subList = new ArrayList<>();
            if (i == 0) {}
            else if (i == 1)  subList.add(1);
            else {
                List<Integer> previousSubList = mainList.get(i - 1);
                for (int j = 0; j < previousSubList.size(); j++) {
                    if (j == 0) subList.add(1);
                    else subList.add(previousSubList.get(j - 1) + previousSubList.get(j));
                }
            }
            subList.add(1);
            mainList.add(subList);
        }
        return mainList;
    }

    public static void main(String[] args) {
        TIQ_118_Pascal_s_Triangle object = new TIQ_118_Pascal_s_Triangle();
        for (int i = 1; i <= 30 ; i++) {
            System.out.println(object.generate(i));
        }
    }
}

