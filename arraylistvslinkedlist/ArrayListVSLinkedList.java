
package arraylistvslinkedlist;
import java.util.*; 
/**
 *
 * @author vpendyam
 */
public class ArrayListVSLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> alist=new ArrayList<String>();  
        alist.add("a");
        alist.add("b");
        alist.add("c");
        alist.add("d");
        //displaying elements
        //displaying elements
        System.out.println("*****Example for ArrayList****");
        System.out.println(alist);
        //how to remove
        alist.remove(3);
        System.out.println(alist);
        
       LinkedList<String> blist = new LinkedList<String>();
       blist.add("Item1");
       blist.add("Item5");
       blist.add("Item3");
       blist.add("Item6");
       blist.add("Item2");
       
       System.out.println("*****Example for LinkedList****");
       System.out.println("List from linkedList:"+ blist);
       
       /*Add First and Last Element*/
       blist.addFirst("item1");
       blist.addLast("item25");
       System.out.println("After adding first and last items to linkedList:"+ blist);
       
       Object firstvar = blist.get(0);
       System.out.println("First element: " +firstvar);
       blist.set(0, "Changed first item");
       Object firstvar2 = blist.get(0);
       System.out.println("First element after update by set method: " +firstvar2);
       
        /* Add to a Position and remove from a position*/
       blist.add(0, "Newly added item");
       blist.remove(2);
       System.out.println("Final Content: " +blist); 
       
    }
    
}
