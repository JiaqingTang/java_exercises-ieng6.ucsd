import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class stringComb {
	public ArrayList<String> comb(String str, Set<String> dict){
		if(str == null || str.length() == 0){
			return null;
		}
		ArrayList<String> result = new ArrayList<String>();
		dfs(result, str, dict, "");
		return result;
	}
	
	public void dfs(ArrayList<String> result, String str, Set<String> dict, String cur){
		if(str.length() == 0){
			result.add(cur.toString());
			return;
		}
		for(int i = 1; i <= str.length(); ++i){
			String sub = str.substring(0, i);
			if(dict.contains(sub)){
				if(cur.length() == 0){
					dfs(result, str.substring(i), dict, sub);
				}
				else{
					dfs(result, str.substring(i), dict, cur+" "+sub);
				}
				
			}
		}
	}
	
	public static void main(String[] args){
		stringComb s = new stringComb();
		HashSet<String> dict = new HashSet<String>();
		dict.add("apple");
		dict.add("pie");
		dict.add("a");
		dict.add("pple");
		System.out.println(s.comb("applepie", dict));
	}
}
