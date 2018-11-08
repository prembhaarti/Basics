package basics.dp;

import java.util.*;
import java.util.stream.Collectors;

public class MaximumSubSquareWithSideX {

	/*public static void main(String[] args) {
		List<String> names = Arrays.asList("a","b","c");
		List<String> filtered=names.stream().filter(name-> name.equalsIgnoreCase("d"))
				.collect(Collectors.toList());
		System.out.println(filtered);
		if(filtered==null){
			System.out.println("null");
		}
	}*/

	public static void main(String[] args) {
		List<Double> txns = new ArrayList<>();
		txns.add(150.0);
		txns.add(150.0);
		txns.add(150.0);

		printDistributedTransactions(60, txns );

	}

	/**
	 * double updatedTxnValue = Math.min(leftValue, transaction.getValue());
	 updateTransaction(transaction, updatedTxnValue, clientEntity);
	 leftValue = Math.max(leftValue - transaction.getValue(), 0); //don't want to update left value as -ve
	 * @param totalValue
	 * @param transactions
	 */

	public static void printDistributedTransactions(double totalValue, List<Double> transactions){
		int txnCount = 1;
		double leftValue = totalValue;
		int noOfTxn = transactions.size();
		for(Double transaction : transactions) {

			if (txnCount == noOfTxn) { //last transaction will get all left value
				System.out.println(leftValue);
			}
			else {
				double updatedTxnValue = Math.min(leftValue, transaction);
				System.out.println(updatedTxnValue);
				leftValue = Math.max(leftValue - transaction, 0);
			}
			txnCount += 1;
		}
	}



}
