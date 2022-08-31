public class mianClass {
	public static void main(String[] args) {
		Student s1=new Student("1", "Anna");
		Student s2=new Student("2", "Bob");
		Student s3=new Student("3", "Cathy");
		Student s4=new Student("4", "Daniel");
		Student s5=new Student("5", "Emily");
		Student s6=new Student("6", "Jason");
		Student s7=new Student("7", "Andrew");
		Student s8=new Student("8", "Krystal");
		
		myLinkedList<Student> listOne = new  myLinkedList<Student>();
		listOne.addFirst(s2);
		listOne.addFirst(s7);
		listOne.addFirst(s8);
		listOne.addFirst(s6);
		listOne.addFirst(s1);
		listOne.addLast(s4);
		listOne.addLast(s5);
		listOne.insert(s3);
		System.out.println("listOne: "+listOne);	
		listOne.delete(s1);
		listOne.delete(s4);
		System.out.println("listOne: "+listOne);
		
		if(listOne.search(s4))
			System.out.println("Found s4 in the list. ");
		else System.out.println("fail to find s4 in the list. ");
		if(listOne.search(s1))
			System.out.println("Found s1 in the list. ");
		else System.out.println("Fail to find s1 in the list. ");
		
		myLinkedList<Student> listTwo = new  myLinkedList<Student>();
		//add some element to listTwo here
		listTwo.addFirst(s2);
		System.out.println("The maximum element is "+listOne.getMax().getElement());
		
		System.out.println("listOne: "+listOne);		
		System.out.println("listTwo: "+listTwo);
		listOne.concatenateList(listTwo);
		System.out.println("Combined list: "+ listOne );		
				
		System.out.println("Middle element of "+ listOne +" is "+listOne.middleElement());
		}


}
