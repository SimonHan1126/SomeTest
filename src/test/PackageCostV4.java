package test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Simon-the-coder
 * @date 9/11/20 10:32 pm
 */
public class PackageCostV4 {

    // Package Type
    private static final int SMALL_PACKAGE = 0;
    private static final int MEDIUM_PACKAGE = 1;
    private static final int LARGE_PACKAGE = 2;
    private static final int INVALID_PACKAGE = -10;

    private static final int AMOUNT_OF_NUMBER_SHOULD_BE_INPUTTED = 4;

    // Error message
    private static final String INVALID_INPUT = "Please enter 2-digit decimal number";
    private static final String INSUFFICIENT_INPUT = "Please enter 4 2-digit decimal numbers";
    private static final String INPUTTED_MORE_THAN_4_NUMBER = "Please don't enter more than 4 numbers";

    private static final String FIRST_OUTPUT_TO_USER = "Please input Length, Breadth, Height and Weight：";

    private static final String SPACE = " ";

    private static Map<String, Double> mapDimensionToLimitValue;
    private static Map<Integer, String> mapCost;

    private static List<String> listDimension;

    private static String[] prepareInputtedData() {
        System.out.println(FIRST_OUTPUT_TO_USER);
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strIn = str.trim().split(SPACE);

        int amountOfInputtedArguments = strIn.length;
        if (amountOfInputtedArguments < AMOUNT_OF_NUMBER_SHOULD_BE_INPUTTED) {
            System.out.println(INSUFFICIENT_INPUT);
            return null;
        }

        if (amountOfInputtedArguments > AMOUNT_OF_NUMBER_SHOULD_BE_INPUTTED) {
            System.out.println(INPUTTED_MORE_THAN_4_NUMBER);
            return null;
        }

        return strIn;
    }

    public static void main(String[] args) {

        String[] inputtedData = prepareInputtedData();

        if (inputtedData == null) {
            return;
        }

        int indexOfLastInputtedNumber = inputtedData.length - 1;

        double[] dimensionsArray = new double[3];

        double weight = new Double(inputtedData[indexOfLastInputtedNumber]);

        for (int i = 0; i < dimensionsArray.length; i++) {
            if (!isDouble(inputtedData[i])) {
                System.out.println(INVALID_INPUT);
                return;
            }
            dimensionsArray[i] = new Double(inputtedData[i]);
        }

        initSolutionData();
        PackageCostV4 pc = new PackageCostV4();
        System.out.println(pc.packageCost(dimensionsArray, weight));
    }

    private static void initSolutionData() {
        mapCost = new HashMap<>();
        mapCost.put(SMALL_PACKAGE, "$5.00");
        mapCost.put(MEDIUM_PACKAGE, "$7.50");
        mapCost.put(LARGE_PACKAGE, "$8.50");
        mapCost.put(INVALID_PACKAGE, "No solution");

        listDimension = new ArrayList<>();
        listDimension.add("LENGTH");
        listDimension.add("BREADTH");
        listDimension.add("HEIGHT");

        double[][] dimensionValues = {
            {200.00, 300.00, 150.00}, // Small Length Breadth Height
            {300.00, 400.00, 200.00}, // Medium Length Breadth Height
            {400.00, 600.00, 250.00}  // Large Length Breadth Height
        };

        mapDimensionToLimitValue = new HashMap<>();

        for (int i = 0; i < dimensionValues.length; i++) {
            double[] curDimension = dimensionValues[i];
            for (int j = 0; j < listDimension.size(); j++) {
                mapDimensionToLimitValue.put(i + listDimension.get(j), curDimension[j]);
            }
        }
    }

    private static boolean isDouble(String input) {
        Pattern pattern= Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // Determine the regular expression for a 2-digit decimal number
        Matcher match = pattern.matcher(input);
        return match.matches();
    }

    private int packageTypeByDimension(double dimensionValue, String suffix) {
        double smallPackageDimensionLimit = mapDimensionToLimitValue.get(SMALL_PACKAGE + suffix);
        double mediumPackageDimensionLimit = mapDimensionToLimitValue.get(MEDIUM_PACKAGE + suffix);
        double largePackageDimensionLimit = mapDimensionToLimitValue.get(LARGE_PACKAGE + suffix);
        if (dimensionValue > 0 && dimensionValue <= smallPackageDimensionLimit) {
            return SMALL_PACKAGE;
        } else if (dimensionValue > smallPackageDimensionLimit && dimensionValue <= mediumPackageDimensionLimit) {
            return MEDIUM_PACKAGE;
        } else if (dimensionValue >= mediumPackageDimensionLimit && dimensionValue <= largePackageDimensionLimit) {
            return LARGE_PACKAGE;
        } else {
            return INVALID_PACKAGE;
        }
    }

    private int checkPackageType(double[] inputtedDimension) {

        int sum = 0;
        for(int i = 0; i < listDimension.size(); i++) {
            int typeByDimension = packageTypeByDimension(inputtedDimension[i], listDimension.get(i));
            if (typeByDimension < 0) {
                return INVALID_PACKAGE;
            }
            sum += typeByDimension;
        }

        if (sum == 0) {
            return SMALL_PACKAGE;
        } else if (sum > 0 && sum <= 3) {
            return MEDIUM_PACKAGE;
        } else {
            return LARGE_PACKAGE;
        }
    }

    /*
        dimension[]: index 0 -> length, index 1 -> breadth, index 2 -> height
     */
    private String packageCost(double inputtedDimensions[], double weight) {
        double MAX_WEIGHT = 25.00;
        if (weight > MAX_WEIGHT) {
            return mapCost.get(INVALID_PACKAGE);
        }
        int packageType = checkPackageType(inputtedDimensions);
        return mapCost.get(packageType);
    }
}
