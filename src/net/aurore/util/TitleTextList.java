package net.aurore.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class TitleTextList implements Iterable<String[]> {

	private List<String[]> list = new ArrayList<String[]>();
	
	public TitleTextList(){}
	
	public String getText(int i){
		if(i < list.size()) return list.get(i)[1];
		return null;
	}
	
	public String getTitle(int i){
		if(i < list.size()) return list.get(i)[0];
		return null;
	}
	
	public String[] getNode(int i){
		return list.get(i);
	}
	
	public void setText(int i, String value){
		if(i < list.size()) list.get(i)[1] = value;
	}
	
	public void setTitle(int i, String value){
		if(i < list.size()) list.get(i)[0] = value;
	}
	
	public void addNode(String title, String value){
		list.add(new String[]{title,value});
	}
	
	public void sortByKey(){
		list.sort(new Comparator<String[]>(){
			@Override
			public int compare(String[] arg0, String[] arg1) {
				if(arg0[0].equals(arg1[0])) return 0;
				if(arg0[0].equals("")) return -1;
				if(arg1[0].equals("")) return 1;
				return (arg0[0].charAt(0) - arg1[0].charAt(0)) + (arg0[0].length() - arg1[0].length());
			}
		});
	}
	
	public List<String[]> getList(){
		List<String[]> result = new ArrayList<String[]>();
		for(String[] str : list){
			result.add(str);
		}
		return result;
	}

	@Override
	public Iterator<String[]> iterator() {
		return list.iterator();
	}
		
}
