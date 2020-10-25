package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

public class GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {

    HashMap<String, ArrayList<String>> anagrams = new HashMap<>();

    for (String str : strs) {
      char[] keyChars = str.toCharArray();

      Arrays.sort(keyChars);
      String key = makeKey(keyChars);

      if (!anagrams.containsKey(key)) {
        ArrayList<String> arrayList = new ArrayList<>();
        anagrams.put(key, arrayList);
      }

      anagrams.get(key).add(str);
    }

    return getAnswerByKeys(anagrams.keySet(), anagrams);
  }

  private List<List<String>> getAnswerByKeys(Set<String> keys, HashMap<String, ArrayList<String>> anagrams) {

    List<List<String>> answer = new ArrayList<>();

    for (String key : keys) {
      answer.add(anagrams.get(key));
    }

    return answer;
  }

  private String makeKey(char[] keyChars) {

    String key = "";

    for (char keyChar : keyChars) {
      key += keyChar;
    }

    return key;
  }

  @Test
  public void 정답(){
    Assert.assertEquals(6, groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
  }

}
