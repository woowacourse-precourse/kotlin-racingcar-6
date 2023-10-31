package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.IllegalArgumentException

fun car_name_length(car_array: List<String>) {
    for (car_name in car_array) {
        //println(car_name)
        if (car_name.length > 5) //자동차의 길이 확인
            throw IllegalArgumentException("이름 길이 초과")
        else if (car_name.isBlank()) // ',' 이후 값을 적지 않았거나 아예 입력한 것이 없을 시
            throw IllegalArgumentException("이름 입력 오류")
        else if (car_name.contains(" "))// 자동차 이름에 공백 감지 시
            throw IllegalArgumentException("공백 입력 오류")
        //같은 모델의 차량이 존재할 수 있는 경우는 오류 대상에서 제외
    }
}

fun decide_winner(cars: Int, car_array: List<String>, count_array: IntArray): ArrayList<String> {
    var result = ArrayList<String>()
    var max: Int = 0 //가장 작은 값은 0이니 max 변수를 int 형 0으로 초기화

    for (i in 1..cars) {//차량의 갯수 만큼 반복
        if (count_array[i - 1] > max) {//이전 max값보다 큰 값 발견 시 result 리스트 초기화 후 값 추가
            max = count_array[i - 1]
            result.clear()
            result.add(car_array[i - 1])
        } else if (count_array[i - 1] == max) {// 현재 확인한 값과 max값이 같을 경우 result 리스트에 값 추가
            result.add(car_array[i - 1])
        }
    }
    return result
}

fun show_winner(result: ArrayList<String>) {
    print("최종 우승자 : ")

    for (i in 1..result.size) {
        if (i == result.size)//break 하지 않을 시 마지막에 ','이 추가로 출력되므로 break로 반복문 탈출
            break
        print("${result.get(i - 1)}, ")
    }

    print(result.get(result.size - 1))//가장 마지막에 있는 문자 출력
}

fun show_move(move_chance: Int, car_array: List<String>): IntArray {

    var cars = car_array.size
    var count_array = IntArray(cars)//자동차가 이동한 기록을 count하는 배열

    for (i in 1..move_chance) {
        var move_array = caculate_move(cars)//자동차가 이동이 가능한지 확인하는 함수로 자동차 순서에 맞게 move_array 배열에 1 혹은 0 을 저장한다
        count_array = plus_move(count_array, move_array, cars)//두 배열을 더해 count_array의 이동을 갱신시킨다.
        record_print(car_array, count_array, cars)//한번의 시도에 대한 결과 출력
    }
    return count_array
}

fun caculate_move(cars: Int): IntArray {
    var move_array = IntArray(cars)

    for (i in 1..cars) {
        var r_number = Randoms.pickNumberInRange(0, 9)//0~9 까지의 랜덤한 수를 변수에 저장
        if (r_number >= 4) {//랜덤 값이 4보다 클 시 한칸 전진할 수 있으므로 배열을 1로 만듦
            move_array[i - 1] = 1
        } else {//랜덤 값이 4보다 작을 시 전진할 수 없으므로 배열을 0으로 만듦
            move_array[i - 1] = 0
        }
    }
    return move_array//move_array에 반환
}

fun plus_move(count_array: IntArray, move_array: IntArray, cars: Int): IntArray {
    for (i in 1..cars) {//이동 기록 배열에 0 혹은 1을 더해 결과 반환
        count_array[i - 1] += move_array[i - 1]
    }
    return count_array
}

fun record_print(car_array: List<String>, count_array: IntArray, cars: Int) {
    for (i in 1..cars) {
        print("${car_array[i - 1]} : ")//자동차 순서에 맞게 이름 출력
        for (i in 1..count_array[i - 1]) {//count_array[현재 자동차의 이동량] 값 만큼 '-' 출력
            print("-")
        }
        println()
    }
    println()
}

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    var insert_car: String = Console.readLine()
    var car_array = insert_car.split(",") //입력 값을 ',' 기준으로 분리하여 car_array에 삽입 ex) po,bi 를 입력한 경우 idx : 0 => po , idx : 1 => bi
    car_name_length(car_array)// 입력 오류 확인
    println("시도할 횟수는 몇 회 인가요?")
    var move_chance = Console.readLine().toInt()

    println("\n실행 결과")
    var count_array = show_move(move_chance, car_array)//이동 기록을 출력 후 최종 이동량 반환
    var result = decide_winner(car_array.size, car_array, count_array)//우승자를 result ArrayList에 넣는 함수
    show_winner(result)//우승자를 출력하는 함수
}