import java.util.Date; 
import java.text.SimpleDateFormat;

public class nowDate{
	public static String getDateTime(){
	SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	Date date = new Date();
	String strDate = sdFormat.format(date);
	System.out.println(strDate);

	return strDate;
	}
}