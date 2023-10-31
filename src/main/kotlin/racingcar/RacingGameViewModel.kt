package racingcar

import racingcar.util.Constants
import racingcar.util.NumberGenerator

class RacingGameViewModel(private val numberGenerator: NumberGenerator) {

    // PlayerRepository 역할의 리스트 (모델 클래스 없이)
    private val _playerList = mutableListOf<Player>()
    val playerList get() = _playerList

    fun savePlayers(inputString: String, delimiter: Char) {
        val candidateList = inputString.split(delimiter)
        _playerList.clear()

        for (candidate in candidateList) {
            if (candidate.length > 5) throw IllegalArgumentException(Constants.EXCEPTION_PLAYER_NAME_LENGTH)
            _playerList.add(Player(candidate))
        }
    }
}