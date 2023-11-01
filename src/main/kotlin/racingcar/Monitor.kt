package racingcar

import racingcar.constants.GameInstruction
import racingcar.model.RaceResult
import racingcar.model.Winner

class Monitor {
    fun display(instruction: GameInstruction) = println(instruction.message)

    fun display(result: RaceResult) = println(result)

    fun display(winner: Winner) = println(winner)
}
