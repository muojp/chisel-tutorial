Chisel Tutorials
================

These are the tutorials for [Chisel](https://github.com/ucb-bar/chisel3).

Chisel is an open-source hardware construction language developed
at UC Berkeley that supports advanced hardware design using highly
parameterized generators and layered domain-specific hardware languages.

Visit the [community website](http://chisel.eecs.berkeley.edu/) for more
information.


Getting the Repo
----------------
Follow the instructions for installing Chisel3 in the README at
(https://github.com/ucb-bar/chisel-tutorial.git).  

    $ git clone https://github.com/ucb-bar/chisel-tutorial.git


Executing Chisel
----------------

####Testing Your System
First make sure the prerequisites are installed. These include make, gcc
and [sbt](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html).

    $ cd hello
    $ sbt run

This will generate and test a simple block (`Hello`) that always outputs the
number 42. You should see `[success]` on the last line of output (from sbt) and
`PASSED` on the line before indicating the block passed the testcase. If you
are doing this for the first time, sbt will automatically download the
appropriate versions of Chisel3, the Chisel Testers harness
and Scala and cache them (usually in `~/.ivy2`).


####Manual Execution
`(available only in Chisel2)`
[//]: # (Will we support any of these things in Chisel3)

The make recipe above automically invoked sbt to use Chisel's C backend to
generate a C emulator and ran it against the testcase. To do it mannually:

    $ sbt "run Hello --backend c --compile --test --genHarness"

To generate a waveform (`Hello.vcd`) of the testcase execution:

    $ sbt "run Hello --backend c --compile --test --genHarness --vcd"

To generate Verilog instead of a C emulator:

    $ sbt "run Hello --backend v --genHarness"


Completing the Tutorials
------------------------
`If you are using Chisel2, please read the documentaion in README-CHISEL2.md`

To learn Chisel, we recommend learning by example and just trying things out.
To help with this, we have produced exercises (`/problems`) which have clearly
marked places to complete their functionality and simple test cases. You can
compare your work with our sample solutions (`/solutions`).

To speed things up, we will keep sbt running. To get started:

    $ cd problems
    $ sbt

#### Mux2
This should already work. Try

    > run Mux2

#### Mux4
You can instantiate a module with `val foo = Module(new Bar())`

    > run Mux4

#### Counter
You can conditionally update a value without a mux by using `when (cond) { foo := bar }`

    > run Counter

#### Vending Machine

    > run VendingMachine

#### Memo
The type of memory that's inferred is based on how you handle the read and
write enables. This is pretty much the same as how Xilinx and Altera infer
memories.

    > run Memo

#### Mul

    > run Mul

#### RealGCD

    > run RealGCD

How these tutorials work
------------------------
Each of the directories `(problems, solutions and examples)` is an independent
sbt module with it's own `build.sbt` configuration file and `Launcher.scala` which contains
the only main() in any of the scala files.  `sbt` looks for a main defined anywhere in the directory.
If there is only one it runs it.  Which is how Launcher is used.  If you create another main sbt
will offer a menu asking which main to run.  This will complicate the above examples.


Learning More Chisel
--------------------
In addition to the problems and the solutions, we have also provided some
examples of more complex circuits (`/examples`). You should take a look at the
source and test them out:

    $ cd examples
    $ make

On our [website](http://chisel.eecs.berkeley.edu/) we also have posted
[documentation](https://chisel.eecs.berkeley.edu/documentation.html).
