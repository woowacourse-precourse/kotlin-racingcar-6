package racingcar.domain.computer

import camp.nextstep.edu.missionutils.Randoms

class Computer() {
    companion object {
        fun forwardCar(): Int {
            val computer = Randoms.pickNumberInRange(1, 9)
            if (computer < 4) {
                return 0
            }
            return 1
        }
    }
}
