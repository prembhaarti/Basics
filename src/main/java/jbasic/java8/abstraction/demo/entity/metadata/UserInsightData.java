package jbasic.java8.abstraction.demo.entity.metadata;



public class UserInsightData {

	private Long frequencyBucket;
	private Long monetaryBucket;
	private Long recencyBucket;
	private String accountId;
	private String abBucket;

	public Long getFrequencyBucket() {
		return frequencyBucket;
	}

	public void setFrequencyBucket(Long frequencyBucket) {
		this.frequencyBucket = frequencyBucket;
	}

	public Long getMonetaryBucket() {
		return monetaryBucket;
	}

	public void setMonetaryBucket(Long monetaryBucket) {
		this.monetaryBucket = monetaryBucket;
	}

	public Long getRecencyBucket() {
		return recencyBucket;
	}

	public void setRecencyBucket(Long recencyBucket) {
		this.recencyBucket = recencyBucket;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAbBucket() {
		return abBucket;
	}

	public void setAbBucket(String abBucket) {
		this.abBucket = abBucket;
	}
}
