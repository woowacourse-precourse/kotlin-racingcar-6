package racingcar.service

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Player
import kotlin.math.max

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
        initGame()

        for (loop in 0..<round) {
            playRound()
            println()
        }
    }

    override fun playRound() {
        players.forEach { player ->
            // 1 : go 0 : stop
            if (canIGo()) player.addWinCount()
            printGame.printGame(player.name, player.winCount)
        }
    }

    override fun endGame(winnerCount: Int) {
    }

    // 5자 이하의 이름인지 확인하는 메서드
    private fun validCheck(name: String) {
        require(name.length < 6) {
            "이름의 길이는 5자이하 여야 합니다."
        }
    }

    // 랜덤으로 값을 뽑아 전진이 가능한지 확인하는 메서드
    // 4 이상 부터 전진한다.
    private fun canIGo(): Boolean {
        return Randoms.pickNumberInRange(0, 9) > RUN_OR_STOP_STANDARD
    }

    companion object {
        const val RUN_OR_STOP_STANDARD = 3
    }
}