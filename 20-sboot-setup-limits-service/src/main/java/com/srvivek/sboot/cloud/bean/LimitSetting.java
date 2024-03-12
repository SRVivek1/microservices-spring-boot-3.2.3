package com.srvivek.sboot.cloud.bean;

import java.util.Objects;

public class LimitSetting {

	private Integer max;
	private Integer min;
	private String common;

	public LimitSetting() {
	}

	/**
	 * @param max
	 * @param min
	 */
	public LimitSetting(Integer max, Integer min, String common) {
		super();
		this.max = max;
		this.min = min;
		this.common = common;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

	@Override
	public int hashCode() {
		return Objects.hash(common, max, min);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LimitSetting other = (LimitSetting) obj;
		return Objects.equals(common, other.common) && Objects.equals(max, other.max) && Objects.equals(min, other.min);
	}
}
