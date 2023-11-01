package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Validation.checkContainComma
import racingcar.domain.Validation.checkNameLength
import racingcar.domain.Validation.checkSameName
import kotlin.IllegalArgumentException

class ValidationTest {

    @Test
    fun `��ǥ üũ �޼��� �׽�Ʈ`() {
        val input = "���� ���� ����"
        assertThrows<IllegalArgumentException> {
            checkContainComma(input)
        }
    }

    @Test
    fun `�̸� ���� üũ �޼��� �׽�Ʈ`() {
        val input = "����,����,���������̸�".split(",")
        assertThrows<IllegalArgumentException> {
            checkNameLength(input)
        }
    }

    @Test
    fun `�ߺ��� �̸� ���� ó�� �׽�Ʈ`() {
        val input = "����,����,����,����".split(",")
        assertThrows<IllegalArgumentException> {
            checkSameName(input)
        }
    }

}