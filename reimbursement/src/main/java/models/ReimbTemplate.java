package models;

public class ReimbTemplate {
	
	private int reimbId;
	private int reimbStatus;
	private String reimbDescription;
	
	public ReimbTemplate() {
		// TODO Auto-generated constructor stub
	}

	public ReimbTemplate(int reimbId, int reimbStatus, String reimbDescription) {
		super();
		this.reimbId = reimbId;
		this.reimbStatus = reimbStatus;
		this.reimbDescription = reimbDescription;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public int getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(int reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	@Override
	public String toString() {
		return "ReimbTemplate [reimbId=" + reimbId + ", reimbStatus=" + reimbStatus + ", reimbDescription="
				+ reimbDescription + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimbDescription == null) ? 0 : reimbDescription.hashCode());
		result = prime * result + reimbId;
		result = prime * result + reimbStatus;
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
		ReimbTemplate other = (ReimbTemplate) obj;
		if (reimbDescription == null) {
			if (other.reimbDescription != null)
				return false;
		} else if (!reimbDescription.equals(other.reimbDescription))
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (reimbStatus != other.reimbStatus)
			return false;
		return true;
	}
	
	


}
