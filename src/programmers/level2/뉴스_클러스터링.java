package programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/17677

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Test;

public class 뉴스_클러스터링 {

  public int solution(String str1, String str2) {

    List<String> splitStr1 = new ArrayList<>();
    List<String> splitStr2 = new ArrayList<>();

    int max = Integer.max(str1.length(), str2.length());

    // 두 자씩 잘라서 리스트에 넣기
    for (int i = 0; i < max - 1; i++) {
      if (i + 1 < str1.length() && Pattern.matches("^[a-zA-Z]*$", str1.substring(i, i + 2))) {
        splitStr1.add(str1.substring(i, i + 2).toUpperCase());
      }
      if (i + 1 < str2.length() && Pattern.matches("^[a-zA-Z]*$", str2.substring(i, i + 2))) {
        splitStr2.add(str2.substring(i, i + 2).toUpperCase());
      }
    }

    // 만약 둘 다 리스트가 비어있다면 65536 반환
    if (splitStr1.isEmpty() && splitStr2.isEmpty()) {
      return 65536;
    }

    // 교집합
    int intersection = 0;

    // 교집합  찾기
    splitStr1.sort(String::compareTo);
    splitStr2.sort(String::compareTo);

    for (int i = 0; i < splitStr1.size(); i++) {
      for (int j = 0; j < splitStr2.size(); j++) {
        if (splitStr1.get(i).equals(splitStr2.get(j))) {
          intersection++;
          splitStr2.remove(j);
          break;
        }
        // 반복적인 작업을 줄이기 위해
        if (splitStr1.get(i).charAt(0) < splitStr2.get(j).charAt(0)) {
          break;
        }
      }
    }

    // 합집합
    int union = splitStr1.size() + splitStr2.size();

    return (int)(((double)intersection / (double)union) * 65536);
  }

  @Test

  public void 정답() {
    Assert.assertEquals(16384, solution("FRANCE", "french"));
    Assert.assertEquals(65536, solution("handshake", "shake hands"));
    Assert.assertEquals(65536, solution("E=M*C^2", "e=m*c^2"));
  }

}
