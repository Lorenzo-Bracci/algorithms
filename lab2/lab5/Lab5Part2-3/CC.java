//Lorenzo Bracci
//2019-10-07
//This program computes the connected components of a given tree
public class CC
{
private boolean[] marked;
private int[] id;
private int count;
public CC(EdgeWeightedGraph G)
{
marked = new boolean[G.V()];
id = new int[G.V()];
for (int s = 0; s < G.V(); s++)
if (!marked[s])//we havent already marked the vertex
{
dfs(G, s);//searches for all reachable vertexs
count++;//increse the number of connected components
}
}
private void dfs(EdgeWeightedGraph G, int v)//normal depth first search
{
marked[v] = true;
id[v] = count;//gives the vertexthe id of its component
for (Edge e : G.adj(v)){
  int w = e.other(v);
if (!marked[w])
dfs(G, w);
}
}
public boolean connected(int v, int w)//checks if 2 nodes are connected
{ return id[v] == id[w]; }
public int id(int v)
{ return id[v]; }
public int count()//returns the number of components
{ return count; }
}
