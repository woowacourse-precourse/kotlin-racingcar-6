package racingcar.domain

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Validation.checkContainComma
import racingcar.domain.Validation.checkNameLength

class Input {

    fun carName(): List<String> {
        println(NAME_GUIDE_MESSAGE)
        val userInput = Console.readLine()
        checkContainComma(userInput)

        val carNameList = userInput.split(",")
        checkNameLength(carNameList)

        return carNameList
    }

    fun attemptNum(): Int {
        println(ATTEMPT_NUM_MESSAGE)
        try {
            return Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            throw java.lang.IllegalArgumentException(ATTEMPT_ERROR_MESSAGE)
        }
    }

    companion object {
        private const val NAME_GUIDE_MESSAGE = "������ �ڵ��� �̸��� �Է��ϼ���.(�̸��� ��ǥ(,) �������� ����)"
        private const val ATTEMPT_NUM_MESSAGE = "�õ��� Ƚ���� �� ȸ�ΰ���?"
        private const val ATTEMPT_ERROR_MESSAGE = "���ڸ� �Է����ּ���"
    }

}