public class MaxConseq{
	public static int getMax(int[] num){
		if(num.length == 0)	
			return 0;
		int len = num.length;
		int max = Math.max(num[0], 0);
		int maxsofar = max;
		for(int i = 1; i < len; ++i){
			max = Math.max(max + num[i], 0);		
			maxsofar = Math.max(max, maxsofar);		

		}
		return maxsofar;

	}
	public static void main(String[] args){
		int [] num = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(MaxConseq.getMax(num));


	}

}
