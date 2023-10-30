package racingcar.game

import camp.nextstep.edu.missionutils.Console
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.lang.String.*

internal class UserInputUtilTest {
    @Test
    fun `getRacingCars 리턴 값 테스팅`() {
        // given
        try {
            command("bamin,pobi,woni")
            val racingCarList = UserInputUtil.getRacingCars()
            // when
            val expectedRacingCarList: List<Car> = listOf(Car("bamin"), Car("pobi"), Car("woni"))
            // then
            assertEquals(racingCarList.toString(), expectedRacingCarList.toString())
        } finally {
            Console.close()
        }
    }

    @Test
    fun `getRacingCars - 중복된 이름인 경우 예외처리`() {

    }

    @Test
    fun `getRacingCars - 이름의 길이가 유효하지 않은 경우 예외처리`() {

    }

    @Test
    fun `getAttempts 리턴 값 테스팅`() {

    }

    @Test
    fun `getAttempts 메서드 - 시도 횟수에 자연수가 아닌 경우 예외처리`() {

    }

    private fun command(vararg args: String) {
        val buf = join("\n", *args).toByteArray()
        System.setIn(ByteArrayInputStream(buf))
    }
}