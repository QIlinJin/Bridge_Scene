package mp.CommandObjects;


import mp.BridgeScene.BridgeScene;
import util.annotations.Tags;

@Tags ({"SayCommand"})
public class SayCommand implements Runnable{
	
	BridgeScene bs;
	String s;
	
	public SayCommand(BridgeScene BS, String S) {
		bs = BS;
		s = S;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		bs.say(s);
	}

}
