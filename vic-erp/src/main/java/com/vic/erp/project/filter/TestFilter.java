package com.vic.erp.project.filter;

import java.util.regex.Pattern;

public class TestFilter {

		// XSS filter pattern compile
			private static Pattern pattern1 = Pattern.compile("<([^>]*) on([A-Z]+)[\t\n\r ]*=([^>]*)>", Pattern.CASE_INSENSITIVE);	
			private static Pattern pattern2 = Pattern.compile("<([^>]*)(?:/\\*(?:.|\\s)*?\\*/)([^>]*)>", Pattern.CASE_INSENSITIVE);
			private static Pattern pattern3 = Pattern.compile("<([^>]*)(?:/\\*(?:.|\\s)*?\\*/)([^>]*)>", Pattern.CASE_INSENSITIVE);
			private static Pattern pattern4 = Pattern.compile("<([^>]*) style[\t\n\r ]*=[\'\"xss: ]*expression[\'\" ]*([^>]*)>", Pattern.CASE_INSENSITIVE);
		    private static Pattern pattern5 = Pattern.compile("<[\t\n\r ]*/?[\t\n\r ]*SCRIPT[\t\n\r ]*[^>]*>", Pattern.CASE_INSENSITIVE);
		    private static Pattern pattern6 = Pattern.compile("<[^>]+((j|&#(106|x6A)[;]*)[\t\n\r]*(a|&#(97|x61)[;]*)[\t\n\r ]*(v|&#(118|x76)[;]*)[\t\n\r]*(a|&#(97|x61)[;]*)|v[\t\n\r]*b)[\t\n\r]*(s|&#(115|x73)[;]*)[\t\n\r]*(c|&#(99|x63)[;]*)[\t\n\r]*(r|&#(114|x72)[;]*)[\t\n\r]*(i|&#(105|x69)[;]*)[\t\n\r]*(p|&#(112|x70)[;]*)[\t\n\r]*(t|&#(116|x74)[;]*)[\t\n\r]*(:|&#(58|x3A)[;]*)[^>]+>", Pattern.CASE_INSENSITIVE);
		    private static Pattern pattern7 = Pattern.compile("<[\t\n\r ]*META[^>]*>", Pattern.CASE_INSENSITIVE);
		    private static Pattern pattern8 = Pattern.compile("<[\t\n\r ]*/?[\t\n\r ]*IFRAME[^>]*>",  Pattern.CASE_INSENSITIVE);
		    private static Pattern pattern9 = Pattern.compile("<[\t\n\r ]*LINK[^>]*>", Pattern.CASE_INSENSITIVE);
		    private static Pattern pattern10=Pattern.compile("<[\t\n\r ]*/?[\t\n\r ]*FORM[^>]*>", Pattern.CASE_INSENSITIVE);
		    private static Pattern pattern11=Pattern.compile("<([^>]*) TYPE[\t\n\r ]*=[\'\" ]*text/x-scriptlet[\'\" ]*([^>]*)>",Pattern.CASE_INSENSITIVE);    
		    private static Pattern pattern12=Pattern.compile("<([^>]*) name[\t\n\r ]*=[\'\" ]*AllowScriptAccess[\'\" ]* value[\t\n\r ]*=[\'\" ]*always[\'\" ]*([^>]*)>", Pattern.CASE_INSENSITIVE);
		    private static Pattern pattern13=Pattern.compile("<([^>]*) AllowScriptAccess[\t\n\r ]*=[\'\" ]*always[\'\" ]*([^>]*)>", Pattern.CASE_INSENSITIVE);
		    private static Pattern pattern14 = Pattern.compile("<[\t\n\r ]*/?[\t\n\r ]*OBJECT[\t\n\r ]*[^>]*>", Pattern.CASE_INSENSITIVE);
		    private static Pattern pattern15 = Pattern.compile("<[\t\n\r ]*/?[\t\n\r ]*JAVASCRIPT[\t\n\r ]*[^>]*>", Pattern.CASE_INSENSITIVE);
		
