package level2;

import java.math.BigInteger;
import org.junit.Assert;
import org.junit.Test;

public class 멀쩡한_사각형 {

  public long solution(int w, int h) {
    long wl = w;
    long h1 = h;

    int gcd = BigInteger.valueOf(wl).gcd(BigInteger.valueOf(h1)).intValue();
    return Long.parseLong((wl * h1) - (((wl / gcd) + (h1 / gcd) - 1) * gcd) + "");
  }

  @Test
  public void 정답() {
    Assert.assertEquals(80, solution(8, 12));
    Assert.assertEquals(80, solution(12, 8));
    Assert.assertEquals(12, solution(4, 4));
  }
}
