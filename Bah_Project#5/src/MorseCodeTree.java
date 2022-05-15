import java.util.ArrayList;

/**
 * 
 * @author alpha bah
 *
 * This is a MorseCodeTree which is specifically used for the conversion of morse code to english
 * It relies on a root (reference to root of the tree)
 *
 * The root is set to null when the tree is empty.
 *
 * The class uses an external generic TreeNode class which consists of a reference to the data and a reference
 *  to the left and right child. The TreeNode is parameterized as a String, TreeNode This class uses a private member root
 *   (reference to a TreeNode)
 */
public class MorseCodeTree extends Object implements LinkedConverterTreeInterface<String>{

	private TreeNode<String> root;
	
	//Constructor - calls the buildTree method
	public MorseCodeTree() {
		buildTree();
	}
	
	//Returns a reference to the root
	@Override
	public TreeNode<String> getRoot() {
		// TODO Auto-generated method stub
		return root;
	}

	//sets the root of the MorseCodeTree
	@Override
	public void setRoot(TreeNode<String> newNode) {
		// TODO Auto-generated method stub
		root=new TreeNode<String>(newNode);
	}

	//Adds element to the correct position in the tree based on the code 
	//This method will call the recursive method addNode
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		// TODO Auto-generated method stub
		addNode(root, code, result);
		return this;
	}

	/**
	 * This is a recursive method that adds element to the correct position in the tree based on the code.
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		// TODO Auto-generated method stub
		if ( code.length() == 1) {
	      if (code.charAt(0) == '.') {
	        root.leftChild = new TreeNode<String>(letter);
	      } 
	      else if (code.charAt(0) == '-') {
	        root.rightChild = new TreeNode<String>(letter);
	      }
	    } 
		else {
	      if (code.charAt(0) == '.') {
	        addNode(root.leftChild, code.substring(1), letter);
	      } 
	      else if (code.charAt(0) == '-') {
	        addNode(root.rightChild,  code.substring(1), letter);
	      }
	    }
	}

	/**
	 * Fetch the data in the tree based on the code This method will call the recursive method fetchNode
	 */
	@Override
	public String fetch(String code) {
		// TODO Auto-generated method stub
		return fetchNode(root, code);
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode that corresponds with the code A '.' (dot) means traverse to the left.
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		// TODO Auto-generated method stub
		
		if ( code.length() == 1) {
	      if (code.charAt(0) == '.') {
	        return root.leftChild.data;
	      } else if (code.charAt(0) == '-') {
	        return root.rightChild.data;
	      }
	    } 
		else if(code.length()>4) {
			throw new RuntimeException(code + " cannot be translated to an alpha letter");
		}
		else {
	      if (code.charAt(0) == '.') {
	        return fetchNode(root.leftChild, code.substring(1));
	      } else if (code.charAt(0) == '-') {
	        return fetchNode(root.rightChild, code.substring(1));
	      }
	    }
		
	    return null;
	}

	//Unsupported Action
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	//Unsupported Action
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code.
	 */
	@Override
	public void buildTree() {
		// TODO Auto-generated method stub
		
		root = new TreeNode<String>("");
		insert(".", "e");
	    insert("-", "t");
	    insert("..", "i");
	    insert(".-", "a");
	    insert("-.", "n");
	    insert("--", "m");
	    insert("...", "s");
	    insert("..-", "u");
	    insert(".-.", "r");
	    insert(".--", "w");
	    insert("-..", "d");
	    insert("-.-", "k");
	    insert("--.", "g");
	    insert("---", "o");
	    insert("....", "h");
	    insert("...-", "v");
	    insert("..-.", "f");
	    insert(".-..", "l");
	    insert(".--.", "p");
	    insert(".---", "j");
	    insert("-...", "b");
	    insert("-..-", "x");
	    insert("-.-.", "c");
	    insert("-.--", "y");
	    insert("--..", "z");
	    insert("--.-", "q");
	}

	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order Used for testing to make sure tree is built correctly
	 */
	@Override
	public ArrayList<String> toArrayList() {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
	    LNRoutputTraversal(root, list);
	    return list;
	}

	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// TODO Auto-generated method stub
		if (root == null) {
	      return;
	    }
		
		// Inorder traversal: Left child then root then Right child
	    if (root.leftChild != null) {
	      LNRoutputTraversal(root.leftChild, list);
	    }
	    
	    list.add(root.data);
	    
	    if (root.rightChild != null) {
	      LNRoutputTraversal(root.rightChild, list);
	    }
	   
	}
	
}
