package at.fh.swenga.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "ENTRY")
public class EntryModel {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="entry_id")
	private int entry_id;
	
	@Column(nullable = false, length = 250)
	private String text;
	
	@Column(nullable = false)
	private int report_count;
	
	@Column(nullable = false)
	private boolean isPinned;
	
	@Column(nullable = false)
	private boolean isFlagged;
	
	
	//Relationships
	@ManyToOne
	private SubforumModel subforum;
	
	@ManyToOne
	private UserModel user;
	
	@OneToMany
	private List<ReportModel> reports;

	
	//Constructors
	public EntryModel() {
	}
	
	public EntryModel(String text, int report_count, boolean isPinned, boolean isFlagged) {
		super();
		this.text = text;
		this.report_count = report_count;
		this.isPinned = isPinned;
		this.isFlagged = isFlagged;
		this.reports = new ArrayList<ReportModel>();
	}

	public EntryModel(String text) {
		super();
		this.text = text;
		this.report_count = 0;
		this.isPinned = false;
		this.isFlagged = false;
		this.reports = new ArrayList<ReportModel>();
	}
	
	
	//Getter & Setter
	public int getEntry_id() {
		return entry_id;
	}

	public void setEntry_id(int entry_id) {
		this.entry_id = entry_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getReport_count() {
		return report_count;
	}

	public void setReport_count(int report_count) {
		this.report_count = report_count;
	}

	public boolean isPinned() {
		return isPinned;
	}

	public void setPinned(boolean isPinned) {
		this.isPinned = isPinned;
	}

	public boolean isFlagged() {
		return isFlagged;
	}

	public void setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
	}

	public SubforumModel getSubforum() {
		return subforum;
	}

	public void setSubforum(SubforumModel subforum) {
		this.subforum = subforum;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public List<ReportModel> getReports() {
		return reports;
	}

	public void setReports(List<ReportModel> reports) {
		this.reports = reports;
	}

	
	//equals & hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + entry_id;
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
		EntryModel other = (EntryModel) obj;
		if (entry_id != other.entry_id)
			return false;
		return true;
	}
}
