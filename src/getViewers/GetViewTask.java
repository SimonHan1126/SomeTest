//package com.uyitv;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//import net.spy.memcached.MemcachedClient;
//import org.apache.log4j.Logger;
//import org.jivesoftware.openfire.XMPPServer;
//import org.jivesoftware.openfire.muc.MUCRole;
//import org.jivesoftware.openfire.muc.MUCRoom;
//import org.jivesoftware.openfire.muc.MultiUserChatManager;
//import org.jivesoftware.openfire.muc.MultiUserChatService;
//
//public class GetViewTask implements Runnable
//{
//  public GetViewTask() {}
//
//  private boolean hadStart = false;
//  private volatile Thread nowThread;
//  private static MemcachedClient client = null;
//  private static final MultiUserChatService chatService = XMPPServer.getInstance().getMultiUserChatManager().getMultiUserChatService("conference");
//
//
//  private List<String> list = null;
//  private Map<String, List<String>> map = new java.util.concurrent.ConcurrentHashMap();
//
//  public void run() {
//    hadStart = true;
//    Thread thisThread = Thread.currentThread();
//    nowThread = thisThread;
//    Logger log = Logger.getLogger("bc_send");
//
//    while (nowThread == thisThread) {
//      try {
//        client = GetViewConfig.getClient();
//
//        List<MUCRoom> mucrooms = chatService.getChatRooms();
//
//        for (MUCRoom room : mucrooms) {
//          list = new ArrayList();
//          Collection<MUCRole> roles = room.getOccupants();
//          for (MUCRole role : roles) {
//            list.add(role.getNickname());
//          }
//          map.put(room.getName(), list);
//        }
//        client.set("mRooms", 30, map);
//
//        Thread.sleep(1000L);
//      }
//      catch (InterruptedException e) {
//        log.error(e.getMessage());
//      } catch (Exception e) {
//        log.error("memcached", e);
//      }
//    }
//  }
//
//  public void stop()
//  {
//    Thread temp = nowThread;
//    nowThread = null;
//    if (temp != null) {
//      try {
//        temp.interrupt();
//      } catch (Exception e) {
//        Logger.getLogger("bc").error("close GetViewTask error!", e);
//      }
//    }
//  }
//
//  public boolean ifStarted() {
//    return hadStart;
//  }
//}
