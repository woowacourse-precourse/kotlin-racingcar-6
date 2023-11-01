package util

import camp.nextstep.edu.missionutils.Randoms

class RandNumGenerator {
    fun getRandNum0to9(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}