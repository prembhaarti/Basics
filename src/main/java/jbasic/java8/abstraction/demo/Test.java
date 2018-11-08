package jbasic.java8.abstraction.demo;

import jbasic.java8.abstraction.demo.entity.BusinessUsecaseContext;
import jbasic.java8.abstraction.demo.entity.ServiceRecoveryGuardRailEntity;
import jbasic.java8.abstraction.demo.entity.metadata.ServiceRecoveryMetaData;
import jbasic.java8.abstraction.demo.orchestrator.GuardRailOrchestrator;

import javax.xml.ws.Service;

public class Test {

	public static void main(String[] args) {

		ServiceRecoveryGuardRailEntity guardRailEntity= new ServiceRecoveryGuardRailEntity();
		guardRailEntity.setBusinessUsecaseContext(BusinessUsecaseContext.SERVICE_RECOVERY);
		ServiceRecoveryMetaData metaData = new ServiceRecoveryMetaData();
		metaData.setCustomerSpentAmout(100.0);
		guardRailEntity.setMetaData(metaData);

		GuardRailOrchestrator orchestrator= new GuardRailOrchestrator();
		orchestrator.orchestrate(guardRailEntity);
		ServiceRecoveryMetaData metaData1=(ServiceRecoveryMetaData)guardRailEntity.getMetaData();
		System.out.println(metaData1.getCustomerSpentAmout());


	}
}
