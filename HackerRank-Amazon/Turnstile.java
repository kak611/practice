// https://leetcode.com/discuss/interview-question/699973/

import java.util.*;

class Turnstile {
	public static void main(String[] args) {
		int[] time = {0,0,1,5};
		int[] direction = {0,1,1,0};

		int[] result = getTimes(time, direction);
		System.out.println(Arrays.toString(result));
	}

	/*
		1. create two PQ based on exit(1) direction or enter(0) direction
		2. Apply the conditions and get the result
	*/
	public static int[] getTimes(int[] time, int[] direction) {
		PriorityQueue<Visitor> exit_pq = new PriorityQueue<>(new TimeIndexComparator());
		PriorityQueue<Visitor> enter_pq = new PriorityQueue<>(new TimeIndexComparator());

		for (int i = 0; i < time.length; i++) {
			if (direction[i] == 1) {
				exit_pq.add(new Visitor(time[i], i));
			} else {
				enter_pq.add(new Visitor(time[i], i));
			}
		}

		int[] res = new int[time.length];
		Status s = Status.NotUsed;
		int t = 0;
		while (!(enter_pq.isEmpty() && exit_pq.isEmpty())) {
			if (!enter_pq.isEmpty() && enter_pq.peek().time == t 
				&& !exit_pq.isEmpty() && exit_pq.peek().time == t
				&& (s == Status.NotUsed || s == Status.UsedExit)) {
				Visitor v = exit_pq.poll();
				res[v.index] = v.time;
				s = Status.UsedExit;			
			} else if (s == Status.UsedEnter && !enter_pq.isEmpty()
				&& enter_pq.peek().time == t && !exit_pq.isEmpty()
				&& exit_pq.peek().time == t) {
				Visitor v = enter_pq.poll();
				res[v.index] = t;
				s = Status.UsedEnter;
			} else if (!exit_pq.isEmpty() && exit_pq.peek().time <= t) {
				Visitor v = exit_pq.poll();
				res[v.index] = t;
				s = Status.UsedExit;
			} else if (!enter_pq.isEmpty() && enter_pq.peek().time <= t) {
				Visitor v = enter_pq.poll();
				res[v.index] = t;
				s = Status.UsedEnter;
			} else {
				s = Status.NotUsed;
			}
			t++;
		}

		return res;
	}

	public static class TimeIndexComparator implements Comparator<Visitor> {
		public int compare(Visitor v1, Visitor v2) {
			if (v1.time == v2.time) {
				return (v1.index - v2.index);
			}

			return Integer.compare(v1.time, v2.time);
		}
	}

	static enum Status {NotUsed, UsedExit, UsedEnter};

	static class Visitor {
		int time;
		int index;

		public Visitor(int time, int index) {
			this.time = time;
			this.index = index;
		}

		public String toString() {
			return this.time + ", " + this.index;
		}
	}
}