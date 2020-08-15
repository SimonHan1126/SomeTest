package test;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by hanshihui on 2018/1/19.
 */
public class GsonTest {

    public static void main(String[] args) {
//        Map<String,Serializable> map = new HashMap<>(10);
//        map.put("1000",new Cat("wocaolei","123"));
//        map.put("1001",new Cat("wocaolei111","234"));
//        map.put("1002",new Cat("wocaolei222","12113"));
//        map.put("1003",new Cat("wocaolei333","66666"));
//        map.put("2000",new Dog("111","123"));
//        map.put("2001",new Dog("222","234"));
//        map.put("2002",new Dog("333","12113"));
//        map.put("2003",new Dog("4444","66666"));
//
//        Gson gson = new Gson();
//        String mapStr = gson.toJson(map);
//
//        System.out.println(mapStr);

        float f1 = 4481.75f;
        float f2 = 4481.0f;
        String strFloat1= String.valueOf(f1);
        String strFloat2 = String.valueOf(f2);
        System.out.println(strFloat1 + " " + strFloat2);
        boolean isContain1 = strFloat1.contains(".0");
        boolean isContain2 = strFloat2.contains(".0");
        System.out.println(isContain1 + " " + isContain2);
        if(isContain1)
        {
            System.out.println("this isContain1 is true");
        }

        if(isContain2)
        {
            strFloat2 = String.valueOf((int)f2);
            strFloat2 = String.valueOf(Integer.valueOf(strFloat2));
            System.out.println("this isContain2 is true strFloat2=" + strFloat2);
        }

        String command = "";
        Process process = null;//执行命令
        try {
            process = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStreamReader ir = new InputStreamReader(process.getInputStream());
    }
}

class Cat implements Serializable
{
    private String name;
    private String age;

    public Cat(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

class Dog implements Serializable
{
    private String height;
    private String weight;

    public Dog(String height, String weight) {
        this.height = height;
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
