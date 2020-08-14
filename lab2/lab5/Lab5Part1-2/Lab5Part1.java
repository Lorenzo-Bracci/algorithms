//Lorenzo Bracci
//05-10-2019
//This is a program based on DFS which can answer questions of the type: "Find the a path from X to Y"
//Which should result in a list of vertices traversed from X to Y if there is a path.
import java.util.Scanner;
public class Lab5Part1{
  public static void main(String[]args){
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
      Graph graph = new Graph(counter);//initializes a graph
      while(!queue.isEmpty()){
        int vertex1 = queue.dequeue();
        int vertex2 = queue.dequeue();
        graph.addEdge(vertex1,vertex2);//adds a vertex to the graph
      }
      LinearProbingHashST <Integer, String> st2 = new LinearProbingHashST<Integer, String>(16);//used to get the name of the state when we have the number associated with import junit.framework.TestCase;
      for(String state : states){
        st2.put(--counter, state);
      }
      DepthFirstPaths path = new DepthFirstPaths(graph, st.get(departure));//inizializes a DFS structure with starting point in departure and computes dfs
if(path.hasPathTo(st.get(arrival))){
  System.out.println("The path from " + departure + " to " + arrival + " is:");
  for (int i : path.pathTo(st.get(arrival)))
System.out.println(st2.get(i));
}else {
  System.out.println("There is no such a path");
}
  }
}
