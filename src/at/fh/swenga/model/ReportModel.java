package at.fh.swenga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REPORT")
public class ReportModel {

	//Attributes
	@Column(nullable = true)
	private String text;
	
	
	//Relationships
	@Id
	@ManyToOne
	@JoinColumn(name = "entry_id")
	private EntryModel entry;
	
	@ManyToOne
	private UserModel user;

	
	//Constructors
	public ReportModel() {
	}

	public ReportModel(String text, EntryModel entry, UserModel user) {
		super();
		this.text = text;
		this.entry = entry;
		this.user = user;
	}

	
	//Getter & Setter
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public EntryModel getEntry() {
		return entry;
	}

	public void setEntry(EntryModel entry) {
		this.entry = entry;
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
		result = prime * result + ((entry == null) ? 0 : entry.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (entry == null) {
			if (other.entry != null)
				return false;
		} else if (!entry.equals(other.entry))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
