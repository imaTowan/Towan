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
	@Column(name = "report_id")
	private int report_id;
	
	@Column(nullable = true)
	private String text;
	
	
	//Relationships
	@ManyToOne
	private UserModel user;

	@ManyToOne
	private EntryModel entry;
	
	//Constructors
	public ReportModel() {
	}

	public ReportModel(String text) {
		super();
		this.text = text;
	}

	
	//Getter & Setter
	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
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

	public EntryModel getEntry() {
		return entry;
	}

	public void setEntry(EntryModel entry) {
		this.entry = entry;
	}
	
	
	//equals & hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + report_id;
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
		if (report_id != other.report_id)
			return false;
		return true;
	}
}
