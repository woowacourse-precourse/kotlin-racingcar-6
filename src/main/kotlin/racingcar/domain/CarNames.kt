package racingcar.domain

import racingcar.io.Reader
import racingcar.utils.InputChecker

class CarNames(
    private val reader: Reader,
    private val inputChecker: InputChecker,
    private var nameList: List<String> = emptyList()
) {
    fun inputCarNames(): List<String> {
        nameList = inputChecker.checkInputNames(reader.readLine()).split(",")

        return nameList
    }

    fun getNameList(): List<String> = nameList
}