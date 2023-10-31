package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingCarTestStudy {

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
    
}
