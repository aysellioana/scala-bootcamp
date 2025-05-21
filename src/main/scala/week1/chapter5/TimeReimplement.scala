package week1.chapter5

class TimeReimplement(h: Int, m: Int) {
  require(h >= 0 && h <= 23, "Hours must be between 0 and 23")
  require(m >= 0 && m <= 59, "Minutes must be between 0 and 59")

  private val minutesSinceMidnight = h * 60 + m

  def hours: Int = minutesSinceMidnight / 60

  def minutes: Int = minutesSinceMidnight % 60
  
  def before(other: TimeReimplement): Boolean = {
    this.totalMinutes < other.totalMinutes
  }
  
  private def totalMinutes: Int = minutesSinceMidnight

}
