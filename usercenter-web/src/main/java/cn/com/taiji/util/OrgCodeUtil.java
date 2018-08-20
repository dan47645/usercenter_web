package cn.com.taiji.util;

import java.text.SimpleDateFormat;

/**
 * 20位随机数
 * 
 * @ClassName: OrgCodeUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lyp
 * @date 2018年4月27日 下午4:38:00
 * @version V1.0
 */
public class OrgCodeUtil {
	/**
	 * 20位末尾的数字id
	 */
	public static int Guid = 100;
	// 位数，默认是8位
	private final static long w = 100000000;

	public static String getGuid() {

		OrgCodeUtil.Guid += 1;
		long now = System.currentTimeMillis();
		// 获取4位年份数字
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		// 获取时间戳
		String time = dateFormat.format(now);
		String info = now + "";
		// 获取三位随机数
		// int ran=(int) ((Math.random()*9+1)*100);
		// 要是一段时间内的数据连过大会有重复的情况，所以做以下修改
		int ran = 0;
		if (OrgCodeUtil.Guid > 999) {
			OrgCodeUtil.Guid = 100;
		}
		ran = OrgCodeUtil.Guid;

		return time + info.substring(2, info.length()) + ran;
	}

	private static byte[] lock = new byte[0];

	public static String createID() {
		long r = 0;
		synchronized (lock) {
			r = (long) ((Math.random() + 1) * w);
		}

		return System.currentTimeMillis() + String.valueOf(r).substring(1);
	}
}
