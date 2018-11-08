package google.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KthPascalRow {

	private Queue<Integer> queue = new LinkedList<>();
	private List<Integer> result = new ArrayList<>();

/*
	public List<Integer> getKthRow(int row){

		if(row<=0){
			return null;
		}
		if(row == 1){
			queue.add(1);
		}
		if(row == 2){
			queue.add(1);
			queue.add(1);
		}
		else {
			queue.add(1);
			queue.add(1);
			while(!queue.isEmpty()){
				int first = queue.remove();
				queue.add(first);
				int second = queue.remove();
				queue.add(first+second);
				if(second==1){
					queue.remove();
					queue.add(1);
				}
			}
			queue.add(1);
		}
	}
*/
}

//13
//2
//1




