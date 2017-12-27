package mp.Parser;

import util.annotations.Tags;
import mp.BridgeScene.BridgeScene;
import mp.BridgeScene_Composite_Interfaces.Avatar;
import mp.CommandList.CommandList;
import mp.CommandObjects.ApproachCommand;
import mp.CommandObjects.CallCommand;
import mp.CommandObjects.DefineCommand;
import mp.CommandObjects.FailCommand;
import mp.CommandObjects.MoveCommand;
import mp.CommandObjects.PassCommand;
import mp.CommandObjects.ProceedAllCommand;
import mp.CommandObjects.RepeatCommand;
import mp.CommandObjects.RotateLeftArmCommand;
import mp.CommandObjects.RotateRightArmCommand;
import mp.CommandObjects.SayCommand;
import mp.CommandObjects.SleepCommand;
import mp.CommandObjects.ThreadCommand;
import mp.Scanner.ScannerBean;
import mp.Table.Table;
import mp.Token_Basic.Number;
import mp.Token_Basic.Token;
import mp.Token_Basic.Word;
import mp.Token_Basic_Extra.End;
import mp.Token_Basic_Extra.Minus;
import mp.Token_Basic_Extra.Plus;
import mp.Token_Basic_Extra.Start;
import mp.Token_Basic_Interfaces.NumberToken;
import mp.Token_Basic_Interfaces.TokenInterface;
import mp.Token_Basic_Interfaces.WordToken;
import mp.Token_Commands.Approach;
import mp.Token_Commands.Call;
import mp.Token_Commands.Define;
import mp.Token_Commands.Fail;
import mp.Token_Commands.Move;
import mp.Token_Commands.Pass;
import mp.Token_Commands.ProceedAll;
import mp.Token_Commands.Repeat;
import mp.Token_Commands.RotateLeftArm;
import mp.Token_Commands.RotateRightArm;
import mp.Token_Commands.Say;
import mp.Token_Commands.Sleep;
import mp.Token_Commands.Thread;
@Tags ({"Parser"})
public class Parser {
	
	static ScannerBean sb;
	public BridgeScene bs;
	String CommandText;
	Runnable CommandObject;
	Table ttt;
	static int index = 0;
	
	
	public Parser() {
		sb = mp.FactoryMethod.FactoryMethod.getOrCreateScannerBean();
		bs = mp.FactoryMethod.FactoryMethod.getOrCreateBridgeScene();
		ttt = mp.FactoryMethod.FactoryMethod.getOrCreateAvatarTable();
		ttt.put("arthur", bs.getArthur());
		ttt.put("galahad", bs.getGalahad());
		ttt.put("lancelot", bs.getLancelot());
		ttt.put("robin", bs.getRobin());
		ttt.put("guard", bs.getGuard());
	}
	public void setCommandText(String s) {
		reset();
		sb.ScanString(s);
		System.out.println(index);
		System.out.println(s);
		CommandObject = parseCommand();
		//System.out.println(index);
		System.out.println("success");
		System.out.println(CommandObject);
	}
	
	public Runnable getCommandObject() {
		//reset();
		return CommandObject;
		
	}
	
	public Runnable parseCommand() {
		
		if(peek() instanceof Move) {
			
			return parseMoveCommand();
		}
		else if(peek() instanceof Say) {
			
			return parseSayCommand();
		}
		else if(peek() instanceof Approach) {
			
			return parseApproachCommand();
		}
		else if(peek() instanceof Pass) {
			
			return parsePassCommand();
		}
		else if(peek() instanceof Fail) {
			
			return parseFailCommand();
		}
		else if(peek() instanceof Start) {
			
			return parseCommandList();
		}
		else if(peek() instanceof RotateLeftArm) {
			
			return parseRotateLeftArmCommand();
		}
		else if(peek() instanceof RotateRightArm) {
			
			return parseRotateRightArmCommand();
		}
		else if(peek() instanceof Sleep) {
			
			return parseSleepCommand();
		}
		else if(peek() instanceof Define) {
			System.out.println("define yeseyeseyesyesyesyesyesyesyesyes");
			return parseDefineCommand();
		}
		else if(peek() instanceof Call) {
			
			return parseCallCommand();
		}
		else if(peek() instanceof Thread) {
			
			return parseThreadCommand();
		}
		else if(peek() instanceof ProceedAll) {
			return parseProceedAllCommand();
		}
		else {
			
			return parseRepeatCommand();
		}
	}
	
	public Runnable parseMoveCommand() {
		
		next();
		WordToken name = (Word)next();
		Avatar av = (Avatar) ttt.get(name.getValue());
		//TokenInterface yy = next();
		
		NumberToken x = (Number)next();
		int move_x = x.getValue();
		NumberToken y = (Number)next();;
		int move_y = y.getValue();
		if(!hasNext())
			reset();
		return new MoveCommand(av,move_x, move_y);
		
	}
	
