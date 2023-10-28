package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Car(val carName: String) {
  private var record: String = ""

  fun moveOrNot(): String {
    val randomNumber = Randoms.pickNumberInRange(0, 9)
    if (randomNumber >= 4) {
      record += "-"
    }

    return record
  }
}