		public static String replaceHtmlTag(String str){

//			String temp = str;
			
			String str_low = "";
			/*
			 * 2019.05.10
			 * Null 값 변경 처리
			 */
			if( StringUtil.nvl(str,"").equals("")) {
				return "";
			}
			
			str = str.replaceAll("<","&lt;");
	        str = str.replaceAll(">","&gt;");
	         
	        // 특수 문자 제거
	        str = str.replaceAll("\"","&gt;");
	        str = str.replaceAll("&", "&amp;");
	        str = str.replaceAll("%00", null);
	        str = str.replaceAll("\"", "&#34;");
	        str = str.replaceAll("\'", "&#39;");
	        str = str.replaceAll("%", "&#37;");    
	        str = str.replaceAll("../", "");
	        str = str.replaceAll("..\\\\", "");
	        str = str.replaceAll("./", "");
	        str = str.replaceAll("%2F", "");
	        // 허용할 HTML tag만 변경
	        str = str.replaceAll("&lt;p&gt;", "<p>");
	        str = str.replaceAll("&lt;P&gt;", "<P>");
	        str = str.replaceAll("&lt;br&gt;", "<br>");
	        str = str.replaceAll("&lt;BR&gt;", "<BR>");
	        str_low= str.toLowerCase();
	        if( str_low.contains("javascript") || str_low.contains("script")     || str_low.contains("iframe") || 
	                str_low.contains("document")   || str_low.contains("vbscript")   || str_low.contains("applet") || 
	                str_low.contains("embed")      || str_low.contains("object")     || str_low.contains("frame") || 
	                str_low.contains("grameset")   || str_low.contains("layer")      || str_low.contains("bgsound") || 
	                str_low.contains("alert")      || str_low.contains("onblur")     || str_low.contains("onchange") || 
	                str_low.contains("onclick")    || str_low.contains("ondblclick") || str_low.contains("enerror") ||  
	                str_low.contains("onfocus")    || str_low.contains("onload")     || str_low.contains("onmouse") || 
	                str_low.contains("onscroll")   || str_low.contains("marquee")  || str_low.contains("onsubmit")  || str_low.contains("confirm") || str_low.contains("svg") || str_low.contains("onstart") || str_low.contains("onunload"))
	        {
	            str = str_low;
	            str = str.replaceAll("javascript", "x-javascript");
	            str = str.replaceAll("script", "x-script");
	            str = str.replaceAll("document", "x-document");
	            str = str.replaceAll("vbscript", "x-vbscript");
	            str = str.replaceAll("applet", "x-applet");
	            str = str.replaceAll("embed", "x-embed");
	            str = str.replaceAll("object", "x-object");
	            str = str.replaceAll("frame", "x-frame");
	            str = str.replaceAll("grameset", "x-grameset");
	            str = str.replaceAll("layer", "x-layer");
	            str = str.replaceAll("bgsound", "x-bgsound");
	            str = str.replaceAll("alert", "");
	            str = str.replaceAll("onblur", "x-onblur");
	            str = str.replaceAll("onchange", "x-onchange");
	            str = str.replaceAll("onclick", "x-onclick");
	            str = str.replaceAll("ondblclick","");
	            str = str.replaceAll("enerror", "");
	            str = str.replaceAll("onfocus", "");
	            str = str.replaceAll("onload", "");
	            str = str.replaceAll("onmouse", "");
	            str = str.replaceAll("onscroll", "");
	            str = str.replaceAll("onsubmit", "");
	            str = str.replaceAll("onunload", "");
	            str = str.replaceAll("marquee", "");
	            str = str.replaceAll("onstart", "");
	            str = str.replaceAll("svg", "");
	            str = str.replaceAll("confirm", "");
	        }
	  
	        String temp = str;
	        return temp;
		}
		
