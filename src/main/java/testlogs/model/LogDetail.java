package testlogs.model;

public class LogDetail {

	private final int id;
	private final Log signIn;
	private final Log signOut;
	private final int deltaTime;
	

	public LogDetail(int id, Log signIn, Log signOut) {
		super();
		this.id = id;
		this.signIn = new Log(signIn);
		this.signOut = new Log(signOut);
		this.deltaTime = calculateDeltaTime();
	}

	private int calculateDeltaTime() {
		return this.signOut.getTime() - this.signIn.getTime();
	}

	public int getId() {
		return id;
	}


	public Log getSingIn() {
		return signIn;
	}

	public Log getSignOut() {
		return signOut;
	}


	public int getDeltaTime() {
		return deltaTime;
	}

	@Override
	public String toString() {
		return "LogDetail [id=" + id + ", singIn=" + signIn + ", signOut=" + signOut + ", deltaTime=" + deltaTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deltaTime;
		result = prime * result + id;
		result = prime * result + ((signOut == null) ? 0 : signOut.hashCode());
		result = prime * result + ((signIn == null) ? 0 : signIn.hashCode());
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
		LogDetail other = (LogDetail) obj;
		if (deltaTime != other.deltaTime)
			return false;
		if (id != other.id)
			return false;
		if (signOut == null) {
			if (other.signOut != null)
				return false;
		} else if (!signOut.equals(other.signOut))
			return false;
		if (signIn == null) {
			if (other.signIn != null)
				return false;
		} else if (!signIn.equals(other.signIn))
			return false;
		return true;
	}
}
