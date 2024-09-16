
public class Course {
	private long id;
	private String prefix;
	private int code;
	private String name;
	
	public Course() {
		
	}
	
	public Course(Long id, String prefix, int code, String name) {
		super();
		this.id = id;
		this.prefix = prefix;
		this.code = code;
		this.name = name;
	}
}