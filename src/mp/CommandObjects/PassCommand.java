package mp.CommandObjects;

import mp.BridgeScene.BridgeScene;
import util.annotations.Tags;
@Tags ({"PassCommand"})
public class PassCommand implements Runnable {

	BridgeScene BS;
	
	public PassCommand(BridgeScene bs) {
		this.BS = bs;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BS.passed();
	}

}
