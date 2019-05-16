/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigo;
import java.util.Random;

/**
 *
 * @author vpendyam
 */
public class Bigo {

    public static int fibnacci(int n){
        if(n == 0) return 0;
        if(n==1) return 1;
        return fibnacci(n - 1) + fibnacci(n - 2);   
    }
    
    public static int factorial(int n){
        if(n == 0) return 1;
        if (n == 1) return 1;
        return n * factorial(n-1);
    }
    
    public static int factLinear(int n){
        if(n == 0) return 1;
        if (n == 1) return 1;
        int curr=1;
        for( int i = 2; i <= n ; i++){
            curr = curr * i;
        }
        return curr;
    }
    
    public static int binarySearch(int[] array , int value){
        int found = -1;
        int start = 0;
        int end = array.length - 1;
        
        if(array[start] == value){
            found = start;
            return found;
        }
        
        if(array[end] == value){
            found= array.length ;
            return found;
        }
        
        int middle = array.length/2;
        while(true){
            if(array[middle] == value){
                found = middle;
                break;
            }
            
            if(start == end){
                break;
            }
            
            if(array[middle] > value){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
            middle =  start+end/2;
            
        }
        
        return found;
        
        
    }
    
    public static void bubbleSort(int[] array){
        boolean swapOcuured = false;
        for(int i=0; i< array.length -1 ; i++){
            swapOcuured = false;
            for(int k =0; k< (array.length -1-i); k++){
                if(array[k] > array[k+1]){
                    int tmp = array[k];
                    array[k] = array[k+1];
                    array[k+1] = tmp;
                    swapOcuured = true;
                }
            }
                
            if(!swapOcuured)
                break;
            
        }
       
        
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        final int NUMBER_OF_TRIES = 10;
        int size = 10;
        int array[] = new int[size];
        Random random = new Random();
        for(int i = 0; i<size ; i++){
            int value = random.nextInt(size-1);
            System.out.println(value);
            array[i]=value;
        }
        System.out.println("Before");
        for(int i =0; i< array.length; i++){
            System.out.print(array[i]);
        }
       bubbleSort(array);
       System.out.println("After");
       for(int i =0; i< array.length; i++){
            System.out.print(array[i]);
        }
       
       
       
        
        
        
        
    }
    
}
