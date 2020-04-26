import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Hello World");
        List <List<Integer>> doubleList = new ArrayList<>();
        int[] numbers = new int [10];
/*        String a = "bike";
        String b = new String("bike");
        String c = new String ("bike");
                System.out.println(a==b);
                System.out.println(c==b);*/

        List test = new ArrayList();
        test.add(10);
        test.add(20);
        doubleList.add(test);
        doubleList.add(test);
        for (List<Integer> list: doubleList) {
            System.out.println(list.get(0));
            System.out.println(list.get(1));
            list.set(1,30);
        }
        for (List<Integer> list: doubleList) {
            System.out.println(list.get(0));
            System.out.println(list.get(1));
        }
       /* for (Object o: test)
            System.out.println(o);
        test.forEach(System.out::println);
        Iterator it = test.iterator();
        System.out.println(LocalDate.now());*/
    }
}