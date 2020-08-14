//Lorenzo Bracci
//2019-10-08
//This program finds the topological order of a directed graph that does not have any cycle
public class DepthFirstOrder
{
private boolean[] marked;
private Stack<Integer> reversePost; // vertices in reverse postorder
public DepthFirstOrder(Digraph G)
{
reversePost = new Stack<Integer>();
marked = new boolean[G.V()];
for (int v = 0; v < G.V(); v++)
if (!marked[v]) dfs(G, v);//calling dfs for every vertex
}
private void dfs(Digraph G, int v)//normal dfs function except for the fact that he vertexes are stored in a postorder stack
{
marked[v] = true;
for (int w : G.adj(v))
if (!marked[w])
dfs(G, w);
reversePost.push(v);//computes reversepostorder
}
public Iterable<Integer> reversePost()
{ return reversePost; }
}
