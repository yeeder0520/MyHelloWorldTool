/*
 * Created on 2005/1/20
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package tradevan.helpdesk;

import com.tradevan.commons.collection.DataObject;
import com.tradevan.commons.io.FileUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.validator.GenericValidator;

import java.io.*;
import java.text.MessageFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author Tear Chen
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CommonLib {
	
    /**
     * get the value string from key_list array
     * @param key_list String[]
     * @throws Exception
     * @return Map contains (key, value)
     */
    public static String getFields(String[] key_list) {
    	if (key_list == null ) return "";
    	StringBuffer sb = new StringBuffer();
    	for (int i = 0; i < key_list.length; i++) {
    		sb.append(key_list[i]);
    		if (i < (key_list.length-1)) sb.append(",");
    	}
    	return sb.toString();
    }
//    File
    /**
     * get the value string from key_list array
     * @param key_list String[]
     * @param table alias
     * @throws Exception
     * @return Map contains (key, value)
     */
    public static String getFields(String[] key_list, String tab) {
    	if (key_list == null ) return "";
    	StringBuffer sb = new StringBuffer();
    	for (int i = 0; i < key_list.length; i++) {
    		sb.append(tab+"."+key_list[i]);
    		if (i < (key_list.length-1)) sb.append(",");
    	}
    	return sb.toString();
    }
    
    /**
     * determine the specified field of the query Map if Null or Empty 
     * @param query Map, field String
     * @throws Exception
     * @return Map contains (key, value)
     */
    public static boolean isNullOrEmpty(Map query, String field) {
    	if (query == null || field == null) return true;	
    	if (query.get(field) == null || ((String)query.get(field)).equals("")) return true;
    	
    	return false;
    }
    
    /**
     * determine the specified field of the query Map if Null or Empty 
     * @param query Map, field String
     * @throws Exception
     * @return Map contains (key, value)
     */
    public static boolean isNullOrEmpty(DataObject obj, String field) {
    	if (obj == null || field == null) return true;
    	if (obj.getValue(field) == null || ((String)obj.getValue(field)).equals("")) return true;
    	return false;
    }
    
    /**
     * determine the specified value if Null or Empty 
     * @param query Map, field String
     * @throws Exception
     * @return Map contains (key, value)
     */
    public static boolean isNullOrEmpty(String value) {
    	if (value == null) return true;
    	if (value.equals("")) return true;
    	return false;
    }
    
    /**
     * translate string QryCount to int 
     * @param qryCount String
     * @throws Exception
     * @return Map contains (key, value)
     */
//    public static int getQryCount(String qryCount) {
//    	if ( qryCount == null || qryCount.equals("") ) return HelpDeskDAOConfig.getDefaultRows();
//    	try {
//		    int _rows = Integer.parseInt(qryCount);
//		    if ( _rows > CommonConstant.MAX_ROWS ) _rows = CommonConstant.MAX_ROWS;
//	    	else if ( _rows == 0 ) _rows = HelpDeskDAOConfig.getDefaultRows();
//		    return _rows;
//		} catch (NumberFormatException nfe) {
//			HelpDeskLogger.error(nfe);
//		}
//		return HelpDeskDAOConfig.getDefaultRows();
//    }
    
