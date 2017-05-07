package at.fh.swenga.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserModel {

	// Attributes
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	
	@Column(nullable = false, length = 15)
	private String username;
	
	@Column(nullable = false, length = 50)
	private String password;
	
	@Column(nullable = false, length = 30)
	private String email_address;
	
	@Column(nullable = true, length = 100)
	private String signature;
	
	@Column(nullable = true, length = 30)
	private String profile_picture;
	
	@Column(nullable = false)
	private boolean isBlocked;
	
	@Column(nullable = false)
	private boolean isHidden;
	
	
	//Relationships
	@OneToOne
	private ProgressModel progress;
	
	@OneToOne
	private StatisticModel statistic;
	
	@OneToMany
	private List<LevelStatisticModel> level_statistics;
	
	@OneToMany
	private List<ScoreModel> scores;
	
	@OneToMany
	private List<EntryModel> entries;
	
	@OneToMany
	private List<ReportModel> reports;
	
	
	//Constructor
	public UserModel() {
	}

	public UserModel(String username, String password, String email_address, boolean isBlocked, boolean isHidden) {
		super();
		this.username = username;
		this.password = password;
		this.email_address = email_address;
		this.isBlocked = isBlocked;
		this.isHidden = isHidden;
	}

	public UserModel(String username, String password, String email_address, String signature, String profile_picture,
			boolean isBlocked, boolean isHidden) {
		super();
		this.username = username;
		this.password = password;
		this.email_address = email_address;
		this.signature = signature;
		this.profile_picture = profile_picture;
		this.isBlocked = isBlocked;
		this.isHidden = isHidden;
	}

	
	//Getter & Setter
	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getProfile_picture() {
		return profile_picture;
	}

	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}
	
	public ProgressModel getProgress() {
		return progress;
	}

	public void setProgress(ProgressModel progress) {
		this.progress = progress;
	}

	public StatisticModel getStatistic() {
		return statistic;
	}

	public void setStatistic(StatisticModel statistic) {
		this.statistic = statistic;
	}

	public List<LevelStatisticModel> getLevel_statistics() {
		return level_statistics;
	}

	public void setLevel_statistics(List<LevelStatisticModel> level_statistics) {
		this.level_statistics = level_statistics;
	}

	public List<ScoreModel> getScores() {
		return scores;
	}

	public void setScores(List<ScoreModel> scores) {
		this.scores = scores;
	}

	public List<EntryModel> getEntries() {
		return entries;
	}

	public void setEntries(List<EntryModel> entries) {
		this.entries = entries;
	}

	public List<ReportModel> getReports() {
		return reports;
	}

	public void setReports(List<ReportModel> reports) {
		this.reports = reports;
	}

	
	//equals & hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email_address == null) ? 0 : email_address.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UserModel other = (UserModel) obj;
		if (email_address == null) {
			if (other.email_address != null)
				return false;
		} else if (!email_address.equals(other.email_address))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (user_id != other.user_id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
