val product = (x: Int, y: Int) => {
  val result = x * y
  println(s"x=$x, y=$y, result=$result")
  result
}

val a = Array(1,2,3)
a.scanLeft(10)(product)
a.foldLeft(1)( (x: Int, y: Int) => x * y )
