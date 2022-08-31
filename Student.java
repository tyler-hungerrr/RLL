public class Student implements Comparable {
	private String id;
	private String name;
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}

	
	@Override
	public boolean equals(Object obj) {
		Student another = (Student) obj;
		return this.id.compareToIgnoreCase(another.id)==0;
	}

	@Override
	public String toString() {
		return "id=" + id + "_name=" + name;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Student another = (Student) o;
		return this.id.compareToIgnoreCase(another.id);
	}
	
	

}
