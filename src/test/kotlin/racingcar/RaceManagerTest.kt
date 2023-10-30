package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
}