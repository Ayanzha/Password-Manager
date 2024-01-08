//package com.company;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.util.concurrent.Executor;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//public class servermultythread {
//    public static void main(String []args) throws IOException {
//        try (ServerSocket listener = new ServerSocket(11111)){
//            System.out.println("THe capitilizeMultiServer is running ....");
//            ExecutorService pool = Executors.newFixedThreadPool(20);
//            while (true)
//            {
//                pool.execute(new Server(listener.accept()));
//            }
//
//        }
//    }
//}
