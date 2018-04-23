package net.aurore.lolservice;

public class RestServiceControllerThread extends Thread{

	private final RestService SERVICE;
	
	private static int instances = 0;
	
	public RestServiceControllerThread(RestService s){
		SERVICE = s;
		this.setName("RiotServiceController" + instances);
		instances += 1;
	}

	@Override
	public void run() {
		while (!(this.isInterrupted())) {
			synchronized (this) {
				if (!SERVICE.queueEmpty()) {
					long delay = SERVICE.queue();
					if (delay != 0) {
						try {
							wait(delay);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					try {
						SERVICE.doRequest();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}
	}
}
