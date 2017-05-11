package at.fh.swenga.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "LEVEL")
public class LevelModel {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "level_id")
	private int level_id;
	
	@Column(nullable = false)
	private int enemy_count;
	
	@Column(nullable = false)
	private int wave_count;
	
	
	//Relationships
	@OneToMany
	private List<LevelStatisticModel> level_statistics;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
	@JoinColumn(name="level_score_id", insertable=false, updatable=false)
	private ScoreModel score;

	
	//Constructors
	public LevelModel() {
		score = new ScoreModel();
	}

	public LevelModel(int enemy_count, int wave_count) {
		super();
		score = new ScoreModel();
		this.enemy_count = enemy_count;
		this.wave_count = wave_count;
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

	public ScoreModel getScore() {
		return score;
	}

	public void setScore(ScoreModel score) {
		this.score = score;
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
	
	
	//Methods
	@PrePersist
	public void initializeScore() {
		this.score.setLevel_score_id(level_id);
	}
}
