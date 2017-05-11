package at.fh.swenga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REPORT")
public class ReportModel {

	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "entry_id")
	private int entry_report_id;
	
	@Column(nullable = true)
	private String text;
	
	
	//Relationships
	@ManyToOne
	private UserModel user;

	
	//Constructors
	public ReportModel() {
	}

	public ReportModel(String text, EntryModel entry, UserModel user) {
		super();
		this.text = text;
		this.user = user;
	}

	
	//Getter & Setter
	public int getEntry_report_id() {
		return entry_report_id;
	}

	public void setEntry_report_id(int entry_report_id) {
		this.entry_report_id = entry_report_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	
	//equals & hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + entry_report_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportModel other = (ReportModel) obj;
		if (entry_report_id != other.entry_report_id)
			return false;
		return true;
	}
}
