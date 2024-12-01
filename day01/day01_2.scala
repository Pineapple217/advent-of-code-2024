import scala.io.Source
import scala.util.Using

object Main extends App {
    val lines = Using.resource(Source.fromFile("./input.txt")) { file =>
        file.getLines().toVector
    }

    val (input1, input2) = lines.map { line =>
        val Array(first, second) = line.split(" {3}").map(_.trim.toInt)
        (first, second)
    }.unzip

    val countMap = input2.groupBy(identity).view.mapValues(_.size).toMap
    val result = input1.map(num => num * countMap.getOrElse(num, 0)).sum

    println(result)
}