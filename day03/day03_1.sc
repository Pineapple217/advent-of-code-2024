import scala.io.Source

val input = Source.fromFile("./input.txt").mkString("")
val result = input
  .sliding(12)
  .collect {
    case s if s.startsWith("mul(") =>
      val sSub = s.stripPrefix("mul(")
      val index = sSub.indexOf(")")
      if (index != -1) {
        val split = sSub.take(index).split(",")
        if (split.length == 2) {
          val Array(a, b) = split
          a.toInt * b.toInt
        } else 0
      } else 0
    case _ => 0
  }
  .sum

println(result)
