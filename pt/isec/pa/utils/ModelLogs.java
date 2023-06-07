package pt.isec.pa.utils;

import java.util.ArrayList;

public class ModelLogs {
    private static ModelLogs instance = null;

    public static ModelLogs getInstance() {
        if(instance == null)
            instance = new ModelLogs();
        return instance;
    }

    private ArrayList<String> logs;

    private ModelLogs(){logs = new ArrayList<>();}

    public void addLog(String log){logs.add(log);}
    public String getLogs(){
        StringBuilder sb = new StringBuilder();

        for (var log: logs) {
            sb.append(log);
        }
        return sb.toString();
    }
    public void removeAllLogs(){logs.clear();}
}
