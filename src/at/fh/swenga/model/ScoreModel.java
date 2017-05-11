package at.fh.swenga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SCORE")
public class ScoreModel {

	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "level_id")
	private int level_score_id;
	
	@Column(nullable = false)
	private int top_score;
	
	
	//Relationships
	@ManyToOne
	private UserModel user;

	
	//Constructors
	public ScoreModel() {
	}
	
	//Getter & Setter
	public int getLevel_score_id() {
		return level_score_id;
	}

	public void setLevel_score_id(int level_score_id) {
		this.level_score_id = level_score_id;
	}
	
	public int getTop_score() {
		return top_score;
	}
	
	public void setTop_score(int top_score) {
		this.top_score = top_score;
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
		result = prime * result + level_score_id;
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
		ScoreModel other = (ScoreModel) obj;
		if (level_score_id != other.level_score_id)
			return false;
		return true;
	}
}
