package at.fh.swenga.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LEVEL")
public class LevelModel {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "level_id")
	private int level_id;
	
	@Column(nullable = true)
	private String creator;
	
	@Column(nullable = false)
	private int enemy_count;
	
	@Column(nullable = false)
	private int wave_count;
	
	@Column(nullable = false)
	private int top_score;
	
	@Column(nullable = true)
	private String top_score_user;
	
	
	//Relationships
	@OneToMany
	private List<LevelStatisticModel> level_statistics;

	
	//Constructors
	public LevelModel() {
	}

	public LevelModel(int enemy_count, int wave_count) {
		super();
		this.creator = null;
		this.enemy_count = enemy_count;
		this.wave_count = wave_count;
		this.top_score = 0;
		this.top_score_user = null;
	}

	public LevelModel(String creator, int enemy_count, int wave_count) {
		super();
		this.creator = creator;
		this.enemy_count = enemy_count;
		this.wave_count = wave_count;
		this.top_score = 0;
		this.top_score_user = null;
	}
	
	
	//Getter & Setter
	public int getLevel_id() {
		return level_id;
	}

	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}

	public int getEnemy_count() {
		return enemy_count;
	}

	public void setEnemy_count(int enemy_count) {
		this.enemy_count = enemy_count;
	}

	public int getWave_count() {
		return wave_count;
	}

	public void setWave_count(int wave_count) {
		this.wave_count = wave_count;
	}

	public List<LevelStatisticModel> getLevel_statistics() {
		return level_statistics;
	}

	public void setLevel_statistics(List<LevelStatisticModel> level_statistics) {
		this.level_statistics = level_statistics;
	}
	
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getTop_score() {
		return top_score;
	}

	public void setTop_score(int top_score) {
		this.top_score = top_score;
	}

	public String getTop_score_user() {
		return top_score_user;
	}

	public void setTop_score_user(String top_score_user) {
		this.top_score_user = top_score_user;
	}

	//equals & hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + level_id;
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
		LevelModel other = (LevelModel) obj;
		if (level_id != other.level_id)
			return false;
		return true;
	}
}
