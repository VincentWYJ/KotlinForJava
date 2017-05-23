import org.jetbrains.annotations.Mutable

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

    println(list.none { it % 2 == 10 })

    println(list.reduce { total, next -> total + next })
    println(list.reduceRight { total, next -> total + next })

    println(list.sumBy { it % 2 })
}

/** 注意：slice()会出现下标越界异常 */
fun filterTest(list: List<Int>) {
    println(list.drop(4))
    println(list.dropWhile { it < 9 })
    println(list.dropLastWhile { it < 9 })

    println(list.filter { it % 2 == 0 })
    println(list.filterNot { it % 2 == 0 })
    println(list.filterNotNull())

    println(list.slice(listOf(0, 4, 8)))
    //println(list.slice(listOf(0, 4, 80)))  //java.lang.ArrayIndexOutOfBoundsException: 80

    println(list.take(2))
    println(list.takeLast(2))
    println(list.takeWhile { it < 3 })
}

fun mapTest(list: List<Int>) {
    println(list.flatMap { listOf(it, it + 1) })

    println(list.groupBy { if (it % 2 == 0) "even" else "odd" })

    println(list.map { it * 2 })
    println(list.mapIndexed { index, it -> index * it })
    println(list.mapNotNull { it * 2 })
}

/** 注意：elementAt()等会出现下标越界异常 */
fun elementTest(list: List<Int>) {
    println(list.contains(2))

    println(list.elementAt(1))
    //println(list.elementAt(11))  //java.lang.ArrayIndexOutOfBoundsException: 11
    println(list.elementAtOrElse(10, { 2 * it }))
    println(list.elementAtOrNull(10))

    println(list.first { it % 2 == 0 })
    //println(list.first { it % 2 == 10 })  //java.util.NoSuchElementException: Collection contains no element matching the predicate
    println(list.firstOrNull() { it % 2 == 10 })

    println(list.indexOf(4))
    println(list.indexOfFirst { it % 2 == 0 })
    println(list.indexOfLast { it % 2 == 0 })

    println(list.last { it % 2 == 0 })
    //println(list.last { it % 2 == 10 })  //java.util.NoSuchElementException: List contains no element matching the predicate
    println(list.lastIndexOf(5))
    println(list.lastOrNull { it % 2 == 10 })

    println(list.single { it % 6 == 5 })
    //println(list.single { it % 2 == 0 })  //java.lang.IllegalArgumentException: Collection contains more than one matching element
    println(list.singleOrNull() { it % 5 == 10 })
}

/** 注意：merge()已经从Kotlin 1.0 Beta 2后的版本弃用 */
fun productTest(list: List<Int>) {
    println(list.partition { it % 2 == 0 })

    println(list + listOf(10, 11))

    println(list.zip(listOf(7, 8)))
    println(listOf(Pair(5, 7), Pair(6, 8)).unzip())
}

/** 注意：sort()返回值为Unit，sorted()才是结果List，其他类似 */
fun sortTest(list: MutableList<Int>) {
    println(list.reversed())

    println(list.sorted())
    println(list.sortedBy {it % 3})

    println(list.sortedDescending())
    println(list.sortedByDescending { it % 3 })
}

fun main(args: Array<String>) {
    println("Kotlin入门第一课：集合")

    val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val mutableList = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    println("\n" + "1. 总数操作：")
    sumTest(list)

    println("\n" + "2. 过滤操作：")
    filterTest(list)

    println("\n" + "3. 映射操作：")
    mapTest(list)

    println("\n" + "4. 元素操作：")
    elementTest(list)

    println("\n" + "5. 生产操作：")
    productTest(list)

    println("\n" + "6. 排序操作：")
    sortTest(mutableList)
}