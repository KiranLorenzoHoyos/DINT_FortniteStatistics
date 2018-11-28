package com.utad.kiran.dint_fortnitestatistics;

public class StatisticsValue {
    private StatisticsRank score;
    private StatisticsRank scorePerMatch;
    private StatisticsRank matches;
    private StatisticsRank kills;

    public StatisticsRank getScore() {
        return score;
    }

    public void setScore(StatisticsRank score) {
        this.score = score;
    }

    public StatisticsRank getScorePerMatch() {
        return scorePerMatch;
    }

    public void setScorePerMatch(StatisticsRank scorePerMatch) {
        this.scorePerMatch = scorePerMatch;
    }

    public StatisticsRank getMatches() {
        return matches;
    }

    public void setMatches(StatisticsRank matches) {
        this.matches = matches;
    }

    public StatisticsRank getKills() {
        return kills;
    }

    public void setKills(StatisticsRank kills) {
        this.kills = kills;
    }
}
