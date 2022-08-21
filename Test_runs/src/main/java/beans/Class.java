package beans;
import java.util.HashSet;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@Entity
public class Class {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="red_gen")
	@SequenceGenerator(name="red_gen", sequenceName="red_seq")
	private int classId;
	
	@Column(length=20)	
	private String Cla_ss;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="class_subjects", joinColumns= {@JoinColumn(name="classId")}, inverseJoinColumns= {@JoinColumn(name="SubId")})
	private Set<Subject>subjects=new HashSet<Subject>();

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="class_teachers", joinColumns= {@JoinColumn(name="classId")}, inverseJoinColumns= {@JoinColumn(name="teachId")})
	private Set<Teacher>teachers=new HashSet<Teacher>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="class_students", joinColumns= {@JoinColumn(name="classId")}, inverseJoinColumns= {@JoinColumn(name="studId")})
	private Set<Student>students=new HashSet<Student>();
	
	

	public int getClassId() {
		return classId;
	}


	public String getCla_ss() {
		return Cla_ss;
	}


	public void setCla_ss(String cla_ss) {
		Cla_ss = cla_ss;
	}


	public Set<Subject> getSubjects() {
		return subjects;
	}


	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}


	public Set<Teacher> getTeachers() {
		return teachers;
	}


	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}


	public Set<Student> getStudents() {
		return students;
	}


	public void setStudents(Set<Student> students) {
		this.students = students;
	}


	public void setClassId(int classId) {
		this.classId = classId;
	}
   
	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}
    
	public void addTeacher(Teacher teacher) {
		this.teachers.add(teacher);
	}
	
}







