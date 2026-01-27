package ScoreUpdator;

import Innings.BallDetails;

public interface ScoreUpdaterObserver {
    public void update(BallDetails ballDetails);
}
