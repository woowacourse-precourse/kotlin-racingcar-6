package racingcar.ui

import org.junit.jupiter.api.Assertions.assertEquals
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.ui.UserInput.createNameList

class UserInterfaceTest {
    val input = "  choi  , gerrard  ,  mint  "
    val names = listOf("choi", "gerrard", "mint")
    val inputNames = input.createNameList()
    @Test
    fun `입력을 쉼표로 구분하고, 앞 뒤 공백을 제거하여 리스트를 생성한다`() {
        assertEquals(names, inputNames)
    }

    @Test
    fun `자동차 이름이 5자 이하인지 검사`() {
        assertThrows<IllegalArgumentException> { InputValidator.checkNamesLength(inputNames)}
    }

    @Test
    fun `중복된 자동차 이름 입력 시, 하나로 처리`() {
        val duplicateInput = "pobi, pobi"
        val duplicateNames = duplicateInput.createNameList()
        assertThat(duplicateNames.size).isEqualTo(1)
    }

    @Test
    fun `시도 횟수가 숫자인지 검사_값 6ab`() {
        assertThrows<IllegalArgumentException> { InputValidator.checkOnlyDigit("6ab")}
    }

    @Test
    fun `시도 횟수가 숫자인지 검사_값 빈문자열`() {
        assertThrows<IllegalArgumentException> { InputValidator.checkOnlyDigit("")}
    }

    @Test
    fun `시도 횟수가 1 이상인지 검사_값 0`() {
        assertThrows<IllegalArgumentException> { InputValidator.isPositive(0)}
    }

    @Test
    fun `시도 횟수가 100 이하인지 검사_값 1000`() {
        assertThrows<IllegalArgumentException> { InputValidator.isUnderHundred(1000)}
    }
}