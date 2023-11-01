package racingcar
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.Console.readLine
fun main() {
    // TODO: 프로그램 구현

    //val input = "1,2"
    //val result = input.split(",")
    //print(result[0])
    //print(result[1])

    var result3= inputname2()
    println(result3)

    var numofperson = result3.size

    var persondata = individualdatainit(numofperson, result3 )

    println(persondata)
    var runnum = inputnum2()
    println("runnum:"+runnum)

    var temp = 0

    while(temp < runnum)
    {
        persondata = individualdata(numofperson, persondata)
        temp++
    }
    var winnerlist = mutableListOf<String>()
    for(item in persondata) {
        println(item.name +":"+ item.data)
        if (item.data == runnum)
        {
            //println("최종우승자:"+item.name)
            winnerlist.add(item.name)
        }
    }
    printdata(persondata)
    print("최종우승자: ")
    for(item in winnerlist){
        println(item+" ")
    }


}
/*
fun inputnum(num:Int) : Unit{

    println("inputname:"+num)
}

fun inputname(arr:List<String>) : List<String>
{
    println("arr size:"+arr.size)
    for(item:String in arr)
    {
        println("item:"+item)
    }
    return arr
}
*/
fun inputname2() : List<String>
{
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    var input2 = readLine()
    println("input2:"+input2)
    var result2 = input2.split(",")
    //print(result2[0])
    //print(result2[1])
    println(result2)
    return result2
}

fun inputnum2() : Int{
    println("시도할 횟수")
    val runnum = readLine()!!.toInt()
    println("runnum:"+runnum)
    return runnum
}



fun individualdatainit(nnum: Int, listofname :List<String>) : MutableList<Person>
{
    var numtemp = 0
    var persondata = mutableListOf<Person>()
    while(numtemp!=nnum)
    {
        persondata.add(Person(listofname[numtemp],0))
        numtemp++
    }
    /*
    var data = 0
    data = pickNumberInRange(0,9)
    println("data:"+data)
    */
    /*
    numtemp = nnum
    while(numtemp!=0)
    {
        println(persondata[numtemp-1].data)
        println(persondata[numtemp-1].name)
        numtemp--
    }*/

    return persondata
}
fun individualdata(nnum: Int ,personlist: MutableList<Person>): MutableList<Person>
{
    var numtemp = 0

    while(numtemp < nnum)
    {
        var data = pickNumberInRange(0,9)
        //println("data :" + data)
        if(data>=4) {
            personlist[numtemp].data ++;
        }
        numtemp++
    }
    printdata(personlist)
    return personlist



}
class Person constructor(name: String, data:Int)
{
    var name: String =""
    var data: Int =0

    init
    {
        this.name = name
        this.data = data
    }
}

fun printdata(personlist: MutableList<Person>)
{
    var temp = 0
    for(item:Person in personlist)
    {
        print(item.name+":")
        while(temp <item.data)
        {
            print("-")
            temp++
        }
        println()
        temp=0

    }
}