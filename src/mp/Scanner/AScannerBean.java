package mp.Scanner;
import mp.Token_Basic.Number;
import mp.Token_Basic.Quote;
import mp.Token_Basic.Word;
import mp.Token_Basic_Extra.End;
import mp.Token_Basic_Extra.EndInterface;
import mp.Token_Basic_Extra.Minus;
import mp.Token_Basic_Extra.MinusInterface;
import mp.Token_Basic_Extra.Plus;
import mp.Token_Basic_Extra.PlusInterface;
import mp.Token_Basic_Extra.Start;
import mp.Token_Basic_Extra.StartInterface;
import mp.Token_Basic_Interfaces.NumberToken;
import mp.Token_Basic_Interfaces.QuoteInterface;
import mp.Token_Basic_Interfaces.TokenInterface;
import mp.Token_Basic_Interfaces.WordToken;
import mp.Token_Commands.Approach;
import mp.Token_Commands.Call;
import mp.Token_Commands.Define;
import mp.Token_Commands.Fail;
import mp.Token_Commands.Move;
import mp.Token_Commands.Pass;
import mp.Token_Commands.ProceedAll;
import mp.Token_Commands.Redo;
import mp.Token_Commands.Repeat;
import mp.Token_Commands.RotateLeftArm;
import mp.Token_Commands.RotateRightArm;
import mp.Token_Commands.Say;
import mp.Token_Commands.Sleep;
import mp.Token_Commands.Thread;
import mp.Token_Commands.Undo;
import mp.Token_Commands.Wait;
import mp.Token_Commands_Interfaces.ApproachInterface;
import mp.Token_Commands_Interfaces.CallInterface;
import mp.Token_Commands_Interfaces.DefineInterface;
import mp.Token_Commands_Interfaces.FailInterface;
import mp.Token_Commands_Interfaces.MoveInterface;
import mp.Token_Commands_Interfaces.PassInterface;
import mp.Token_Commands_Interfaces.ProceedAllInterface;
import mp.Token_Commands_Interfaces.RedoInterface;
import mp.Token_Commands_Interfaces.RepeatInterface;
import mp.Token_Commands_Interfaces.RotateLeftArmI;
import mp.Token_Commands_Interfaces.RotateRightArmI;
import mp.Token_Commands_Interfaces.SayInterface;
import mp.Token_Commands_Interfaces.SleepInterface;
import mp.Token_Commands_Interfaces.ThreadInterface;
import mp.Token_Commands_Interfaces.UndoInterface;
import mp.Token_Commands_Interfaces.WaitInterface;
import util.annotations.Tags;
@Tags({"ScannerBean"})
public class AScannerBean implements ScannerBean{
	String ScannedString = "";
	private static TokenInterface[] TI = new TokenInterface[100];
	static int i = 0;
	
	static TokenInterface[] Tokens;//
	//= new TokenInterface[i+1];
	//for(int j = 0;j<i+1;j++) {
	//	TI2[j] = TI[j];
		