		/**
		 * 파라미터로 받은 String변수의 Html및 스크립트를 변환 수행
		 * @param contents			- String
		 * @return
		 */
		public static String xssFilter(String contents) {
	        try {
	            
	        	if( StringUtil.nvl(contents,"").equals("")) {
	    			return "";
	    		}
	        	
	            // 태그내(<>)에 on으로 시작하는 함수명 앞에 no-를 추가
	            // before : <tr onmouseover="alert('test')">
	            // after : <tr no-onmouseover="alert('test')">
	            contents = pattern1.matcher(contents).replaceAll("<$1 no-on$2=$3>");

	            // 태그내 /* */주석 제거
	            while( pattern2.matcher(contents).find()){
	                contents = pattern3.matcher(contents).replaceAll("<$1$2>");
	            }

	            // 태그내(<>)에 style속성내에 expression이후 속성을 제거
	            // befor : <IMG STYLE="xss:e/*XSS*/xpression(alert('XSS'))">
	            // after : <IMG no-style>
	            contents = pattern4.matcher(contents).replaceAll("<$1>");
	                        
	            // script  태그를 주석처리함.
	            // before : <SCRIPT/XSS SRC="http://xxxx/xss.js"></SCRIPT>
	            // after : <no-script></no-script>
	            contents = pattern5.matcher(contents).replaceAll("<!--<script>-->");
	            
	            // 태그내(<>) javascript문자열 또는 unicode로 변환된 javascript가 들어 있는 태그를 주석처리함.
	            // before : <LINK REL="stylesheet" HREF="javascript:alert('XSS');">
	            // after : <no-javascript>
	            // before :<IMG SRC=&#106;&#97;&#118;&#97;&#115;&#99;&#114;&#105;&#112;&#116;&#58;&#97;&#108;&#101;&#114;&#116;&#40;&#39;&#88;&#83;&#83;&#39;&#41;>
	            // after : <no-javascript>
	            contents = pattern6.matcher(contents).replaceAll("<!--<javascript>-->");
	            
	            
	            // meta 태그를 주석처리함
	            // before : <META HTTP-EQUIV="refresh" CONTENT="0;url=data:text/html;base64,PHNjcmlwdD5hbGVydCgnWFNTJyk8L3NjcmlwdD4K">
	            // after : <!--<meta>-->
	            contents = pattern7.matcher(contents).replaceAll("<!--<meta>-->");

	            // iframe 태그를 주석처리함
	            // before : <IFRAME SRC=http://ha.ckers.org/scriptlet.html/>
	            // after : <!--<iframe>-->
	            contents = pattern8 .matcher(contents).replaceAll("<!--<iframe>-->");
	            

	            // link 태그를 주석처리함
	            // before : <LINK REL="stylesheet" HREF="http://ha.ckers.org/xss.css">
	            // after : <!--<link>-->
	            contents = pattern9.matcher(contents).replaceAll("<!--<link>-->");
	            
	            // form 태그를 주석처리함   
	            // before : <form name=\"formName\" action=\xss.php\">
	            // after : <!--<form>-->            
	            contents =pattern10.matcher(contents).replaceAll("<!--<form>-->");


	            // 태그내에 text/x-scriptlet을 text/plain으로 변경
	            // before : <OBJECT TYPE="text/x-scriptlet" DATA="http://ha.ckers.org/scriptlet.html">
	            // after : <OBJECT TYPE="text/plain" DATA="http://ha.ckers.org/scriptlet.html"/>        
	            contents = pattern11.matcher(contents).replaceAll("<$1 TYPE=\"text/plain\" $2>");
	            
	            // 태그내에 name="AllowScriptAccess" value="always" 를 name="AllowScriptAccess" value="naver" 변경.
	            // before: <object width="480" height="385">
	            //               <param name="movie" value="http://www.youtube.com/v/nhcdFSUA4TI?fs=1&amp;hl=ko_KR"></param>
	            //               <param name="allowFullScreen" value="true"></param>
	            //               <param name="allowScriptAccess" value="always"></param>
	            //               <embed src="http://www.youtube.com/v/nhcdFSUA4TI?fs=1&amp;hl=ko_KR" type="application/x-shockwave-flash" allowScriptAccess="allways" allowfullscreen="true" width="480" height="385"></embed>
	            //            </object>
	            // after: <object width="480" height="385">
	            //               <param name="movie" value="http://www.youtube.com/v/nhcdFSUA4TI?fs=1&amp;hl=ko_KR"></param>
	            //               <param name="allowFullScreen" value="true"></param>
	            //               <param name="allowScriptAccess" value="never"></param>
	            //               <embed src="http://www.youtube.com/v/nhcdFSUA4TI?fs=1&amp;hl=ko_KR" type="application/x-shockwave-flash" allowScriptAccess="never" allowfullscreen="true" width="480" height="385"></embed>
	            //            </object>
	            contents = pattern12.matcher(contents)
	                    .replaceAll("<$1 name=\"allowScriptAccess\" value=\"never\" $2>");
	            
//	            contents = contents.replaceAll("\'", "&#39;");
//	            contents = contents.replaceAll("\"", "&#34;");
	            // 태그내에 AllowScriptAccess=always를 never로 변경.
	            // before : <EMBED SRC="http://ha.ckers.org/xss.swf" AllowScriptAccess="always">
	            // after : <EMBED SRC="http://ha.ckers.org/xss.swf" AllowScriptAccess="never" >
	            contents =pattern13.matcher(contents).replaceAll("<$1 allowScriptAccess=\"never\" $2>");
	            contents =pattern14.matcher(contents).replaceAll("<!--<object>-->");
	            contents =pattern15.matcher(contents).replaceAll("<!--<javascript>-->");
	            
	            String str_low= contents.toLowerCase();
	            if( str_low.contains("javascript") || str_low.contains("script")     || str_low.contains("iframe") || 
	                    str_low.contains("document")   || str_low.contains("vbscript")   || str_low.contains("applet") || 
	                    str_low.contains("embed")      || str_low.contains("object")     || str_low.contains("frame") || 
	                    str_low.contains("grameset")   || str_low.contains("layer")      || str_low.contains("bgsound") || 
	                    str_low.contains("alert")      || str_low.contains("onblur")     || str_low.contains("onchange") || 
	                    str_low.contains("onclick")    || str_low.contains("ondblclick") || str_low.contains("enerror") ||  
	                    str_low.contains("onfocus")    || str_low.contains("onload")     || str_low.contains("onmouse") || 
	                    str_low.contains("onscroll")   || str_low.contains("onsubmit")   || str_low.contains("marquee")  || str_low.contains("onunload")  || str_low.contains("confirm") || str_low.contains("svg") || str_low.contains("onstart") || str_low.contains("prompt") )
	            {
	            	contents = str_low;
	            	contents = contents.replaceAll("iframe", "x-iframe");
	            	contents = contents.replaceAll("document", "x-document");
	            	contents = contents.replaceAll("javascript", "x-javascript");
	            	contents = contents.replaceAll("script", "x-script");
	            	contents = contents.replaceAll("vbscript", "x-vbscript");
	            	contents = contents.replaceAll("applet", "x-applet");
	            	contents = contents.replaceAll("embed", "x-embed");
	            	contents = contents.replaceAll("object", "x-object");
	            	contents = contents.replaceAll("frame", "x-frame");
	            	contents = contents.replaceAll("grameset", "x-grameset");
	            	contents = contents.replaceAll("layer", "x-layer");
	            	contents = contents.replaceAll("bgsound", "x-bgsound");
	            	contents = contents.replaceAll("alert", "x-alert");
	            	contents = contents.replaceAll("onblur", "x-onblur");
	            	contents = contents.replaceAll("onchange", "x-onchange");
	            	contents = contents.replaceAll("onclick", "x-onclick");
	            	contents = contents.replaceAll("ondblclick","x-ondblclick");
	            	contents = contents.replaceAll("enerror", "x-enerror");
	                contents = contents.replaceAll("onfocus", "x-onfocus");
	                contents = contents.replaceAll("onload", "x-onload");
	                contents = contents.replaceAll("onmouse", "x-onmouse");
	                contents = contents.replaceAll("onscroll", "x-onscroll");
	                contents = contents.replaceAll("onsubmit", "x-onsubmit");
	                contents = contents.replaceAll("onunload", "x-onunload");
	                contents = contents.replaceAll("marquee", "x-marquee");
	                contents = contents.replaceAll("onstart", "x-onstart");
	                contents = contents.replaceAll("svg", "x-svg");
	                contents = contents.replaceAll("confirm", "x-confirm");
	                contents = contents.replaceAll("prompt", "x-prompt");
	                System.out.println(contents);
	            }
	      
	            
	        } catch (Exception e) {}
	        
	        return contents;
	    }
		
