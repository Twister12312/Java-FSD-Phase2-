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
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sub_gen")
	@SequenceGenerator(name="sub_gen", sequenceName="sub_seq")
	private int teachId;
	
	@Column(length=20)
	private String t_name;
	
	@ManyToMany(mappedBy="teachers")
	private Set<Class> classes=new HashSet<Class>();
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="teachers_subjects", joinColumns= {@JoinColumn(name="teachId")}, inverseJoinColumns= {@JoinColumn(name="subId")})
	private Set<Subject> subjects=new HashSet<Subject>();

	public int getTeachId() {
		return teachId;
	}

	public void setTeachId(int teachId) {
		this.teachId = teachId;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public Set<Class> getClasses() {
		return classes;
	}

	public void setClasses(Set<Class> classes) {
		this.classes = classes;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}
	public void addClass(Class cla_ss) {
		this.classes.add(cla_ss);
	}
	
}
