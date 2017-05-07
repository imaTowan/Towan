package at.fh.swenga.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "STATISTIC")
public class StatisticModel {

	//Attributes
	@Column(nullable = false)
	private int total_enemies_slain;
	
	@Column(nullable = false)
	private int total_waves_completed;
	
	@Column(nullable = false)
	private int total_towers_built;
	
	@Temporal(TemporalType.TIME)
	private Time playtime;
	
	
	//Relationships
	@Id
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserModel user;
	
	
	//Constructors
	public StatisticModel() {
	}

	public StatisticModel(int total_enemies_slain, int total_waves_completed, int total_towers_built, Time playtime, UserModel user) {
		super();
		this.total_enemies_slain = total_enemies_slain;
		this.total_waves_completed = total_waves_completed;
		this.total_towers_built = total_towers_built;
		this.playtime = playtime;
		this.user = user;
	}

	
	//Getter & Setter
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

	public Time getPlaytime() {
		return playtime;
	}

	public void setPlaytime(Time playtime) {
		this.playtime = playtime;
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
		StatisticModel other = (StatisticModel) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}	
}
