package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Car(val carName: String) {
  var record: String = ""
    get() {
      val randomNumber = Randoms.pickNumberInRange(0, 9)
      if (randomNumber >= 4) {
        field += "-"
      }

      return field
    }
}