//    public static String inStream2String(InputStream from) {
//        StringBuffer sb = new StringBuffer();
//        try{
//            byte[] buffer = new byte[1];
//            for (int i = -1; from.read(buffer) != -1;) {
//            	sb.append(new String(buffer));
//            }//end of for(;;)
//        } catch(IOException ie) {
//        	HelpDeskLogger.error(ie);
//        } finally {
//        	try {
//        		if (from != null) from.close();
//        	} catch (IOException ie) {
//        		HelpDeskLogger.error(ie);
//        	}
//        }
//        return sb.toString();
//    }
//    
//    public static byte[] inStream2Bytes(InputStream from) {
//    	ByteArrayOutputStream to = null;
//    	byte[] document = new byte[0];
//        try{
//        	to = new ByteArrayOutputStream();
//            byte[] buffer = new byte[1024];
//            int bytes_read;
//            while ((bytes_read = from.read(buffer)) != -1) {
//            	to.write(buffer, 0, bytes_read);
//            }//end of while
//            document = to.toByteArray();
//        } catch (IOException ie) {
//        	HelpDeskLogger.error(ie);
//        } finally {
//        	try {
//        		if (from != null) from.close();
//        		if (to != null) to.close();
//        	} catch (IOException ie) {
//        		HelpDeskLogger.error(ie);
//        	}
//        }
//        return document;
//    }
    
    public static byte[] appendByteArray(byte[] head, byte[] tail){
        if(head==null || head.length==0) return tail;
        if(tail==null || tail.length==0) return head;
        byte[] temp=new byte[head.length+tail.length];
        System.arraycopy(head,0,temp,0,head.length);
        System.arraycopy(tail,0,temp,head.length,tail.length);
        return temp;
    }
    
    public static byte[] appendByteArray(byte[] head, byte tail){
    	byte[] temp=new byte[head.length+1];
    	System.arraycopy(head,0,temp,0,head.length);
    	temp[head.length] = tail;
        return temp;
    }
    
    public static int getIndex(byte[] data, byte[] key) {
        return getIndex(data,key,0);
    }

    public static int getIndex(byte[] data, byte[] key, int start) {
        if (data == null)
            return -1;
        if (start < 0 || start > data.length)
            return -1;
        for (int i = start; i < data.length; i++) {
            boolean found = true;
            if ((i + key.length) > data.length) break;
            for (int j = 0; j < key.length; j++) {
                if (data[i+j] == key[j])
                    continue;
                found = false;
                break;
            }
            if (found)
                return i;
        }
        return -1;
    }
    
    public static String getContextRoot(String uri, String servletPath) {
        int index = uri.indexOf(servletPath);
        if (index != -1) {
            return uri.substring(0,index);
        }
        return "";
    }
    
    /*
    X25          X.25 connector
    DN           Dolphin connector
    FTP          FTP connector
    PM           ProcessMessage
    ES           EDIFACTFileSrc
    PS           PEDIFileSrc
    DS           DolphinFileSrc
    EH           ErrorHandle
    AUTO         DocSwitchServer
    EDIT         Edit
    OP           Operation
    SYS          System Error
    */
    public static String getCateDesc(String categoryCode) {
        String categoryDesc = "";
        if ( categoryCode.equals("X25") ) categoryDesc="X.25 connector";
        else if ( categoryCode.equals("DN") ) categoryDesc="Dolphin connector";
        else if ( categoryCode.equals("FTP") ) categoryDesc="FTP connector";
        else if ( categoryCode.equals("PM") ) categoryDesc="ProcessMessage";
        else if ( categoryCode.equals("ES") ) categoryDesc="EDIFACTFileSrc";
        else if ( categoryCode.equals("PS") ) categoryDesc="PEDIFileSrc";
        else if ( categoryCode.equals("DS") ) categoryDesc="DolphinFileSrc";
        else if ( categoryCode.equals("EH") ) categoryDesc="ErrorHandle";
        else if ( categoryCode.equals("AUTO") ) categoryDesc="DocSwitchServer";
        else if ( categoryCode.equals("EDIT") ) categoryDesc="Edit";
        else if ( categoryCode.equals("OP") ) categoryDesc="Operation";
        else if ( categoryCode.equals("SYS") ) categoryDesc="System Error";
        return categoryDesc;
    }
    
    public static String fixString(String str, int fixLength) {
        if ( str == null || str.length() == 0 ) return "";
        if ( fixLength < 3 ) return str;
        if ( str.length() <= fixLength ) return str;
        String newstr = "..." + str.substring(str.length()-fixLength,str.length());
        return "<font title='" + str + "'>" + newstr + "</font>";
    }
    
    public static boolean bytes2file(byte[] from, String to) {
    	ByteArrayInputStream in = null;
    	FileOutputStream out = null;
    	boolean success = false;
    	try {
            //建立串流讀取來源檔
            in = new ByteArrayInputStream(from);
            //建立串流壓縮資料，並將結果寫入目的檔
            out = new FileOutputStream(to);
            //將位元組從串流複製至另一個串流
            byte[] buffer = new byte[4096];
            int bytes_read;
            while ((bytes_read = in.read(buffer)) != -1)
                out.write(buffer, 0, bytes_read);
            //關閉串流
            success =  true;
    	} catch (IOException ie) {
    		ie.printStackTrace();
    	} finally {
            //關閉串流
    		try {
    		    in.close();
    		    out.close();
    		} catch (IOException ie) {
    			ie.printStackTrace();
    		}
    	}
    	return success;
    }
    
    public static boolean mkdir(String dirName) {
    	try {
    		File dir = new File(dirName);
    		return dir.mkdir();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return false;
    }

    public static int copyFile(String src,String dest) {

        try {
            File srcf =new File(src);
            File destf = new File(dest);
            return FileUtil.copy(srcf, destf, false, false);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        return 0;
    }

    public static byte[] inStream2Bytes(InputStream from) {
        ByteArrayOutputStream to = null;
        byte[] document = new byte[0];
        try{
            to = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytes_read;
            while ((bytes_read = from.read(buffer)) != -1) {
                to.write(buffer, 0, bytes_read);
            }//end of while
            document = to.toByteArray();
        } catch (IOException ie) {
        	ie.printStackTrace();
        } finally {
            try {
                if (from != null) from.close();
                if (to != null) to.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
        return document;
    }
    
    public static String transHTMLCode(String in) {
        StringBuffer sb = new StringBuffer();
        for (int i =0 ; i < in.length(); i++) {
            if ( (in.charAt(i)) == ' ' ) {
                sb.append( "&nbsp;" );
            } else {
                sb.append( in.charAt(i) );
            }
        }
        return sb.toString();
    }
    
    public static Vector splitStrToVec(String inStr, String sep) {
    	Vector v = new Vector();
    	if ( inStr == null || sep == null ) return v;
    	StringTokenizer tokens = new StringTokenizer( inStr, sep );
    	while (tokens.hasMoreTokens()) {
    		v.add( tokens.nextToken() );
        }
        return v;
    }

    /**
    * 將 BO 轉換成 XML
    * 
    * @param clazz
    * @param bo
    * @return
    * @throws Exception
    */
   public static String parseBO2XML(Class clazz, Object bo) throws Exception {
       if (clazz == null)
           throw new IllegalArgumentException("class can not be null");

       ParserInterface parser = getProcessClass(clazz.getName());
       String xml = "";
       xml = parser.marshal(bo);
       return paddingNamespace(parser, xml);
   }
    

    /**
     * 處理 XML 的 namespace
     * @param parser
     * @param xml
     * @return
     */

    private static String paddingNamespace(ParserInterface parser, String xml) {
   	 String PATTERN_NAMESPACE = "{0} xmlns=\"{1}\"";
        String namespace = parser.getNameSpace();
        String tagName = parser.getMessageAlias();
        String replacement = MessageFormat.format(PATTERN_NAMESPACE, tagName, namespace);
        return xml.replaceFirst(Pattern.quote(tagName), replacement);
    }
    /**
     * 取得partent folder path
     * @param path
     * @return
     */
    public static int getParentFolderIndex(String path){
        int  index2=path.length();
        int count=0;
         while(index2>0){
             
            if( path.lastIndexOf("/", index2)>0){
                count++;
                if(count==4){
                    return path.lastIndexOf("/", index2);}
            }
             
            index2=path.lastIndexOf("/", index2)-1;
         }
        return 0;
    }
    /**
     * 取得檔案路徑得第二個點的index
     * @param path
     * @return
     */
    public static int getPathFName(String path){
        int  index2=path.length();
        int count=0;
         while(index2>0){
             
            if( path.lastIndexOf(".", index2)>0){
                count++;
                if(count==2){
                    return path.lastIndexOf(".", index2);}
            }
             
            index2=path.lastIndexOf(".", index2)-1;
         }
        return 0;
    }
    /**
     * 取得BO的Parser
     * 
     * @param bo
     * @return
     * @throws Exception
     */
    private static ParserInterface getProcessClass(String bo) throws Exception {
        if(GenericValidator.isBlankOrNull(bo))
            throw new IllegalArgumentException("bo can not be null or empty");

        if (bo.indexOf(".") > 0)
            bo = bo.substring(bo.lastIndexOf(".") + 1);

        ParserInterface processClass = (ParserInterface) Class.forName(
                ParserInterface.class.getPackage().getName() + "." + bo
                + "Parser").newInstance();
        return processClass;
    }
	public static String getOutsideMSHStatusStr(String status, String iotype) {

 		String act = iotype.equals("O")? "傳送":"接收";

    	if ( status.equals("C") ) return "關貿已" + act;

	    else if ( status.equals("P") ) return "關貿" + act + "中";

	    else if ( status.equals("F") ) return "關貿" + act + "中";

	    else if ( status.equals("E") ) return "關貿" + act + "失敗";

	    return status;

	}
	
    /**
     * 傳入yyyyMMddhhmmssSSS 造出parentFolder\yyMMdd\hh\m資料夾
     * 
     * @param parentFolder
     * @param dts
     * @return
     * @throws IOException
     */
    public static String mkDTDir(String parentFolder, String dts) throws IOException {
        return mkDirs(parentFolder, dts.substring(2, 8), dts.substring(8, 10), dts.substring(10, 11));
    }
    public static String getDateTimeFolder( String dts) throws IOException {
        return  "/"+dts.substring(2, 8)+"/"+ dts.substring(8, 10)+"/"+dts.substring(10, 11)+"/";
    }

    /**
     * 建立指定目錄
     * 
     * @param property
     * @return
     * @throws IOException
     */
    public static String mkDirs(String parentFolder, String... subFolder) throws IOException {
        StringBuffer dir = new StringBuffer(parentFolder);
        
        if (subFolder != null) {
            for (String s : subFolder) {
                dir.append(File.separator + s);
            }
        }
        mkDir(dir.toString());
        return new File(dir.toString()).getAbsolutePath();
    }

    public static void mkDir(String dir) throws IOException {
        File df = new File(dir);
        if (df.isDirectory())
            return;
        if (!df.mkdirs()) {
            if (!df.isDirectory()) {
                throw new IOException("Cannot create directory [" + dir + "]");
            }
        }
    }
    
    /**
     * trim space
     * @param DataObject
     * @return
     * @throws Exception
     */
    public static void trimSpace(DataObject dataobj) {
		Object[] params = dataobj.getKeys();
		String trimVal = "";	
		for (Object param : params) {
			if (param != null) {
				String paramStr = (String)param;
				//trim字串
				Object obj = dataobj.getValue(paramStr);
		
				//判斷此物件是否為字串
				boolean judge = obj instanceof String;

				//若為字串就trim後塞回
				if (judge) {
					trimVal = ((String)obj).trim();
					//將trim過的字串重新放回dataobj
					dataobj.setValue(paramStr, trimVal);
				}
				
			}
		}
	}

    /**  
     * ?java?象??成json字符串  
     *
     * @param bean  
     * @return  
     */
    public static JSONObject beanToJson(Object bean) {
  
        JSONObject json = JSONObject.fromObject(bean);
       
        
        return json;
 
    }
    
    
    public static JSONArray beanList2Jsonist(List beanList){
        List<JSONObject> jsonList = new ArrayList<JSONObject>();
        if(beanList != null && beanList.size() > 0){
            for(int i = 0; i < beanList.size(); i++){
                DataObject dataObj = (DataObject) beanList.get(i);
                //將不需要的資訊移除
                JSONObject json= beanToJson(dataObj);
                jsonList.add(json);
            }
        }
        return JSONArray.fromObject(jsonList);
    }
    
}
