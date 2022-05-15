

public class LinkedQueue<T> implements QueueInterface<T> {

	private Node firstNode;
	private Node lastNode;
	
	LinkedQueue() {
		firstNode=null;
		lastNode=null;
	}
	
	@Override
	public void enqueue(T newEntry) {
		// TODO Auto-generated method stub
		Node newNode= new Node(newEntry, null);
		if(isEmpty())
			firstNode=newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode=newNode;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		T front=null;
		try {
			front = getFront();
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   firstNode.setData(null);
		   firstNode = firstNode.getNextNode();

		   if (firstNode == null)
		      lastNode = null;

		   return front;
			
	}

	@Override
	public T getFront() throws EmptyQueueException {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new EmptyQueueException();
		else
			return firstNode.getData();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (firstNode==null)&&(lastNode==null);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		firstNode=null;
		lastNode=null;
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
