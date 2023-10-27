package racingcar.utils

import racingcar.utils.Constant.GAME_OVER_MESSAGE

object Exception {

    fun String.requireValidCarNames() = require(this.trim().split(",").all { it.length in 1..5 }) { GAME_OVER_MESSAGE }

    fun String.requireValidPositiveInt() = requireNotNull(this.toIntOrNull()) { GAME_OVER_MESSAGE }

    fun String.requirePositiveInt() = require(this.toInt() > 0) { GAME_OVER_MESSAGE }

}