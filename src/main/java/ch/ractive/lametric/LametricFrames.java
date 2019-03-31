package ch.ractive.lametric;

import lombok.Value;

import java.util.Collections;
import java.util.List;

@Value
public class LametricFrames {
	public static LametricFrames errorFrames(String s) {
		return singleFrame("a4786", s);
	}

	public static LametricFrames singleFrame(String icon, String s) {
		return new LametricFrames(Collections.singletonList(
			new SimpleFrame(icon, s)
		));
	}
	
	public interface Frame {
	}

	@Value
	public static class SimpleFrame implements Frame {
		private String icon;
		private String text;
	}

	@Value
	public static class GoalFrame implements Frame {
		@Value
		public static class GoalData {
			private int start;
			private int current;
			private int end;
			private String unit;
		}

		private String icon;
		private GoalData goalData;
	}

	@Value
	public static class SpikeChartFrame implements Frame {
		private List<Integer> chartData;
	}

	private List<Frame> frames;
}
