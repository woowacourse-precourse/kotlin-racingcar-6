import Validator.nameCheck
import Validator.roundCheck
import camp.nextstep.edu.missionutils.Console
import car.Car
import car.CarFactory.makeCar
import race.RacingSystemValues.CAR_INPUT_MESSAGE
import race.RacingSystemValues.TRIES_REQUEST_MESSAGE
import java.math.BigInteger

object Controller {
    fun inputCarInformation(): List<Car> {
        println(CAR_INPUT_MESSAGE)
        val input = Console.readLine()
        nameCheck(input)
        return makeCar(input)
    }

    fun inputRacingRoundInformation(): BigInteger {
        println(TRIES_REQUEST_MESSAGE)
        val input = Console.readLine()
        roundCheck(input)
        return input.toBigInteger()
    }
}
