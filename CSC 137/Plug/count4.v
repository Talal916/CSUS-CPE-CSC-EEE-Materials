
module TestMod;
   reg CLK;
   wire Q0, Q1, Q2, Q3, C1, C0;

   always begin // this is clock wave
      CLK = 0;  // 0 for half cycle (#1)
      #1;
      CLK = 1;  // 1 for half cycle (#1)
      #1;
   end

   RippleMod my_ripple(CLK, Q0, Q1, Q2, Q3);
   CoderMod my_coder(Q0, Q1, Q2, Q3, C1, C0);

   initial #16 $finish;

   initial begin
      $display("Q0 Q1 Q2 Q3 C1 C0");
      $monitor("%b %b %b %b %b %b",Q0, Q1, Q2, Q3, C1, C0);
   end
endmodule

module CoderMod(Q0, Q1, Q2, Q3, C1, C0);
   input Q0, Q1, Q2, Q3;
   output C0, C1;
   or(C1, Q2, Q3);
   or(C0, Q1, Q3);
endmodule

module RippleMod(CLK, Q0, Q1, Q2, Q3);
   input CLK;
   output Q0, Q1, Q2, Q3;

   reg Q0, Q1, Q2, Q3;

   always @(posedge CLK) begin
      Q0 <= Q3;
      Q1 <= Q0;
      Q2 <= Q1;
      Q3 <= Q2;
   end

   initial begin // here we conveniently set flipflops to 1000 (binary)
      Q0 = 1;
      Q1 = 0;
      Q2 = 0;
      Q3 = 0;
   end
endmodule
