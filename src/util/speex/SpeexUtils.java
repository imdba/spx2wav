package util.speex;

import java.lang.reflect.Field;

/**
 * @author ZhaoChangjin
 * @date 2018.4.10
 */
public class SpeexUtils {

	/**
	 * .speex to .wav
	 * 
	 * @param src .speex
	 * @param dist .wav
	 * @return
	 */
	public static native boolean decode(String src, String dist);

	static {
		try {
			System.setProperty("java.library.path", System.getProperty("java.library.path") + ":/usr/local/lib/");
			Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
			fieldSysPath.setAccessible(true);
			fieldSysPath.set(null, null);
			System.loadLibrary("jspeex");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
