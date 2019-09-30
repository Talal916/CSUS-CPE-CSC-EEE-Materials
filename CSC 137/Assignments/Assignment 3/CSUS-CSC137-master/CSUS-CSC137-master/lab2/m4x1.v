// Ryan Kozak
// CSC137 Class #32509
// 2nd Programming Assignment
//
// m4x1.v, 4x1 multiplexor, gate synthesis
// compile: ~changw/ivl/bin/iverilog m4x1.v
// run: ./a.out



module DecoderMod(s, o); // decoder module definition

   input [1:0] s; // input array
   output [0:3] o; // output array

   wire [1:0] n_s; // extra wires

   not(n_s[1], s[1]); // first not gate in diagram
   not(n_s[0], s[0]);  // second not gate in diagram

   and(o[0], n_s[1], n_s[0]); // first and gate in diagram
   and(o[1], n_s[1], s[0]); // second and gate in diagram
   and(o[2], s[1], n_s[0]); // third and gate in diagram
   and(o[3], s[1], s[0]);  // fourth and gate in diagram

endmodule



module MuxMod(s, d, o); // multiplexer module definition

   input [1:0] s; // input array
   input [0:3] d; // input array
   
   output o; // output

   wire [0:3] io, w_and; // extra wires

   DecoderMod my_decoder(s, io); // declaration of decoder module
  
   and(w_and[0], io[0], d[0] ); // first and gate in diagram
   and(w_and[1], io[1], d[1]); // second and gate in diagram
   and(w_and[2], io[2], d[2]); // third and gate in diagram
   and(w_and[3], io[3], d[3]);  // fourth and gate in diagram

   or(o, w_and[0], w_and[1], w_and[2], w_and[3]); // or gate

endmodule

module TestMod; // module to test multiplexer

   reg [1:0] s; 
   reg [0:3] d;
   wire o;

   MuxMod my_mux(s, d, o); // delclaration of  multiplexer module

   initial begin
      $display("Time\ts\td\to");
      $display("-----------------------------");
      $monitor("%2d\t%b\t%b\t%b", $time, s, d, o);
   end

   initial begin
      
      s[1] = 0; s[0] = 0; d = 4'b0000; #1; //0
      s[1] = 0; s[0] = 0; d = 4'b0001; #1; //1
      s[1] = 0; s[0] = 0; d = 4'b0010; #1; //2
      s[1] = 0; s[0] = 0; d = 4'b0011; #1; //3 
      s[1] = 0; s[0] = 0; d = 4'b0100; #1; //4 
      s[1] = 0; s[0] = 0; d = 4'b0101; #1; //5 
      s[1] = 0; s[0] = 0; d = 4'b0110; #1; //6 
      s[1] = 0; s[0] = 0; d = 4'b0111; #1; //7 
      s[1] = 0; s[0] = 0; d = 4'b1000; #1; //8 
      s[1] = 0; s[0] = 0; d = 4'b1001; #1; //9 
      s[1] = 0; s[0] = 0; d = 4'b1010; #1; //10
      s[1] = 0; s[0] = 0; d = 4'b1011; #1; //11
      s[1] = 0; s[0] = 0; d = 4'b1100; #1; //12
      s[1] = 0; s[0] = 0; d = 4'b1101; #1; //13
      s[1] = 0; s[0] = 0; d = 4'b1110; #1; //14
      s[1] = 0; s[0] = 0; d = 4'b1111; #1; //15

      s[1] = 0; s[0] = 1; d = 4'b0000; #1; //16
      s[1] = 0; s[0] = 1; d = 4'b0001; #1; //17
      s[1] = 0; s[0] = 1; d = 4'b0010; #1; //18
      s[1] = 0; s[0] = 1; d = 4'b0011; #1; //19
      s[1] = 0; s[0] = 1; d = 4'b0100; #1; //20
      s[1] = 0; s[0] = 1; d = 4'b0101; #1; //21 
      s[1] = 0; s[0] = 1; d = 4'b0110; #1; //22 
      s[1] = 0; s[0] = 1; d = 4'b0111; #1; //23
      s[1] = 0; s[0] = 1; d = 4'b1000; #1; //24
      s[1] = 0; s[0] = 1; d = 4'b1001; #1; //25
      s[1] = 0; s[0] = 1; d = 4'b1010; #1; //16
      s[1] = 0; s[0] = 1; d = 4'b1011; #1; //27
      s[1] = 0; s[0] = 1; d = 4'b1100; #1; //28
      s[1] = 0; s[0] = 1; d = 4'b1101; #1; //29
      s[1] = 0; s[0] = 1; d = 4'b1110; #1; //30
      s[1] = 0; s[0] = 1; d = 4'b1111; #1; //31

      s[1] = 1; s[0] = 0; d = 4'b0000; #1; //32
      s[1] = 1; s[0] = 0; d = 4'b0001; #1; //33
      s[1] = 1; s[0] = 0; d = 4'b0010; #1; //34
      s[1] = 1; s[0] = 0; d = 4'b0011; #1; //35
      s[1] = 1; s[0] = 0; d = 4'b0100; #1; //36
      s[1] = 1; s[0] = 0; d = 4'b0101; #1; //37
      s[1] = 1; s[0] = 0; d = 4'b0110; #1; //38
      s[1] = 1; s[0] = 0; d = 4'b0111; #1; //39
      s[1] = 1; s[0] = 0; d = 4'b1000; #1; //40 
      s[1] = 1; s[0] = 0; d = 4'b1001; #1; //41
      s[1] = 1; s[0] = 0; d = 4'b1010; #1; //42
      s[1] = 1; s[0] = 0; d = 4'b1011; #1; //43
      s[1] = 1; s[0] = 0; d = 4'b1100; #1; //44
      s[1] = 1; s[0] = 0; d = 4'b1101; #1; //45
      s[1] = 1; s[0] = 0; d = 4'b1110; #1; //46
      s[1] = 1; s[0] = 0; d = 4'b1111; #1; //47

      s[1] = 1; s[0] = 1; d = 4'b0000; #1; //48
      s[1] = 1; s[0] = 1; d = 4'b0001; #1; //49
      s[1] = 1; s[0] = 1; d = 4'b0010; #1; //50
      s[1] = 1; s[0] = 1; d = 4'b0011; #1; //51
      s[1] = 1; s[0] = 1; d = 4'b0100; #1; //52
      s[1] = 1; s[0] = 1; d = 4'b0101; #1; //53 
      s[1] = 1; s[0] = 1; d = 4'b0110; #1; //54 
      s[1] = 1; s[0] = 1; d = 4'b0111; #1; //55
      s[1] = 1; s[0] = 1; d = 4'b1000; #1; //56
      s[1] = 1; s[0] = 1; d = 4'b1001; #1; //57
      s[1] = 1; s[0] = 1; d = 4'b1010; #1; //58
      s[1] = 1; s[0] = 1; d = 4'b1011; #1; //59
      s[1] = 1; s[0] = 1; d = 4'b1100; #1; //60
      s[1] = 1; s[0] = 1; d = 4'b1101; #1; //61
      s[1] = 1; s[0] = 1; d = 4'b1110; #1; //62
      s[1] = 1; s[0] = 1; d = 4'b1111; #1; //63
      
    end

endmodule
