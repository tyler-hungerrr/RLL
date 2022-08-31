public class myLinkedList<E extends Comparable>{
  // instance variables of the SinglyLinkedList
  private Node <E> head;               // refers to the first node of the list (or null if empty)
  private int size;               // refers to the number of nodes of the list
  
  public myLinkedList() {// constructs an initially empty list
	  head=null;
	  size=0;
  }            

  public boolean isEmpty() {// Tests whether the linked list is empty.
	  if(head==null||size==0) {
		  return true;
	  }
	  else return false;
  }

  public int size() {//return number of nodes in the list
	  return size;
  }
  
  public boolean search(E target){//check if a target element can be found on the list, return true for yes and false for no
	  /*for(Node curr=head;curr!=null;curr=curr.getNext()) {
			if(curr.getElement().equals(target)) 
				return true;
		}
		return false;*/
	  Node<E> curr=head;
	  while(curr!=null) {
		  if(curr.getElement().equals(target))
			  return true;
		  curr =curr.getNext();
		}
		return false;
  }
  
  public void addFirst(E newItem) { // add newItem to the front of the list if the item is not found in the list
	  /*if(search(newItem)==false) {
	  Node newNode=new Node(newItem, null);
		if(head!=null) { //check if list has nodes
			Node curr=head;
			newNode.setNext(curr);
			head=newNode;
			size++;
		}
		else head=newNode;
		size++;//if list is empty
	  }*/
	  if(search(newItem)==false) {
		  Node<E> newENode = new Node<E>(newItem, null);
		  newENode.setNext(head);
		  head=newENode;
		  size++;
		  }
  }

  public void addLast(E newItem) {// adds newItem to the end of the list if the item is not found in the list	  
	  /*if (search(newItem)==false) {
	  Node newNode=new Node(newItem, null);
			Node curr=head;
		while(curr.getNext()!=null) curr=curr.getNext(); //locate the last node
		curr.setNext(newNode);
		size++;
	  }*/
	  if (search(newItem)==false) {
		  Node<E> newNode=new Node<E>(newItem, null);
				if(head==null) head=newNode;
				else {
					Node<E> curr=head;
			while(curr.getNext()!=null) {
				curr=curr.getNext(); //locate the last node
			}
			curr.setNext(newNode);
			size++;
				}
		}
	  }

  public E removeFirst() {  // remove the first node of the list and return the removed item	  		
	  /*if (size!=0) {
		  Node item = head;
		  if (item.getNext==null)
			  head=null;
		  if (item.getNext!=null)
			  head= head.getNext();
	  }
	  size--;
	  return item;*/
	  if(isEmpty()==false) {
		  E removed=head.getElement();
		  Node<E> curr=head;
		  head=head.getNext();
		  curr.setNext(null);
		  size--;
		  return removed;
	  }
	  return null;
  }
  
  public E removeLast() {   // removes and returns the last element if exist
	  if (size!=0) {
		  Node item = head;
		  if (item.getNext()==null) {
			  head=null;
			  size--;
			  return item;
		  }
		  if (item.getNext!=null) {
			  Node prev= null, curr=head;
				while(curr.getElement()!=target&&curr!=null) {
					prev=curr;
					curr=curr.getNext();
				}
				prev.setNext(null);
				size--;
				return curr;
		  }
	  }
  }

  public void insert(E newItem) {// if newItem is not found in the list, this method will insert in front of first node that stores item greater than e.
	  /*if (search(newItem)==false) {
		  Node newNode=new Node(newItem, null);
		  if (head.getNext()!=null) {
			  Node prev= null, curr=head;
			  while(curr!=null && curr.getElement()!=newItem) { //always check for nulls first
					prev=curr;
					curr=curr.getNext();
			  }
			  prev.setNext(newNode);
			  newNode.setNext(curr);
			  size++;
		  }
		  else addFirst(newItem);
	  }*/
	  if(search(newItem)==false) {
		  Node<E> newNode = new Node<E>(newItem);
		  Node<E> prev = null;
		  Node<E> curr = head;
		  while(curr!=null&&curr.getElement().compareTo(newItem)<0) {
			  prev=curr;
			  curr=curr.getNext();
		  }
		  if(prev==null) addFirst(newItem);
		  else {
			  prev.setNext(newNode);
			  newNode.setNext(curr);
		  }
		  size++;
	  }
  }
  
  public void delete(E target) {//this method will find and remove the node that contains target
	  /*Node prev= null, curr=head;
		while(curr.getElement()!=target&&curr!=null) {
			prev=curr;
			curr=curr.getNext();
		}
		if(curr!=null) {
			if(curr==head) {
				///if node to be removed is the first node
				head=head.getNext();
			}
			else {
			prev.setNext(curr.getNext());
			curr.setNext(null);
			curr=null;
			}
		}
		size--;*/
	  if(search(target)!=false) {
		  Node<E> prev=null;
		  Node<E> curr=head;
		  while(curr.getElement().equals(target)==false) {
			  prev=curr;
			  curr=curr.getNext();
		  }
		  if(curr==head) removeFirst();
		  else prev.setNext(curr.getNext());
		  size--;
	  }
  }
 
 
 public Node getMax() {//find and return the node stores the maximum item in the list
	 /*if (size!=0) {
		 Node max = head;
		 Node curr=head.getNext();
		  while(curr!=null)  {
			if(curr.getElement().compareTo(max.getElement())>=0) max= curr;
			curr=curr.getNext();
		  }
		return max;
	 }
	 else {
	 return null;
	 }*/
	 Node<E> curr=head, max=head;
	 while(curr!=null) {
		 if(curr.getElement().compareTo(max.getElement())>0) max=curr;
		 curr=curr.getNext();
	 }
	 return max;
 }
 
  public void concatenateList (myLinkedList<E> L) {//append (or concatenate) another linkedList referred by L to the end of this linkedList
	  /*if (size!=0) {
		  Node curr=head;
		  while(curr.getNext()!=null) curr=curr.getNext(); 
		  curr.setNext(L.head);
		  size++;
	  }
	  else {
		  head=L.head;
		  size++;
	  }*/
	  if(this.head==null) {
		  this.head=L.head;
	  }
	  else {
		  Node<E> curr=head;
		  while(curr.getNext()!=null)
			  curr=curr.getNext();
		  curr.setNext(L.head);
	  }
	  this.size+=L.size;
  }
 
  public E middleElement(){//find and return the element that stored at the middle node of a linkedList 
	  /*Node item= null;
	  if (size==1)
		  return head.getElement();
	  if (size==2) {
		  Node r=head.getNext();
		  return head.getElement(); 
	  }
	  else {
		  Node <E> prev = head, curr=head.getNext();
		  while(curr!=null&&curr.getNext()!=null) {
				prev=curr;
				curr=curr.getNext().getNext();
		  }
		  return prev.getElement();
	  }*/
	  if(size==1||size==2) return head.getElement();
	  else if(size>2) {
		  Node<E> prev=head;
		  Node<E> curr=head;
		  while(curr.getNext()!=null&&curr.getNext().getNext()!=null) {
			  prev=prev.getNext();
			  curr=curr.getNext().getNext();
		  }
		  return prev.getElement();
	  }
	  else return null;
  }

  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = head;
    while (walk != null) {
      sb.append(walk.getElement());
      if (walk != null)
        sb.append(", ");
      walk = walk.getNext();
    }
    sb.append(")");
    return sb.toString();
  }
}
