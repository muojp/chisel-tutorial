package examples

import Chisel._
import Chisel.testers._

class Functionality extends Module {
  val io = new Bundle {
    val x   = Bits(INPUT,  16)
    val y   = Bits(INPUT,  16)
    val z   = Bits(OUTPUT, 16)
  }
  def clb(a: UInt, b: UInt, c: UInt, d: UInt) =
    (a & b) | (~c & d)
  io.z := clb(io.x, io.y, io.x, io.y)
}

class FunctionalityUnitTester extends UnitTester {
  val c = Module(new Functionality)
  val maxInt = 1 << 16
  for (i <- 0 until 10) {
    val x = rnd.nextInt(maxInt)
    val y = rnd.nextInt(maxInt)
    poke(c.io.x, x)
    poke(c.io.y, y)
    expect(c.io.z, (x & y) | (~x & y))
    step(1)
  }
  install(c)
}
