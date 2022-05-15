/**
 * @author alpha bah
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class NotationStack<T> implements StackInterface<T>{

	private int size=10;
	private int NumOfElements=0;
	private Node topNode;
	
	public NotationStack(int size) {
		this.size=size;
		topNode=null;
	}
	
	public NotationStack() {
		topNode=null;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return topNode==null;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return NumOfElements==size;
	}

	@Override
	public T pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		else {
		T top= top();
		topNode=topNode.getNextNode();
		NumOfElements--;
		return top;
		}
	}

	@Override
	public T top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		else 
			return topNode.getData();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return NumOfElements;
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		// TODO Auto-generated method stub
		if(isFull()) {
			throw new StackOverflowException();
		}
		else {
			Node newNode= new Node(e, topNode);
			topNode = newNode;
			NumOfElements++;
			return true;
		}
	}
	
	@Override
	public String toString() {
		
		String str="";
		
		Node temp = topNode;
		
		while (temp != null) {
			
			str = temp.getData() +str;
			
			temp = temp.next;
		}
		
		return str;
			
	}

	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		String str="";
		Node temp = topNode;
		
		while (temp!=null) {
			str=temp.getData()+delimiter+str;
			
			temp=temp.next;
		}
		str = str.substring(0, str.length()-1);
		return str;
	}

	@Override
	public void fill(ArrayList<T> list) {
		// TODO Auto-generated method stub
		for (int i=0; i<list.size(); i++)
			try {
				push(list.get(i));
			} catch (StackOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private class  Node {
		private T data;
		private Node next;
		
		private Node(T dataPortion) {
			this(dataPortion, null);
		}
		
		private Node(T dataPortion, Node nextNode) {
			data=dataPortion;
			next=nextNode;
		}
		
		private T getData() {
			return data;
		}
		private void setData(T newData) {
			data=newData;
		}
		
		private Node getNextNode() {
			return next;
		}
		private void setNextNode(Node nextNode) {
			next=nextNode;
		}
	}

}
