package test;

public class ClassLoderTest {
	public static void main(String[] args) {
        // TODO Auto-generated method stub

        ClassLoader cl = Test.class.getClassLoader();

        System.out.println("ClassLoader is:"+cl.toString());
        System.out.println("Parent ClassLoader is:" + cl.getParent().toString());
        System.out.println("Parent`s parent ClassLoader is:" + cl.getParent().getParent().toString());
        
//        cl = int.class.getClassLoader();
//
//        System.out.println("ClassLoader is:"+cl.toString());
        
    }
}
