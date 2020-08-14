//Lorenzo Bracci
//2019-10-07
//This program computes the shortest path between 2 vertices in a graph
public class DijkstraSP
{
private Edge[] edgeTo;
private double[] distTo;
private IndexMinPQ pq;
public DijkstraSP(EdgeWeightedGraph G, int s)
{
edgeTo = new Edge[G.V()];
distTo = new double[G.V()];
pq = new IndexMinPQ();
for (int v = 0; v < G.V(); v++)
distTo[v] = Double.POSITIVE_INFINITY;//inizializes all distances to infinity
distTo[s] = 0.0;//inizializes the first distance to 0
pq.insert(s, 0.0);
while (!pq.isEmpty())//while the priority queue is not empty relaxes adges
relax(G, pq.delMin());
}
private void relax(EdgeWeightedGraph G, int v)
{
for(Edge e : G.adj(v))
{
int w = e.other(v);
if (distTo[w] > distTo[v] + e.weight())//checks if we should update values for distance
{
distTo[w] = distTo[v] + e.weight();
edgeTo[w] = e;
if (pq.contains(w)) pq.change(w, distTo[w]);//update values is we already had the value
else pq.insert(w, distTo[w]);//insert the value if we already had it
}
}
}
public double distTo(int v)
{ return distTo[v]; }
public boolean hasPathTo(int v)
{ return distTo[v] < Double.POSITIVE_INFINITY; }
public Iterable<Integer> pathTo(int v)
{
if (!hasPathTo(v)) return null;
Stack<Integer> path = new Stack<Integer>();
Edge e = edgeTo[v];
int to = v;
int from;
while(e != null){
  path.push(to);
from = e.other(to);
e = edgeTo[from];
to = from;
}
path.push(to);//adds last vertex
return path;
}
}
