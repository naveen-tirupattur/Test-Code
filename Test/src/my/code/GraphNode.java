/**
 * Class for Graph Node
 */
package my.code;

import java.util.List;

/**
 * @author Naveen
 *
 */
public class GraphNode {
	
	public int data;
	
	public boolean visited;
	
	public List<GraphNode> children;
	
	public List<GraphNode> getChildren()
	{
		return children;
	}
	
	public boolean isVisited()
	{
		return visited;
	}

}
