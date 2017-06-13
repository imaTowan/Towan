package at.fh.swenga.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUBFORUM")
public class SubforumModel {

	//Attributes
	@Id
	@Column(name = "subforum_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subforum_id;
	
	@Column(nullable = false, length = 30)
	private String title;
	
	@Column(nullable = false)
	private boolean isPinned;
	
	
	//Relationships
	@ManyToOne
	private ForumModel forum;
	
	@OneToMany
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
	public int getSubforum_id() {
		return subforum_id;
	}

	public void setSubforum_id(int subforum_id) {
		this.subforum_id = subforum_id;
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
		result = prime * result + subforum_id;
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
		if (subforum_id != other.subforum_id)
			return false;
		return true;
	} 
}
