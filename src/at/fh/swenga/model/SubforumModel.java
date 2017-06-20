package at.fh.swenga.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "SUBFORUM")
public class SubforumModel {

	//Attributes
	@Id
	@Column(name = "subforum_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subforumId;
	
	@Column(nullable = false, length = 30)
	private String title;
	
	@Column(nullable = false)
	private boolean isPinned;
	
	
	//Relationships
	@ManyToOne
	private ForumModel forum;
	
	
	@OneToMany(mappedBy="subforum",fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<EntryModel> entries;
	
	
	//Constructors
	public SubforumModel() {
	}

	public SubforumModel(String title, boolean isPinned) {
		super();
		this.title = title;
		this.isPinned = isPinned;
	}

	
	//Getter & Setter
	public int getSubforumId() {
		return subforumId;
	}

	public void setSubforumId(int subforumId) {
		this.subforumId = subforumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isPinned() {
		return isPinned;
	}

	public void setPinned(boolean isPinned) {
		this.isPinned = isPinned;
	}

	public ForumModel getForum() {
		return forum;
	}

	public void setForum(ForumModel forum) {
		this.forum = forum;
	}

	public List<EntryModel> getEntries() {
		return entries;
	}

	public void setEntries(List<EntryModel> entries) {
		this.entries = entries;
	}

	
	//equals & hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + subforumId;
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
		SubforumModel other = (SubforumModel) obj;
		if (subforumId != other.subforumId)
			return false;
		return true;
	} 
}
