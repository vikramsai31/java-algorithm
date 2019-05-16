/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.*;

public class Dfs {
    int vertex;
    LinkedList<Integer> list[];
    
    public Dfs(int n){
        this.vertex = n;
        list = new LinkedList[vertex];
        for(int i=0; i<vertex;i++)
            list[i]= new LinkedList<>();
     
    }
    
    public void addEdge(int source, int destination)
    {
        list[source].addFirst(destination);
        
    }
    
    public void traversal(){
         System.out.print("Depth First Traversal: ");
         boolean[] visited = new boolean[vertex];
         
         Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i< vertex; i++){
            if(!visited[i]){
                stack.push(i);
                visited[i]=true;
            }
          while(stack.isEmpty() == false){
              int nodeIndex = stack.pop();
              LinkedList<Integer> nodeList = list[nodeIndex];
              System.out.print(nodeIndex + " ");
              
              for(int j=0; j<nodeList.size(); j++){
                  int dest = nodeList.get(j);
                  
                   if (!visited[dest]){
                       stack.push(dest);
                       visited[dest]=true;
                      
                     }
                  
              }
              
          }
           
        }
        System.out.println(""); 
            
    }
    
    void printDFS(){
        for(int i=0; i< vertex; i++){
            LinkedList<Integer> nodeList = list[i];
            if(!nodeList.isEmpty()){
                System.out.print("source = " + i + " is connected to nodes: ");
                 for(int j= 0; j< nodeList.size(); j++){
                    System.out.print(" " + nodeList.get(j));
                }
                 System.out.println("");
            }
        }
    }
    
    public static void main(String[] args) {
        Dfs d = new Dfs(9);
        d.addEdge(0, 2);
        d.addEdge(2, 4);
        d.addEdge(1, 3);
        d.addEdge(3, 6);
        d.addEdge(4, 1);
        d.addEdge(1, 5);
        d.addEdge(5, 7);
        d.addEdge(8, 1);
        d.traversal();
        d.printDFS();
        
       
        
    }
    
    
    
}
