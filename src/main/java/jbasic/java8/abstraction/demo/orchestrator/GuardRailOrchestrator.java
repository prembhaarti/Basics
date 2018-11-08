package jbasic.java8.abstraction.demo.orchestrator;

import jbasic.java8.abstraction.demo.entity.GuardRailEntity;

public class GuardRailOrchestrator<B,D> {

//	private G input;
//	private D output;



	public D orchestrate(GuardRailEntity<B,D> input){
		System.out.println(input.getBusinessUsecaseContext());

		return null;
	}



}
