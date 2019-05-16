/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.*;

public class Graph {
    LinkedList<Integer> list[];
    int vertex;
    
    public Graph(int v){
        this.vertex = v;
        list = new LinkedList[vertex];

        
        for(int i=0; i < vertex; i++){
            list[i] = new LinkedList<>();       
        }
    }
    
    void addEdge(int source, int destination){
        list[source].addFirst(destination);
    }
    
    void DFS(){
        System.out.print("Depth First Traversal: ");
        boolean[] visited = new boolean[vertex];
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i < vertex; i++){
            if(visited[i]== false){
                stack.push(i);
                visited[i]=true;
            }
            while(stack.isEmpty() == false){
                int nodeIndex = stack.pop();
                System.out.print(nodeIndex + " ");
                LinkedList<Integer> nodeList = list[nodeIndex];
                
                for (int j = 0; j < nodeList.size(); j++) {
                    int dest = nodeList.get(j);
                    if (visited[dest] == false) {
                            stack.push(dest);
                            visited[dest] = true;
                        }
                    
                }
            }
        }
        System.out.println();

    }
    
    void printDFS(){
        for(int i=0; i< vertex; i++){
            LinkedList<Integer> nodeList = list[i];
            
            if(!nodeList.isEmpty()){
                System.out.print("source = " + i + " is connected to nodes: ");
                for(int j= 0; j< nodeList.size(); j++){
                    System.out.print(" " + nodeList.get(j));
                }
            }
            System.out.println("");
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0, 2);
        graph.addEdge(2, 4);
        graph.addEdge(1, 3);
        graph.addEdge(3, 6);
        graph.addEdge(4, 1);
        graph.addEdge(1, 5);
        graph.addEdge(5, 7);
        graph.addEdge(8, 1);
       
        graph.printDFS();
        graph.DFS();

        
    }
    
}
