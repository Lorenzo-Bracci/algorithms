//Lorenzo Bracci
//2019-10-08
//This program checks if there is a path between 2 vertices in a given directed graph
import java.util.Scanner;
public class Lab5Part5{
  public static void main(String[]args){
    String departure = args[0];
    String arrival = args[1];
    int counter = 0;//used to give uniques integers values to every String
    LinearProbingHashST <String, Integer> st = new LinearProbingHashST<String, Integer>(16);//create a hash table where we store the strings to check if they have already occourred
    Queue<Integer> queue = new Queue<Integer>();//creates a queue where we will store every element transforment in an int
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()){
      String word = scanner.next();
if(st.contains(word)){//checks if the word is already in the hash map
  queue.enqueue(st.get(word));
}else{//checks if the word is already in the hash map
  st.put(word, counter);//associates the string word with the current value of the counter and then increments it after that the value has been added to the queue
  queue.enqueue(counter++);
}
      }
      Digraph graph = new Digraph(counter);//initializes a digraph
      while(!queue.isEmpty()){
        int vertex1 = queue.dequeue();
        int vertex2 = queue.dequeue();
        graph.addEdge(vertex1,vertex2);//adds a vertex to the digraph
      }
      DirectedDFS path = new DirectedDFS(graph, st.get(departure));//inizializes a DFS structure with starting point in departure and computes dfs
if(path.marked(st.get(arrival))){//checks if there is the path that we are looking for
System.out.println("There is a path between " + departure + " and " + arrival);
}else {
  System.out.println("There is not a path between " + departure + " and " + arrival);
}
  }
}
