package com.impact.karma.common.business.util;

import java.text.MessageFormat;

public final class DateUtil {

	private DateUtil() {
	}

	public static final String yyyyMMdd = "yyyy-MM-dd";
	public static final String ddMMyyyy = "dd-MM-yyyy";

	public static final String hhmmssSSS_SSSS = "hh:mm:ss.SSS-SSSS";
	public static final String hhmmssSSS = "hh:mm:ss.SSS";
	public static final String hhmmss = "hh:mm:ss";
	public static final String hhmm = "hh:mm";

	public static final String T = "'T'";
	public static final String SPACE = " ";

	public static final String DATE_001 = yyyyMMdd + T + hhmmssSSS_SSSS;
	public static final String DATE_002 = yyyyMMdd + T + hhmmssSSS;
	public static final String DATE_003 = yyyyMMdd + T + hhmmss;
	public static final String DATE_004 = yyyyMMdd + T + hhmm;

	public static final String DATE_005 = ddMMyyyy + SPACE + hhmmssSSS_SSSS;
	public static final String DATE_006 = ddMMyyyy + SPACE + hhmmssSSS;
	public static final String DATE_007 = ddMMyyyy + SPACE + hhmmss;
	public static final String DATE_008 = ddMMyyyy + SPACE + hhmm;
	
	public static String pattern(String datePattern, String timePattern) {
		return pattern(datePattern, timePattern, " ");
	}

	public static String patternT(String datePattern, String timePattern) {
		return pattern(datePattern, timePattern, "'T'");
	}

	public static String pattern(String datePattern, String timePattern, String betweenSeparator) {
		return MessageFormat.format("{0}{1}{2}", datePattern, betweenSeparator, timePattern);
	}

}
