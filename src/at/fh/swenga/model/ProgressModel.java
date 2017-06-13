package at.fh.swenga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROGRESS")
public class ProgressModel {

	//Attributes
	@Id
	@Column(name="user_id")
	private long user_progress_id;
	
	@Column(nullable = false)
	private int currentLevel;
	
	
	//Constructor
	public ProgressModel() {
	}

	
	//Getter & Setter
	public long getUser_progress_id() {
		return user_progress_id;
	}

	public void setUser_progress_id(long user_progress_id) {
		this.user_progress_id = user_progress_id;
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	
	//equals & hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (user_progress_id ^ (user_progress_id >>> 32));
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
		if (user_progress_id != other.user_progress_id)
			return false;
		return true;
	}
}
