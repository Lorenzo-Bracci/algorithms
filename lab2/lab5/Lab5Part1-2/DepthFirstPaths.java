//Lorenzo Bracci
//05-10-2019
//This is program implements DFS
public class DepthFirstPaths
{
private boolean[] marked; // Has dfs() been called for this vertex?
private int[] edgeTo; // last vertex on known path to this vertex
private final int s; // source
public DepthFirstPaths(Graph G, int s)
{
marked = new boolean[G.V()];
edgeTo = new int[G.V()];
this.s = s;
dfs(G, s);
}
private void dfs(Graph G, int v)
{
marked[v] = true;
for (int w : G.adj(v))//for every adjacent vertex if the vertex is non marked make recursive call to dfs
if (!marked[w])
{
edgeTo[w] = v;//stores the current vertex in edgeto[nextvertex]
dfs(G, w);
}
}
public boolean hasPathTo(int v)
{ return marked[v]; }
public Iterable<Integer> pathTo(int v)
{
if (!hasPathTo(v)) return null;
Stack<Integer> path = new Stack<Integer>();
for (int x = v; x != s; x = edgeTo[x])//pushes every vertex from the arrival to the one before the departure to a stack
path.push(x);
path.push(s);//pushes departure
return path;
}
}
