package numconversion;

public class Conversion {
	final static String table = "0123456789ABCDEF";
	public static String convert(int origin,int base ){
		StringBuilder sb = new StringBuilder();
		while(origin > 0){
			int index = origin % base;
			origin = origin / base;
			sb.insert(0, table.charAt(index));
		}
		return new String(sb);
	}
	public static int numtodec(String origin, int base){
		int result = 0;
		int len = origin.length() - 1;
		for(int i = len; i >= 0; i--){
			int num = origin.charAt(i) - '0';
			int pow = len - i;
			result += Math.pow(base, pow) * num;
		}
		return result;
	}
	public static void main(String[] args){
		System.out.println(Conversion.convert(104, 16));
		System.out.println(Conversion.numtodec("11", 8));
	}
}
