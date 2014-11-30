import java.io.PrintWriter;


public class Test {
	public static void main(String[] args){
		
		double[][] data = new double[50][500];
		int[] n = {20, 100, 500, 1000};
		double[] cost = new double[50];
		double[] time = new double[50];
		
//		for(int i = 0; i < 4; ++i)
//		{
			int j = 0;
			for(double p = 0; p < 1; p = p + 0.02, j++)
			{
				
				long startTime = System.currentTimeMillis();
				double result = 0;
				for(int k = 0; k < 500; ++k)
				{
					EdgeWeightedGraph g = new EdgeWeightedGraph(1000, p) ;
					PrimMST mst = new PrimMST(g);
					double weight = mst.weight();
					data[j][k] = weight / mst.getCount();
					result += data[j][k];
					
				}
				result /= 500;
				cost[j] = result;
				System.out.println(j + " " + result);
				long endTime  = System.currentTimeMillis();
				long totalTime = endTime - startTime;
				time[j] = totalTime / 500 ;
			}
//		}
		
		
		try
		{
		    PrintWriter pr = new PrintWriter("d1b");    

		    	pr.println("cost");
		    	for(int k = 0; k < 50; ++k)
		    		pr.print(cost[k]+" ");
		    	pr.println();
		    	pr.println("time");
		    	for(int k = 0; k < 50; ++k)
		    		pr.print(time[k]+" ");
		    	pr.println();
		    	

		    pr.close();
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		    System.out.println("No such file exists.");
		}
	}
}
