//Lorenzo Bracci
//2019-10-07
//Assign unique weights to the edges (1,2,3...E) and write a program that can find the shortest path
//between X and Y and print the vertices traversed and the associated sum of the weights of the path.
import java.util.Random;
import java.util.Scanner;
public class Lab5Part3{
  public static void main(String[]args){
    Random rand = new Random();
    String departure = args[0];
    String arrival = args[1];
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
        System.out.println(n);
        graph.addEdge(e);//adds a vertex to the graph
      }
      LinearProbingHashST <Integer, String> st2 = new LinearProbingHashST<Integer, String>(16);//used to get the name of the state when we have the number associated with import junit.framework.TestCase;
      for(String state : states){
        st2.put(--counter, state);
      }
      DijkstraSP path = new DijkstraSP(graph, st.get(departure));//inizializes a DFS structure with starting point in departure and computes dfs
if(path.hasPathTo(st.get(arrival))){
  System.out.println("The path from " + departure + " to " + arrival + " is:");
  for (int i : path.pathTo(st.get(arrival)))
System.out.println(st2.get(i));
System.out.println("The total distance is: " + path.distTo(st.get(arrival)));
}else {
  System.out.println("There is no such a path");
}
  }
}
