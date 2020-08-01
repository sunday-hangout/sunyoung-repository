package baekjoon.bronze;

// https://www.acmicpc.net/problem/11006

import java.util.Scanner;

public class 남욱이의_닭장 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int loop = Integer.parseInt(sc.nextLine()); // 총 몇 번 반복할건지

    for (int i = 0; i < loop; i++) {
      String chicken = sc.nextLine();
      String[] chickenInfo = chicken.split(" "); // 0 - 모든 닭다리 수의 합 / 1 - 닭의 수

      int allLeg = Integer.parseInt(chickenInfo[1]) * 2; // 닭의 원래 전체 다리 수
      int sickChicken = allLeg - Integer.parseInt(chickenInfo[0]); // 병든 닭의 수

      System.out.println(sickChicken + " " + (Integer.parseInt(chickenInfo[1]) - sickChicken));
    }

  }
}
