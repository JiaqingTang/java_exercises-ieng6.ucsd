package CH1;

public class OperationAdd extends Operation{
	public double GetResult(){
		double result = 0;
		double numberA = super.getNumberA();
		double numberB = super.getNumberB();
		result = numberA + numberB;
		return result;
		
	}
}
