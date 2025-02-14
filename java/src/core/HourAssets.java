package core;

public class HourAssets {

	public boolean hourMinuteValid(String hour) {
		// El formato: (hh:mm)
		
		if (null == hour) {
			return false;
		}
	
		if (hour.length() != 5) {
			return false;
		}
		
		String[] valuesString = hour.split(":");
		
		if (valuesString.length != 2) {
			return false;
		}
		
		if (valuesString[0].length() != 2) {
			return false;
		}
		
		int[] valuesInt = {0, 0};
		
		try {
			valuesInt[0] = Integer.valueOf(valuesString[0]);
			valuesInt[1] = Integer.valueOf(valuesString[1]);
		} catch (Exception ex) {
			return false;
		}
		
		if (
			valuesInt[0] > 23 ||
			valuesInt[0] < 0  ||
			valuesInt[1] > 59 ||
			valuesInt[1] < 0
		) {
			return false;
		}
		
		return true;
	}

	public long hourMinuteToMilisecods(String hour) {
		// El formato: (hh:mm)

		long ret = 0;
		
		String[] valuesString = hour.split(":");
		
		ret += Integer.valueOf(valuesString[0]);
		ret *= 60;
		ret += Integer.valueOf(valuesString[1]);
		ret *= 60;
		ret *= 1000;
		
		return ret;
	}
	
	
	public static void main(String[] args) {
		HourAssets ha = new HourAssets();
		
		System.out.println(ha.hourMinuteValid("10:10"));
		System.out.println(ha.hourMinuteValid("10:10"));
	}

}
