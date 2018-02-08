import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class ChangeTimeZone {

	public static LocalDateTime d2ldt(Date d,String offset) {
		return LocalDateTime.ofInstant(d.toInstant(), getZoneID(offset));
	}
	
	public static Date ldt2d(LocalDateTime ldt,String offset) {
		return Date.from(ldt.toInstant(getZoneOffset(offset)));
	}
	
	public static ZoneId getZoneID(String offset) {
		return ZoneOffset.ofOffset("UTC", ZoneOffset.of(offset));
	}
	
	public static ZoneOffset getZoneOffset(String offset) {
		return ZoneOffset.of(offset);
	}
	
	public static Date changeTimeZone(Date d,String from,String to) {
		return ldt2d(d2ldt(d, to), from);
	}

	public static void main(String[] args) {
		Date d=new Date();
		System.out.println("Current Time: "+d);
		System.out.println("Changed Time: "+changeTimeZone(d, "-01:00", "+02:00"));
	}
}
