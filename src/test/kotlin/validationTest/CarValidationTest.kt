package validationTest


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.validation.CheckValidation
import java.lang.IllegalArgumentException

class CarValidationTest {
    private val discriminator = CheckValidation()

    @Test
    fun `자동차 이름의 길이 유효성 검사`() {
        val input = "kona"
        val result = discriminator.checkCarLength(input)
        assertThat(result)
    }

    @Test
    fun `자동차 이름이 제한 문자열 길이보다 큰 경우 예외 발생`(){
        val input = "avante"
        assertThrows<IllegalArgumentException>("자동차 이름은 1자 이상, 5자 이하만 가능합니다."){
            discriminator.checkCarLength(input)
        }
    }

    @Test
    fun `자동차 이름이 공백인 경우 예외 발생`(){
        val input = ""
        assertThrows<IllegalArgumentException>("자동차 이름은 1자 이상, 5자 이하만 가능합니다."){
            discriminator.checkCarLength(input)
        }
    }

    @Test
    fun `자동차 이름의 정규표현식 검사`() {
        val input = "k7"
        val result = discriminator.checkCarNameValidation(input)
        assertThat(result)
    }

    @Test
    fun `자동차 이름이 정규표현식을 따르지 않을 경우 예외 발생`() {
        val input = "k@7"
        assertThrows<IllegalArgumentException>("올바른 자동차 이름을 입력해야 합니다."){
            discriminator.checkCarNameValidation(input)
        }
    }
}