	public Runnable parseRotateLeftArmCommand() {
		next();
		WordToken name = (Word)next();
		Avatar av = (Avatar) ttt.get(name.getValue());
		int rotateNum;
		TokenInterface yy = next();
		if(yy.getInput() == "-") {
			NumberToken x = (Number)next();
			rotateNum = x.getValue();
		}
		else {
			NumberToken x = (Number)yy;
			rotateNum = x.getValue();
		}
		//NumberToken x = (Number)next();
		//int rotateNum = x.getValue();
		if(!hasNext())
			reset();
		return new RotateLeftArmCommand(av,rotateNum);
	}
	
	public Runnable parseRotateRightArmCommand() {
		next();
		WordToken name = (Word)next();
		Avatar av = (Avatar) ttt.get(name.getValue());
		int rotateNum;
		TokenInterface yy = next();
		if(yy.getInput() == "-") {
			NumberToken x = (Number)next();
			rotateNum = x.getValue();
		}
		else {
			NumberToken x = (Number)yy;
			rotateNum = x.getValue();
		}
		//NumberToken x = (Number)next();
		//int rotateNum = x.getValue();
		if(!hasNext())
			reset();
		return new RotateRightArmCommand(av,rotateNum);
	}
	
	public Runnable parseSleepCommand() {
		next();
		NumberToken x = (Number)next();
		long sleepTime = x.getValue();
		if(!hasNext())
			reset();
		return new SleepCommand(sleepTime);	
	}
	
	public Runnable parseDefineCommand() {
		next();
		WordToken commandName = (Word)next();
		String name = commandName.getValue();
		Runnable c = parseCommand();
		if(!hasNext())
			reset();
		return new DefineCommand(name, c);
	}
	
	public Runnable parseCallCommand() {
		next();
		WordToken commandName = (Word)next();
		String name = commandName.getValue();
		if(!hasNext())
			reset();
		return new CallCommand(name);
	}
	
	public Runnable parseThreadCommand() {
		next();
		WordToken commandName = (Word)next();
		String name = commandName.getValue();
		if(!hasNext())
			reset();
		return new ThreadCommand(name);
	}
	
	public Runnable parseProceedAllCommand() {
		next();
		if(!hasNext())
			reset();
		return new ProceedAllCommand();
	}
	
	public Runnable parseSayCommand() {
		
		next();
		
		String s = next().getInput();
		
		if(!hasNext())
			reset();
		return new SayCommand(bs, s);
	}
	
	public Runnable parseApproachCommand() {
		
		next();
		WordToken name = (Word)next();
		Avatar av = (Avatar) ttt.get(name.getValue());
		if(!hasNext())
			reset();
		return new ApproachCommand(bs,av);
	}
	
	public Runnable parsePassCommand() {
		
		next();
		if(!hasNext())
			reset();
		return new PassCommand(bs);
	}
	
	public Runnable parseFailCommand() {
		
		next();
		if(!hasNext())
			reset();
		return new FailCommand(bs);
	}
	
	public Runnable parseCommandList() {
		
		next();
		CommandList cl = new CommandList();
		while(!(peek() instanceof End)) {
			if(peek() instanceof Move) {
				cl.add(parseMoveCommand());
			}
			else if(peek() instanceof Say) {
				cl.add(parseSayCommand());
			}
			else if(peek() instanceof Approach) {
				cl.add(parseApproachCommand());
			}
			else if(peek() instanceof Pass) {
				cl.add(parsePassCommand());
			}
			else if(peek() instanceof Fail) {
				cl.add(parseFailCommand());
			}
			else if(peek() instanceof Start) {
				cl.add(parseCommandList());
			}
			else if(peek() instanceof Repeat){
				cl.add(parseRepeatCommand());
			}
		}
		next();
		
		if(!hasNext())
			reset();
		return cl;
	}
	
	public Runnable parseRepeatCommand() {
		
		next();
		
		NumberToken x = (Number)next();
		
		int times = x.getValue();
		Runnable c = parseCommand();
		if(!hasNext())
			reset();
		
		return new RepeatCommand(times,c);
	}
	
	
	public static TokenInterface next() {
		
		TokenInterface t = peek();
		index++;
		return t;
		
	}
	
	public static TokenInterface peek() {
		if(hasNext()) {
			return sb.getTokens()[index];
		}
		else 
			return null;
	}
	
	public static boolean hasNext() {
		return (index != sb.getTokens().length);
	}
	
	public static void reset() {
		index = 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
