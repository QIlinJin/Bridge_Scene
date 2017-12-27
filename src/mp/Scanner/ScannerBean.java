package mp.Scanner;

import mp.Token_Basic_Interfaces.TokenInterface;

public interface ScannerBean {
	public String getScannedString();
	public void setScannedString(String input);
	public void ScanString(String s);
	public TokenInterface[] getTokens();
}
