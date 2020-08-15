//package com.uyitv;
//
//import java.io.IOException;
//import java.net.URL;
//import net.spy.memcached.AddrUtil;
//import net.spy.memcached.ConnectionFactoryBuilder;
//import net.spy.memcached.ConnectionFactoryBuilder.Protocol;
//import net.spy.memcached.MemcachedClient;
//import net.spy.memcached.auth.AuthDescriptor;
//import net.spy.memcached.auth.PlainCallbackHandler;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//
//
//
//
//
//
//
//
//
//
//
//
//public class GetViewConfig
//{
//  public static final String host = "c43adf8537fd4082.m.cnhzaliqshpub001.ocs.aliyuncs.com";
//  public static final String port = "11211";
//  public static final String username = "c43adf8537fd4082";
//  public static final String password = "racqNku12Bu5K1K8elve";
//  public static final int mtime = 30;
//  public static final String mkey = "mRooms";
//  private static MemcachedClient client = null;
//
//  public GetViewConfig() {}
//
//  public static MemcachedClient getClient() { Logger log = Logger.getLogger("bc_send");
//    synchronized ("client") {
//      if (null == client) {
//        AuthDescriptor ad = new AuthDescriptor(new String[] { "PLAIN" }, new PlainCallbackHandler("c43adf8537fd4082", "racqNku12Bu5K1K8elve"));
//        try
//        {
//          client = new MemcachedClient(new ConnectionFactoryBuilder().setProtocol(ConnectionFactoryBuilder.Protocol.BINARY).setAuthDescriptor(ad).build(), AddrUtil.getAddresses("c43adf8537fd4082.m.cnhzaliqshpub001.ocs.aliyuncs.com:11211"));
//
//
//
//
//          log.info("创建了memcached实例");
//        } catch (IOException e) {
//          e.printStackTrace();
//        }
//      }
//
//      return client;
//    }
//  }
//
//
//  private static Boolean initFinished = Boolean.valueOf(false);
//
//  public static void initMqResources() { synchronized (initFinished) {
//      if (!initFinished.booleanValue()) {
//        URL url = GetViewConfig.class.getResource("bc_log4j.properties");
//        if (null != url) {
//          PropertyConfigurator.configure(url);
//        }
//        getClient();
//      }
//
//
//      initFinished = Boolean.valueOf(true);
//    }
//  }
//}
