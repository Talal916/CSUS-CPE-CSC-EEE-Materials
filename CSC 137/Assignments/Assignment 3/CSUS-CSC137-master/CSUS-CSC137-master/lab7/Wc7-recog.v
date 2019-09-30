// Wc7-recog.v
// sequence recognizer, recognize input of "Wc7" by ouput match = 1
//
// compile: ~changw/ivl/bin/iverilog Wc7-recog.v
// run: ./a.out 

module TestMod;

   parameter STDIN = 32'h8000_0000; // keyboard-input file-handle address

   reg clk;
   reg [6:0] str [1:4];  // to what's to be entered
   wire match;           // to be set 1 when matched
   
   reg [6:0] ascii;      // each input letter is an ASCII bitmap

   RecognizerMod my_recognizer(clk, ascii, match);

   initial begin
      $display("Enter the the magic sequence: ");
      str[1] = $fgetc(STDIN);  // 1st letter
      str[2] = $fgetc(STDIN); // 2nd letter
      str[3] = $fgetc(STDIN); // 3rd letter

      $display("Time clk    ascii       match");
      $monitor("%4d   %b    %c %b   %b", $time, clk, ascii, ascii, match);

      clk = 0;

      ascii = str[1];
      #1 clk = 1; #1 clk = 0;
      ascii = str[2];
      #1 clk = 1; #1 clk = 0;
      ascii = str[3];
      #1 clk = 1; #1 clk = 0;
      
   end

endmodule



module RecognizerMod(clk, ascii, match);

   input clk;
   input [6:0] ascii;
   output match;

   wire [0:2] Q [6:0];   // 3-input sequence, 7 bits each
   wire [6:0] submatch;  // all bits matched (7 3-bit sequences)

   wire invQ60, invQ52, invQ41, invQ32, invQ31, invQ30; // inverted signals

   //         654 3210   Q
   //     hex binary
   // 'W' 57  101 0111 < q2
   // 'c' 63  110 0011 < q1
   // '7' 37  011 0111 < q0

   RippleMod Ripple6(clk, ascii[6], Q[6]);
   RippleMod Ripple5(clk, ascii[5], Q[5]);
   RippleMod Ripple4(clk, ascii[4], Q[4]);
   RippleMod Ripple3(clk, ascii[3], Q[3]);
   RippleMod Ripple2(clk, ascii[2], Q[2]);
   RippleMod Ripple1(clk, ascii[1], Q[1]);
   RippleMod Ripple0(clk, ascii[0], Q[0]);

   not(invQ60, Q[6][0]);
   not(invQ52, Q[5][2]);
   not(invQ41, Q[4][1]);
   not(invQ32, Q[3][2]);
   not(invQ31, Q[3][1]);
   not(invQ30, Q[3][0]);
   not(invQ21, Q[2][1]);   

   and(submatch[6], Q[6][2], Q[6][1], invQ60);
   and(submatch[5], invQ52, Q[5][1], Q[5][0]);
   and(submatch[4], Q[4][2], invQ41, Q[4][0]);
   and(submatch[3], invQ32, invQ31, invQ30);
   and(submatch[2], Q[2][2], invQ21, Q[2][0]);
   and(submatch[1], Q[1][2], Q[1][1], Q[1][0]);
   and(submatch[0], Q[0][2], Q[0][1], Q[0][0]);

   and(match, submatch[6], submatch[5], submatch[4], submatch[3], submatch[2], submatch[1], submatch[0]);

endmodule



module RippleMod(clk, ascii_bit, q);

   input clk, ascii_bit;
   output [0:2] q;

   reg [0:2] q;          // flipflops

   always @(posedge clk) begin
      q[0] <= ascii_bit;
      q[1] <= q[0];
      q[2] <= q[1];
   end

   initial q = 3'b000;

endmodule

