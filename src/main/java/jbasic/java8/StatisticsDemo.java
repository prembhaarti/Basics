package jbasic.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StatisticsDemo {
	public static void main(String[] args) {

		List<Integer> ages= Arrays.asList(22,23,24,25,26);
		List<Double> agesD= Arrays.asList(22.0,23.0,24.0,25.0,26.0);


		IntSummaryStatistics agesStats=ages.stream()
				.collect(IntSummaryStatistics::new,IntSummaryStatistics::accept,IntSummaryStatistics::combine);
//		ages.stream().collect(Collectors.summarizingInt(Mr B))

		System.out.println("**"+agesD.stream().max(Double::compare).get());

		System.out.println(agesStats.getAverage());

		System.out.println("---DoubleSummaryStatistics---");
		DoubleSummaryStatistics dstats = DoubleStream.of(5.33d, 2.34d, 5.32d, 2.31d, 3.51d).
				collect(DoubleSummaryStatistics::new, DoubleSummaryStatistics::accept,
						DoubleSummaryStatistics::combine);
		System.out.println("Max:" + dstats.getMax() + ", Min:" + dstats.getMin());
		System.out.println("Count:" + dstats.getCount() + ", Sum:" + dstats.getSum());
		System.out.println("Average:" + dstats.getAverage());

		System.out.println("---LongSummaryStatistics---");
		LongSummaryStatistics lstats = LongStream.of(51l, 23l, 53l, 23l, 35l).
				collect(LongSummaryStatistics::new, LongSummaryStatistics::accept, LongSummaryStatistics::combine);
		System.out.println("Max:" + lstats.getMax() + ", Min:" + lstats.getMin());
		System.out.println("Count:" + lstats.getCount() + ", Sum:" + lstats.getSum());
		System.out.println("Average:" + lstats.getAverage());

		System.out.println("---IntSummaryStatistics---");
		IntSummaryStatistics istats = IntStream.of(51, 22, 50, 27, 35).
				collect(IntSummaryStatistics::new, IntSummaryStatistics::accept, IntSummaryStatistics::combine);
		System.out.println("Max:" + istats.getMax() + ", Min:" + istats.getMin());
		System.out.println("Count:" + istats.getCount() + ", Sum:" + istats.getSum());
		System.out.println("Average:" + istats.getAverage());
	}
}

