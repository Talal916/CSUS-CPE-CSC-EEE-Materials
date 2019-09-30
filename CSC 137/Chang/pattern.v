module TestMod;
   reg CLK;
   wire [0:12] Q;
   wire [6:0] C;

   initial begin
      #1;
    forever begin
      CLK = 0;
      #1;
      CLK = 1;
      #1;
    end
   end

   RippleMod my_ripple(CLK, Q);
   CoderMod my_coder(Q, C);

   initial #26 $finish;

   initial begin
      $display("Time   CLK     Q                Name  Hex  Binary");
      $monitor("%4d\t%b      %b    %c    %h   %b", $time, CLK, Q, C, C, C);

   end
endmodule

module CoderMod(Q, C);
   input  [0:12] Q;
   output [6:0] C;

   or(C[0], Q[1], Q[3], Q[7], Q[8], Q[9], Q[10]);
   or(C[1], Q[6], Q[8]);
   or(C[2], Q[0], Q[2], Q[4], Q[8], Q[11]);
   or(C[3], Q[2], Q[4], Q[6], Q[10]);
   or(C[4], Q[0], Q[8]);
   or(C[5], Q[1], Q[2],Q[3], Q[4], Q[5], Q[7], Q[8], Q[9], Q[10], Q[11], Q[12]);
   or(C[6], Q[0], Q[1],Q[2], Q[3], Q[4], Q[6], Q[7], Q[8], Q[9], Q[10], Q[11]);

endmodule

module RippleMod(CLK, Q);
   input CLK;
   output [0:12]Q;

   reg [0:12]Q;


   always @(CLK) begin
      Q[0]  <=  Q[12];
      Q[1]  <=  Q[0];
      Q[2]  <=  Q[1];
      Q[3]  <=  Q[2];
      Q[4]  <=  Q[3];
      Q[5]  <=  Q[4];
      Q[6]  <=  Q[5];
      Q[7]  <=  Q[6];
      Q[8]  <=  Q[7];
      Q[9]  <=  Q[8];
      Q[10] <=  Q[9];
      Q[11] <=  Q[10];
      Q[12] <=  Q[11];
 end

  initial Q = 13'b1000000000000;
endmodule