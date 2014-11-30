import java.util.ArrayList;
import java.io.PrintWriter;

import javax.swing.text.html.HTMLDocument.Iterator;


public class Main {
	public static void main(String[] args){

//		StdDraw.setCanvasSize(800, 800);
//		StdDraw.setXscale(-100, 100);
//		StdDraw.setYscale(-100, 100);
//		StdDraw.setPenRadius(.005);
//		StdDraw.setPenColor(StdDraw.RED);
//        StdDraw.setPenRadius(.02);
		int[] ns = {20, 50, 100, 200, 500, 1000, 2000, 3000};
		for(int N : ns){
	        double count = 1;
	        
	        long startTime = System.currentTimeMillis();
	        for(int ii = 0; ii < 500; ++ii){
				Point2D[] points = new Point2D[N];
				ArrayList<Point2D> list = new ArrayList<Point2D>();
		        for(int i = 0; i < N; i++){
		        	double t = 2 * Math.PI * Math.random();
		    		double r = 9 * Math.random();
		    		
		    		points[i] = new Point2D(r*Math.cos(t), r*Math.sin(t));
		    		list.add(points[i]);
		        }
		        
		        while(points.length >= 3){
		        	GrahamScan gra = new GrahamScan(points);
		            for(Point2D point : gra.hull()){
		            	
		            	list.remove(point);
		            }
		            points = list.toArray(new Point2D[0]);
		            count ++;
		        }
	//	        for(Point2D p : points){
	//	        	p.draw();
	//	        }
		        //System.out.println(count1-1);
	        }
	        long endTime  = System.currentTimeMillis();
	        long totalTime = endTime - startTime;
	        System.out.println("n = " + N + " " + "count " + count/500 + " " + "time " + totalTime * 2 + "us");
	        try
			{
			    PrintWriter pr = new PrintWriter(N + "");    
			
			        pr.println("iteration times " + count / 500);

			        pr.println("time " + totalTime / 500);

			
			    pr.close();
			}
			catch (Exception e)
			{
			    e.printStackTrace();
			    System.out.println("No such file exists.");
			}
		}
		
	}
}
