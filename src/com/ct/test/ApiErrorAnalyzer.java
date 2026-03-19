package src.com.ct.test;

import java.util.HashMap;
import java.util.Map;

class ApiStat {
    int totalCount;
    int errorCount;

    double getErrorRate() {
        return (double) errorCount / totalCount;
    }
}

public class ApiErrorAnalyzer {
    private static final String ERROR_CODE = "500";

    public static void main(String[] args) {

        String[] logs = {
                "api1 200",
                "api2 500",
                "api1 200",
                "api1 500",
                "api2 200"
        };

        Map<String, ApiStat> statsMap = new HashMap<>();

        // 1. 로그 집계
        for (String log : logs) {
            String[] parts = log.split(" ");
            String apiName = parts[0];
            String statusCode = parts[1];

            statsMap.putIfAbsent(apiName, new ApiStat());

            ApiStat stat = statsMap.get(apiName);
            stat.totalCount++;

            if (ERROR_CODE.equals(statusCode)) {
                stat.errorCount++;
            }
        }

        // 2. 최대 에러율 API 찾기
        String result = "";
        double maxRate = -1;

        for (Map.Entry<String, ApiStat> entry : statsMap.entrySet()) {
            double rate = entry.getValue().getErrorRate();

            if (rate > maxRate) {
                maxRate = rate;
                result = entry.getKey();
            }
        }

        System.out.println(result);
    }
}
