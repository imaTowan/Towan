package at.fh.swenga.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ENTRY")
public class EntryModel {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="entry_id")
	private int entryId;
	
	@Column(nullable = false, length = 250)
	private String text;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
	private Timestamp date;
	
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
	
	public EntryModel(String text, int report_count, boolean isPinned, boolean isFlagged, Timestamp date) {
		super();
		this.text = text;
		this.report_count = report_count;
		this.isPinned = isPinned;
		this.isFlagged = isFlagged;
		this.date = date;
		this.reports = new ArrayList<ReportModel>();
	}

	public EntryModel(String text, Timestamp date) {
		super();
		this.text = text;
		this.report_count = 0;
		this.isPinned = false;
		this.isFlagged = false;
		this.date = date;
		this.reports = new ArrayList<ReportModel>();
	}
	
	
	//Getter & Setter
	public int getEntryId() {
		return entryId;
	}

	public void setEntryId(int entryId) {
		this.entryId = entryId;
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
	
	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		   Calendar calendar = Calendar.getInstance();
		    Date now = calendar.getTime();
		    Timestamp currentTimestamp = new Timestamp(now.getTime());
		    this.date = currentTimestamp;
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
		result = prime * result + entryId;
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
		if (entryId != other.entryId)
			return false;
		return true;
	}
}
