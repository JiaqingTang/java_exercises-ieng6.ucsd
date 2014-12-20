package gcd;

public class Gcd {
	int x, y;
	Gcd(int x, int y){
		this.x = x;
		this.y = y;
		
	}
	private int getGcd(){
		int z = 0;
		if(x*y == 0)
			return z;
		int tmp = x;
		z = x;
		if(x < y)
		{
			tmp = x;
			x = y;
			y = tmp;
		}
		while(z != 0)
		{
			z = x % y;
			x = y;
			y = z;
		}
		return x;
			
	}
	public static void main(String[] args){
		Gcd g = new Gcd(121, 11);
		System.out.println(g.getGcd());
	}
}
