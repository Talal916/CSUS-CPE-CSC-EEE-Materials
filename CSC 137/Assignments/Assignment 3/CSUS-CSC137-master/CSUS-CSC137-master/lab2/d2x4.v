// Ryan Kozak
// CSC137 Class #32509
// 2nd Programming Assignment
//
// d2x4.v, 2x4 decoder, gate synthesis
//
// how to compile: ~changw/ivl/bin/iverilog d2x4.v
// how to run: ./a.out


module DecoderMod(s, o); // decoder module definition
  
   input [1:0] s; // input array
   output [0:3] o; // output array

   wire [0:1] n_s; // array of exta wires

   not(n_s[1], s[1]); // first not gate in diagram
   not(n_s[0], s[0]); // second not gate in digaram 

   and(o[0], n_s[1], n_s[0]); // first and gate in diagram
   and(o[1], n_s[1], s[0]);  // second and gate in diagram
   and(o[2], s[1], n_s[0]);  // third and gate in diagram
   and(o[3], s[1], s[0]);  // fourth and gate in diagram
   
endmodule

module TestMod; // Tests DecoderMod
   reg [1:0] s;       // array of 1-bit flipflops
   wire [0:3] o; // 4 additional wires

   DecoderMod my_decoder(s, o); // create instance of decoder

   initial begin
      $monitor("%0d\t%b\t%b", $time, s, o);
      $display("Time\ts\to");
      $display("--------------------");
   end

   initial begin
      s[0] = 0;       // initially s[0] set to 0
      s[1] = 0;       // initially s[1] set to 0
      #1;          // wait 1 simulation time unit/cycle
      s[0] = 1;      // change s[0] to 1
      #1;         // wait 1 simulation time unit/cycle
      s[0] = 0;     // change s[0] to 0
      s[1] = 1;     //
      #1;         // wait 1 simulation time unit/cycle
      s[0] = 1;      // change s[0] to 1

   end
endmodule

