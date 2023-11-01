package racingcar.domain

import racingcar.utils.RandomNumberGenerator

class RacingGame(
    private val randomNumberGenerator: RandomNumberGenerator,
    private var raceState: MutableList<GameState> = mutableListOf()
) {
    companion object {
        const val MAKE_MOVE_NUMBER = 4
    }

    fun race(namesSize: Int): List<Boolean> {
        // true 일때 움직임, false 일때 정지 리스트
        val isMoveList = mutableListOf<Boolean>()
        for (i in 1..namesSize) {
            isMoveList.add(randomNumberGenerator.createNumber() >= MAKE_MOVE_NUMBER)
        }

        return isMoveList
    }

    fun result(): List<String> {
        var max = 0
        raceState.forEach { gameState ->
            if (max < gameState.progress) max = gameState.progress
        }

        return raceState.filter { gameState -> gameState.progress == max }.map { it.name }
    }

    fun getRaceState(): List<GameState> {

        return raceState
    }

    fun initRaceState(nameList: List<String>) {
        nameList.forEach { name ->
            raceState.add(GameState(name, 0))
        }
    }

    fun updateRaceState(progress: List<Boolean>) {
        raceState.forEachIndexed { index, _ ->
            raceState[index].progress += if (progress[index]) 1 else 0
        }
    }
}