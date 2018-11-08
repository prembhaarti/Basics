package jbasic.java8.abstraction.demo.entity;

import jbasic.java8.abstraction.demo.entity.metadata.MetaData;

public abstract class GuardRailEntity<B,D> {
	private BusinessUsecaseContext businessUsecaseContext;
	private B businessEntity;
	private D decision;
	private MetaData metaData;

	public BusinessUsecaseContext getBusinessUsecaseContext() {
		return businessUsecaseContext;
	}

	public void setBusinessUsecaseContext(BusinessUsecaseContext businessUsecaseContext) {
		this.businessUsecaseContext = businessUsecaseContext;
	}

	public D getDecision() {
		return decision;
	}

	public void setDecision(D decision) {
		this.decision = decision;
	}

	public B getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(B businessEntity) {
		this.businessEntity = businessEntity;
	}


	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

}
