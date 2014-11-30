package maintainmedian;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	private PriorityQueue<Integer> maxHeap, minHeap;
	Solution() {
		maxHeap = new PriorityQueue<Integer>(100, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		minHeap = new PriorityQueue<Integer>();
	}
	public void add(int num) {
		if(maxHeap.size() == 0) maxHeap.add(num);
		else {
			if (num > maxHeap.peek()) minHeap.add(num);
			else maxHeap.add(num);
			if (minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll());
			if (minHeap.size() < maxHeap.size() - 1) minHeap.add(maxHeap.poll());
		}
	}
	
	public double getMedian() {
		if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
		else return (maxHeap.peek() + minHeap.peek()) * 0.5;
	}
	
	public int getSize() {
		return minHeap.size() + maxHeap.size();
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {-3,3,1,4,5};
		for(int n : nums) {
			s.add(n);
		}
		assert(s.getMedian() == 3);
		s.add(6);
		assert(s.getMedian() == 3.5);
		s.add(-6);
		assert(s.getMedian() == 3);
		s.add(-6);
		assert(s.getMedian() == 2);
		s.add(2);
		assert(s.getMedian() == 2);
		s.add(3);
		assert(s.getMedian() == 2.5);
		s.add(100);
		assert(s.getMedian() == 3);
	}
}


