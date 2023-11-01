package racingcar.service

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Player

class CarPlayGameImpl(
        private val printGame: PrintGame
) : PlayGame {

    private var round: Int = 0
    private var players: List<Player> = listOf()
    override fun initGame() {
        printGame.printInit()
        val inputPlayers = Console.readLine()
        val names = inputPlayers.split(",")
        initPlayers(names)
        printGame.tryCount()
        round = Console.readLine().toInt()
    }

    override fun initPlayers(names: List<String>) {
        players = names.map { name ->
            validCheck(name)
            Player.toPlayer(name)
        }
    }

    override fun playGame() {
    }

    override fun playRound() {
    }

    override fun endGame(winnerCount: Int) {
    }

    private fun validCheck(name: String) {
        require(name.length < 6) {
            "이름의 길이는 5자이하 여야 합니다."
        }
    }
}