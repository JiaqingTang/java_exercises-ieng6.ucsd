package countsay;

public class CountSay {
	public String countAndSay(int n) {
		if(n < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('1');
        for(int i = 1; i < n; ++i) {
            StringBuilder tmp = new StringBuilder();
            char last = sb.charAt(0);
            int count = 1;
            for(int j = 1; j < sb.length(); ++j) {
                char cur = sb.charAt(j);
                if(cur == last) {
                    count++;
                }
                else {
                    tmp.append(Integer.toString(count));
                    tmp.append(last);
                    last = cur;
                    count = 1;
                }
            }
            tmp.append(Integer.toString(count));
            tmp.append(last);
            sb = tmp;
        }
        return sb.toString();
    }
	
	public static void main(String[] args){
		CountSay test = new CountSay();
		System.out.println(test.countAndSay(5));
	}
}
