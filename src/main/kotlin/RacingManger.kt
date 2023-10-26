import CarFactory.makeCar
import Racing.racingResult
import Racing.racingSetting
import camp.nextstep.edu.missionutils.Console
import util.Validator.inputRacingRoundContentCheck

class RacingManger {
    fun racingInfoInput() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)") // 추후 특정 객체에서 메시지 관리
        val racingCarList = makeCar(Console.readLine())
        println("시도할 횟수는 몇 회인가요?")
        val raceRound = inputRacingRoundContentCheck(Console.readLine())
        racingSetting(racingCarList, raceRound)
        racingResult(racingCarList)
    }
}
