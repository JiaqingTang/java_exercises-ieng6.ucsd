package CH1;

public class Main {
	public static void main(String[] args){
		Operation oper;
		oper = OperationFactory.creatOperate("+");
		oper.setNumberA(4);
		oper.setNumberB(7);
		System.out.println(oper.GetResult()); 
	}
}
