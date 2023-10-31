package racingcar.domain

import racingcar.utils.getRandomNumber
import racingcar.res.CarMovement.GO
import racingcar.res.CarMovement.GO_RECORD
import racingcar.res.CarMovement.STOP

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
      this._record += GO_RECORD
      GO
    } else {
      STOP
    }
  }
}