/**
 * Created by Dylan on 2017/5/22.
 */

fun sumTest(list: List<Int>) {
    println(list.any { it % 2 == 1 })

    println(list.all { it % 2 == 1 })

    println(list.count { it % 2 == 1 })

    println(list.fold(10) { total, next -> total + next })
    println(list.foldRight(10) { total, next -> total + next })

    list.forEach { value -> if (value > 8) println(value) }
    list.forEachIndexed { index, value -> if (value > 8) println("value of index $index is $value") }

    println(list.max())
    println(list.maxBy { -it })

    println(list.min())
    println(list.minBy { -it })

    println(list.none { it % 10 == 0 })

    println(list.reduce { total, next -> total + next })
    println(list.reduceRight { total, next -> total + next })

    println(list.sumBy { it % 2 })
}

fun filterTest(list: List<Int>) {
    println(list.drop(4))
    println(list.dropWhile { it < 9 })
    println(list.dropLastWhile { it < 9 })

    println(list.filter { it % 2 == 0 })
}

fun main(args: Array<String>) {
    println("Kotlin1")

    val list = listOf(1, 3, 5, 7, 9, 2, 4, 6, 8)

    //1 总数操作符
    sumTest(list)

    //2 过滤操作符
    filterTest(list)
}