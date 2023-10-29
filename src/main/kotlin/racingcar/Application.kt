package racingcar

import racingcar.console.GameConsole
import racingcar.manager.MessageManager
import racingcar.manager.RacingManager

fun main() {
    val messenger = MessageManager()
    val racingManager = RacingManager()

    messenger.printGameStart()
    GameConsole.getUserInput()
    GameConsole.separateCarList()

    messenger.printGameCount()
    GameConsole.getUserInput()
    GameConsole.setRacingCount()

    messenger.printGameResult()
    repeat(GameConsole.getRacingCount()){
        racingManager.racingCycle(GameConsole.getCarList())
        messenger.printOneRacingResult(GameConsole.getCarList())
    }

}
