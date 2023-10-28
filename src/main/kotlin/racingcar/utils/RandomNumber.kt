package racingcar.utils

import camp.nextstep.edu.missionutils.Randoms
import racingcar.resources.Number.NINE
import racingcar.resources.Number.ZERO

fun generateRandomNumbers(): Int = Randoms.pickNumberInRange(ZERO, NINE)