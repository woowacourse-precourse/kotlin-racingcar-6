package racingcar.domain

object Validation {

    fun checkContainComma(userInput: String) {
        if (!userInput.contains(","))
            throw IllegalArgumentException(COMMA_ERROR_MESSAGE)
    }

    fun checkNameLength(carNameList: List<String>) {
        carNameList.forEach { name ->
            if (name.length > NAME_MAX_LENGTH)
                throw IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE)
        }
    }

    private const val NAME_MAX_LENGTH = 5
    private const val COMMA_ERROR_MESSAGE = "��ǥ(,)�� �������� �������ּ���"
    private const val NAME_LENGTH_ERROR_MESSAGE = "�� �̸��� 5�� ���ϸ� �����մϴ�."
}