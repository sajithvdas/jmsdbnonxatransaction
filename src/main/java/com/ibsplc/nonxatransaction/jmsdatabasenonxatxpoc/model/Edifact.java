package com.ibsplc.nonxatransaction.jmsdatabasenonxatxpoc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "edifact")
public class Edifact {

	@Id
	@Column(name = "PNR_NO", nullable = false)
	private String pnr;

	@Column(name = "EDIFACT_RAWDATA", nullable = false)
	private String edifactRaw;

	@Column(name = "EDIFACT_JSON", nullable = false)
	private String eifactJson;

	@Column(name = "POLL_STATUS", nullable = false)
	private long pollStatus;

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getEdifactRaw() {
		return edifactRaw;
	}

	public void setEdifactRaw(String edifactRaw) {
		this.edifactRaw = edifactRaw;
	}

	public String getEifactJson() {
		return eifactJson;
	}

	public void setEifactJson(String eifactJson) {
		this.eifactJson = eifactJson;
	}

	public long getPollStatus() {
		return pollStatus;
	}

	public void setPollStatus(long pollStatus) {
		this.pollStatus = pollStatus;
	}

}
