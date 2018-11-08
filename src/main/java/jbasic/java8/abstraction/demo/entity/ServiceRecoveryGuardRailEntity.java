package jbasic.java8.abstraction.demo.entity;

import jbasic.java8.abstraction.demo.entity.metadata.ServiceRecoveryMetaData;

public class ServiceRecoveryGuardRailEntity<B,D> extends GuardRailEntity<B,D> {

	private ServiceRecoveryMetaData serviceRecoveryMetaData;

	public ServiceRecoveryMetaData getServiceRecoveryMetaData() {
		return serviceRecoveryMetaData;
	}

	public void setServiceRecoveryMetaData(ServiceRecoveryMetaData serviceRecoveryMetaData) {
		this.serviceRecoveryMetaData = serviceRecoveryMetaData;
	}
}
