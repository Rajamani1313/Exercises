/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayResturantTable {
    public static void main(String[] args){
        ArrayList<ArrayList<String>> orders = {{"David","3","Ceviche"},{"Corina","10","Beef Burrito"},{"David","3","Fried Chicken"},{"Carla","5","Water"},{"Carla","5","Ceviche"},{"Rous","3","Ceviche"}};

    }
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<String> items = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (List<String> list: orders){
            if (!items.contains(list.get(2)))
                items.add(list.get(2));
            if(!map(list.get(1))){
                List<String> temp = new ArrayList<>();
                temp.add(list.get(2));
                map.add(list.get(1),temp);
            }
            else
                map.get(list.get(1)).add(list.get(2));
        }
        for (String str:map.keySet())
            System.out.println(str);

    }
}*/
