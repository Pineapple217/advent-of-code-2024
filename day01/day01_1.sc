import scala.io.Source
import scala.util.Using

val lines = Using.resource(Source.fromFile("./input.txt")) { file =>
  file.getLines().toVector
}

val (input1, input2) = lines.map { line =>
  val Array(first, second) = line.split(" {3}").map(_.trim.toInt)
  (first, second)
}.unzip

val result = input1.sorted
  .zip(input2.sorted)
  .map { case (a, b) => (a - b).abs }
  .sum

println(result)
