package programmers.level2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 셔틀버스 {

  public static String solution(int n, int t, int m, String[] timetable) {

    String answer = "";

    // 시간표 정렬
    PriorityQueue<Integer> times = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });

    for (String table : timetable) {
      int time =
          Integer.parseInt(table.substring(0, 2)) * 60 + Integer.parseInt(table.substring(3)); // 분 단위로 변경

      times.add(time);
    }

    int arrivalAt = 9 * 60; // 버스는 9시부터 운행
    int last = 0;

    while (n-- > 0) { // 셔틀 운행 횟수

      int accept = m; //수용 인원을 초기화
      int time = 0; // 마지막으로 탄 크루의 시간을 저장하기 위함

      while (!times.isEmpty()) { //기다리는 크루가 있다면
        if (times.peek() <= arrivalAt && accept > 0) { //현재 버스의 도착시간보다 일찍왔으며, 수용인원도 있을 때
          accept--; // 버스에 탔다고 가정하고 수용인원 1 감소
          time = times.poll(); // 시간표에 탄 사람 제거
        } else {
          break;
        }
      }


      if (n > 0) { // 마지막 버스가 아님

        if (times.isEmpty()) { //기다리는 크루가 없다면
          last = arrivalAt + ((n + 1) * t); //마지막 버스의 도착시간
          break;
        }

        arrivalAt += t; // 버스의 다음 시간 셋팅

      } else { // 마지막 버스
        if (accept > 0) { // 수용인원이 있다면
          last = arrivalAt; // 버스의 도착시간으로
        } else {
          last = time - 1; // 없다면, 마지막으로 탄 크루의 시간보다 1분 일찍
        }

        break;
      }
    }

    answer = String.format("%02d", last / 60) + ":" + String.format("%02d", last % 60);

    return answer;
  }

}
