package framework.util;

public class ValidatorUtil {

	public static boolean isNumeric(String value) {
		if (value.isEmpty())
			return false;
		for (int i = 0; i < value.length(); i++) {
			if (!Character.isDigit(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}