package racingcar

fun presetCars(carsNameInput: String): List<String> {
    // 입력받은 자동차들의 이름을 ,에 따라 구분하여 List에 저장
    val splitedCars = carsNameInput.split(",".toRegex()).toList()

    // 만약 이 중 글자 수가 5 이상인 자동차가 있다면 오류 반환
    repeat(splitedCars.size) {
        if (splitedCars[it].length >= 5)
            throw IllegalArgumentException()
    }

    // 이름에 따라 구분된 자동차가 들어가나 List 반환
    return splitedCars
}

fun checkValidInput(trialInput: String): Int {
    // 시도를 받을 정수형 trial
    val trial: Int

    // 정수형이 안되면 오류 반환
    if (trialInput.toIntOrNull() == null)
        throw IllegalArgumentException()

    // 정수형이 된다면 Int로 변환
    else
        trial = trialInput.toInt()

    // 이동 횟수가 1 이상의 정수가 아니라면 오류 반환
    if (trial < 0)
        throw  IllegalArgumentException()

    return trial
}
