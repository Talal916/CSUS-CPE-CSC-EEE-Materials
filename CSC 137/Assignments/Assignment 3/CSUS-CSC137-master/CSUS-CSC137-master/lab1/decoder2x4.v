// Ryan Kozak
// CSC137 Class #32509
//
// decoder4x2.v, 4x2 decoder, gate synthesis
//
// how to compile: ~changw/ivl/bin/iverilog decoder4x2.v
// how to run: ./a.out

/*
   old-style comments starts with "slash-star"
   why didn't I do this: x=y*z;
   all comments until "star-slash"
*/

module DecoderMod(s1, s0, o0, o1, o2, o3); // module definition
  
   input s0, s1;
   output o0, o1, o2, o3; 

   wire n_s0, n_s1; // extra wires

   not(n_s1, s1); // first not gate in diagram
   not(n_s0, s0); // second not gate in digaram 

   and(o0, n_s1, n_s0);
   and(o1, n_s1, s0);
   and(o2, s1, n_s0);
   and(o3, s1, s0);
   
endmodule

module TestMod; // or call it main, it tests DecoderMod
   reg s0,s1;       // s1 and s2 are 1-bit flipflops
   wire o0, o1, o2, o3; // 4 additional wires

   DecoderMod my_decoder(s1, s0, o0, o1, o2, o3); // create instance

   initial begin
      $monitor("%0d\t%b\t%b\t%b\t%b\t%b\t%b", $time, s1, s0, o0, o1, o2, o3);
      $display("Time\ts1\ts0\to0\to1\to2\to3");
      $display("--------------------------");
   end

   initial begin
      s0 = 0;       // initially s0 set to 0
      s1 = 0;       // initially s1 set to 0
      #1;          // wait 1 simulation time unit/cycle
      s0 = 1;      // change s0 to 1
      #1;         // wait 1 simulation time unit/cycle
      s0 = 0;     // change s0 to 0
      s1 = 1;     //
      #1;         // wait 1 simulation time unit/cycle
      s0 = 1;      // change s to 1

   end
endmodule

