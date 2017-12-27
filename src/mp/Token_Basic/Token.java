package mp.Token_Basic;

import mp.Token_Basic_Interfaces.TokenInterface;
import util.annotations.Tags;

@Tags ({"Token"})
public abstract class Token implements TokenInterface {
	protected String input;
	
	public Token(String s) {
		this.input = s;
	}
	@Override
	public void setInput(String inputt) {
		// TODO Auto-generated method stub
		this.input = inputt;
	}

	@Override
	public String getInput() {
		// TODO Auto-generated method stub
		return input;
	}

}
