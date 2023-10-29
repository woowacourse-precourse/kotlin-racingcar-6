package racingcar.service

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar
import racingcar.util.Util
import racingcar.view.Message

class RacingService {

    private val message = Message()
    val carList = mutableListOf<RacingCar>()
    var playCount = 0

    //자동차 경주 전 세팅
    fun setRacing() {
        message.requestCarNames()

        val nameList = Util.getCarNames()
        for (name in nameList) {
            carList.add(RacingCar(name = name))
        }

        message.requestPlayCount()

        playCount = Util.getPlayCount() ?: throw IllegalArgumentException()
    }

    //경주 시작
    fun doRacing() {
        carList.forEach { car ->
            val randomNumber = getRandomNumber()
            if (isGoForward(randomNumber)) {
                car.goOneStep()
            }
        }
        message.progress(carList)
    }

    //자동차가 앞으로 전진해야하는지 파악 함수
    fun isGoForward(number : Int): Boolean {

        return number >= MINIMUM_NUMBER_TO_WIN
    }

    private fun getRandomNumber() : Int{
        return Randoms.pickNumberInRange(0,9)
    }

    companion object{
        const val MINIMUM_NUMBER_TO_WIN = 4
    }
}