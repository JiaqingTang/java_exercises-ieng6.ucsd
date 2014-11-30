package c101;
import java.util.Arrays;  
import java.util.Comparator;
/** 
 * java.lang.comparable 此接口强行对实现它的每个类的对象进行整体排序。 
 * 这种排序被称为类的自然排序，类的 compareTo 方法被称为它的自然比较方法。 
 * Arrays.sort(Object[])根据元素的自然顺序对指定对象数组按升序进行排序。 
 * 数组中的所有元素都必须实现 Comparable 接口。 
 * @author edwin 
 * 
 */  
public class Test implements Comparator<Test> {  
    private String id;  
    private int age;  
    public Test(){
    	
    }
    public Test(String id, int age){  
        this.id = id;  
        this.age = age;  
    }  
      
    public String getId() {  
        return id;  
    }  
  
    public void setId(String id) {  
        this.id = id;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
  
    public int compareTo(Test o) {  
        return this.age - ((Test)o).getAge();  
    }  
      
    public static void main(String[] args){  
        Test[] users = new Test[]{  
                new Test("id_1",23),  
                new Test("id_2",20),  
                new Test("id_3",25),  
                new Test("id_4",19)  
        };  
        Arrays.sort(users, new Test());  
        for(Test user : users){  
            System.out.println("id="+user.getId()+" age="+user.getAge());  
        }  
    }

	@Override
	public int compare(Test o1, Test o2) {
		// TODO Auto-generated method stub
		return this.age - ((Test)o2).getAge();  
	}  
}  