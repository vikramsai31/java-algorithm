/**
 * Filename: Graph.java
 * Author: vikram Pendyam
 * Date: 05/9/2019 Description:
 * Description: To read values from file and build directed graph in topological order
 * 
*/
package cmsc350project4;

import java.util.*;
import java.io.*;

public class Graph {
    private ArrayList<LinkedList<Integer>> adjLists;//adjecency list
    private HashMap<String, Integer> intToClass;//maping int to class name
    int vertex=0;//initiating the vertex
    private StringBuilder path;//building the output
    private Stack<Integer> stack;//stack after building directed graph
    private ArrayList<Integer> adj;//tenporary space
    
    public Graph(){
        adjLists = new ArrayList<>();//store all edges
        intToClass = new HashMap<>();  //map classname to vertex   
    }
    
    /*
    @params 
    FileName: Pass in the filename where vertex values are read from
    IOException incase file not found exception is raised
    */
    ArrayList<String[]> readFromFile(String fileName) throws IOException{
        String file = new File(fileName).getAbsolutePath();//getting absolute path
        BufferedReader br = new BufferedReader(new FileReader(file));//reading file content into buffer
        ArrayList<String[]> fileArray = new ArrayList<>();//List of String array variable
        
        String line = "";
        int index =0;
        while((line = br.readLine())!= null){
            String lineArray[] = line.split("\\s");//spliting based on the space
            fileArray.add(index,lineArray);   
            index++;   
        }      
        return fileArray;//return list array variable
       
    }
    /*
    @param fileName
    Building directed graph
    Throw IOException incase file not found
    */
    void BuildDgraph(String fileName) throws IOException{
      ArrayList<String[]> fileArray = readFromFile(fileName);//processed file
      for(String[] lineArray :fileArray ){           
         for(int i=0; i<lineArray.length;i++){  
               addVertex(lineArray[i]);//adding vertex
              if(i>0){
                  addEdge(lineArray[0],lineArray[i]);//adding edges to build directed graph
              }
          }
      }  
    }
  /*
    Adding vertex to the adjcent list
    */ 
    void addVertex(String className){
        if(!intToClass.containsKey(className)){ //check to see if the vertex exist
            intToClass.put(className, vertex);//add vextex by incrementing the int
            LinkedList<Integer> init = new LinkedList<>();//create an empty linked list
            adjLists.add(vertex,init);//add the vertex to the empty linked list
            vertex++;
        }    
    }
    /*
    Adding edge for the linked list created above. Source which is the where the vertex begin and
    and destination is the edge
    */
    void addEdge(String source ,String destination ){
        int s = intToClass.get(source);//get source id to map into hash
        int d = intToClass.get(destination);//get destination id to map into hash
        adjLists.get(s).add(d);//adding source to destination
     
    }
    /*
    Depth first search visiting each vertex and its neighbours and marking and adding it to the stack
    */
    void depth_first_search(int v) throws CycleDetectedException{
        
        while (stack.empty()==false) {
            //System.out.print(getClassName(stack.pop())+",");
            path.append(getClassName(stack.pop())).append(" ");
            //System.out.println("");
        }    
        for(Integer x : adjLists.get(v)){
            System.out.println(x);
            if(adj.contains(x)==true){
                 System.out.println(x);
                throw new CycleDetectedException("Cycle Detected");
            }
            adj.add(x);
            stack.push(x);
            depth_first_search(x);//recursives handling all the vertices
        } 
    }
    /*
    Topologicaly sorting graph by visiting each node and its neighbours
    */
    
    String topologicalSort(String className) throws InvalidClassName,CycleDetectedException{
        if(intToClass.get(className)== null){
            throw new InvalidClassName();//throw invalid class name if class name entered not found
        }
        int n = intToClass.get(className);//get if from the mapper
        
        path = new StringBuilder();//to build the output
        stack = new Stack();//to build sorted order
        adj = new ArrayList<>();
        stack.push(n);//first value
        depth_first_search(n);   //do search based on the className
        return path.toString();       
    }
    
    /**
     * 
     * @param vertex value for a give key
     * @return classname for given vertex
     */
    String getClassName(int vertex){
        for(String x :intToClass.keySet()){
            if(intToClass.get(x).equals(vertex)){
                return x.toString();//return classname
            }            
        }
        return "";   //return null
    }
            
    /*
    testing if the directed graph values are correct
    This is kind of test method 
    */
    void printList(String fileName) throws IOException{
        BuildDgraph(fileName);//just for testing
        for(LinkedList<Integer> x : adjLists){
            System.out.print(x.toString());
            
        }
        System.out.println("");
    }
    

   
    public static void main(String args[]){
        try{
        Graph g = new Graph();
        g.BuildDgraph("graph1.txt");
        
       String x =g.topologicalSort("ClassA");
     
         System.out.println(x);
        } catch (Exception e){
            System.out.print(e);
        
    }
    }
    
}
