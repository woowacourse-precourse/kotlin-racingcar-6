package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

object MoveConditionGenerator {
    fun generate() = Randoms.pickNumberInRange(0, 9)
}