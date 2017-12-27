package mp.CommandInterpreter;

import mp.Animation.AnimatingCommand;
import mp.Animation.Animator;
import mp.Animation.CoordinatedAnimationCommand;
import mp.Animation.CoordinatedAnimator;
import mp.BridgeScene.BridgeScene;
import mp.BridgeScene_Composite_Interfaces.Avatar;
import mp.ClearanceManager.BroadcastingClearanceManager;
import mp.CommandObjects.MoveCommand;
import mp.CommandObjects.SayCommand;
import mp.Parser.Parser;
import mp.Scanner.ScannerBean;
import mp.Table.ATable;
import mp.Table.Table;
import mp.Token_Basic.Number;
import mp.Token_Basic.Quote;
import mp.Token_Basic.Word;
import mp.Token_Basic_Extra.Minus;
import mp.Token_Basic_Extra.Plus;
import mp.Token_Basic_Interfaces.NumberToken;
import mp.Token_Basic_Interfaces.WordToken;
import mp.Token_Commands.Move;
import mp.Token_Commands.Say;
import util.annotations.Tags;
@Tags ({"CommandInterpreter"})


public class ACommandInterpreter implements CommandInterpreter{
	ScannerBean SB;
	BridgeScene BS;
	String Command = "";
	Animator a1 = new Animator();
	Animator a2 = new Animator();
	Animator a3 = new Animator();
	Animator a4 = new Animator();
	BroadcastingClearanceManager BCM = mp.FactoryMethod.FactoryMethod.getOrCreateBroadcastingClearanceManager();
	CoordinatedAnimator a11 = new CoordinatedAnimator();
	CoordinatedAnimator a22 = new CoordinatedAnimator();
	CoordinatedAnimator a33 = new CoordinatedAnimator();
	CoordinatedAnimator a44 = new CoordinatedAnimator();
	
	
	public ACommandInterpreter(BridgeScene bs,ScannerBean sb) {
		this.SB = sb;
		this.BS = bs;
		
	}
	
	
	
	public void setCommand(String s) {
//		SB.setScannedString(s);
//		if(SB.getTokens()[0] instanceof Say) {
//			Runnable sayCommand = parseSay(s);
//			animateRunnable(sayCommand);
//		}
//		else if(SB.getTokens()[0] instanceof Move) {
//			Runnable moveCommand = parseMove(s);
//			animateRunnable(moveCommand);
//		}
		Parser p = mp.FactoryMethod.FactoryMethod.getOrCreateParser();
		//Parser p = new Parser();
		p.setCommandText(s);
		System.out.println("new"+p.getCommandObject());
		animateRunnable(p.getCommandObject());
		System.out.println("Occupied"+p.bs.getOccupied());
		System.out.println("KnightTurn"+p.bs.getKnightTurn());
	}
	
	public String getCommand() {
		return Command;
		
	}
	
	
	
	
	
	public void animateRunnable(Runnable a) {
		//Thread aThread = new Thread(a);
		//aThread.start();
		a.run();
	}
	
	
	@Tags ({"waitingArthur"})
	public void asynchronousArthur() {
		//a1 = new Animator();
		Thread aThread = new Thread(new AnimatingCommand(a1,BS.getArthur(),BCM));
		aThread.start();	
	}
	
	@Tags ({"waitingGalahad"})
	public void asynchronousGalahad() {
		//a2 = new Animator();
		Thread aThread = new Thread(new AnimatingCommand(a2,BS.getGalahad(),BCM));
		aThread.start();
	}
	
	@Tags ({"waitingLancelot"})
	public void asynchronousLancelot() {
		//a3 = new Animator();
		Thread aThread = new Thread(new AnimatingCommand(a3,BS.getLancelot(),BCM));
		aThread.start();
	}
	
	@Tags ({"waitingRobin"})
	public void asynchronousRobin() {
		//a4 = new Animator();
		Thread aThread = new Thread(new AnimatingCommand(a4,BS.getRobin(),BCM));
		aThread.start();
	}
	@Tags ({"startAnimation"})
	public void proceedAll() {
		BCM.proceedAll();
	}
	
	@Tags ({"lockstepArthur"})
	public void lockstep() {
		//a1 = new Animator();
		Thread aThread = new Thread(new CoordinatedAnimationCommand(a11,BS.getArthur(),BCM));
		aThread.start();	
	}
	
	@Tags ({"lockstepGalahad"})
	public void lockstepGalahad() {
		//a2 = new Animator();
		Thread aThread = new Thread(new CoordinatedAnimationCommand(a22,BS.getGalahad(),BCM));
		aThread.start();
	}
	
	@Tags ({"lockstepLancelot"})
	public void lockstepLancelot() {
		//a3 = new Animator();
		Thread aThread = new Thread(new CoordinatedAnimationCommand(a33,BS.getLancelot(),BCM));
		aThread.start();
	}
	
	@Tags ({"lockstepRobin"})
	public void lockstepRobin() {
		//a4 = new Animator();
		Thread aThread = new Thread(new CoordinatedAnimationCommand(a44,BS.getRobin(),BCM));
		aThread.start();
	}
	
}






