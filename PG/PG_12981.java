package PG;

import java.util.*;

class PG_12981 {

    public static Map<String, Boolean> visited = new HashMap<>();

    public int[] solution(int n, String[] words) {
        int[] answer = new int[] {0, 0};

        int len = words.length;
        boolean flag = true;

        String prev = words[0];
        String cur = "";
        visited.put(prev, true);
        for(int index = 1; index < len; index++) {
            cur = words[index];

            // 끝말이 아닌 경우
            if(prev.charAt(prev.length() - 1) != cur.charAt(0)) {
                flag = false;
                answer[0] = index % n + 1;
                answer[1] = index / n + 1;
                break;
            }

            // 사용한 단어인 경우
            if(visited.containsKey(cur)) {
                flag = false;
                answer[0] = index % n + 1;
                answer[1] = index / n + 1;
                break;
            }

            prev = cur;
            visited.put(cur, true);
        }

        return answer;
    }
}
