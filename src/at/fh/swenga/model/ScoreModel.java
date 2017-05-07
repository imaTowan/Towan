package at.fh.swenga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SCORE")
public class ScoreModel {

	//Attributes
	@Column(nullable = false)
	private int top_score;
	
	
	//Relationships
	@Id
	@OneToOne
	@JoinColumn(name = "level_id")
	private LevelModel level;
	
	@ManyToOne
	private UserModel user;

	
	//Constructors
	public ScoreModel() {
	}

	public ScoreModel(int top_score, LevelModel level) {
		super();
		this.top_score = top_score;
		this.level = level;
	}

	
	//Getter & Setter
	public int getTop_score() {
		return top_score;
	}

	public void setTop_score(int top_score) {
		this.top_score = top_score;
	}

	public LevelModel getLevel() {
		return level;
	}

	public void setLevel(LevelModel level) {
		this.level = level;
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
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + top_score;
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
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (top_score != other.top_score)
			return false;
		return true;
	}	
}
