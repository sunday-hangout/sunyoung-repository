package programmers.level1;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import org.junit.Assert;
import org.junit.Test;

public class _2016년 {

  public String solution(int a, int b) {
    return LocalDate.of(2016, a, b).getDayOfWeek()
        .getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase();
  }

  @Test
  public void 정답() {
    Assert.assertEquals("TUE", solution(5, 24));
  }
}
