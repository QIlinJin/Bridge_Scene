package mp.CommandObjects;

import util.annotations.Tags;
@Tags ({"DefineCommand"})
public class DefineCommand implements Runnable {
	
	String name;
	Runnable r;
	
	public DefineCommand(String newName, Runnable R) {
		name = newName;
		r = R;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
//call environment
		mp.FactoryMethod.FactoryMethod.getOrCreateEnvironment().put(name, r);
	}

}
