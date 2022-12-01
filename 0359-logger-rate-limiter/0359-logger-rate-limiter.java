class Logger {
  private HashMap<String, Integer> map;

  public Logger() {
    map = new HashMap();
  }

  /**
   * Returns true if the message should be printed in the given timestamp, otherwise returns false.
   */
  public boolean shouldPrintMessage(int timestamp, String message) {
    if (!this.map.containsKey(message)) {
      map.put(message, timestamp);
      return true;
    }

    Integer oldTimestamp = this.map.get(message);
    if (timestamp - oldTimestamp >= 10) {
      map.put(message, timestamp);
      return true;
    } else return false;
  }
}