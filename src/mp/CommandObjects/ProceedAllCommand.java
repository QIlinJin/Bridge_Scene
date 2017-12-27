package mp.CommandObjects;

import util.annotations.Tags;

@Tags ({"ProceedAllCommand"})
public class ProceedAllCommand implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		mp.FactoryMethod.FactoryMethod.getOrCreateBroadcastingClearanceManager().proceedAll();
	}

}
