/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.*;

public class TopologicalSort {
    int vertex;
    LinkedList<Integer> list[] ;
    
    public TopologicalSort(int v){
        this.vertex = v;
        this.list = new LinkedList[v];  
        for (int i=0; i<v; ++i) 
            list[i] = new LinkedList();
    }
    
    void addEdge(int source, int destination){
        list[source].add(destination);
    }
    
    void topologicalSort(int v, boolean visited[],Stack stack){
        //node just visited
        visited[v]=true;
        
        for(int i=0; i< list[v].size(); i++){
            if(!visited[i]){
               topologicalSort(i, visited,stack); 
            }
            
        }
        stack.push(new Integer(v));
        
    }
    
    void topologicalSort(){
        boolean[] visited = new boolean[vertex];
        
        Stack stack = new Stack();
        
        //let put every vertex false as not visited
        for(int i=0;i< vertex; i++){
            visited[i]=false;
        }
        
        for(int i=0; i< vertex ; i++){
            if(!visited[i]){
                //call helper passing stack,visited,i
                topologicalSort(i,visited,stack);
                
            }
        }
        
        while (stack.empty()==false) {
            System.out.print(stack.pop()+",");
        }
        
    }
    
    public static void main(String args[]){
        TopologicalSort graph = new TopologicalSort(9);
     graph.addEdge(0, 2);
        graph.addEdge(2, 4);
        graph.addEdge(1, 3);
        graph.addEdge(3, 6);
        graph.addEdge(4, 1);
        graph.addEdge(1, 5);
        graph.addEdge(5, 7);
        graph.addEdge(8, 1); 
        
        graph.topologicalSort();
    }
    
}
