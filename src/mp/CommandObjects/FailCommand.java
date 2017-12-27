package mp.CommandObjects;

import mp.BridgeScene.BridgeScene;
import util.annotations.Tags;
@Tags ({"FailCommand"})
public class FailCommand implements Runnable {

	BridgeScene BS;
	
	public FailCommand(BridgeScene bs) {
		this.BS = bs;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BS.failed();
	}

}
