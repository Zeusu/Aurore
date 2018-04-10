package net.aurore.util;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ThreadPoolManager {
	
	private static final List<ThreadPoolExecutor> POOLS = new LinkedList<ThreadPoolExecutor>();
	private static final List<Thread> THREADS = new LinkedList<Thread>(); 
	
	public static synchronized ThreadPoolExecutor initiatePool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit){
		ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, new LinkedBlockingQueue<Runnable>());
		pool.prestartAllCoreThreads();
		pool.allowCoreThreadTimeOut(true);
		POOLS.add(pool);
		return pool;
	}
	
	public static synchronized void addSingleThread(Thread t){
		THREADS.add(t);
	}
	
	public static synchronized void softShutdown(){
		for(ThreadPoolExecutor thread: POOLS){
			thread.shutdown();
		}
		for(Thread t : THREADS){
			t.interrupt();
		}
	}
	
	public static synchronized void shutdown(){
		for(ThreadPoolExecutor thread: POOLS){
			thread.shutdownNow();
		}
		for(Thread t : THREADS){
			t.interrupt();
		}
	}
}
