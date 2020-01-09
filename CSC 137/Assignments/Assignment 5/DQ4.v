// DQ4.v -- array of 4 DQ F/F


module SR(S, R, O);
   input S, R;
   output O;

   wire Obar, bot;			

   nor(Obar, S, bot);
   nor(bot, R, Obar);

   assign #1 O = bot;
endmodule

module DQ(D, en, Q);
   input D, en;
   wire [0:1] o;
   output Q;

   wire notD;
   not(notD, D);

   and(o[0], D, en);
   and(o[1], notD, en);

   SR my_SR(o[0], o[1], Q);
endmodule

module DQ4(D, en, Q);
   input [0:3] D;
   input en;
   output [0:3] Q;

   DQ myDQ [0:3] (D[0:3], en, Q[0:3]);

endmodule

module TestMod;
   reg [0:3] D;
   reg en;
   wire [0:3] Q;

   DQ4 myDQ4(D, en, Q);

   initial begin
      $monitor("%4d  %b  %b  %b", $time, D, en, Q);
      $display("Time  D...  en Q...");
      $display("----  ----  -  ----");
   end

   always begin
      #1; D = 4'b0000; #1; en = 1; #1; en = 0; #1;
      #1; D = 4'b0001; #1; en = 1; #1; en = 0; #1;
      #1; D = 4'b0010; #1; en = 1; #1; en = 0; #1;
      #1; D = 4'b0011; #1; en = 1; #1; en = 0; #1;
      #1; D = 4'b0100; #1; en = 1; #1; en = 0; #1;
      #1; D = 4'b0101; #1; en = 1; #1; en = 0; #1;
      #1; D = 4'b0110; #1; en = 1; #1; en = 0; #1;
      #1; D = 4'b0111; #1; en = 1; #1; en = 0; #1;
      #1; D = 4'b1000; #1; en = 1; #1; en = 0; #1;
      #1; D = 4'b1001; #1; en = 1; #1; en = 0; #1;
      #1; D = 4'b1010; #1; en = 1; #1; en = 0; #1;
      #1; D = 4'b1011; #1; en = 1; #1; en = 0; #1;
      #1; D = 4'b1100; #1; en = 1; #1; en = 0; #1;
      #1; D = 4'b1101; #1; en = 1; #1; en = 0; #1;
      #1; D = 4'b1110; #1; en = 1; #1; en = 0; #1;
      #1; D = 4'b1111; #1; en = 1; #1; en = 0; #1;
   end

   initial #69 $finish;
endmodule
