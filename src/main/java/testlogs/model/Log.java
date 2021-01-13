package testlogs.model;

public class Log {

	private int id;
	private int time;
	private SignType signType;
	
	public Log() {
		super();
	}
	
	public Log(Log copyLog) {
		this.id = copyLog.id;
		this.time = copyLog.time;
		this.signType = copyLog.signType;
	}

	public Log(int id, int time, SignType signType) {
		super();
		this.id = id;
		this.time = time;
		this.signType = signType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public SignType getSignType() {
		return signType;
	}

	public void setSignType(SignType signType) {
		this.signType = signType;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", time=" + time + ", signType=" + signType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((signType == null) ? 0 : signType.hashCode());
		result = prime * result + time;
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
		Log other = (Log) obj;
		if (id != other.id)
			return false;
		if (signType != other.signType)
			return false;
		if (time != other.time)
			return false;
		return true;
	}
}
