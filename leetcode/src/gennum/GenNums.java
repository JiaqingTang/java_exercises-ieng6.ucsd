package gennum;

import java.util.ArrayList;

public class GenNums {
	public ArrayList<String> genNums(int n){
		ArrayList<String> result = new ArrayList<String>();
			genNumsRecur(result, n, new StringBuilder(), 0);
		return result;
	}
	
	public void genNumsRecur(ArrayList<String> result, int n, StringBuilder cur, int index){
		if(index == n){
			result.add(cur.toString());
			return;
		}
		for(int i = 0; i < 3; ++i){
			cur.append(i);
			genNumsRecur(result, n, cur, index+1);
			cur.deleteCharAt(cur.length()-1);
		}
	}
	
	public static void main(String[] args){
		GenNums  g = new GenNums();
		System.out.println(g.genNums(3));
	}
	
}
