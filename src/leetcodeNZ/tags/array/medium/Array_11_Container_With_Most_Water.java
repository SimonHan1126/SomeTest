package leetcodeNZ.tags.array.medium;

public class Array_11_Container_With_Most_Water {


//    System.out.println("i " + i + " j " + j + " areaHeight " + areaHeight + " areaWidth " + areaWidth + " area " + area);

//    public int maxArea(int[] height) {
//        int maxArea = 0;
//        for (int i = height.length - 1; i > 0 ; i--) {
//            for (int j = 0; j < i; j++) {
//                int areaHeight = Math.min(height[i], height[j]);
//                int areaWidth = i - j;
//                int area = areaHeight * areaWidth;
//                if (area > maxArea) maxArea = area;
//            }
//        }
//        return maxArea;
//    }

    public int maxArea(int[] height) {
        int maxArea = 0;
//        for (int i = height.length - 1; i > 0 ; i--) {
//            for (int j = 0; j < i; j++) {
//                int areaHeight = Math.min(height[i], height[j]);
//                int areaWidth = i - j;
//                int area = areaHeight * areaWidth;
//                if (area > maxArea) maxArea = area;
//            }
//        }
        for (int i = 0; i < height.length; i++) {

        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
//        int[] height = {1,1};
        Array_11_Container_With_Most_Water object = new Array_11_Container_With_Most_Water();
        System.out.println(object.maxArea(height));
    }
}
