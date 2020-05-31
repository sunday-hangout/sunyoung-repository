package programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/12899

public class _124_나라의_숫자 {

  public String solution(int num) {
    String answer;

    // 1 to 3
    answer = for124(num);
    answer = reverseString(answer);

    return answer;
  }

  private String for124(int num) {

    String answer = "";
    int rem = 0; // 나머지

    while (num > 0) {

      // 몫(quo)과 나머지(rem) 변수 초기화
      rem = num % 3;
      num = num / 3;

      // answer에 나머지를 붙여준다. 0은 4로 치환한다. 몫 -1을 해준다.
      if (rem == 0) {
        num -= 1;
        rem = 4;
      }
      answer += Integer.toString(rem);
    }
    return answer;
  }

  public static String reverseString(String s) {
    return (new StringBuffer(s)).reverse().toString();
  }

}
