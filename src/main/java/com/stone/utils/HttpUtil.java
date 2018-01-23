package com.stone.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;


public class HttpUtil {
	public static Logger log = Logger.getLogger(HttpUtil.class); 
	/**
	 * 
	 * 目的：从url读取字符串，按行插入换行符，5秒超时
	 *
	 * @param url
	 * @return
	 */
	@Deprecated
	public static String getStrFromUrl(String url, String charsetName) {
		StringBuffer sb = new StringBuffer();
		try {
			URLConnection urlConn = new URL(url).openConnection();
			urlConn.setConnectTimeout(5000);
			urlConn.setReadTimeout(5000);
			InputStreamReader isr = new InputStreamReader(
					urlConn.getInputStream(), charsetName);
			BufferedReader br = new BufferedReader(isr);
			String str = br.readLine();
			while (str != null) {
				sb.append(str);
				sb.append('\n');
				str = br.readLine();
			}
			br.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (sb.length() > 0) {
			return sb.toString();
		} else {
			return null;
		}
	}

	/**
	 * 
	 * 目的：下载文件，5秒超时
	 *
	 * @param url
	 *            文件url
	 * @param saveFile
	 *            另存文件路径及名字，若该文件存在则会被覆盖掉
	 * @return
	 */
	public static Boolean downloadFile(String url, String saveFile) {
		Boolean result = false;
		URL u;
		FileOutputStream fos;
		BufferedInputStream bis;
		try {
			fos = new FileOutputStream(saveFile);
			u = new URL(url);
			URLConnection con = u.openConnection();
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			bis = new BufferedInputStream(con.getInputStream());
			byte[] b = new byte[65535];
			int byteRead;
			while ((byteRead = bis.read(b)) > 0) {
				fos.write(b, 0, byteRead);
			}
			fos.flush();
			fos.close();
			bis.close();
			result = true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (java.net.SocketTimeoutException e) {
			// System.out.println("download file " + url + " timeout");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Boolean unZipHttpFiles(String httpUrl, String savePath) {
		URL url;
		URLConnection conn;
		InputStream is;
		ZipInputStream zis;
		Boolean result = false;
		try {
			url = new URL(httpUrl);
			conn = url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			is = conn.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		zis = new ZipInputStream(new BufferedInputStream(is));
		try {
			ZipEntry ze;
			while ((ze = zis.getNextEntry()) != null) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int count;
				while ((count = zis.read(buffer)) != -1) {
					baos.write(buffer, 0, count);
				}
				String filename = ze.getName();
				byte[] bytes = baos.toByteArray();
				// do something with 'filename' and 'bytes'...
				File f = new File(savePath, filename);
				if (f.exists()) {
					f.delete();
				}
				FileOutputStream fs = new FileOutputStream(savePath + "/"
						+ filename);
				fs.write(bytes);
				fs.close();
			}
			result = true;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		} finally {
			try {
				zis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * HTTP GET 请求
	 * 
	 * @param url
	 *            请求 url
	 * @return String
	 */
	public static String Get(String url) {
		log.info("GET查询URL：" + url);
		HttpURLConnection urlConnection;
		InputStreamReader in = null;
		BufferedReader br = null;
		String temp = "";
		StringBuffer result = new StringBuffer();
		try {
			URL getUrl = new URL(url);
			urlConnection = (HttpURLConnection) getUrl.openConnection();
			// 设置连接主机超时（单位：毫秒）
			urlConnection.setConnectTimeout(10000);
			urlConnection.setReadTimeout(10000);
			urlConnection.connect();
			in = new InputStreamReader(urlConnection.getInputStream(), "UTF-8");
			br = new BufferedReader(in);
			temp = br.readLine();
			while (temp != null) {
				result.append(temp);
				result.append("\n");
				temp = br.readLine();
			}
			return result.toString();
		} catch (Exception e) {
			log.info("Exception,HTTP get URL=" + url);
			e.printStackTrace();
			return "";
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * HTTP POST 请求
	 * 
	 * @param url
	 *            请求url
	 * @param params
	 *            url参数
	 * @return String
	 */
	public static String Post(String url, String params) {
		log.info("POST请求URL：" + url);
//		log.info("POST参数params：" + params);
		BufferedReader br = null;
		HttpURLConnection connection = null;
		String temp = "";
		StringBuffer result = new StringBuffer();
		try {
			URL postUrl = new URL(url);
			// 打开连接
			connection = (HttpURLConnection) postUrl.openConnection();
			// 设置是否向connection输出，因为这个是post请求，参数要放在 http正文内，因此需要设为true
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			// Post 请求不能使用缓存
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			/*
			 * 配置本次连接的Content-type，配置为application/x-www-form-
			 * urlencoded的意思是正文是urlencoded编码过的form参数，
			 * 下面我们可以看到我们对正文内容使用URLEncoder.encode进行编码
			 */
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			// 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
			// 要注意的是connection.getOutputStream会隐含的进行connect。
			connection.connect();
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(10000);
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());
			// DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写道流里面
			out.writeBytes(params);
			out.flush();
			out.close();
			// 获取字节流，把字节流转换成字符流。 设置编码,防止中文乱码
			br = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));
			temp = br.readLine();
			while (temp != null) {
				result.append(temp);
				result.append("\n");
				temp = br.readLine();
			}
			return result.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			log.error("通过http post获取数据失败，获取的url为=" + url + params);
			e.printStackTrace();
			return "";
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				connection.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
    /**
     * 描述:  发起https请求并获取结果
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject weChatHttpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
            log.error("Weixin server connection timed out.");
        } catch (Exception e) {
            log.error("https request error:{}", e);
        }
        return jsonObject;
    }
    
    
  //上传图片素材/上传图文消息内的图片获取URL 
 // url - 路径
 //filePath 图片绝对路径
 public static String postFile(String url, String filePath) {
     File file = new File(filePath);
     if (!file.exists())
         return null;
     String result = "";
     try {
         URL url1 = new URL(url);
         HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
         conn.setConnectTimeout(5000);
         conn.setReadTimeout(30000);
         conn.setDoOutput(true);
         conn.setDoInput(true);
         conn.setUseCaches(false);
         conn.setRequestMethod("POST");
         conn.setRequestProperty("Connection", "Keep-Alive");
         conn.setRequestProperty("Cache-Control", "no-cache");
         String boundary = "-----------------------------" + System.currentTimeMillis();
         conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

         OutputStream output = conn.getOutputStream();
         output.write(("--" + boundary + "\r\n").getBytes());
         output.write(
                 String.format("Content-Disposition: form-data; name=\"media\"; filename=\"%s\"\r\n", file.getName())
                         .getBytes());
         output.write("Content-Type: image/jpeg \r\n\r\n".getBytes());
         byte[] data = new byte[1024];
         int len = 0;
         FileInputStream input = new FileInputStream(file);
         while ((len = input.read(data)) > -1) {
             output.write(data, 0, len);
         }
         output.write(("\r\n--" + boundary + "\r\n\r\n").getBytes());
         output.flush();
         output.close();
         input.close();
         InputStream resp = conn.getInputStream();
         StringBuffer sb = new StringBuffer();
         while ((len = resp.read(data)) > -1)
             sb.append(new String(data, 0, len, "utf-8"));
         resp.close();
         result = sb.toString();
     } catch (ProtocolException e) {
         log.error("postFile，不支持http协议", e);
     } catch (IOException e) {
    	 log.error("postFile数据传输失败", e);
     }
     return result;
 }

}
