 /* File: ButtonsPanel.java
 * Author: Vikram Pendyam
 * Date: Feb 20, 2019
 * Purpose: Sequence class which gets efficency along with recursive and iterative methods
 * 
 */
package project3;

public  class Sequence {
    private static int efficiencyValue=0;
    //computes iterative
    public static int computeIterative(int n){
       efficiencyValue=0;
       int currValue=0;
       
        if( n == 0){
            efficiencyValue++;
            return 0;
        } else if( n == 1){
            efficiencyValue++;
            return 1; 
        } else {
              int lastValue=1;
             int nextLast=0;
          for(int i=2 ; i<= n;i++){
             efficiencyValue = efficiencyValue+1;
           
             currValue = 2* lastValue + nextLast;  
             nextLast  = lastValue;
             lastValue = currValue;
             //System.out.println(currValue+",Iter-EFF:"+ efficiencyValue);
             
                    }
               }
       
     return currValue;
    }
    //computes recursive
    public static int computeRecursive(int n){
        efficiencyValue=0; 
        return  recursiveHelper(n);
        
    }
    //helper for recursive
    private static int recursiveHelper(int n){
       int retValue;
        if( n == 0){
            efficiencyValue++;
            return 0;
        } else if( n == 1){
            efficiencyValue++;
            return 1;  
        } else{
            efficiencyValue++;
            retValue = 2 * recursiveHelper(n -1) + recursiveHelper(n - 2);
            //System.out.println(retValue +", Rec-eFF:"+efficiencyValue);
            return retValue ;
        }
    }
    
  //gets efficiency value
    public static int getEfficiency(){
        return efficiencyValue;
    }
    //below used for debugging
    public static void main(String[] args) {
        int n;
        int iterEff;
        int m ;
        int recEff;
         
         for(int i=0;i<= 10; i++){
            n = computeIterative(i); 
             iterEff = getEfficiency();
             m = computeRecursive(i);
             recEff = getEfficiency();
             System.out.println("iterEff"+iterEff+",recEff:"+recEff);
                     
         }
        
        //computeIterative(3);

    }
   
    
}

