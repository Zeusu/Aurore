package net.aurore.util;

public final class Encoder {

	public static String encode(String toEncode){
		StringBuffer result = new StringBuffer();
		String[] toEncodeAsTable = toEncode.split(" ");
		if(toEncodeAsTable.length > 1){
			for(int i = 0; i < toEncodeAsTable.length; i++){
				result.append(toEncodeAsTable[i]);
				if(i != toEncodeAsTable.length - 1) result.append("%20");
			}
		}else{
			return toEncode;
		}
		return result.toString();
	}
	
}
