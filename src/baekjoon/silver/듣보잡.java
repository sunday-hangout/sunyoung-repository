package baekjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 듣보잡 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] loop = sc.nextLine().split(" "); // 듣/보수

    HashMap<String, Integer> hear = new HashMap<>();
    List<String> nothing = new ArrayList<>();

    // 못 들은 사람
    for (int i = 0; i < Integer.parseInt(loop[0]); i++) {
      hear.put(sc.nextLine(), 0);
    }

    // 못 본 사람
    for (int i = 0; i < Integer.parseInt(loop[1]); i++) {
      String name = sc.nextLine();

      if (hear.containsKey(name)) {
        nothing.add(name);
      }
    }

    Collections.sort(nothing);

    System.out.println(nothing.size());
    nothing.forEach(System.out::println);
  }

}
