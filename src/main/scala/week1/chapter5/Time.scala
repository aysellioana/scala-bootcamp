package week1.chapter5
//ex3: Write a class Time with read-only properties hours and minutes and a method
//before(other: Time): Boolean that checks whether this time comes before the
//other. A Time object should be constructed as new Time(hrs, min), where hrs is in
//military time format (between 0 and 23).

class Time(val hours: Int, val minutes: Int) {
  require(hours >= 0 && hours <= 23, "Hours must be between 0 and 23")
  require(minutes >= 0 && minutes <= 59, "Minutes must be between 0 and 59")

  def before(other: Time): Boolean = {
    if (this.hours < other.hours) true
    else if (this.hours == other.hours && this.minutes < other.minutes) true
    else false
  }
}