package mp.Token_Basic;
import mp.Token_Basic_Interfaces.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"Word"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input", "Value"}) 
@EditablePropertyNames({"Input"})

public class Word extends Token implements WordToken{
	
	public String Value;
	public Word(String s) {
		super(s);
	}
	
	public String getValue() {
		Value = input.toLowerCase();
		return Value;
	}
}
