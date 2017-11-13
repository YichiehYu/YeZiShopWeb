package com.wujiuye.yezishop.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Base64;


/**
 * 使用代理访问http 
 * @author wjy
 *
 */
public class ProxyHttpURLConnectionUtils {
	/**
	 * http代理ip
	 */
	private static final String proxyAddress = "116.196.107.90";
	/**
	 * http代理端口
	 */
	private static final int proxyPort = 16816;
	/**
	 *  http代理账号用户名
	 */
	private static final String proxyUserName = "15278712509";
	/**
	 * http代理账号密码
	 */
	private static final String proxyPassword = "2mqnzvgq";

	/**
	 * 接口调用 GET
	 */
	public static String httpURLConectionGET(String httpUrl) {
		try {
			URL url = new URL(httpUrl); // 把字符串转换为URL请求地址
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyAddress, proxyPort));
			HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);// 打开连接

			// 以下三行是在需要验证时，输入帐号密码信息
			String headerkey = "Proxy-Authorization";
			// 帐号密码用:隔开，base64加密方式
			String headerValue = "Basic "
					+ Base64.getEncoder().encodeToString((proxyUserName + ":" + proxyPassword).getBytes());
			connection.setRequestProperty(headerkey, headerValue);

			// 获取输入流
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {// 循环读取流
				sb.append(line);
			}
			br.close();// 关闭流
			connection.disconnect();// 断开连接
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("失败!");
		}
		return null;
	}

}
