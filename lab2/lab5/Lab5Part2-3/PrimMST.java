//Lorenzo Bracci
//2019-10-07
//This program computes the minimum spanning tree of the a given tree
public class PrimMST
{
private Edge[] edgeTo; // shortest edge from tree vertex
private double[] distTo; // distTo[w] = edgeTo[w].weight()
private boolean[] marked; // true if v on tree
private IndexMinPQ pq; // eligible crossing edges
public PrimMST(EdgeWeightedGraph G)
{
edgeTo = new Edge[G.V()];
distTo = new double[G.V()];
marked = new boolean[G.V()];
for (int v = 0; v < G.V(); v++)
distTo[v] = Double.POSITIVE_INFINITY;
pq = new IndexMinPQ();
distTo[0] = 0.0;//we start with vertex 0 so we set the distance to vertex 0 to 0
pq.insert(0, 0.0); // Initialize pq with 0, weight 0.
while (!pq.isEmpty())
visit(G, pq.delMin()); // Add closest vertex to tree.
}
private void visit(EdgeWeightedGraph G, int v)
{ // Add v to tree; update data structures.
marked[v] = true;//adds the vertx to the spanning tree
for (Edge e : G.adj(v))
{
int w = e.other(v);
if (marked[w]) continue; // v-w is ineligible.
if (e.weight() < distTo[w])
{ // Edge e is new best connection from tree to w.
edgeTo[w] = e;
distTo[w] = e.weight();
if (pq.contains(w)) pq.change(w, distTo[w]);//if we found a better connection update the old one
else pq.insert(w, distTo[w]);//if we didnt see the vertex before add it to the priority queue
}
}
}
public Iterable<Edge> edges()
{
Bag<Edge> mst = new Bag<Edge>();
for (int v = 1; v < edgeTo.length; v++)
mst.add(edgeTo[v]);
return mst;
}
public double weight() {//returns the total weight of the spanning tree
  double weight = 0.0;
  for (Edge e : edges())
  weight += e.weight();
  return weight;
}
}
