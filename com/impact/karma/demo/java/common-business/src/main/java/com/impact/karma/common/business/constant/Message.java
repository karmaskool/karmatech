package com.impact.karma.common.business.constant;

import static java.text.MessageFormat.format;

public final class Message {
	
	private Message() {
	}

	public static final String DELETED_SUCCESFULLY = "Deleted succesfully";
	public static final String DELETED_SUCCESFULLY_$ = DELETED_SUCCESFULLY+" {0}";

	public static String deletedSuccesfully(Object... arg) {
		return format(DELETED_SUCCESFULLY_$, arg);
	}
}
