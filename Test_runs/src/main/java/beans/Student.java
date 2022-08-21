package beans;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@Entity

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sub_gen")
	@SequenceGenerator(name="sub_gen", sequenceName="sub_seq")
	private int studId;
	
	@Column(length=20)
	private String st_name;
	
	

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}


	
}
