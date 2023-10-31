package racingcar.domain

import racingcar.utils.getRandomNumber

class Car(val carName: String) {
  private var _record: String = ""
    get() {
      moveOrNot(getRandomNumber())

      return field
    }

  val record: String
    get() = _record

  fun moveOrNot(number: Int): Boolean {
    return if (number >= 4) {
      this._record += "-"
      true
    } else false
  }
}