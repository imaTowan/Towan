package at.fh.swenga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "STATISTIC")
public class StatisticModel {

	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private long user_statistic_id;
	
	@Column(nullable = false)
	private int total_enemies_slain;
	
	@Column(nullable = false)
	private int total_waves_completed;
	
	@Column(nullable = false)
	private int total_towers_built;
	
	@Column(nullable = false)
	private int playtime;
		
	
	//Constructors
	public StatisticModel() {
	}

	public StatisticModel(int total_enemies_slain, int total_waves_completed, int total_towers_built, int playtime, UserModel user) {
		super();
		this.total_enemies_slain = total_enemies_slain;
		this.total_waves_completed = total_waves_completed;
		this.total_towers_built = total_towers_built;
		this.playtime = playtime;
	}

	
	//Getter & Setter
	public long getUser_statistic_id() {
		return user_statistic_id;
	}

	public void setUser_statistic_id(long user_statistic_id) {
		this.user_statistic_id = user_statistic_id;
	}
	
	public int getTotal_enemies_slain() {
		return total_enemies_slain;
	}

	public void setTotal_enemies_slain(int total_enemies_slain) {
		this.total_enemies_slain = total_enemies_slain;
	}

	public int getTotal_waves_completed() {
		return total_waves_completed;
	}

	public void setTotal_waves_completed(int total_waves_completed) {
		this.total_waves_completed = total_waves_completed;
	}

	public int getTotal_towers_built() {
		return total_towers_built;
	}

	public void setTotal_towers_built(int total_towers_built) {
		this.total_towers_built = total_towers_built;
	}

	public int getPlaytime() {
		return playtime;
	}

	public void setPlaytime(int playtime) {
		this.playtime = playtime;
	}

	
	//equals & hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (user_statistic_id ^ (user_statistic_id >>> 32));
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
		StatisticModel other = (StatisticModel) obj;
		if (user_statistic_id != other.user_statistic_id)
			return false;
		return true;
	}
}
