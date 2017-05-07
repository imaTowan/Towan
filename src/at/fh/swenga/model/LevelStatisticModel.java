package at.fh.swenga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LEVEL_STATISTIC")
public class LevelStatisticModel {

	//Attributes
	@Column(nullable = false)
	private int enemies_slain;
	
	@Column(nullable = false)
	private int waves_completed;
	
	@Column(nullable = false)
	private int towers_built;
	
	
	//Relationships
	@Id
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserModel user;

	@ManyToOne
	private LevelModel level;

	//Constructors
	public LevelStatisticModel() {
	}

	public LevelStatisticModel(int enemies_slain, int waves_completed, int towers_built, UserModel user) {
		super();
		this.enemies_slain = enemies_slain;
		this.waves_completed = waves_completed;
		this.towers_built = towers_built;
		this.user = user;
	}

	public LevelStatisticModel(int enemies_slain, int waves_completed, int towers_built, UserModel user, LevelModel level) {
		super();
		this.enemies_slain = enemies_slain;
		this.waves_completed = waves_completed;
		this.towers_built = towers_built;
		this.user = user;
		this.level = level;
	}

	
	//Getter & Setter
	public int getEnemies_slain() {
		return enemies_slain;
	}

	public void setEnemies_slain(int enemies_slain) {
		this.enemies_slain = enemies_slain;
	}

	public int getWaves_completed() {
		return waves_completed;
	}

	public void setWaves_completed(int waves_completed) {
		this.waves_completed = waves_completed;
	}

	public int getTowers_built() {
		return towers_built;
	}

	public void setTowers_built(int towers_built) {
		this.towers_built = towers_built;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public LevelModel getLevel() {
		return level;
	}

	public void setLevel(LevelModel level) {
		this.level = level;
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
		LevelStatisticModel other = (LevelStatisticModel) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
