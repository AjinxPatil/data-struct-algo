public class BinNumGenerator {
  public static StringBuffer[] generate(int n) {
    StringBuffer[] bins = new StringBuffer[n];
    bins[0] = new StringBuffer("0");
    bins[1] = new StringBuffer("1");
    int count = 1;
    int i = 2;
    int t = 2;
    while (count < n && t < n) {
      bins[t] = bins[t].append(bins[i - 1]).append("0");
      bins[t + 1] = bins[t + 1].append(bins[i - 1]).append("1");
      t = t + 2;
      i++;
      count++;
    }
    return bins;
  }
  public static void main(String[] args) {
    StringBuffer[] result = BinNumGenerator.generate(Integer.parseInt(args[0]));
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i].toString());
    }
  }
}
