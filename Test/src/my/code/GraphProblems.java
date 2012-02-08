/**
 * Graph Problems
 */
package my.code;

import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Naveen
 *
 */
public class GraphProblems {

	public static boolean findRoute(GraphNode a, GraphNode b)
	{

		List<GraphNode> children = a.getChildren();

		Stack<GraphNode> nodesStack = new Stack<GraphNode>();

		if(children.contains(b)) return true;	

		for(GraphNode n: children)
		{
			if(!n.visited )
			{
				nodesStack.addAll(n.getChildren());
				{
					while(!nodesStack.isEmpty())
					{
						if(nodesStack.pop() == b) return true;
					}
					n.visited = true;
				}
			}

		}
		return false;
	}

}
