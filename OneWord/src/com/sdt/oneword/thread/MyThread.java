package com.sdt.oneword.thread;

public class MyThread implements Runnable{

	private boolean runningFlag = false;
	
	public boolean isRunningFlag() {
		return runningFlag;
	}

	public void setRunningFlag(boolean runningFlag) {
		this.runningFlag = runningFlag;
	}

	@Override
	public void run() {
		
//		while(this.isRunningFlag()==true){
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("线程执行~");
//		}
		System.out.println("开启线程执行");
	}

}
