package mp.Token_Basic;
import util.annotations.Tags;
import mp.Token_Basic_Interfaces.NumberToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@Tags ({"Number"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input", "Value"}) 
@EditablePropertyNames({"Input"})
public class Number extends Token implements NumberToken {
	public int Value;
	
	public Number(String s) {
		super(s);
	}
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		Value = Integer.parseInt(input);
		return Value;
	}

	

}
