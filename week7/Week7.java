/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week7;

/**
 *
 * @author vpendyam
 */
import java.util.*;
public class Week7 {

    /**
     * @param args the command line arguments
     **/
  
public static <E extends Comparable<E>> E max(E[] list) {
      E max = list[0];
      for (int i = 1; i < list.length; i++) {
         if (max.compareTo(list[i]) < 0) {
            max = list[i];
         }
     }
  return max;
  }

public static Integer nonGenericMax(Integer[] list){
   Integer max =  list[0];
   for(int i=1;i< list.length; i++){
       if(max < list[i]){
           max = list[i];     
       }
    
   }
   return max;
}

public static <E extends Comparable<E>> E min(E[] list) {
      E min = list[0];
      for (int i = 1; i < list.length; i++) {
         if (min.compareTo(list[i]) > 0) {
            min = list[i];
         }
     }
  return min;
  }

public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
    ArrayList<E> dup = new ArrayList<E>();
    
    for(E element : list){
    
         if(!dup.contains(element)){
             dup.add(element);
         }
    }
    return dup;
    
}

public static <E extends Comparable<E>> E max(E[ ][ ] list){
    E max = list[0][0];
    for (E[] elements : list) {
            for (E element : elements) {
                if (element.compareTo(max) > 0) {
                    max = element;
                }
            }
        }

        return max;
    
}

public static void main(String[] args) {
Integer[] numbers = { 1, 2, -3, 7, 5, 4 , 11,12, 87, 23, -1, 0, 3, 5 , 7 , 8 , 9, -3};

ArrayList<Integer> list = new ArrayList<>( 
                Arrays.asList(1, 10, 1, 2, 2, 3, 3, 10, 3, 4, 5, 5)); 



    for (Integer number : numbers) {
        System.out.print(number + " ");
    }
     System.out.println();
     System.out.println("Max= "+max(numbers));
     System.out.println("Min= "+min(numbers));
     System.out.println("ArrayList with duplicates: "
                           + list); 
     ArrayList<Integer> removedDupes = removeDuplicates(list);
     
     System.out.println("Removed dupes=" + removedDupes);
     
     Integer[][] alist = new Integer[20][20];
        int value = 0;
        for (int i = 0; i < alist.length; i++) {
            for (int j = 0; j < alist[i].length; j++) {
                alist[i][j] = value++;
            }
        }

        System.out.println("Double array Max = " + max(alist));
        
        System.out.println("Output from non-Generic");
        System.out.println(nonGenericMax(numbers));
   
}
}    




