package mp.Token_Basic;
import util.annotations.Tags;
import mp.Token_Basic_Interfaces.QuoteInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@Tags ({"Quote"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input"}) 
@EditablePropertyNames({"Input"})
public class Quote extends Token  implements QuoteInterface{
	
	public Quote(String s) {
		super(s);
	}
	
	

}
