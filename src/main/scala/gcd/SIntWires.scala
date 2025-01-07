package gcd

import chisel3._

class SIntWires(bitWidth: Int) extends RawModule {
  val in = IO(Input(SInt(bitWidth.W)))
  val out = IO(Output(SInt(bitWidth.W)))
  out := in
}
