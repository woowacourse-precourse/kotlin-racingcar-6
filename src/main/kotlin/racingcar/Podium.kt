package racingcar

fun showWinners(carsList: List<String>, carsLocation: List<Int>) {
    // 최종 우승자 메시지 출력
    print("최종 우승자 : ")

    // 최대 값 (우승자의 거리) 추출
    val max = carsLocation.max()
    repeat(carsList.size) {
        if (it > 0)
            print(", ")

        // 최대 값과 거리가 같다면 출력
        if (carsLocation[it] == max)
            print(carsList[it])
    }
}