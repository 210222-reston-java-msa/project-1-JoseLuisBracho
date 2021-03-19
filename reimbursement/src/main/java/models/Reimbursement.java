package models;

import java.io.FileInputStream;
import java.sql.Blob;
import java.util.Date;

public class Reimbursement {
	
	private int reimbId;
	private double reimbAmount;
	private Date reimbSubmitted;
	private Date reimbResolved;
	private String reimbDescripton;
	private FileInputStream reimbReceipt;
	private int reimbAuthor;
	private int reimbResolver;
	private int reimbStatus;
	private int reimbType;
	
	public Reimbursement() {
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reimbId, double reimbAmount, Date reimbSubmitted, Date reimbResolved,
			String reimbDescription, FileInputStream reimbReceipt, int reimbAuthor, int reimbResolver, int reimbStatus,
			int reimbType) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescripton = reimbDescription;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}

	public Reimbursement(double reimbAmount, Date reimbSubmitted, Date reimbResolved, String reimbDescripton,
			FileInputStream reimbReceipt, int reimbAuthor, int reimbResolver, int reimbStatus, int reimbType) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescripton = reimbDescripton;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public Date getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(Date reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public Date getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(Date reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescripton() {
		return reimbDescripton;
	}

	public void setReimbDescripton(String reimbDescripton) {
		this.reimbDescripton = reimbDescripton;
	}

	public FileInputStream getReimbReceipt() {
		return reimbReceipt;
	}

	public void setReimbReceipt(FileInputStream reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}

	public int getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public int getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public int getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(int reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	public int getReimbType() {
		return reimbType;
	}

	public void setReimbType(int reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescripton=" + reimbDescripton
				+ ", reimbReceipt=" + reimbReceipt + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver
				+ ", reimbStatus=" + reimbStatus + ", reimbType=" + reimbType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimbAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbAuthor;
		result = prime * result + ((reimbDescripton == null) ? 0 : reimbDescripton.hashCode());
		result = prime * result + reimbId;
		result = prime * result + ((reimbResolved == null) ? 0 : reimbResolved.hashCode());
		result = prime * result + reimbResolver;
		result = prime * result + reimbStatus;
		result = prime * result + ((reimbSubmitted == null) ? 0 : reimbSubmitted.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(reimbAmount) != Double.doubleToLongBits(other.reimbAmount))
			return false;
		if (reimbAuthor != other.reimbAuthor)
			return false;
		if (reimbDescripton == null) {
			if (other.reimbDescripton != null)
				return false;
		} else if (!reimbDescripton.equals(other.reimbDescripton))
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (reimbResolved == null) {
			if (other.reimbResolved != null)
				return false;
		} else if (!reimbResolved.equals(other.reimbResolved))
			return false;
		if (reimbResolver != other.reimbResolver)
			return false;
		if (reimbStatus != other.reimbStatus)
			return false;
		if (reimbSubmitted == null) {
			if (other.reimbSubmitted != null)
				return false;
		} else if (!reimbSubmitted.equals(other.reimbSubmitted))
			return false;
		if (reimbType != other.reimbType)
			return false;
		return true;
	}
	
	

}

