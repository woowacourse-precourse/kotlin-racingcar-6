package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RacingSystemDemo {
    companion object {
        private val standardOut = System.out
        private val outputStreamCaptor = ByteArrayOutputStream()
        private var output = outputStreamCaptor.toString().trim()
        @BeforeAll
        fun setUpStream() {
            System.setOut(PrintStream(outputStreamCaptor))
        }

        @AfterAll
        fun tearDown() {
            System.setOut(standardOut)
        }
    }

    @Test
    fun `콤마를 기준으로_CarName이 나뉘었는지 테스트`() {
        val input = "a,b,c"
        RacingSystem.setCarNames(input)
        val result = RacingSystem.getCarNames()

        assertEquals(listOf("a","b","c"),result)
    }
    @Test
    fun `공백이 있을 경우_CarName에 포함되는지 테스트`() {
        val input = "팀 노홍철, 팀  버튼, 팀   쿡"
        RacingSystem.setCarNames(input)
        val result = RacingSystem.getCarNames()

        assertEquals(listOf("팀 노홍철","팀  버튼","팀   쿡"),result)
    }

    @Test
    fun `CarName에 5글자 초과인 이름이 포함될 경우_IlleGalArgumentException발생 테스트`() {
        val input = "스쿠테리아 람보르기니, 레드불 레이싱"

        assertThrows<IllegalArgumentException>{
            RacingSystem.setCarNames(input)
        }
    }

    @Test
    fun `문자열 타입의 숫자를 입력한 경우_정수 타입의 시도횟수로 변환되는지 테스트`() {
        val input = "4"
        RacingSystem.setAttemptNumber(input)
        val result = RacingSystem.getAttemptNumber()

        assertEquals(4,result)
    }
    @Test
    fun `문자열 타입의 문자열을 입력한 경우_IlleGalArgumentException발생 테스트`() {
        val input = "세번"

        assertThrows<IllegalArgumentException>{
            RacingSystem.setAttemptNumber(input)
        }
    }

    @Test
    fun `자동차 이름이 들어간 자동차들이 생성되었는지 테스트`() {
        val input = "람보르기니, 레드불, 맥라렌"
        RacingSystem.setCarNames(input)
        RacingSystem.createCarLane()
        var result = arrayListOf<String>()
        RacingSystem.getCarLane().getCars().forEach { result.add(it.getName())}

        assertEquals(listOf("람보르기니","레드불","맥라렌"),result)
    }

    @Test
    fun `입력한 시도횟수만큼 자동차경주 결과가 나오는지 확인` () {
        RacingSystem.setCarNames("a, b, c")
        RacingSystem.setAttemptNumber("3")
        RacingSystem.createCarLane()
        RacingSystem.startAttemptCarLane()
        val expect = "a :\nb :\nc :\n" + "a :\nb :\nc :\n" +"a :\nb :\nc :\n"

        Assertions.assertThat(output.contains(expect))
    }
}