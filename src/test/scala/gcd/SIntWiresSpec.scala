package gcd

import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class SIntWiresSpec extends AnyFreeSpec with Matchers {
  "SIntWires' output should be the same as input" in {
    for (bitWidth <- 2 until 8) {
      simulate(new SIntWires(bitWidth)) { dut =>
//        val valueNearZero = for { v <- -3 to 5} yield v
//        val valueNearMax = for {delta <- 0 to 3} yield Int.MaxValue-delta
//        val valueNearMin = for {delta <- 0 to 3} yield Int.MinValue+delta
//        val testValues = valueNearMin ++ valueNearZero ++ valueNearMax
        val in = BigInt(-1)<<(bitWidth-1)
        dut.in.poke(in)
        assert(dut.out.peek().litValue == in)
      }
    }
  }
}
