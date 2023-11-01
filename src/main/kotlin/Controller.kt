import InputValue.INPUT_CAR_MESSAGE
import InputValue.INPUT_ROUND_MESSAGE
import Validator.nameCheck
import Validator.roundCheck
import camp.nextstep.edu.missionutils.Console
import car.Car
import car.CarFactory.makeCar
import java.math.BigInteger

object Controller {
    fun inputCarInformation(): List<Car> {
        println(INPUT_CAR_MESSAGE)
        val input = Console.readLine()
        nameCheck(input)
        return makeCar(input)
    }

    fun inputRacingRoundInformation(): BigInteger {
        println(INPUT_ROUND_MESSAGE)
        val input = Console.readLine()
        roundCheck(input)
        return input.toBigInteger()
    }
}
