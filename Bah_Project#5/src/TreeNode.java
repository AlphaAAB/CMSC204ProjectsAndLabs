/**
 * 
 * @author alpha bah
 *
 * The external Tree Node for Linked Trees
 * @param <T>
 */
public class TreeNode<T> extends Object {
	T data;
	TreeNode<T> leftChild;
	TreeNode<T> rightChild;
	
	/**
	 * Constructor
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode){
		data=dataNode;
		leftChild=rightChild=null;
	}
	
	/**
	 * Constructor
	 * used for making deep copies
	 * @param node- node to make copy of
	 */
	public TreeNode(TreeNode<T> node){
		data=node.data;
		leftChild=node.leftChild;
		rightChild=node.rightChild;
	}
	
	/**
	 * Return the data within this TreeNode
	 * @return  the data within this TreeNode
	 */
	public T getData() {
		return data;
	}

	//getters
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	//setters
	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	
	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
}
