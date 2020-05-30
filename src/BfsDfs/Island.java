package BfsDfs;

import java.util.ArrayList;
import java.util.List;

public class Island {
    public static void main (String[] args){
        List<List<Integer>> doubleList = new ArrayList<>();
        List<Integer>  listOne = new ArrayList<>();
        listOne.add(1);
        listOne.add(1);
        listOne.add(1);
        listOne.add(1);
        listOne.add(0);
        doubleList.add(listOne);

        List<Integer>  listTwo = new ArrayList<>();
        listTwo.add(1);
        listTwo.add(1);
        listTwo.add(0);
        listTwo.add(1);
        listTwo.add(0);
        doubleList.add(listTwo);

        List<Integer>  listThree = new ArrayList<>();
        listThree.add(1);
        listThree.add(1);
        listThree.add(0);
        listThree.add(0);
        listThree.add(1);
        doubleList.add(listThree);

        List<Integer>  listFour = new ArrayList<>();
        listFour.add(0);
        listFour.add(0);
        listFour.add(1);
        listFour.add(0);
        listFour.add(0);
        doubleList.add(listFour);

        List<Integer>  listFive = new ArrayList<>();
        listFive.add(1);
        listFive.add(0);
        listFive.add(1);
        listFive.add(0);
        listFive.add(0);
        doubleList.add(listFive);
        Island I = new Island();
        System.out.println("Number of islands is: " + I.countIslands(doubleList));
    }
    int countIslands(List<List<Integer>> M)
    {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        int ROW = M.size();
        int COL = M.get(0).size();

        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M.get(i).get(j) == 1 ) // If a cell with
                { // value 1 is notqwe
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    ++count;
                    merge(M, i, j);
                }

        return count;
    }
    void merge(List<List<Integer>> grid, int i, int j)
    {
        int m=grid.size();
        int n=grid.get(0).size();

        if(i>=m||j>=n||grid.get(i).get(j)!=1)
            return;

        grid.get(i).set(j,0);
//        List <Integer> tmp = grid.get(i);
//        tmp.set(j,0);
//        grid.set(i,tmp);

//        merge(grid, i-1, j);
        merge(grid, i+1, j);
//        merge(grid, i, j-1);
        merge(grid, i, j+1);
    }
}
