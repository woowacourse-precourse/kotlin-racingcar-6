package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.lang.IllegalArgumentException

class RacingCarTestStudy {

    //standardOut는 원래의 system.out으로 바꿔주기 위해 백업
    private val standardOut = System.`out`
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        //출력 바꿔주기
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @Test
    fun `자동차 이름 쉼표(,)구분 테스트`() {
        var carList = splitCarName("aa,bb,cc,ddd,eee")
        var carResultList = listOf("aa","bb","cc","ddd","eee")
        assertThat(carList).isEqualTo(carResultList)
    }

    @Test
    fun `자동차 이름 예외 테스트`() {
        var carNameList = listOf("aa","bbb","cdcdc","qeqeqeq")
        assertThrows<IllegalArgumentException> { checkExceptionCarName(carNameList) }
    }

    @Test
    fun `경기 횟수 입력 에외 테스트`() {
        assertThrows<IllegalArgumentException> { checkExceptionTryCount(-1) }
    }

    //outputStreamCaptor에 print값이 들어감
    @Test
    fun `경기 우승 자동차 출력 테스트`() {
        val carNameList = listOf("aa","bb","cc")
        var carForwardCount = mutableListOf(5,3,5)
        printVictoryCar(carForwardCount,carNameList)
        val answer = "최종 우승자 : aa, cc"
        assertThat(answer).isEqualTo(outputStreamCaptor.toString())
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }
}