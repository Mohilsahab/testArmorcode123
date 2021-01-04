package src.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public static void main(String[] args) {
        List<String> list = new BinaryWatch().readBinaryWatch(2);
        System.out.println(list);
    }

//    [0:03, 0:05, 0:06, 0:09, 0:10, 0:12, 0:17, 0:18, 0:20, 0:24, 0:33, 0:34, 0:36, 0:40, 0:48, 1:01, 1:02, 1:04, 1:08, 1:16, 1:32, 2:01, 2:02, 2:04, 2:08, 2:16, 2:32, 3:00, 4:01, 4:02, 4:04, 4:08, 4:16, 4:32, 5:00, 6:00, 8:01, 8:02, 8:04, 8:08, 8:16, 8:32, 9:00, 10:00]
//    ["0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"]
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int hours=0; hours<12; hours++) {
            for (int mins = 0; mins<60; mins++) {
                if (Integer.bitCount(hours) + Integer.bitCount(mins) == num) {
                    if (mins<10) {
                        result.add(String.format("%d:0%d",hours, mins));
                    } else {
                        result.add(String.format("%d:%d",hours, mins));
                    }
                }
            }
        }


        /*if (num<=0) {
            result.add("0:00");
            return result;
        }
        dfs(result, 0,0,0, num);
        Collections.sort(result);*/
        return result;
    }

    private void dfs(List<String> result, int hours, int mins, int index, int num) {
        if (index == num) {
            if  (mins >= 60) {
                hours += 1;
                result.add(hours + ":0" + mins);
            } else if (mins < 10){
                result.add(hours + ":0" + mins);
            } else {
                result.add(hours + ":" + mins);
            }
            return;
        }
        int time[] = {1, 2, 4 , 8, 16 ,32};
        for (int i=0; i<4; i++) {
            if (hours < time[i]) {
                dfs(result, hours + time[i], mins, index+1, num);
            }
        }

        for (int i=0; i<6; i++) {
            if (mins < time[i]) {
                dfs(result, hours, mins + time[i], index+1, num);
            }
        }
    }
}
