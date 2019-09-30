// Amrit Singh
// AddSub.v, 137 Verilog programming assignment #4
module TestMod;
   parameter STDIN = 32'h8000_0000;

   reg [7:0] str [1:3];
   reg [4:0] X, Y;

   wire [4:0] S;
   wire C5;

   Big_Adder my_adder(X, Y, S, C5);

   initial begin
      $display("Enter X:  ");
      str[1] = $fgetc(STDIN);
      str[2] = $fgetc(STDIN);
      str[3] = $fgetc(STDIN);

      X = (str[1]-48)*10+str[2]-48;
      $display("Enter Y:  ");
      str[1] = $fgetc(STDIN);
      str[2] = $fgetc(STDIN);
      str[3] = $fgetc(STDIN);

      Y = (str[1]-48)*10+str[2]-48;
      #1;
      $display("Enter either '+' or '-':");
      $display("X =%d (%b) Y =%d (%b) ", X, X, Y, Y);
      $display("Result=%d (%b)  C5 = %b", S, S, C5);
   end
endmodule
//big adder
module Big_Adder(X, Y, S, C5);
   input [4:0] X, Y;
   output [4 :0] S;
   output C5;

   wire C1, C2, C3, C4;
   FullAddMod Full_add_0(X[0], Y[0], 0, S[0], C1);
   FullAddMod Full_add_1(X[1], Y[1], C1, S[1], C2);
   FullAddMod Full_add_2(X[2], Y[2], C2, S[2], C3);
   FullAddMod Full_add_3(X[3], Y[3], C3, S[3], C4);
   FullAddMod Full_add_4(X[4], Y[4], C4, S[4], C5);
endmodule

//fulladder
module FullAddMod( X, Y, Cin, Sum,  Cout);
     input X, Y, Cin;
     output Sum, Cout;
     Parity_Mod myParity(X, Y, Cin, Sum);
     Majority_Mod myMajority(X, Y, Cin, Cout);
endmodule
// Majority mod
module Majority_Mod(X, Y, Cin, Cout);
        input X, Y, Cin;
        output Cout;
        wire [0:2] and_out;

        and(and_out[0], X, Y);
        and(and_out[1], X, Y);
        and(and_out[2], X, Y);
        or(Cout, and_out[0], and_out[1], and_out[2]);
endmodule
//parity mod
module Parity_Mod( X, Y,Cin, Sum);
     input  X, Y, Cin;
     output Sum;
     wire xxor;

     xor(xxor, X, Y);
     xor(Sum, xxor, Cin);
endmodule