	//}
	public String getScannedString() {
		return ScannedString;
	}
	public void setScannedString(String input) {
		ScannedString = input;
		ScanString(ScannedString);
		i = 0;
		
	} 
	/*public String getScannedString() {
		return ScannedString;
	}*/
	public void ScanString(String s) {
		char ch = ' ';
		int index1 = 0;
		int index2 = 0;
		index1 = indexOfNot(s,ch,0);
		index2 = indexOf(s,ch,index1);
		while(index1!=-1&&index2!=-1) {
			
			
			String subS = s.substring(index1, index2);
			
			if(subS.charAt(0)<='9'&&subS.charAt(0)>='0') {
				Number n = new Number(subS);
				TI[i] = n;
				i++;
				//n.setInput(subS);
				//System.out.println(n);
				//System.out.println(n.getInput());
				//System.out.println(n.getValue());
			}
			else if((subS.charAt(0)<='Z'&&subS.charAt(0)>='A')||(subS.charAt(0)<='z'&&subS.charAt(0)>='a')) {
				if(subS.toLowerCase().equals("move")) {
					MoveInterface m = new Move("Move");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("say")) {
					SayInterface m = new Say("Say");
					TI[i] = m;
					i++;
					////////////////////////////////////////////////////////////////////////////////
					//System.out.println("say got"+TI[i-1].getInput()+(i-1));
				}
				else if(subS.toLowerCase().equals("repeat")) {
					RepeatInterface m = new Repeat("Repeat");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("approach")) {
					ApproachInterface m = new Approach("Approach");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("passed")) {
					PassInterface m = new Pass("Pass");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("failed")) {
					FailInterface m = new Fail("Fail");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("rotateleftarm")) {
					RotateLeftArmI m = new RotateLeftArm("RotateLeftArm");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("rotaterightarm")) {
					RotateRightArmI m = new RotateRightArm("RotateRightArm");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("define")) {
					DefineInterface m = new Define("Define");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("call")) {
					CallInterface m = new Call("Call");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("thread")) {
					ThreadInterface m = new Thread("Thread");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("wait")) {
					WaitInterface m = new Wait("Wait");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("proceedall")) {
					ProceedAllInterface m = new ProceedAll("ProceedAll");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("sleep")) {
					SleepInterface m = new Sleep("Sleep");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("undo")) {
					UndoInterface m = new Undo("Undo");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("redo")) {
					RedoInterface m = new Redo("Redo");
					TI[i] = m;
					i++;
				}
				else {
					WordToken m = new Word(subS);
					TI[i] = m;
					i++;
					//m.setInput(subS);
					//System.out.println(m);
					//System.out.println(m.getInput());
					//System.out.println(m.getValue());
				}
				
			}
			else if(subS.charAt(0)=='"') {
				////////////////////////////////////////////////*******************/////////////////
				//System.out.println("666");
				index2 = indexOf(s,'"',index1+1);
				if(index2==-1) {
					System.out.println("Error: Closing double quote is missing!");
					QuoteInterface q = new Quote(subS);
					TI[i] = q;
					i++;
					//q.setInput(s.substring(index1+1,s.length()));
					//System.out.println(q);
					//System.out.println(q.getInput());
					
					index2 = s.length()-1;
				}
				else {
					QuoteInterface q = new Quote(subS);
					q.setInput(s.substring(index1+1,index2));
					TI[i] = q;
					i++;
					//System.out.println(q);
					//System.out.println(q.getInput());
				}
			}
			else if(subS.charAt(0)=='+') {
				PlusInterface p = new Plus(subS);
				TI[i] = p;
				i++;
				//System.out.println(p);
				//System.out.println(p.getInput());
			}
			else if(subS.charAt(0)=='-') {
				MinusInterface p = new Minus(subS);
				TI[i] = p;
				i++;
				//System.out.println(p);
				//System.out.println(p.getInput());
			}
			else if(subS.charAt(0)=='{') {
				StartInterface p = new Start(subS);
				TI[i] = p;
				i++;
				//System.out.println(p);
				//System.out.println(p.getInput());
			}
			else if(subS.charAt(0)=='}') {
				EndInterface p = new End(subS);
				TI[i] = p;
				i++;
				//System.out.println(p);
				//System.out.println(p.getInput());
			}
			index1 = indexOfNot(s,ch,index2+1);
			index2 = indexOf(s,ch,index1);
		}
		if(index2==-1&&index1!=-1) {
			String subS = s.substring(index1, s.length());
			if(subS.charAt(0)<='9'&&subS.charAt(0)>='0') {
				NumberToken n = new Number(subS);
				TI[i] = n;
				i++;
				
				//System.out.println(n);
				//System.out.println(n.getInput());
				//System.out.println(n.getValue());
			}
			else if((subS.charAt(0)<='Z'&&subS.charAt(0)>='A')||(subS.charAt(0)<='z'&&subS.charAt(0)>='a')) {
				
				
				if(subS.toLowerCase().equals("move")) {
					MoveInterface m = new Move("Move");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("say")) {
					SayInterface m = new Say("Say");
					TI[i] = m;
					i++;
					///////////////////////////////////////////////////////////////
					//System.out.println("say got"+i);
				}
				else if(subS.toLowerCase().equals("repeat")) {
					RepeatInterface m = new Repeat("Repeat");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("approach")) {
					ApproachInterface m = new Approach("Approach");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("passed")) {
					PassInterface m = new Pass("Pass");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("failed")) {
					FailInterface m = new Fail("Fail");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("rotateLeftArm")) {
					RotateLeftArmI m = new RotateLeftArm("RotateLeftArm");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("rotateRightArm")) {
					RotateRightArmI m = new RotateRightArm("RotateRightArm");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("define")) {
					DefineInterface m = new Define("Define");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("call")) {
					CallInterface m = new Call("Call");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("thread")) {
					ThreadInterface m = new Thread("Thread");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("wait")) {
					WaitInterface m = new Wait("Wait");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("proceedall")) {
					ProceedAllInterface m = new ProceedAll("ProceedAll");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("sleep")) {
					SleepInterface m = new Sleep("Sleep");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("undo")) {
					UndoInterface m = new Undo("Undo");
					TI[i] = m;
					i++;
				}
				else if(subS.toLowerCase().equals("redo")) {
					RedoInterface m = new Redo("Redo");
					TI[i] = m;
					i++;
				}
				
				
				else {
					WordToken m = new Word(subS);
					TI[i] = m;
					i++;
					//System.out.println(m);
					//System.out.println(m.getInput());
					//System.out.println(m.getValue());
				}
				
			}
			else if(subS.charAt(0)=='"') {
				////////////////////////////////////////////////*******************/////////////////
				
				index2 = indexOf(s,'"',index1+1);
				if(index2==-1) {
					System.out.println("Error: Closing double quote is missing!");
					QuoteInterface q = new Quote(subS);
					TI[i] = q;
					i++;
					//q.setInput(s.substring(index1+1,s.length()));
					//System.out.println(q);
					//System.out.println(q.getInput());
					
					index2 = s.length()-1;
				}
				else {
					QuoteInterface q = new Quote(subS);
					q.setInput(s.substring(index1+1,index2));
					TI[i] = q;
					i++;
					//System.out.println(q);
					//System.out.println(q.getInput());
				}
			}
			else if(subS.charAt(0)=='+') {
				PlusInterface p = new Plus(subS);
				TI[i] = p;
				i++;
				//System.out.println(p);
				//System.out.println(p.getInput());
			}
			else if(subS.charAt(0)=='-') {
				MinusInterface p = new Minus(subS);
				TI[i] = p;
				i++;
				//System.out.println(p);
				//System.out.println(p.getInput());
			}
			else if(subS.charAt(0)=='{') {
				StartInterface p = new Start(subS);
				TI[i] = p;
				i++;
				//System.out.println(p);
				//System.out.println(p.getInput());
			}
			else if(subS.charAt(0)=='}') {
				EndInterface p = new End(subS);
				TI[i] = p;
				i++;
				//System.out.println(p);
				//System.out.println(p.getInput());
			}
		}
		Tokens = new TokenInterface[i];
		for(int j = 0;j<i;j++) {
				Tokens[j] = TI[j];
				//System.out.println(i);
				//System.out.println(Tokens[j].getInput()+"lol"+j);
				
		}
		i=0;
		
	}
	public TokenInterface[] getTokens() {
		return Tokens;
	}
	/*public void clear() {
		for(int i = 0;i<Tokens.length;i++) {
			Tokens[i] = null;
		}
	}*/
	public static int indexOfNot(String s, char ch, int fromIndex) {
		if(fromIndex==-1)
			return fromIndex;
		else{
			while(fromIndex<s.length()&&s.charAt(fromIndex) == ch) {
				fromIndex++;
			}
			if(fromIndex==s.length()) {
				fromIndex = -1;}
			return fromIndex;
		}
	}
	public static int indexOf(String s, char ch, int fromIndex) {
		if(fromIndex==-1)
			return fromIndex;
		else {
			while(fromIndex<s.length()&&s.charAt(fromIndex) != ch) {
				fromIndex++;
			}
			if(fromIndex==s.length()) {
				fromIndex = -1;}
			return fromIndex;
		}
		
	}

	

}
