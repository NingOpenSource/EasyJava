package org.ning.EasyJava.utils;

import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.TimeZone;

/**
 * 获得时间的工具类
 * @author yanni
 *
 */
public class TimeUtils {
	/**
	 *  获得当前时间
	 * @return
	 */
	public long getCurrentTimeLong() {
		long time = 0;
		URL url;
		try {
			TimeZone.setDefault(TimeZone.getTimeZone("GMT+8")); // 时区设置
			url = new URL("https://www.baidu.com/");
			URLConnection uc = url.openConnection();// 生成连接对象
			uc.connect(); // 发出连接
			time = uc.getDate();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
			time = curDate.getTime();
		} // 取得资源对象

		return time;
	}


}
