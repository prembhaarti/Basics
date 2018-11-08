package jbasic.java8.abstraction.demo.entity.metadata;



public class ServiceRecoveryMetaData extends MetaData{

	private UserInsightData getUserInsightData;
	private Double toaAmount;
	private Double customerSpentAmout;
	private Double globalCustomerSpentAmount;
	private Double toaAmountAllowedPerCustomer;
	private Double globalToaAmountThreshold;

	public UserInsightData getGetUserInsightData() {
		return getUserInsightData;
	}

	public void setGetUserInsightData(UserInsightData getUserInsightData) {
		this.getUserInsightData = getUserInsightData;
	}

	public Double getToaAmount() {
		return toaAmount;
	}

	public void setToaAmount(Double toaAmount) {
		this.toaAmount = toaAmount;
	}

	public Double getCustomerSpentAmout() {
		return customerSpentAmout;
	}

	public void setCustomerSpentAmout(Double customerSpentAmout) {
		this.customerSpentAmout = customerSpentAmout;
	}

	public Double getGlobalCustomerSpentAmount() {
		return globalCustomerSpentAmount;
	}

	public void setGlobalCustomerSpentAmount(Double globalCustomerSpentAmount) {
		this.globalCustomerSpentAmount = globalCustomerSpentAmount;
	}

	public Double getToaAmountAllowedPerCustomer() {
		return toaAmountAllowedPerCustomer;
	}

	public void setToaAmountAllowedPerCustomer(Double toaAmountAllowedPerCustomer) {
		this.toaAmountAllowedPerCustomer = toaAmountAllowedPerCustomer;
	}

	public Double getGlobalToaAmountThreshold() {
		return globalToaAmountThreshold;
	}

	public void setGlobalToaAmountThreshold(Double globalToaAmountThreshold) {
		this.globalToaAmountThreshold = globalToaAmountThreshold;
	}
}
