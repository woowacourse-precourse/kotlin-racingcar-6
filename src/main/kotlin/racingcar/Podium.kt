package racingcar

fun showWinners(carsList: List<String>, carsLocation: List<Int>) {
    // 최종 우승자 메시지 출력
    print("최종 우승자 : ")

    var printed = false

    // 최대 값 (우승자의 거리) 추출
    val max = carsLocation.max()
    repeat(carsList.size) {
        // 최대 값과 거리가 같다면 출력
        if (carsLocation[it] == max) {

            // 앞에 이미 출력된게 있다면 ,를 넣는다
            if (printed == true)
                print(", ")

            print(carsList[it])
            printed = true
        }
    }
}