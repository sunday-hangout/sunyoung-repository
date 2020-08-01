package baekjoon.silver;

import java.util.Scanner;

public class 토너먼트 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    String[] loop = sc.nextLine().split(" "); // 총 토너먼트 수 - a 순서 - b 순

    System.out.println(tournament(loop));
  }

  private static int tournament(String[] loop) {

    int total = Integer.parseInt(loop[0]);
    int a = Integer.parseInt(loop[1]);
    int b = Integer.parseInt(loop[2]);

    int count = 1;

    while (total > 0) {
      if ((a + 1) / 2 == (b + 1) / 2) {
        return count;
      }

      total /= 2;
      a = (a + 1) / 2;
      b = (b + 1) / 2;
      count++;
    }

    return -1;

  }
}