		public static String escapeHtmlString(String s) {
		    String s1 = s;
		    if (s1 == null)
		        return null;
		    String[] arguments     = { "<", ">", "\"", "\'" };
		    String[] replacements  = { "&lt;", "&gt;", "&quot;", "&#39;" };
		    return replace(s1, arguments, replacements);
		}

		public static String reEscapeHtmlString(String s) {
			String s1 = s;
			if (s1 == null)
				return null;
			String[] arguments = { "&amp;", "&lt;", "&gt;", "&quot;", "&#39;" };
			String[] replacements = { "&", "<", ">", "\"", "\'" };
			return replace(s1, arguments, replacements);
		}
		
		public static String replace(String target, String[] arguments,
				String[] replacements) {
			if (target == null || arguments == null || replacements == null)
				return target;

			for (int index = 0; index < arguments.length; index++) {
				target = replace(target, arguments[index], replacements[index]);
			}

			return target;
		}
		
		public static String replace(String target, String argument,
				String replacement) {
			if (target == null || argument == null || replacement == null)
				return target;

			int i = target.indexOf(argument);

			if (i == -1)
				return target;

			StringBuffer targetSB = new StringBuffer(target);
			while (i != -1) {
				targetSB.delete(i, i + argument.length());
				targetSB.insert(i, replacement);
				// check for any more
				i = targetSB.toString().indexOf(argument, i + replacement.length());
			}

			return targetSB.toString();
		}



}
