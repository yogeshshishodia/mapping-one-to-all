package jdbappmapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_bi")
public class StudentBi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	private String studentName;
	// Student class has an address -- HAS A relationship
	// ONe to One bi
	@OneToOne(cascade = CascadeType.ALL)
	private AddressBi addressBi; // owning side

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public AddressBi getAddressBi() {
		return addressBi;
	}

	public void setAddressBi(AddressBi addressBi) {
		this.addressBi = addressBi;
	}

	@Override
	public String toString() {
		return "StudentBi [studentId=" + studentId + ", studentName=" + studentName + ", addressBi=" + addressBi + "]";
	}

}