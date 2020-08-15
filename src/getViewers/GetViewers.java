//package com.uyitv;
//
//import java.io.File;
//import org.apache.log4j.Logger;
//import org.jivesoftware.openfire.container.Plugin;
//import org.jivesoftware.openfire.container.PluginManager;
//
//public class GetViewers
//  implements Plugin
//{
//  private Logger log = Logger.getLogger("bc");
//  private Thread thread;
//  private GetViewTask task = null;
//
//  public GetViewers() {}
//
//  public void initializePlugin(PluginManager manager, File pluginDirectory) {
//    try {
//      GetViewConfig.initMqResources();
//      log = Logger.getLogger("bc");
//      task = new GetViewTask();
//      thread = new Thread(task);
//      thread.start();
//      log.info("=========== init GetViewers plugin success. ============");
//    } catch (Exception e) {
//      e.printStackTrace();
//      log.error("===========  init GetViewers plugin failed! ===========", e);
//      destroyPlugin();
//    }
//  }
//
//
//  public void destroyPlugin()
//  {
//    try
//    {
//      if ((null != task) && (task.ifStarted())) {
//        task.stop();
//      }
//    } catch (Exception e) {
//      log.error("===========  stop excutor failed! ===========", e);
//    }
//    log.info("=========== destroy GetViewers plugin success. ============");
//  }
//}
