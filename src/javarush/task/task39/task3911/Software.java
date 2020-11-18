package javarush.task.task39.task3911;

import javarush.task.task33.task3310.strategy.Entry;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if (!versionHistoryMap.containsKey(rollbackVersion)) return false;
        if (currentVersion < rollbackVersion) return false;

        Set<Integer> deletes = new HashSet<>();
        for (Integer version : versionHistoryMap.keySet()){
            if (version > rollbackVersion) deletes.add(version);
        }

        for (Integer version : deletes){
            versionHistoryMap.remove(version);
        }
        currentVersion = rollbackVersion;
        return true;
    }
}