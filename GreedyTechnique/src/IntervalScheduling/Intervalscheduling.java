package IntervalScheduling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Intervalscheduling {

	/**
	 * Approach
	 * 
	 * sort by finish time
	 * choose the earliest finish point
	 * make sure intervals don't conflict
	 * 
	 */
	public static void main(String[] args) {
		int[][] intervals = { {0, 3 }, { 0, 15 }, { 5, 10 }, { 7, 12 }, { 11, 16 }, { 12, 14 }, { 16, 20 }};
		List<int[]> optimalSchedule = schedule(intervals);
		for(int[] interval : optimalSchedule)
		{
			for(int i=0 ; i<interval.length; i++)
			{
				System.out.print(interval[i]+" ");
			}
			System.out.println();
		}
	}

	private static List<int[]> schedule(int[][] intervals) {
		List<int[]> optimalIntervalSet = new ArrayList<>();
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int lastFinishTime = Integer.MIN_VALUE;
		for (int[] interval : intervals) {
			int start = interval[0];
			if (start > lastFinishTime) {
				optimalIntervalSet.add(interval);
				lastFinishTime = interval[1];
			}
		}
		return optimalIntervalSet;
	}

}
