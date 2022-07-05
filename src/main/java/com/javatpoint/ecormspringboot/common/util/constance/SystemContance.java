package com.javatpoint.ecormspringboot.common.util.constance;

import java.util.Base64;

public class SystemContance {
	public static final long EXPIRATION_TIME = 86400000;
	public static final long REFRESH_TIME = 90000000;
	public static final String SECREC = "huynhgiahuy";
	public static final String TOKEN_PREFIX = "Bearer";
	public static final String AUTHORIZATION_KEY_IN_HEADER = "Authorization";
	public static final Base64.Encoder encoder = Base64.getEncoder();
	public static final Base64.Decoder decoder = Base64.getDecoder();
	public static final String DEFAULT_SELECTION = "None";
	public static final String PUBLIC_KEY_FILE_NAME = "public.txt";
	public static final String PRIVATE_KEY_FILE_NAME = "private.txt";
	public static final String UNICODE_FORMAT = "UTF-8";
	public static final String TEXT_TYPE = "text";
	public static final String FILE_TYPE = "file";
	public static final String ENCRYPT_PREFIX = "encrypted-file";
	public static final String DECRYPT_PREFIX = "decrypted-file";
}
