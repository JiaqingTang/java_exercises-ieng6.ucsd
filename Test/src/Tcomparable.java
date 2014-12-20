import java.util.TreeSet;
import java.util.Iterator;

public class Tcomparable implements Comparable<Tcomparable> {
        private int id;
        private String name;

        public Tcomparable (int id, String name) {
                this.id = id;
                this.name = name;
        }

        public void setId (int id) {
                this.id = id;
        }

        public void setName (String name) {
                this.name = name;
        }

        public int getId () {
                return id;
        }

        public String getName () {
                return name;
        }

        /* Student 类的字符串表达式，形如：
         * 2   张三 */

        public String toString () {
                return (id + "\t" + name);
        }

        /* 实现 Comparable 接口中的 compareTo 方法，
         * 通常大于时返回一个正数，小于时返回一个负数，
         * 等于时返回零，具体情况可以自行决定。
         *********************************************************
         * 这里我根据 id 号的大小进行了比较。由于 TreeSet
         * 会根据 compareTo 的结果来排序，因此输出结果
         * 应该是按照 id 号从小到大排序的。
         * 如果要根据姓名进行排序，只需对这个方法进行相应的修改。*/

        public int compareTo (Tcomparable arg) {
                if (id > arg.id)
                        return 1;
                else if (id == arg.id)
                        return 0;
                else
                        return -1;
        }

        /* 以下为主方法，输出结果是：
         * 3     John
         * 5     Tom
         * 7     Alice
         * 9     David
         * 可以看到不同于输入顺序，
         * TreeSet 已经将其排序了。*/

        public static void main (String args[]) {
                TreeSet<Tcomparable> tset = new TreeSet<Tcomparable>();
                tset.add(new Tcomparable(5, "Tom"));
                tset.add(new Tcomparable(3, "John"));
                tset.add(new Tcomparable(9, "David"));
                tset.add(new Tcomparable(7, "Alice"));

                Iterator<Tcomparable> itor = tset.iterator();
                while (itor.hasNext()) {
                        System.out.println(itor.next().toString());
                }
        }

	
}