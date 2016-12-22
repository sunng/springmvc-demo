package self.sunng.springmvc.common.util;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.PropertyResourceBundle;

public final class CommonUtil {
	
	private static final String RES_FILENAME = "config";
	private static final PropertyResourceBundle RES_PROPERTIES = (PropertyResourceBundle) PropertyResourceBundle
			.getBundle(RES_FILENAME);
	
	
	private static final String DEFAULT_CHARSET = "UTF-8";
	private CommonUtil() {
	}

    public static String getProperty(String key) {
        return RES_PROPERTIES.getString(key);
    }
	
	public static String md5(String str) {
		String resultStr = "";
		final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes(DEFAULT_CHARSET));
			final byte[] bytes = md.digest();
			final char[] chars = new char[bytes.length * 2];
			int k = 0;
			for (int i = 0; i < bytes.length; i++) {
				final byte byte0 = bytes[i];
				chars[k++] = hexDigits[byte0 >>> 4 & 0xf];
				chars[k++] = hexDigits[byte0 & 0xf];
			}
			resultStr = new String(chars);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return resultStr;
	}
	
	public static Long getSafeLong(String in) {
		if(StringUtils.isEmpty(in)) {
			return null;
		}
		try {
			return Long.parseLong(in);
		} catch(Exception e) {
			return null;
		}
	}
	
	public static int getSafeInt(String in) {
		if(StringUtils.isEmpty(in)) {
			return 0;
		}
		try {
			return Integer.parseInt(in);
		} catch(Exception e) {
			return 0;
		}
	}

	public static float getSafeFloat(String in) {
		if(StringUtils.isEmpty(in)) {
			return 0;
		}
		try {
			return Float.parseFloat(in);
		} catch(Exception e) {
			return 0;
		}
	}
}
