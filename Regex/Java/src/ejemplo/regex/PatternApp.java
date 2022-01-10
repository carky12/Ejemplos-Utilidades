package ejemplo.regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternApp {
	
	public static void main(String[] args) {
		
		Pattern p = Pattern.compile(".");
		
		Matcher m = p.matcher("XYZ");
		
		System.out.println(m.matches());
		
		
		
	}

}
