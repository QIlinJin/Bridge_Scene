package mp.CommandObjects;

import mp.BridgeScene.BridgeScene;
import mp.BridgeScene_Composite_Interfaces.Avatar;
import util.annotations.Tags;
@Tags ({"ApproachCommand"})

public class ApproachCommand implements Runnable {

	BridgeScene BS;
	Avatar AV;
	
	public ApproachCommand(BridgeScene bs, Avatar av) {
		this.BS = bs;
		this.AV = av;
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BS.approach(AV);
	}

}
