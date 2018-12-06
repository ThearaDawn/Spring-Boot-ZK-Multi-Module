package com.djava.configuration;

public class SecurityUtil {
	private SecurityUtil() {
	}

	public static boolean isAllGranted(String authorities) {
		return true;
	}

	@SuppressWarnings("unused")
	private static boolean isAuthenticated(final String feature) {
		return true;
	}
}
