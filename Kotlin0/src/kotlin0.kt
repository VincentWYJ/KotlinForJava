/**
 * Created by Dylan on 2017/5/19.
 */

/** 1 数据类定义 */
/*
public class Artist {
    private long id;
    private String name;
    private String blog;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    @Override public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blog='" + blog + '\'''}';
    }
}
*/

data class Artist(
        var id: Long,
        var name: String,
        var blog: String)

fun testArtist() {
    var artist = Artist(1, "Dylan", "http://www.cnblogs.com/tgyf/")
    println("artist info: " + "id: " + artist.id + ", name: " + artist.name + ", blog: " + artist.blog)
    println("artist.toString(): " + artist.toString())
}

/** 2 变量空安全 */
fun testNull() {
    //var str1: String = null  //Null can not be a value of a non-null type String

    var str2: String? = null  //str2 can be null
    println("str2?.length: " + str2?.length)  //print length if str2 is nun-null, else print 'null'
    //println(str2!!.length)  //Exception in thread "main" kotlin.KotlinNullPointerException
    if (str2 != null) {
        println("str2!!.length: " + str2!!.length)
    }
    str2 = "testNull"
    println("str2.length: " + str2.length)
    println("str2?.length: " + str2?.length)
    println("str2!!.length: " + str2!!.length)

    var str3 = "testNull"
    println("assign directly: " + str3)
}

/** 3 类方法扩展 */
fun String.printStr(str: String) {
    println("printStr: " + str)
}

fun testExtend() {
    var str = "testExtend"
    str.printStr(str)
}

fun main(args: Array<String>) {
    println("Hello World")
    println()

    testArtist()
    println()

    testNull()
    println()

    testExtend()
}