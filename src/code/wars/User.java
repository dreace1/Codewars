package code.wars;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * <a href="https://www.codewars.com/kata/51fda2d95d6efda45e00004e/train/java">
 * Ranking System </a>
 *
 * @author rosen
 *
 */

public class User {
	private int rank;
	private int progress;
	private List<Integer> ranks;

	public User() {
		rank = -8;
		ranks = initializeArrayListWithRanks();
	}

	private ArrayList<Integer> initializeArrayListWithRanks() {
		final ArrayList<Integer> rankList = new ArrayList<>();
		for (int i = -8; i <= 8; i++) {
			if (i == 0) {
				continue;
			}

			rankList.add(i);
		}
		return rankList;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public List<Integer> getRanks() {
		return ranks;
	}

	public void setRanks(List<Integer> ranks) {
		this.ranks = ranks;
	}

	public void incProgress(int activityRank) {
		final int MINRANK = -8;
		final int MAXRANK = 8;

		if (activityRank < MINRANK || activityRank > MAXRANK || activityRank == 0) {
			throw new IllegalArgumentException();
		}

		try {
			progress += activity(activityRank);
			if (progress >= 100 && rank <= 8) {
				rank = ranks.get(ranks.indexOf(rank) + progress / 100);
				progress = progress % 100;

			}

			if (rank >= 8) {
				progress = 0;
			}

		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	public int activity(int activityRank) {
		int progressValue = 0;

		if (rank == activityRank) {

			progressValue = 3;
		} else if (ranks.indexOf(activityRank) == ranks.indexOf(rank) - 1) {

			progressValue = 1;
		} else if (ranks.indexOf(activityRank) > ranks.indexOf(rank)) {

			final int diff = ranks.indexOf(activityRank) - ranks.indexOf(rank);
			progressValue = 10 * (diff) * (diff);
		}
		return progressValue;
	}
}
