import scala.io.Source
import scala.util.Using

val lines = Using.resource(Source.fromFile("./input.txt")) { file =>
  file
    .getLines()
    .map(
      _.split("\\s+")
        .map(_.toInt)
        .toVector
    )
    .toVector
}

val result = lines
  .map(line => {
    val difs = line
      .sliding(2)
      .collect { case Seq(a, b) =>
        b - a
      }
      .toVector
    difs.forall(x => x.abs > 0 && x.abs <= 3) &&
    (difs.forall(_ > 0) || difs.forall(_ < 0))
  })
  .count(identity)

println(result)
