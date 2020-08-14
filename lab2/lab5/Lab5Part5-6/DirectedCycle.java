//Lorenzo Bracci
//2019-10-08
//This program find directed cycles in a Digraph
public class DirectedCycle//only finds one directed cycle not  all of them
{
private boolean[] marked;
private int[] edgeTo;
private Stack<Integer> cycle; // vertices on a cycle (if one exists)
private boolean[] onStack; // vertices on recursive call stack
public DirectedCycle(Digraph G)
{
onStack = new boolean[G.V()];
edgeTo = new int[G.V()];
marked = new boolean[G.V()];
for (int v = 0; v < G.V(); v++)
if (!marked[v]) dfs(G, v);
}
private void dfs(Digraph G, int v)
{
onStack[v] = true;
marked[v] = true;
for (int w : G.adj(v))
if (this.hasCycle()) return;
else if (!marked[w])//checks if the vertex has been marked already
{ edgeTo[w] = v; dfs(G, w); }
else if (onStack[w])//checks if the vertx is on the execution stack of dfs
{
cycle = new Stack<Integer>();//we save the cycle on a stack
for (int x = v; x != w; x = edgeTo[x])//pushes every vertex of the cycle until the last one starting from the vertex that was used to call dfs
cycle.push(x);
cycle.push(w);//pushes the two vertices that were in the edge e that we were examining
cycle.push(v);
}
onStack[v] = false;//the vertex v is not anymore on the execution stack
}
public boolean hasCycle()
{ return cycle != null; }
public Iterable<Integer> cycle()
{ return cycle; }
}
