/**
cerner_2^5_2020

This program is to make connections between mentioned all the nodes with possible minimum cost.
For example in the following scenario noOfNodesInNetwork is 5 and connections array define with index 0 - node, index 1-node, index 2- cost required to to build this connection. 

Input: noOfNodesInNetwork = 5, connections = [[1, 2, 3], [2, 3, 2], [3, 4, 8], [4, 5, 6], [1, 5, 9]]
Output: 19 
Ideas - Applying mkruskal's minimum spanning tree algorithm to calculate minimum cost to make this network.
Time complexity - sort - O(nlogn) + O(number of connections) + find representative O(n) + making set through union O(n) = O(nlogn)
Space Complexity - O(m) where m is the number of entries in map.  */

public int minimumCostToConnectNodesInNetwork( int noOfNodesInNetwork, int[][] connections)
{
	// check the constraints 
	if (noOfNodesInNetwork <=1 && connections == null || connections.length == 0)
	{
		return 0;
	}

	// makeset which creates a set where each node has a representative in the set they belong. Initially parent of each node is -1.
	final Map<Integer, Integer> nodeToRepresentative= new HashMap<>();

	for (int i=1; i<=noOfNodesInNetwork; i++)
	{
		nodeToRepresentative.put(i, -1);
	}

	Arrays.sort(connections, (a,b) -> a[2] - b[2]);

	int result = 0;

	for (int edge[] : connections)
	{
		int node1 = findRepresentative(nodeToRepresentative, edge[0]);
		int node2 = findRepresentative(nodeToRepresentative, edge[1]);

		if (node1 != node2)
		{
			result += edge[2];
			nodeToRepresentative.put(node1, node2);
			noOfNodesInNetwork--;
		}
	}

	return (noOfNodesInNetwork == 1) ? result : -1;
} 

private int findRepresentative(Map<Integer, Integer> nodeToRepresentative, int node)
{
	int parent = nodeToParent.get(node);
	int index = node;
	
	while (parent != -1)
	{
		index= parent;
		parent = nodeTOParent.get(parent);
	}
	return index;
}