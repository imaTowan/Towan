package at.fh.swenga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROGRESS")
public class ProgressModel {

	//Attributes
	@Column(nullable = false)
	private int currentLevel;
	
	
	//Relationships
	@Id
	@OneToOne
	@JoinColumn(name="user_id")
	private UserModel user;
	
	
	//Constructor
	public ProgressModel() {
	}

	public ProgressModel(int currentLevel, UserModel user) {
		super();
		this.currentLevel = currentLevel;
		this.user = user;
	}

	
	//Getter & Setter
	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
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
		ProgressModel other = (ProgressModel) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
