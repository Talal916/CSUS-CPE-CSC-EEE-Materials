// Ryan Kozak 
// CSC137 Class #32509
// 6th Programming Assignment
//
// pattern.v, Pattern Generator
// compile: ~changw/ivl/bin/iverilog pattern.v
// run: ./a.out 

module TestMod;

   reg CLK;
   wire [0:10] Q;
   wire [6:0] ascii; 

   always begin
      #1; // As the example shows, CLK is initially x
      CLK = 1;
      #1;
      CLK = 0;
   end

   RippleMod my_ripple(CLK, Q);
   PatternEncoder my_encoder(Q, ascii);

   initial #25 $finish;

   initial begin
      $display("Time\tCLK\tQ\t\tName");
      $monitor("%4d\t%3d\t%b\t%c %h %b", $time, CLK, Q, ascii, ascii, ascii);
   end
endmodule



module PatternEncoder(Q, ascii);

   input [0:10] Q;
   output [6:0] ascii;

   or(ascii[6], Q[0], Q[1], Q[2], Q[3], Q[5], Q[6], Q[7], Q[8], Q[9]);
   or(ascii[5], Q[1], Q[2], Q[3], Q[4], Q[6], Q[7], Q[8], Q[9], Q[10]);
   or(ascii[4], Q[0], Q[1], Q[7]);
   or(ascii[3], Q[1], Q[3], Q[5], Q[6], Q[7], Q[9]);
   or(ascii[2], Q[3], Q[6]);
   or(ascii[1], Q[0], Q[3], Q[5], Q[6], Q[7], Q[9]);
   or(ascii[0], Q[1], Q[2], Q[5], Q[6], Q[8], Q[9]);


endmodule



module RippleMod(CLK, Q);
  
 input CLK;
   output [0:10] Q;
   reg [0:10] Q;

   always @(CLK) begin
      Q[0]  <= Q[10];
      Q[1]  <= Q[0];
      Q[2]  <= Q[1];
      Q[3]  <= Q[2];
      Q[4]  <= Q[3];
      Q[5]  <= Q[4];
      Q[6]  <= Q[5];
      Q[7]  <= Q[6];
      Q[8]  <= Q[7];
      Q[9]  <= Q[8];
      Q[10] <= Q[9];
   end

   initial begin
      Q[0]  = 1;
      Q[1]  = 0;
      Q[2]  = 0;
      Q[3]  = 0;
      Q[4]  = 0;
      Q[5]  = 0;
      Q[6]  = 0;
      Q[7]  = 0;
      Q[8]  = 0;
      Q[9]  = 0;
      Q[10] = 0;
   end
endmodule

