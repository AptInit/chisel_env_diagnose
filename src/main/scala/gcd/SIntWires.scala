package gcd

import chisel3._

class SIntWires extends RawModule {
  val in = IO(Input(SInt(32.W)))
  val out = IO(Output(SInt(32.W)))
  out := in
}
