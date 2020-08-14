//Lorenzo Bracci
//2019-10-08
//This program implements DFS for directed graphs
public class DirectedDFS
{
private boolean[] marked;
public DirectedDFS(Digraph G, int s)
{
marked = new boolean[G.V()];
dfs(G, s);
}
public DirectedDFS(Digraph G, Iterable<Integer> sources)
{
marked = new boolean[G.V()];
for (int s : sources)
if (!marked[s]) dfs(G, s);
}
private void dfs(Digraph G, int v)//comptes DFS paths from a given vertex in a digraph
{
marked[v] = true;
for (int w : G.adj(v))
if (!marked[w]) dfs(G, w);
}
public boolean marked(int v)//checks if there is a path to a given vertex
{ return marked[v]; }

}
