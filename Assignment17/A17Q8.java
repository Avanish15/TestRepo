class DataStream {
  private final int k;
  private final int value;
  private int countEquals = 0;

  public DataStream(int value, int k) {
    this.k = k;
    this.value = value;
  }

  public boolean consec(int num) {
    if (num == value)
      countEquals++;
    else
      countEquals = 0;

    return countEquals >= k;
  }
}