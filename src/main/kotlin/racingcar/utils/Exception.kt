package racingcar.utils

import racingcar.utils.Constant.GAME_OVER_MESSAGE
import racingcar.utils.Constant.MAX_LENGTH_VALUE
import racingcar.utils.Constant.MIN_LENGTH_VALUE

object Exception {

    fun String.requireValidCarNames() =
        require(this.trim().split(",").all { it.length in MIN_LENGTH_VALUE..MAX_LENGTH_VALUE }) { GAME_OVER_MESSAGE }

    fun String.requireValidPositiveInt() = requireNotNull(this.toIntOrNull()) { GAME_OVER_MESSAGE }

    fun String.requirePositiveInt() = require(this.toInt() > 0) { GAME_OVER_MESSAGE }

}