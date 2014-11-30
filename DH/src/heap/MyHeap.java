package heap;

public class MyHeap {
	private int []array;
	int rear ;
	MyHeap(int len){
		array = new int[len];
		rear = 0;
	}
	private void add(int num){
		int i = rear;
		array[rear++] = num;
		
		while(i > 0){
			if(array[i] < array[i / 2])
			{
				int tmp = array[i/2];
				array[i/2] = array[i];
				array[i] = tmp;
			}
			i = i / 2;
		}
	}
	private int poll(){
		if(rear == 0)
			return 0;
		int result = array[0];
		array[0] = array[rear - 1];
		int i = 0;
		while(i < rear){
			if((i+1) * 2 < rear)
			{
				if(array[(i+1)*2] < array[i])
				{
					int tmp = array[(i+1)*2];
					array[(i+1)*2] = array[i];
					array[i] = tmp ;
					i = array[(i+1)*2 -1];
				}
				if(array[(i+1)*2 - 1] < array[i])
				{
					int tmp = array[(i+1)*2 -1];
					array[(i+1)*2 -1] = array[i];
					array[i] = tmp ;
					i = array[(i+1)*2 -1];
				}
			}
			else{
				break;
			}
		}
		--rear;
		return result;
	}
	private void print(){
		for(int i = 0; i < rear; ++i)
			System.out.print(array[i]);
		System.out.println();
	}
	public static void main(String[] args){
		MyHeap heap = new MyHeap(10);
		heap.add(3);
		heap.add(5);
		heap.add(1);
		heap.print();
		heap.poll();
		heap.print();
		heap.poll();
		heap.print();
		heap.poll();
		heap.print();
		heap.poll();
		heap.print();
	}

}
