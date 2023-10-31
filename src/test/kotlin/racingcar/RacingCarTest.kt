package racingcar

import camp.nextstep.edu.missionutils.test.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll

class RacingCarTest {


    @Test
    fun `경주 자동차 이름 입력 및 exception 처리`() {
        var input = splitCarNames("aaaaaaa,bb,cc")

        assertThat(input).isEqualTo(listOf("aaaaaaa","bb","cc"))
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            if (input != null) {
                checkNames(input)
            }
        }
    }


    @Test
    fun `자동차 경주 각 게임 실행`(){


    }


}