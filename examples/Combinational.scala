package examples

import Chisel._
import Chisel.testers._

class Combinational extends Module {
  val io = new Bundle {
    val x   = UInt(INPUT,  16)
    val y   = UInt(INPUT,  16)
    val z   = UInt(OUTPUT, 16)
  }
  io.z := io.x + io.y
}

class CombinationalUnitTester extends UnitTester {
  val c = Module(new Combinational)
  val maxInt = 1 << 16
  for (i <- 0 until 10) {
    val x = rnd.nextInt(maxInt)
    val y = rnd.nextInt(maxInt)
    poke(c.io.x, x)
    poke(c.io.y, y)
    expect(c.io.z, (x + y)&(maxInt-1))
    step(1)
  }
  install(c)
}

