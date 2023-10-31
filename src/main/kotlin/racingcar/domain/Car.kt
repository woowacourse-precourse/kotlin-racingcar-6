package racingcar.domain

import racingcar.res.CarMovement.MOVING_FORWARD
import racingcar.res.CarMovement.MOVING_FORWARD_RECORD
import racingcar.res.CarMovement.STOP
import racingcar.res.CarMovement.STOP_RECORD

class Car(val carName: String) {
  private var _record: String = ""

  val record: String
    get() = _record

  fun moveOrNot(number: Int): Boolean {
    return if (number >= 4) {
      this._record += MOVING_FORWARD_RECORD
      MOVING_FORWARD
    } else {
      this._record += STOP_RECORD
      STOP
    }
  }
}