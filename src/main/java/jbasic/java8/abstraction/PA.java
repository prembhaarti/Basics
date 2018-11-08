package jbasic.java8.abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class PA<B,D> {
	B businessEntity;
	D decisionEntity;
	GuardRailConstraint constraint;
	Meta meta;

	public static void main(String[] args) {
		PA pa = new PA1();
		pa.setMeta(new ServiceRecoveryMeta());
	}

	public B getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(B businessEntity) {
		this.businessEntity = businessEntity;
	}

	public D getDecisionEntity() {
		return decisionEntity;
	}

	public void setDecisionEntity(D decisionEntity) {
		this.decisionEntity = decisionEntity;
	}

	public GuardRailConstraint getConstraint() {
		return constraint;
	}

	public void setConstraint(GuardRailConstraint constraint) {
		this.constraint = constraint;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}
}

enum GuardRailConstraint{
	PER_CUSTOMER_LIMIT, OVER_ALL_LIMIT,CUSTOMER_USED,
}

class PA1 extends PA{

}

class PA2 extends PA{

}

abstract class Meta{

}
class ServiceRecoveryMeta extends Meta{

}
