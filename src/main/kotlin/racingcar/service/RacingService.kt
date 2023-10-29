package racingcar.service

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar
import racingcar.util.Util
import racingcar.view.Message

class RacingService {

    private val message = Message()
    val carList = mutableListOf<RacingCar>()
    var playCount = 0

    fun setRacing() {
        message.requestCarNames()

        val nameList = Util.getCarNames()
        for (name in nameList) {
            carList.add(RacingCar(name = name))
        }

        message.requestPlayCount()

        playCount = Util.getPlayCount() ?: throw IllegalArgumentException()
    }

    fun doRacing() {
        carList.forEach { car ->
            if (isGoForward()) {
                car.goOneStep()
            }
        }
        message.progress(carList)
    }

    fun isGoForward(): Boolean {
        val randomNumber = Randoms.pickNumberInRange(0, 9)

        return randomNumber >= MINIMUM_NUMBER_TO_WIN
    }

    companion object{
        const val MINIMUM_NUMBER_TO_WIN = 4
    }
}