package gcd

import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class SIntWiresSpec extends AnyFreeSpec with Matchers {
  "SIntWires' output should be the same as input" in {
    simulate(new SIntWires) { dut =>
      val valueNearZero = for { v <- -3 to 5} yield v
      val valueNearMax = for {delta <- 0 to 3} yield Int.MaxValue-delta
      val valueNearMin = for {delta <- 0 to 3} yield Int.MinValue+delta
      val testValues = valueNearMin ++ valueNearZero ++ valueNearMax
      for (in <- testValues) {
        dut.in.poke(in)
        assert(dut.out.peek().litValue == in)
      }
    }
  }
}
