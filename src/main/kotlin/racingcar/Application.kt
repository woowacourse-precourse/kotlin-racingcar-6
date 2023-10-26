package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.IllegalArgumentException

fun car_name_length(array : List<String>){

    for(car_name in array){
        //println(car_name)
        if(car_name.length > 5) //자동차의 길이 확인
            throw IllegalArgumentException("입력 오류")
        else if(car_name.isBlank()) // ',' 이후 값을 적지 않았거나 띄어져 있을 경우의 오류 확인
            throw IllegalArgumentException("입력 오류")
    }
}
fun start(){
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    var insert_car : String = Console.readLine()
    var array = insert_car.split(",") //입력 값을 ',' 기준으로 분리

    car_name_length(array)

    println("시도할 횟수는 몇 회 인가요?")
    var N = Console.readLine().toInt()

    println("\n실행 결과")
    move(N,array)
}

fun move(move_chance : Int,array: List<String>){

    var cars = array.size
    var count_array = IntArray(cars)//자동차가 이동한 기록을 count하는 배열

    for (i in 1..move_chance){
        var rand_array = random_number(cars)//자동차가 이동이 가능한지 확인하는 배열으로 가능하면 1 불가능하면 0 을 저장한다
        count_array = plus_move(count_array,rand_array,cars)//두 배열을 더해서 기록을 갱신시킨다.
        record_print(array,count_array,cars)
    }

    var result = ArrayList<String>()
    var max : Int = 0

    for(i in 1..cars){
        if(count_array[i-1] > max){
            max = count_array[i-1]
            result.clear()
            result.add(array[i-1])
        }else if(count_array[i-1] == max){
            result.add(array[i-1])
        }
    }

    print("최종 우승자 : ")

    for(i in 1..result.size){
        if(i == result.size)
            break
        print("${result.get(i-1)}, ")
    }

    print(result.get(result.size-1))
}

fun random_number(cars: Int): IntArray {
    var  count_array = IntArray(cars)

    for(i in 1..cars){
        count_array[i-1] = Randoms.pickNumberInRange(0,9)
    }

//    for(i in 1..cars){
//        print("${count_array[i-1]},")
//    }
//    println()

    decide_move(count_array)

    return count_array
}

fun decide_move(count_array: IntArray) : IntArray{

    for(i in 1..count_array.size){
        if(count_array[i-1] >= 4){
            count_array[i-1] = 1 //1은 갈수 있다
        }else{
            count_array[i-1] = 0 //0은 갈수 없다
        }
    }

//    for(i in 1..count_array.size){
//        print("${count_array[i-1]},")
//    }
//    println()


    return count_array
}

fun plus_move(count_array: IntArray,rand_array: IntArray,cars : Int) : IntArray{

    for(i in 1..cars){
        count_array[i-1] += rand_array[i-1]
    }
    return count_array
}

fun record_print(array: List<String>, count_array: IntArray,cars: Int){
    for(i in 1..cars){
        print("${array[i-1]} : ")
        for(i in 1..count_array[i-1]){
            print("-")
        }
        println()
    }
    println()
}

fun main(){
    start()
}