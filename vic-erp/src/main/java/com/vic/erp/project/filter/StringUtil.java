package com.vic.erp.project.filter;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;


public class StringUtil {
	public static String nvl(String str, String defaultStr) {
        return str == null ? defaultStr : str ;
	}
	
	public static String[] nvl(String[] input) {
		  if(input == null) {
		   return new String[0];
		  }  
		  return input;
		 }
	
	public static String nvl2(String str, String defaultStr) {
        return str == null ? defaultStr : (str == (null))?defaultStr: (str == "null") ?defaultStr:(str == "(null)") ?defaultStr:str ;
	}
	
	
	
	public static String enterToBr(String str) {
		str = replaceString(str);
		return str == null ? "" : str.replaceAll("\n", " <br/>");
	}
	
	public static String enterToNull(String str) {
		return str == null ? "" : str.replaceAll("\n", "");
	}	
	
	public static String decode (String msg, String type) throws UnsupportedEncodingException {
		return URLDecoder.decode (msg, type);
	}
	
	/**
	 * toString();
	 * @param value
	 * @return
	 */
	public static String toString(int value) {
		try {
			return value+"";
		} catch (Exception e) {
			return "";
		}
	}
	
	public static int toInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static long toLong(String value) {
		try {
			return Long.parseLong(value);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static String lpad(int value, int length, String prefix) {
		try {
			StringBuilder sb = new StringBuilder();
			String castValue = value + "";

			for (int i = castValue.length(); i< length; i++) {
				sb.append(prefix);
			}
			sb.append(castValue);
			return sb.toString();
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String rpad(int value, int length, String prefix) {
		try {
			StringBuilder sb = new StringBuilder();
			String castValue = value + "";
			sb.append(castValue);
			for (int i = castValue.length(); i< length; i++) {
				sb.append(prefix);
			}
			return sb.toString();
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String cutText(String text, int length, String suffix) {
		StringBuffer sb = new StringBuffer();
		
		if (!text.isEmpty()) {
			if (text.length() > length) {
				sb.append(text.substring(0, length)).append(suffix);
			} else {
				sb.append(text);
			}
		} else {
			sb.append(text);
		}
		return sb.toString();
	}

	//StringÀÌ ºñ¾ú°Å³ª nullÀÎÁö °Ë»ç
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	public static String replaceText(String text, String originTxt, String replaceTxt) {
		return text.replaceAll(originTxt, replaceTxt);
	}


	public static String replaceBrTag(String text) {
		return text.replaceAll("\\n", "<br/>");
	}
	
	public static String removeAllTag(String txt) {
        return txt.replaceAll("(?:<!.*?(?:--.*?--\\s*)*.*?>)|(?:<(?:[^>'\"]*|\".*?\"|'.*?')+>)","");
    }
	
	
	/**
	  *  get String of java.util.Map keys and values to log
	  */
	 public static String getDatasOfMap(Map map) {
	  StringBuffer buf = new StringBuffer();
	  buf.append("getDatasOfMap() =>");
	  Set set = map.keySet();
	  Iterator iter = set.iterator();
	  while(iter.hasNext()) {
	   String name = (String)iter.next();
	   String value = (String)map.get(name);
	   buf.append("[").append(name).append("|").append(value).append("]");
	  }
	  return buf.toString();  
	 }
	 
	
	public static boolean isNullCheck(String str) {
		boolean bool = false;
		
		if(str != null && !"".equals(str)) {
			bool = true;
		}
		
		return bool;
	}
	
	/**
	 * °Ë»ö °á°ú ³¯Â¥Ç¥±â MM/DD 
	 * @param value
	 * @return
	 */
	public static String historyDate(String value) {
		return !(nvl(value, "").length() == 0) && value.length() == 8 ? value = value.substring(4, 6) + "/" + value.substring(6, 8) : "";
	}
	
	
	/**
	 * °Ë»ö °á°ú ³¯Â¥Ç¥±â YYYY.MM.DD 
	 * @param value
	 * @return
	 */
	public static String historyDate2(String value) {
		return !(nvl(value, "").length() == 0) && value.length() == 8 ? value = value.substring(0, 4) + "." + value.substring(4, 6) + "." + value.substring(6, 8) : "";
	}	
	/**
	 * ÄÞ¸¶ Ãß°¡
	 * @param data
	 * @return
	 */
	public static String addComma(long data) {
		
		return new DecimalFormat("#,###").format(data);
	}
	
	/**
	 * ÇØ´ç URL ÀÇ HTML ÄÚµå¸¦ String À¸·Î °¡Á®¿È
	 * @param uri
	 * @return
	 */
	public static String getSource(String uri){
		String str=null;
		try {
			URL url = new URL( uri );
			URLConnection uc = url.openConnection();
			InputStream in = uc.getInputStream();
			int len = uc.getContentLength();
			byte buf[] = new byte[len];
			in.read(buf, 0, buf.length);
			str = new String(buf);
	    } catch (Exception e){
	    	e.printStackTrace();
	    }
	    return str;
	  }
	/**
	 * ±æÀÌÃ¼Å©
	 * @param min
	 * @param max
	 * @param str
	 * @return
	 */
	public static boolean chkLength (int min, int max, String str) {
		int len = str.length ();
		return len < min || len > max ;
	}
	/**
	 * ¿¬¼ÓµÈ °ª Ã¼Å©
	 * @param str
	 * @param cmpCnt
	 * @return
	 */
	public static boolean chkSer (String str, int cmpCnt) {
		ByteBuffer bf = ByteBuffer.wrap(str.getBytes());
		//¿¬¼ÓµÈ °³¼ö
		int serCnt = 1;
		//Ã¹¹øÂ° ¹®ÀÚÄÚµå
		int curr = bf.get ();
		//¿¡·¯ ¿©ºÎ
		boolean flag = false;
		
		for (int i = bf.position(), last =  bf.capacity(); i < last; i += 1) {
			//ÀÓ½Ã º¯¼ö
			int tmp = bf.get();
			//Ã¹¹øÂ° ¹®ÀÚ¿Í ÇöÀç ¹®ÀÚÀÇ Â÷ÀÌ°¡ 1ÀÌ¸é
			if ( Math.abs(curr - tmp) == 1 ) {
				//¿¬¼Ó Ä«¿îÆ® 1Áõ°¡
				serCnt += 1;
			} else {
				//Ä«¿îÆ® ¸®¼Â
				serCnt = 1;
			}
			//¼ýÀÚ º¯°æ
			curr = tmp;
			//¿¬¼ÓÈ½¼ö°¡ ¼³Á¤ÇÑ °ª°ú °°´Ù¸é Á¾·á
			/*if ( (flag = serCnt == cmpCnt) ) {
				break;
			}*/
			if ( serCnt == cmpCnt ) {
				return flag; 
			}
		}
		return flag;
	}
	/**
	 * ¹Ýº¹°ª Ã¼Å©
	 * @param str
	 * @param cmpCnt
	 * @return
	 */
	public static boolean chkRpt (String str, int cmpCnt) {
		ByteBuffer bf = ByteBuffer.wrap(str.getBytes());
		//¹Ýº¹µÈ °³¼ö
		int rptCnt = 1;
		//Ã¹¹øÂ° ¹®ÀÚÄÚµå
		int curr = bf.get ();
		//¿¡·¯ ¿©ºÎ
		boolean flag = false;
		
		for (int i = bf.position(), last = bf.capacity(); i < last; i += 1) {
			//ÀÓ½Ã º¯¼ö
			int tmp = bf.get();
			//Ã¹¹øÂ° ¹®ÀÚ¿Í ÇöÀç ¹®ÀÚÀÇ Â÷ÀÌ°¡ 1ÀÌ¸é
			if ( curr == tmp ) {
				//¿¬¼Ó Ä«¿îÆ® 1Áõ°¡
				rptCnt += 1;
			} else {
				//Ä«¿îÆ® ¸®¼Â
				rptCnt = 1;
			}
			//¼ýÀÚ º¯°æ
			curr = tmp;
			//¿¬¼ÓÈ½¼ö°¡ ¼³Á¤ÇÑ °ª°ú °°´Ù¸é Á¾·á
			//$ANALYSIS-IGNORE
			if ( (flag = rptCnt == cmpCnt) ) {
				break;
			}
		}
		return flag;
	}
	/**
	 * ÁöÁ¤ÇÑ Á¤º¸°¡ ¹®ÀÚ¿­¿¡ ÁöÁ¤ÇÑ °³¼ö ÀÌ»ó Æ÷ÇÔµÇ¾ú´ÂÁö Ã¼Å©
	 * @param cnt
	 * @param info
	 * @param str
	 * @return
	 */
	public static boolean chkInfo (int cnt, String info, String str) {
		//¿¡·¯ ¿©ºÎ
		boolean flag = false;

		if (null == info) {
			return flag; 
		} else {
			for (int i = 0, length = info.length() - cnt + 1; i < length; i += 1) {
				//ÀÔ·Â°ª¿¡ Á¤º¸°¡ 3ÀÚ¸® ÀÌ»ó Æ÷ÇÔµÇ¸é ¿¡·¯ 
				/*if ( (flag = str.indexOf(info.substring(i, i + cnt)) != -1) ) {
					break;
				}*/
				if ( str.indexOf(info.substring(i, i + cnt)) != -1 ) {
					return flag;
				}
			}
		}
		return flag;
	}
	/**
	 * ÁöÁ¤ÇÑ Byte·Î ¹®ÀÚ¿­À» ÀÚ¸£°í ÁöÁ¤ÇÑ ¸»ÁÙÀÓ ¹®ÀÚ¸¦ ºÙÀÎ´Ù.
	 * @param raw
	 * @param len
	 * @param encoding
	 * @param prefix
	 * @return
	 */
	public static String stringByteCut(String raw, int len, String encoding, String prefix) {  
		if (raw == null) return null;
		String[] ary = null;
		String result = null;
		try {
			// raw ÀÇ byte
			byte[] rawBytes = raw.getBytes(encoding);
			int rawLength = rawBytes.length;

			int index = 0;
			int minus_byte_num = 0;
			int offset = 0;

			int hangul_byte_num = encoding.equals("UTF-8") ? 3 : 2;

			if(rawLength > len){
				int aryLength = (rawLength / len) + (rawLength % len != 0 ? 1 : 0);
				ary = new String[aryLength];

				for(int i=0; i<aryLength; i++){
					minus_byte_num = 0;
					offset = len;
					if(index + offset > rawBytes.length){
						offset = rawBytes.length - index;
					}
					for(int j=0; j<offset; j++){      
						if(((int)rawBytes[index + j] & 0x80) != 0){
							minus_byte_num ++;
						}
					}     
					if(minus_byte_num % hangul_byte_num != 0){
						offset -= minus_byte_num % hangul_byte_num;
					}     
					ary[i] = new String(rawBytes, index, offset, encoding);     
					index += offset ;

				}    
				result = ary[0] + prefix;
			} else {
				//ary = new String[]{raw};
				result = raw;
			}    
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static Boolean regex (String regex,  String str) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		return m.find();
	}
	public static boolean NumberChk(String str){
		str = str.trim();
	    char c = ' ';

	    if(str.length() == 0) return false;
	    
	    int loopCnt = str.length();
	    for(int i = 0 ; i < loopCnt ; i++){
	        c = str.charAt(i);
	        if(c < 48 || c > 57){
	            return false;
	        }
	    }
	    return true;
	}

	/**
	 * Æ¯¼ö¹®ÀÚ¸¦ À¥ ºê¶ó¿ìÀú¿¡¼­ Á¤»óÀûÀ¸·Î º¸ÀÌ±â À§ÇØ Æ¯¼ö¹®ÀÚ¸¦ Ã³¸®('<' -> & lT)ÇÏ´Â ±â´ÉÀÌ´Ù
	 * @param str
	 * @return
	 */
	public static String replaceString(String str)	{
		String returnValue = "";
		if(  str== null ) 			{
			returnValue="" ;
		} else {
		  	str = str.replaceAll("&"  , "&amp;");
		    str = str.replaceAll("<"  , "&lt;");
		    str = str.replaceAll(">"  , "&gt;");
		  	str = str.replaceAll("\'" , "&apos;");
		  	str = str.replaceAll("\"" , "&quot;");
//		  	str = str.replaceAll("%"  , "&#37;");
//		  	str = str.replaceAll(" "  , "&#10;");
//		  	str = str.replaceAll("\r"  , "&#10;");
//		  	str = str.replaceAll("\n"  , "&#10;");
//		  	str = str.replaceAll("\\("  , "&#40;");
//		  	str = str.replaceAll("\\)"  , "&#41;");
//		  	str = str.replaceAll("#"  , "&#35;");
		  	returnValue = str; 
		  	
		}
		return returnValue ;
	}
	
	public static boolean adminYn(String str){ 
		return Pattern.matches("^[°¡-ÆR]*$", str);
	}
	
    public static String getClientIp(HttpServletRequest request){
		String clientIp = StringUtil.nvl(request.getHeader("X-Forwarded-For"),"");
		if(clientIp == null || clientIp.length() == 0){
			clientIp = StringUtil.nvl(request.getHeader("WL-Proxy-Client-IP"),"");
		}
		if(clientIp == null || clientIp.length() == 0){
			clientIp = StringUtil.nvl(request.getHeader("Proxy-Client-IP"),"");
		}
		if(clientIp == null || clientIp.length() == 0){
			clientIp = request.getRemoteAddr();
		}
    	return clientIp.trim();
    }
    
	public static String commaStr(Long num) {
		String commaNum = NumberFormat.getInstance(Locale.US).format(num);
		return commaNum;
	}    
	
	public static String commaStr(int num) {
		String commaNum = NumberFormat.getInstance(Locale.US).format(num);
		return commaNum;
	}	
	
	public static String nullTrim( String str ) {
		if (str == null) {
			str = "";
		} else {
			str = str.trim();
		}
		return str;
	}	
	
}
