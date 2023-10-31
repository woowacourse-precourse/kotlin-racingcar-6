package lst1995kotlintest

import Validator.nameCheck
import Validator.roundCheck
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class InputValueTest {

    @Test
    fun `자동차들의 이름을 정확하게 입력하였을 경우`() {
        val input = "가나다,마바사,자동차1번,123,asd,qwe,1q2wr"
        assertDoesNotThrow {
            nameCheck(input)
        }
    }

    @Test
    fun `최대 길이보다 긴 이름이 포함되어 있을 경우`() {
        val input = "가나다,마바사,자동차1번,123456,asd,qwe,1q2wr"
        assertThrows<IllegalArgumentException> {
            nameCheck(input)
        }
    }

    @Test
    fun `이름을 입력하지 않았을 경우`() {
        val input = ""
        assertThrows<IllegalArgumentException> {
            nameCheck(input)
        }
    }

    @Test
    fun `입력하지 않은 이름이 포함되어 있을 경우`() {
        val input = "asdm,123,asdc,,sd"
        assertThrows<IllegalArgumentException> {
            nameCheck(input)
        }
    }

    @Test
    fun `진행할 라운드의 값에 정확한 숫자를 입력하였을 경우`() {
        val input = "753"
        assertDoesNotThrow {
            roundCheck(input)
        }
    }

    @Test
    fun `진행할 라운드의 값에 과도하게 큰 숫자를 입력하였을 경우`() {
        val input = "753161616121361145911295119128347322351466553674"
        assertDoesNotThrow {
            roundCheck(input)
        }
    }

    @ParameterizedTest
    @CsvSource("65-1", "asd", "ㄱㄴㄷ")
    fun `진행할 라운드의 값을 정확하게 입력하지 않았을 경우`(input: String) {
        assertThrows<IllegalArgumentException> {
            roundCheck(input)
        }
    }
}
