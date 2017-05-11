package at.fh.swenga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LEVEL_STATISTIC")
public class LevelStatisticModel {

	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private long user_level_statistic_id;
	
	@Column(nullable = false)
	private int enemies_slain;
	
	@Column(nullable = false)
	private int waves_completed;
	
	@Column(nullable = false)
	private int towers_built;
	
	
	//Relationships
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
	}

	
	//Getter & Setter
	public long getUser_level_statistic_id() {
		return user_level_statistic_id;
	}

	public void setUser_level_statistic_id(long user_level_statistic_id) {
		this.user_level_statistic_id = user_level_statistic_id;
	}

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
		result = prime * result + (int) (user_level_statistic_id ^ (user_level_statistic_id >>> 32));
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
		if (user_level_statistic_id != other.user_level_statistic_id)
			return false;
		return true;
	}	
}
