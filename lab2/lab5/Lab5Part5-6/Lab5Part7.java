//Lorenzo Bracci
//2019-10-08
//This program checks if there is directed cycle in a given directed graph and if there is not any it computes the topological order
import java.util.Scanner;
public class Lab5Part7{
  public static void main(String[]args){
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
      Digraph graph = new Digraph(counter);//initializes a digraph
      while(!queue.isEmpty()){
        int vertex1 = queue.dequeue();
        int vertex2 = queue.dequeue();
        graph.addEdge(vertex1,vertex2);//adds a vertex to the digraph
      }
      LinearProbingHashST <Integer, String> st2 = new LinearProbingHashST<Integer, String>(16);//used to get the name of the state when we have the number associated with import junit.framework.TestCase;
      for(String state : states){
        st2.put(--counter, state);
      }
      DirectedCycle cycle = new DirectedCycle(graph);//inizializes a directed cycle
      DepthFirstOrder topologicalOrder = new DepthFirstOrder(graph);
if(cycle.hasCycle()){//checks if there is a cycle
System.out.println("This graph is not a DAG");
}else {
  for(int i : topologicalOrder.reversePost())//prints the digraph in topological order
  System.out.println(st2.get(i));
}
  }
}
