// Ryan Kozak 
// CSC137 Class #32509
// 5th Programming Assignment
//
// count4.v, ripple counter
// compile: ~changw/ivl/bin/iverilog count4.v
// run: ./a.out 

module TestMod;

   reg CLK;
   wire [0:3] Q;
   wire [1:0] C; 

   always begin // this is clock wave
      CLK = 0;  // 0 for half cycle (#1)
      #1;
      CLK = 1;  // 1 for half cycle (#1)
      #1;
   end

   RippleMod my_ripple(CLK, Q);
   CoderMod my_coder(Q, C);

   initial #16 $finish;

   initial begin
      $display("Time\tCLK\tQ\tC");
      $monitor("%4d\t%3d\t%b\t%b", $time, CLK, Q, C);
   end
endmodule



module CoderMod(Q, C);

   input [0:3] Q;
   output [1:0] C;

   or(C[0], Q[1], Q[3]);
   or(C[1], Q[2], Q[3]);

endmodule



module RippleMod(CLK, Q);
  
 input CLK;
   output [0:3] Q;

   reg [0:3] Q;

   always @(posedge CLK) begin
      Q[0] <= Q[3];
      Q[1] <= Q[0];
      Q[2] <= Q[1];
      Q[3] <= Q[2];
   end

   initial begin // here we conveniently set flipflops to 1000 (binary)
      Q[0] = 1;
      Q[1] = 0;
      Q[2] = 0;
      Q[3] = 0;
   end
endmodule

