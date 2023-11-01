package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException
import kotlin.math.max


class inputtype(carlist: List<String> , trial : Int){
    var carlist :List<String> = carlist
    var trial: Int = trial

}//사용자 입력 타입
fun main() {
    val userinfo = user_input()
    play(userinfo)

}
fun play(input: inputtype){
    var totalscore = IntArray(input.carlist.size)
    println("실행 결과")
    for(i : Int in 1..input.trial)
    {
        val gamescore = game_detail(input.carlist)
        totalscore = aggregate_score(totalscore,gamescore)
        print_game(input.carlist,totalscore)
    }
    total_score_print(input.carlist,totalscore)

}//게임 전체를 관장

fun total_score_print(carlist: List<String>, totalscore: IntArray){
    var max_tmp = 0
    var k = 0
    for(i : Int in 0 until totalscore.size)
    {
        if(totalscore[i]>max_tmp){
            max_tmp = totalscore[i]
        }

    }
    print("최종 우승자 :")
    for(i : Int in 0 until totalscore.size){
        if((totalscore[i] == max_tmp)&&(k == 0))
        {
            print(" ${carlist[i]}")
            k = 1
        }
        else if((totalscore[i] == max_tmp)&&(k == 1))
        {
            print(", ${carlist[i]}")
        }
    }

}// 모든 게임이 끝난 후 최종 결과 출력
fun game_detail(carlist: List<String>) : IntArray {
    var score = IntArray(carlist.size,{0})
    for (i : Int in 1 .. score.size){
        when(random_number()) {
            in 4 .. 9 -> score[i-1] = 1
        }
    }
    return score
}//게임의 한 사이클을 담당
fun aggregate_score(totalscore: IntArray , gamescore : IntArray) : IntArray{
    for(i : Int in 0 until totalscore.size)
    {
        totalscore[i] += gamescore[i]
    }
    return totalscore

}// 게임이 끝날 때마다 스코어 집계
fun print_game(carlist : List<String> , totalscore:IntArray){
    for (i : Int in 0 until totalscore.size)
    {
        print("${carlist[i]} : ")
        for(k : Int in 1..totalscore[i])
        {
            print("-")
        }
        println("")
    }
    println("")

}//각 게임의 결과 출력
fun random_number() : Int{
    return Randoms.pickNumberInRange(0, 9)
}// 0~9의 랜덤 난수 발생
fun user_input() : inputtype{
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val tmp =Console.readLine()
    val carlist = tmp.split(",")
    for(i : Int in 0 until carlist.size)
    {
        if(carlist[i].length>=5)
        {
            throw IllegalArgumentException("이름에 대한 예외 처리")

        }
    }
    println("시도할 횟수는 몇 회인가요?")
    val trial = Console.readLine().toInt()
    val returntype = inputtype(carlist,trial)
    return returntype
}//사용자의 입력 관리 -> carlist & trial 반환
