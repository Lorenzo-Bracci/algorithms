//Lorenzo Bracci
//2019-10-07
//This program computes the minimum spanning tree of the largest connected component in a given tree
import java.util.Random;
import java.util.Scanner;
public class Lab5Part4{
  public static void main(String[]args){
    Random rand = new Random();
    int counter = 0;//used to give uniques integers values to every String
    LinearProbingHashST <String, Integer> st = new LinearProbingHashST<String, Integer>(16);//create a hash table where we store the strings to check if they have already occourred
    Queue<Integer> queue = new Queue<Integer>();//creates a queue where we will store every element transforment in an int
Stack<String> states = new Stack<String>();
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()){
      String word = scanner.next();
if(st.contains(word)){//checks if the word is already in the hash map
  queue.enqueue(st.get(word));
}else{//checks if the word is already in the hash map
  st.put(word, counter);//associates the string word with the current value of the counter and then increments it after that the value has been added to the queue
  queue.enqueue(counter++);
  states.push(word);
}
      }
      EdgeWeightedGraph graph = new EdgeWeightedGraph(counter);//initializes a graph
      while(!queue.isEmpty()){
        int n = rand.nextInt(50);
        int vertex1 = queue.dequeue();
        int vertex2 = queue.dequeue();
        Edge e = new Edge(vertex1, vertex2,n);
        graph.addEdge(e);//adds a vertex to the graph
      }
      EdgeWeightedGraph newgraph = new EdgeWeightedGraph(counter);//creates a new graph with the same size as the old one
      CC connectedComponents = new CC(graph);//creates a new connected components object
      if(connectedComponents.count() == 1){//if theere is only 1 connected component that the graph that we want to find the spanning tree of is the original graph
      newgraph = graph;
      }else{
        int[] sizeOfComponents = new int[connectedComponents.count()];
      for (int v = 0; v < counter; v++){//this loop stores the length of every component in the array
        int id = connectedComponents.id(v);
        sizeOfComponents[id]++;
      }
      int greatestComponent = 0;
      int size = sizeOfComponents[0];
      for (int i = 1; i < connectedComponents.count();i++){//find the largestComponent
        if(sizeOfComponents[i] > size){
          greatestComponent = i;
          size = sizeOfComponents[i];
        }
      }
      for (Edge e : graph.edges()){//adds every edge connecting vertices in the largest connectd component to the new graph
        int vertex = e.either();
        if(connectedComponents.id(vertex) == greatestComponent && connectedComponents.id(e.other(vertex)) == greatestComponent){
          newgraph.addEdge(e);
      }
      }
      }
      LinearProbingHashST <Integer, String> st2 = new LinearProbingHashST<Integer, String>(16);//used to get the name of the state when we have the number associated with import junit.framework.TestCase;
      for(String state : states){
        st2.put(--counter, state);
      }
      PrimMST mst = new PrimMST(newgraph);//inizializes a DFS structure with starting point in departure and computes dfs

  System.out.println("The minimum spanning tree is: ");
  for (Edge e : mst.edges()){
    int one = e.either();
System.out.println(st2.get(one) + " " + st2.get(e.other(one)));
}
System.out.println("The weight of the mst is: " + mst.weight());

  }
}
