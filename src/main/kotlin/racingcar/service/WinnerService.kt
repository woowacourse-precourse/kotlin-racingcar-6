package racingcar.service

object WinnerService {
    fun findWinners(lastRoundResult: Map<String, Int>): Set<String> {
        val maxPosition = lastRoundResult.values.maxOrNull()!!
        return lastRoundResult.filter { it.value == maxPosition }.keys
    }
}