package org.example.Cricbuzz.ScoreUpdater;

import org.example.Cricbuzz.Inning.BallDetails;

public interface ScoreUpdaterObserver {
    public void update(BallDetails ballDetails);
}
