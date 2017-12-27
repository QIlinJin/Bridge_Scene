package mp.CommandObjects;

import util.annotations.Tags;

@Tags ({"ThreadCommand"})
public class ThreadCommand implements Runnable {

	String commandName;
	
	public ThreadCommand(String s){
		commandName = s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread t = new Thread(mp.FactoryMethod.FactoryMethod.getOrCreateEnvironment().get(commandName));
		t.start();
	}

}
