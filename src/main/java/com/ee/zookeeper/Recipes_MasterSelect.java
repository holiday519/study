//package com.ee.zookeeper;
//
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.framework.recipes.leader.LeaderSelector;
//import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
//import org.apache.curator.retry.ExponentialBackoffRetry;
//
//public class Recipes_MasterSelect {
//    static String master_path = "/curator_recipes_master_path";
//    static CuratorFramework client = CuratorFrameworkFactory.builder()
//            .connectString("192.168.1.100:2181,192.168.1.100:2182,192.168.1.100:2183")
//            .sessionTimeoutMs(5000)
//            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
//            .build();
//
//    public static void main(String[] args) throws InterruptedException {
//        client.start();
//        LeaderSelector selector = new LeaderSelector(client, master_path,
//                new LeaderSelectorListenerAdapter() {
//                    @Override
//                    public void takeLeadership(CuratorFramework client) throws Exception {
//                        System.out.println("成为Master角色");
//                        Thread.sleep(3000);
//                        System.out.println("完成Master操作，释放Master权利");
//                    }
//                });
//        selector.autoRequeue();
//        selector.start();
//        Thread.sleep(Integer.MAX_VALUE);
//    }
//}
