package com.utad.kiran.dint_fortnitestatistics;

public class StatisticsUser {
    private String accountId;
    private String platformId;
    private String platformName;
    private String platformNameLong;
    private String epicUserHandle;
    private StatisticsP2 stats;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformNameLong() {
        return platformNameLong;
    }

    public void setPlatformNameLong(String platformNameLong) {
        this.platformNameLong = platformNameLong;
    }

    public String getEpicUserHandle() {
        return epicUserHandle;
    }

    public void setEpicUserHandle(String epicUserHandle) {
        this.epicUserHandle = epicUserHandle;
    }

    public StatisticsP2 getStats() {
        return stats;
    }

    public void setStats(StatisticsP2 stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "StatisticsObject{" +
                "accountId='" + accountId + '\'' +
                ", platformId='" + platformId + '\'' +
                ", platformName='" + platformName + '\'' +
                ", platformNameLong='" + platformNameLong + '\'' +
                ", epicUserHandle='" + epicUserHandle + '\'' +
                ", stats=" + stats +
                '}';
    }
}
