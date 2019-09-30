// Ryan Kozak 
// CSC137 Class #32509
//
// 7th Programming Assignment
// sequence recognizer, recognize input of "Ryan " (must include trailing
// space) by output match = 1
//
// compile: ~changw/ivl/bin/iverilog name-recog.v
// run: ./a.out 

module TestMod;
   parameter STDIN = 32'h8000_0000; // keyboard-input file-handle address

   reg clk;
   reg [6:0] str [1:5];  // to what's to be entered
   wire match;           // to be set 1 when matched
   reg [6:0] ascii;      // each input letter is an ASCII bitmap

   RecognizerMod my_recognizer(clk, ascii, match);

   initial begin
      $display("Enter the 1st 5 letters in your fullname (e.g., 'Ryan '): ");
      str[1] = $fgetc(STDIN);  // 1st letter R
      str[2] = $fgetc(STDIN); // 2nd letter  y
      str[3] = $fgetc(STDIN); // 3rd letter  a
      str[4] = $fgetc(STDIN); // 4th letter  n
      str[5] = $fgetc(STDIN); // 5th letter  (space)

      $display("Time clk    ascii       match");
      $monitor("%4d   %b    %c %b   %b", $time, clk, ascii, ascii, match);

      clk = 0;

      ascii = str[1];
      #1 clk = 1; #1 clk = 0;
      ascii = str[2];
      #1 clk = 1; #1 clk = 0;		
      ascii = str[3];
      #1 clk = 1; #1 clk = 0;
      ascii = str[4];
      #1 clk = 1; #1 clk = 0;
      ascii = str[5];
      #1 clk = 1; #1 clk = 0;
  end
endmodule

module RecognizerMod(clk, ascii, match);
   input clk;
   input [6:0] ascii;
   output match;

   wire [0:4] Q [6:0];   // 5-input sequence, 7 bits each (reversed from example)
   wire [6:0] submatch;  // all bits matched (7 5-bit sequences)

   wire invQ60, invQ54, invQ42,  // Inverted wires
        invQ41, invQ40, invQ34, 
        invQ32, invQ30, invQ24, 
        invQ23, invQ22, invQ20, 
        invQ13, invQ12, invQ10, 
        invQ04, invQ01, invQ00;
   
   RippleMod Ripple6(clk, ascii[6], Q[6]);
   RippleMod Ripple5(clk, ascii[5], Q[5]);
   RippleMod Ripple4(clk, ascii[4], Q[4]);
   RippleMod Ripple3(clk, ascii[3], Q[3]);
   RippleMod Ripple2(clk, ascii[2], Q[2]);
   RippleMod Ripple1(clk, ascii[1], Q[1]);
   RippleMod Ripple0(clk, ascii[0], Q[0]);

   not(invQ60, Q[6][0]);
   not(invQ54, Q[5][4]);
   not(invQ42, Q[4][2]);
   not(invQ41, Q[4][1]);
   not(invQ40, Q[4][0]);
   not(invQ34, Q[3][4]);
   not(invQ32, Q[3][2]);
   not(invQ30, Q[3][0]);
   not(invQ24, Q[2][4]);
   not(invQ23, Q[2][3]);
   not(invQ22, Q[2][2]);
   not(invQ20, Q[2][0]);
   not(invQ13, Q[1][3]);
   not(invQ12, Q[1][2]);
   not(invQ10, Q[1][0]);
   not(invQ04, Q[0][4]);
   not(invQ01, Q[0][1]);
   not(invQ00, Q[0][0]);
   
   and(submatch[6], Q[6][4], Q[6][3], Q[6][2], Q[6][1], invQ60);
   and(submatch[5], invQ54, Q[5][3], Q[5][2], Q[5][1], Q[5][0]);
   and(submatch[4], Q[4][4], Q[4][3], invQ42, invQ41, invQ40);
   and(submatch[3], invQ34, Q[3][3], invQ32, Q[3][1], invQ30);
   and(submatch[2], invQ24, invQ23, invQ22, Q[2][1], invQ20);
   and(submatch[1], Q[1][4], invQ13, invQ12, Q[1][1], invQ10);
   and(submatch[0], invQ04, Q[0][3], Q[0][2], invQ01, invQ00);
  
   and(match, submatch[6], submatch[5], submatch[4], submatch[3], submatch[2], submatch[1], submatch[0]);
endmodule

module RippleMod(clk, ascii_bit, q);
   input clk, ascii_bit;
   output [0:4] q;
   reg [0:4] q;          // flipflops

   always @(posedge clk) begin
      q[0] <= ascii_bit;
      q[1] <= q[0];
      q[2] <= q[1];
      q[3] <= q[2];
      q[4] <= q[3];
   end

   initial q = 5'b00000;
endmodule
