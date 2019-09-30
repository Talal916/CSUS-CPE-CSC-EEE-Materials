// Ryan Kozak
// CSC 137 Class #32509 
// 4th Programming Assignment
// AddSub.v
//
// compile: ~changw/ivl/bin/iverilog AddSub.v
// run: ./a.out


module TestMod;                     // the "main" thing
   
   parameter STDIN = 32'h8000_0000; // I/O address of keyboard input channel

   reg C0;              // 1 or 0 depending on user input
   reg [7:0] str [1:3]; // typing in 2 chars at a time (decimal # and Enter key)
   reg [4:0] X, Y;      // 5-bit X, Y to sum
   wire [4:0] S;        // 5-bit Sum to see as result
   wire C4, C5, E;      // like to know this as well from result of Add/Sub Mod.

   // instantiate the 5-bit addition/subtraction  module.
   AddSubMod  my_addsub(X, Y, S, C0, C4, C5, E);

   initial begin

      $display("Enter X (range 00 ~ 15):");
      str[1] = $fgetc( STDIN );      // get first character.  
      str[2] = $fgetc( STDIN );      // get second character.
      str[3] = $fgetc( STDIN );      // get enter key
      str[1] = str[1] - 48;          // convert ASCII representation to integer.
      str[2] = str[2] - 48;          // convert ASCII representation to integer.
      str[1] = str[1] * 10;          // multiply digit in tens place by ten.
      X = str[1] + str[2];           // add tens place and ones place for decimal value of X.

      $display("Enter Y (range 00 ~ 15):");
      str[1] = $fgetc( STDIN );      // get first character.  
      str[2] = $fgetc( STDIN );      // get second character.
      str[3] = $fgetc( STDIN );      // get enter key
      str[1] = str[1] - 48;          // convert ASCII representation to integer.
      str[2] = str[2] - 48;          // convert ASCII representation to integer.
      str[1] = str[1] * 10;          // multiply digit in tens place by ten.
      Y = str[1] + str[2];           // add tens place and ones place for deimcal value of Y.

      $display("Enter either '+' or '-':");
      str[1] = $fgetc( STDIN );      // get desired operation character

      if( str[1] == 45 ) // Subtract numbers
          C0 = 1;
      else // Add Numbers
          C0 = 0; 
      
      #1; // wait until Adder gets them processed

      $display("X=%b (%d) Y=%b (%d) C0=%d", X, X, Y, Y, C0);
      $display("Result=%b (as unsigned %d) ", S, S);
      $display("C4=%d C5=%d E=%d", C4, C5, E);
      if(E==0)
        $display("Since E is %d, C5 is not needed.", E);      
      else 
        $display("Since E is %d, correct with C5 in front: %d%b", E, C5, S);
   end

endmodule


module AddSubMod(X, Y, S, C0, C4, C5, E); // 5-Bit Adder/Subtractor

   input C0;            // 0 for add, 1 for subtract
   input [4:0] X, Y ;   // two 5-bit input items
   output [4:0] S;     // S should be similar
   output E, C4, C5;   // another output
   wire [0:5] c;       // declare temporary wires
   wire [0:4] xw;      // declare temporary wires off xor gates

   assign c[0] = C0;   // assign desired operation bit to input
   assign C4 = c[4];   // assign output to output wire of fourth full adder
   assign C5 = c[5];   // assign output to output wire of fifth full adder

   xor(xw[0], c[0], Y[0]); // First xor gate
   xor(xw[1], c[0], Y[1]); // Second xor gate
   xor(xw[2], c[0], Y[2]); // Third xor gate
   xor(xw[3], c[0], Y[3]); // Fourth xor gate
   xor(xw[4], c[0], Y[4]); // Fifth xor gate

   FullAdder fa1(X[0], xw[0], c[0], c[1], S[0]);  // get an instance of first adder, C0 is just hardcoded as 0
   FullAdder fa2(X[1], xw[1], c[1] ,c[2] ,S[1]); // get an instance of the second adder, carry in bit from first.
   FullAdder fa3(X[2], xw[2], c[2] ,c[3] ,S[2]); // get an instance of the third adder, carry in bit from second.
   FullAdder fa4(X[3], xw[3], c[3], c[4] ,S[3]); // get an instance of the fourth adder, carry in bit from third.
   FullAdder fa5(X[4], xw[4], c[4], c[5] ,S[4]);  // get an instance of the fifth adder , carry in bit from fourth.

   xor(E, c[4], c[5]); // Final xor output gate 

endmodule

module MajorityModule(x, y, c_in, c_out); //Majority Module Definition (carry out)

   input x, y, c_in; // inputs
   output c_out; // carry out (out put)

   wire [0:2] a_wire; // array of extra wires

   and(a_wire[0], x, y); // first and gate
   and(a_wire[1], x, c_in); // secoind and gate
   and(a_wire[2], y, c_in); // third and gate 

   or(c_out, a_wire[0], a_wire[1], a_wire[2]); // or gate to output

endmodule



module ParityModule(x, y, c_in, sum); // Parity Module Definition

   input x, y, c_in; // inputs
   output sum; // sum (out put)

   wire x_y; // extra wire

   xor(x_y, x, y); // first xor gate

   xor(sum, x_y, c_in); // second xor gate

endmodule


module FullAdder(x, y, c_in, c_out, sum); // Full Adder (FA)

   input x, y, c_in; // inputs
   output c_out, sum; // outputs

   MajorityModule my_mm (x, y, c_in, c_out); // declare majority module
   ParityModule my_pm (x, y, c_in, sum); // declare partiy module

endmodule

