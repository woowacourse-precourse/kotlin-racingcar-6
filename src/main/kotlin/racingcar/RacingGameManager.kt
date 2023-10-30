package racingcar

import camp.nextstep.edu.missionutils.Console

object RacingGameManager {
    private lateinit var racingGame : RacingGame

    fun startGame() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

        racingGame = RacingGame(
            carList = receiveCarNamesFromUser(),
            amount = recieveTryAmountFromUser()
        )
    }
    private fun receiveCarNamesFromUser() = Console.readLine().split(",")


    private fun recieveTryAmountFromUser() = Console.readLine().toInt()



}