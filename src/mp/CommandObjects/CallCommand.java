package mp.CommandObjects;

import util.annotations.Tags;

@Tags ({"CallCommand"})
public class CallCommand implements Runnable {
	
	String commandName;
	
	public CallCommand(String s) {
		commandName = s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
//environment needed
		mp.FactoryMethod.FactoryMethod.getOrCreateEnvironment().get(commandName).run();
	}

}
