package at.fh.swenga.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserModel implements java.io.Serializable {

	// Attributes
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "userId")
	private long userId;
	
	@Column(nullable = false, length = 15)
	private String username;
	
	@Column(nullable = false, length = 200)
	private String password;
	
	@Column(nullable = false, length = 30)
	private String email_address;
	
	@Column(nullable = true, length = 100)
	private String signature;
	
	@Column(nullable = true, length = 50)
	private String profile_picture;
	
	@Column(nullable = false)
	private boolean isBlocked;
	
	@Column(nullable = false)
	private boolean isHidden;
	
	@Column(nullable = false)
	private boolean isActivated;
	
	@Column(nullable = false)
	private int total_enemies_slain;
	
	@Column(nullable = false)
	private int total_waves_completed;
	
	@Column(nullable = false)
	private int total_towers_built;
	
	@Column(nullable = false)
	private int playtime;
	
	


	
	//Relationships
	@ManyToMany
	private List<LevelModel> level_statistics;
	
	@OneToMany
	private List<EntryModel> entries;
	
	@OneToMany
	private List<ReportModel> reports;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRoleModel> userRole = new HashSet<UserRoleModel>(0);
	
	
	//Constructor
	public UserModel() {
	}

	public UserModel(String username, String password, String email_address) {
		super();
		this.username = username;
		this.password = password;
		this.email_address = email_address;
		this.signature = null;
		this.profile_picture = null;
		this.isBlocked = false;
		this.isHidden = false;
		this.isActivated = false;
		this.total_enemies_slain = 0;
		this.total_waves_completed = 0;
		this.total_towers_built = 0;
		this.playtime = 0;
	}
	
	public UserModel(String username, String password, String email_address, boolean isBlocked, boolean isHidden, boolean isActivated, int currentLevel,
			int total_enemies_slain, int total_waves_completed, int total_towers_built, int playtime) {
		super();
		this.username = username;
		this.password = password;
		this.email_address = email_address;
		this.signature = null;
		this.profile_picture = null;
		this.isBlocked = isBlocked;
		this.isHidden = isHidden;
		this.isActivated = isActivated;
		this.total_enemies_slain = total_enemies_slain;
		this.total_waves_completed = total_waves_completed;
		this.total_towers_built = total_towers_built;
		this.playtime = playtime;
	}

	public UserModel(String username, String password, String email_address, String signature, String profile_picture,
			boolean isBlocked, boolean isHidden, boolean isActivated , int currentLevel,
			int total_enemies_slain, int total_waves_completed, int total_towers_built, int playtime) {
		super();
		level_statistics = new ArrayList<LevelModel>();
		this.username = username;
		this.password = password;
		this.email_address = email_address;
		this.signature = signature;
		this.profile_picture = profile_picture;
		this.isBlocked = isBlocked;
		this.isHidden = isHidden;
		this.isActivated = isActivated;
		this.total_enemies_slain = total_enemies_slain;
		this.total_waves_completed = total_waves_completed;
		this.total_towers_built = total_towers_built;
		this.playtime = playtime;
	}

	
	//Getter & Setter
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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
	
	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public List<LevelModel> getLevel_statistics() {
		return level_statistics;
	}

	public void setLevel_statistics(List<LevelModel> level_statistics) {
		this.level_statistics = level_statistics;
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
	
	public Set<UserRoleModel> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRoleModel> userRole) {
		this.userRole = userRole;
	}

	
	//equals & hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email_address == null) ? 0 : email_address.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
