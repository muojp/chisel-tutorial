package problems

import Chisel._
import Chisel.hwiotesters._

class Max2 extends Module {
  val io = new Bundle {
    val in0 = UInt(INPUT,  8)
    val in1 = UInt(INPUT,  8)
    val out = UInt(OUTPUT, 8)
  }
  io.out := Mux(io.in0 > io.in1, io.in0, io.in1)
}

class Max2Tests extends SteppedHWIOTester {
  val device_under_test = Module(new Max2)
  val c = device_under_test
  enable_all_debug = true

  for (i <- 0 until 10) {
    // FILL THIS IN HERE
    poke(c.io.in0, 0)
    poke(c.io.in1, 0)
    // FILL THIS IN HERE
    step(1)
    expect(c.io.out, 1)
  }

}
