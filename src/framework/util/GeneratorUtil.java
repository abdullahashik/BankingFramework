package framework.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GeneratorUtil {
	@SuppressWarnings("deprecation")
	public static String randomString(int lo, int hi) {
		int n = rand(lo, hi);
		byte b[] = new byte[n];
		for (int i = 0; i < n; i++)
			b[i] = (byte) rand('0', '9');
		return new String(b, 0);
	}

	private static int rand(int lo, int hi) {
		java.util.Random rn = new java.util.Random();
		int n = hi - lo + 1;
		int i = rn.nextInt(n);
		if (i < 0)
			i = -i;
		return lo + i;
	}

	public static LocalDate getDateFromString(String strDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		if (!"".equals(strDate)) {
			return LocalDate.parse(strDate, formatter);
		}
		return LocalDate.parse("01/01/2001", formatter);
	}
}
