package models;

public class ReimbUser {
	private int reimbType;
	private double reimbAmount;
	private String reimbDescription;
	private String reimbReceipt;
	
	public ReimbUser() {
		// TODO Auto-generated constructor stub
	}

	public ReimbUser(int reimbType, double reimbAmount, String reimbDescription, String reimbReceipt) {
		super();
		this.reimbType = reimbType;
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = reimbReceipt;
	}

	public int getReimbType() {
		return reimbType;
	}

	public void setReimbType(int reimbType) {
		this.reimbType = reimbType;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public String getReimbReceipt() {
		return reimbReceipt;
	}

	public void setReimbReceipt(String reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}

	@Override
	public String toString() {
		return "ReimbUser [reimbType=" + reimbType + ", reimbAmount=" + reimbAmount + ", reimbDescription="
				+ reimbDescription + ", reimbReceipt=" + reimbReceipt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimbAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((reimbDescription == null) ? 0 : reimbDescription.hashCode());
		result = prime * result + ((reimbReceipt == null) ? 0 : reimbReceipt.hashCode());
		result = prime * result + reimbType;
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
		ReimbUser other = (ReimbUser) obj;
		if (Double.doubleToLongBits(reimbAmount) != Double.doubleToLongBits(other.reimbAmount))
			return false;
		if (reimbDescription == null) {
			if (other.reimbDescription != null)
				return false;
		} else if (!reimbDescription.equals(other.reimbDescription))
			return false;
		if (reimbReceipt == null) {
			if (other.reimbReceipt != null)
				return false;
		} else if (!reimbReceipt.equals(other.reimbReceipt))
			return false;
		if (reimbType != other.reimbType)
			return false;
		return true;
	}
	
	

}
