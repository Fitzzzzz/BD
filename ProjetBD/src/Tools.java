import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Tools {

	public static java.sql.Date parseDate(String dateString) throws ParseException {
		
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	     java.util.Date parsed = format.parse(dateString);
	     return new java.sql.Date(parsed.getTime());
		
	}
	
	
}
