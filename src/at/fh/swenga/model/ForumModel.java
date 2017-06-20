package at.fh.swenga.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "FORUM")
public class ForumModel {

	//Attributes
	@Id
	@Column(name = "forum_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int forumId;
	
	@Column(nullable = false, length = 30)
	private String name;
	
	
	//Relationships
	@OneToMany(mappedBy="forum", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<SubforumModel> subforums;

	
	//Constructors
	public ForumModel() {
	}

	public ForumModel(String name) {
		super();
		this.name = name;
	}

	
	//Getter & Setter
	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SubforumModel> getSubforums() {
		return subforums;
	}

	public void setSubforums(List<SubforumModel> subforums) {
		this.subforums = subforums;
	}

	
	//equals & hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + forumId;
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
		ForumModel other = (ForumModel) obj;
		if (forumId != other.forumId)
			return false;
		return true;
	}
	
	
	
}
