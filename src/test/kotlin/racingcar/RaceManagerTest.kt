package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.Car.Companion.THRESHOLD_FOR_MOVE_FORWARD
import racingcar.fake.FakeNumberGenerator
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RaceManagerTest {

    @Test
    fun `전진을 시도할 횟수에 문자열을 넣을 수 없다`() {
        //given
        val raceManager = RaceManager()
        val input = "tgyuu"

        //when


        //then
        assertThrows<IllegalArgumentException> {
            raceManager.setMovementAttemptCount(input)
        }
    }

    @Test
    fun `전진을 시도할 횟수에 음수를 넣을 수 없다`() {
        //given
        val raceManager = RaceManager()
        val input = "-1"

        //when


        //then
        assertThrows<IllegalArgumentException> {
            raceManager.setMovementAttemptCount(input)
        }
    }

    @Test
    fun `자동차를 추가하면, 해당 자동차의 이름을 key로 하는 entry가 생성된다`() {
        //given
        val raceManager = RaceManager()
        val input = Car(name = "tgyuu")


        //when
        raceManager.addCarToRace(input)


        //then
        val actual = raceManager.movedDirection.containsKey(input.name)
        assertThat(actual).isTrue()
    }

    @Test
    fun `경주가 종료되었을 경우, 가장 많이 전진한 자동차가 승리한다`() {
        // given
        val raceCars = listOf(
            Car(name = "tgyuu", numberGenerator = FakeNumberGenerator(THRESHOLD_FOR_MOVE_FORWARD)),
            Car(name = "pobi", numberGenerator = FakeNumberGenerator(THRESHOLD_FOR_MOVE_FORWARD-1)),
        )

        // when
        val actual = startRaceAndGetResult(raceCars, movementAttempt = "1")


        // then
        val expected = "최종 우승자 : tgyuu"
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `경주가 종료되었을 경우, 동점자가 존재할 경우 함께 승리한다`() {
        // given
        val raceCars = listOf(
            Car(name = "tgyuu", numberGenerator = FakeNumberGenerator(THRESHOLD_FOR_MOVE_FORWARD)),
            Car(name = "pobi", numberGenerator = FakeNumberGenerator(THRESHOLD_FOR_MOVE_FORWARD)),
        )


        // when
        val actual = startRaceAndGetResult(raceCars, movementAttempt = "1")


        //then
        val expected = "최종 우승자 : tgyuu, pobi"
        assertThat(actual).isEqualTo(expected)
    }

    private fun startRaceAndGetResult(raceCars: List<Car>, movementAttempt: String): String {
        val raceManager = RaceManager()

        raceCars.forEach { car ->
            raceManager.addCarToRace(car)
        }
        raceManager.setMovementAttemptCount(movementAttempt)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        raceManager.startRace()
        System.setOut(System.out)

        return outputStream.toString().trim()
    }
}