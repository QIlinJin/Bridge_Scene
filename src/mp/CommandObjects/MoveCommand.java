package mp.CommandObjects;

import mp.BridgeScene_Composite_Interfaces.Avatar;
import util.annotations.Tags;

@Tags ({"MoveCommand"})
public class MoveCommand implements Runnable{

	Avatar a;
	int XOffset;
	int YOffset;
	
	public MoveCommand(Avatar A, int x, int y) {
		a = A;
		XOffset = x;
		YOffset = y;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		a.move(XOffset, YOffset);
	}

}
