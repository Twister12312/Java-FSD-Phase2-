package beans;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sub_gen")
	@SequenceGenerator(name="sub_gen", sequenceName="sub_seq")
	private int SubId;
	
	@Column(length=20)
	private String subname;
	
	@ManyToMany(mappedBy="subjects")
	private Set<Class> classes=new HashSet<Class>();
	
	@ManyToMany(mappedBy="subjects")
	private Set<Teacher>teachers=new HashSet<Teacher>();
	
	

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public int getSubId() {
		return SubId;
	}

	public void setSubId(int subId) {
		SubId = subId;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public Set<Class> getClasses() {
		return classes;
	}

	public void setClasses(Set<Class> classes) {
		this.classes = classes;
	}
	
	public void addClass(Class cla_ss) {
		this.classes.add(cla_ss);
	}
	
	public void addTeacher(Teacher teacher) {
		this.teachers.add(teacher);
	}
	
}
