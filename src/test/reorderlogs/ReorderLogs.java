package test.reorderlogs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderLogs {
    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] result = reorder(logs);
       for(String s : result) {
           System.out.println(s);
       }
    }

    public static String[] reorder(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for (String log : logs) {
            String[] split = log.split(" ");
            try {
                Integer.parseInt(split[1]);
                digitLogs.add(log);
            } catch (NumberFormatException nfe) {
                letterLogs.add(log);
            }
        }

        Collections.sort(letterLogs, (s1, s2) -> {
            String[] split1 = s1.split(" ");
            String[] split2 = s2.split(" ");
            // split1 의 길이 만큼 반복????
            int comp = split1[1].compareTo(split2[1]);
            if(comp != 0) {
                return comp;
            }

            return split1[0].compareTo(split2[0]);
        });

        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[letterLogs.size()]);
    }


}
