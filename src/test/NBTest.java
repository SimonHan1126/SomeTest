package test;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author hanshihui
 */
public class NBTest implements Runnable{


    public void startServer() throws Exception {
        int channels = 0;
        int nKeys = 0;
//        int currentSelector = 0;
        //使用Selector 　　
        Selector selector = Selector.open();
        //建立Channel 并绑定到9000端口 　　
        ServerSocketChannel ssc = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 9000);
        ssc.socket().bind(address);
        //使设定non-blocking的方式。 　　
        ssc.configureBlocking(false);

        //向Selector注册Channel及我们有兴趣的事件 　　
        SelectionKey s = ssc.register(selector, SelectionKey.OP_ACCEPT);
        printKeyInfo(s);

        //不断的轮询 　　
        while (true) {
            debug("NBTest: Starting select");
            //Selector通过select方法通知我们我们感兴趣的事件发生了。 　　　　
            nKeys = selector.select();
            //如果有我们注册的事情发生了，它的传回值就会大于0 　　　　
            if (nKeys > 0) {
                debug("NBTest: Number of keys after select operation: " + nKeys);
                //Selector传回一组SelectionKeys 　　　　　　
                // 我们从这些key中的channel()方法中取得我们刚刚注册的channel。 　　　　　　
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> i = selectedKeys.iterator();
                while (i.hasNext()) {
                    s = (SelectionKey) i.next();
                    printKeyInfo(s);
                    debug("NBTest: Nr Keys in selector: " + selector.keys().size());
                    //一个key被处理完成后，就都被从就绪关键字（ready keys）列表中除去 　　　　　　 　
                    i.remove();
                    if (s.isAcceptable()) {
                        // 从channel()中取得我们刚刚注册的channel。 　　　　　　 　 　
                        Socket socket = ((ServerSocketChannel) s.channel()).accept().socket();

                        SocketChannel sc = socket.getChannel();
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        System.out.println(++channels);
                    } else {
                        debug("NBTest: Channel not acceptable");
                    }
                }
            } else {
                debug("NBTest: Select finished without any keys.");
            }

        }
    }

    private static void debug(String s) {
        System.out.println(s);
    }

    private static void printKeyInfo(SelectionKey sk) {
        String s = new String();
        s = "Att: " + (sk.attachment() == null ? "no" : "yes");
        s += ", Read: " + sk.isReadable();
        s += ", Acpt: " + sk.isAcceptable();
        s += ", Cnct: " + sk.isConnectable();
        s += ", Wrt: " + sk.isWritable();
        s += ", Valid: " + sk.isValid();
        s += ", Ops: " + sk.interestOps();
        debug(s);
        Thread t = new Thread();
        t.toString();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        NBTest nbTest = new NBTest();
//        try {
//            nbTest.startServer();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    	NumberFormat num = NumberFormat.getPercentInstance();
//		num.setMinimumFractionDigits(2);

        String micTime = "25小时38分钟";
//        String micTime = "38分钟";
        boolean isContainHour = micTime.contains("小时");
        boolean isContainMinute = micTime.contains("分钟");
        int indexOfHour = micTime.indexOf("小时");
        int indexOfMinute = micTime.indexOf("分钟");

        int hour = 0;
        int minute = 0;
        if(isContainHour)
        {
            String strHour = micTime.substring(0,indexOfHour);
            if(strHour == null || strHour.length() <= 0)
            {
                hour = 0;
            }
            else
            {
                hour = Integer.valueOf(strHour);
            }

        }

        if(isContainMinute)
        {
            int minuteStart = 0;
            if(isContainHour)
            {
                minuteStart =indexOfHour + 2;
            }
            String strMinute = micTime.substring(minuteStart,indexOfMinute);
            if(strMinute == null || strMinute.length() <= 0)
            {
                minute = 0;
            }
            else
            {
                minute = Integer.valueOf(strMinute);
            }
        }


        System.out.println(isContainHour + " " + isContainMinute + " " + indexOfHour + " " + indexOfMinute);
        System.out.println(hour + " " + minute);

        ExecutorService executor =  Executors.newCachedThreadPool();
        executor.execute(new NBTest());


//        ScheduledThreadPoolExecutor
    }

    @Override
    public void run() {

//        List<String> list = new ArrayList<>();
//        list.add("11111");
//        list.add("22222");
//        list.add("33333");
//        list.add("444444");
//        list.add("555555");
//        list.add("6666666");
//        list.add("777777");
//        list.add("888888");

//        int index = 0;
//        for(int i = 0; i < 1000; i++)
//        {
//            index = i % list.size();
//            System.out.println(list.get(index) + " " + i);
//        }




        String s3 = new String("0分钟");
        String s4 = new String("0分钟");

        System.out.println("---------------------------");
        System.out.println("ssssss " + (s3==s4));
        System.out.println("nnnnnn " + s3.equals(s4));

        long l1 = 1000L;
        String s1 = l1 + "0分钟";
        String s2 = l1 + "0分钟";

        System.out.println("HHHHHHHHHHH 11111 " + (s1==s2));
        System.out.println("KKKKKKKKKKK 22222 " + s1.equals(s2));

        System.out.println("this NBTest run");
    }
}

