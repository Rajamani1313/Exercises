package Search;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("pid,store,count");
        list.add("1,1,1");
        list.add("2,1,2");
        list.add("3,2,3");
        Set<String> set = loadCsv2(list);
        for (String s : set)
            System.out.println(s);
    }

    private static HashSet<String> loadCsv2(List<String> list){
        boolean skipFirstRow = true;
        int rowsToRead = 365391;
        List<String> csvValues = list;
        List<String> res = new ArrayList<String>();

        for (String line : list) {
            System.out.println(line);
            String temp = line.split(",")[0];
            res.add(temp);
        }
        HashSet<String> big4ids = (HashSet<String>) res.stream().collect(Collectors.toSet());

        csvValues.clear();


        return big4ids;
    }
//        List<String> csvValues = new ArrayList<String>();
//        BufferedReader reader = new BufferedReader(
//        new InputStreamReader(
//        new FileInputStream("//abc.csv")));
//        int i = 0;
//        String line;
//        while ((line = reader.readLine()) != null) {​​​​​
//        if (i > 0 || !skipFirstRow)
//        for (String line : list) {​​​​​
//            String record = line.split(",")[0];
//            csvValues.add(record);
//        }​​​​​
//        //            if (++i >= rowsToRead && rowsToRead != -1) {​​​​​
////                break;
////            }​​​​​
////        }​​​​​
////        reader.close();
//
//
//        HashSet<String> big4ids = (HashSet<String>) csvValues.stream().collect(Collectors.toSet());
//
//        csvValues.clear();
//
//
//        return big4ids;
//    }​​​​​
}
