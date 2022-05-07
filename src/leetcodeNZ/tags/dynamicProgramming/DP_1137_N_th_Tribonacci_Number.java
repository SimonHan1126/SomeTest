package leetcodeNZ.tags.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class DP_1137_N_th_Tribonacci_Number {
    private Map<Integer, Integer> resultMap;
    public int tribonacci(int n) {
        if (resultMap == null) resultMap = new HashMap<>();
        if (resultMap.containsKey(n)) return resultMap.get(n);
        if (n == 0 || n == 1) {
            resultMap.put(n, n);
            return n;
        }
        if (n == 2) {
            resultMap.put(n, 1);
            return 1;
        }
        int result = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        resultMap.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        DP_1137_N_th_Tribonacci_Number obj = new DP_1137_N_th_Tribonacci_Number();
        for (int i = 0; i < 38; i++) {
            System.out.println(i + "====>>> " +obj.tribonacci(i));
        }
    }
}
