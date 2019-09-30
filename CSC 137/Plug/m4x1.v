//Amrit Singh
//mux4x1
//
module DecoderMod(s,o);
	input[1:0]s;
	output[0:3]o;
	wire[1:0]inv_s;

	not(inv_s[1], s[1]);
   	not(inv_s[0], s[0]);
   
	and(o[0], inv_s[1], inv_s[0]);
   	and(o[1], inv_s[1],     s[0]);
   	and(o[2],     s[1], inv_s[0]);
   	and(o[3],     s[1],     s[0]);
endmodule

module MuxMod(s,d,o);
	input [1:0] s;
   	input [0:3] d;
   	output o;
 
   	wire [0:3] s_decoded, and_out;
   	DecoderMod myDecoder(s, s_decoded);
 
   	and(and_out[0], d[0], s_decoded[0]);
   	and(and_out[1], d[1], s_decoded[1]);
   	and(and_out[2], d[2], s_decoded[2]);
   	and(and_out[3], d[3], s_decoded[3]);
   	or(o, and_out[0], and_out[1], and_out[2], and_out[3]);
endmodule
 
module TestMod; 
   	reg [1:0] s;
   	reg [0:3] d;
   	wire o;
   	MuxMod myMux(s, d, o);
 
   	initial begin
      		$display("Time\ts\td\to");
      		$display("-------------------------------------");
      		$monitor("%4d\t%b%b\t%b%b%b%b\t%b",
         	$time, s[1], s[0], d[0], d[1], d[2], d[3], o);
   	end
	initial begin
		s=2'b00; d=4'b0000; 
		#1;  
         	s=2'b00; d=4'b0001;
		#1;
         	s=2'b00; d=4'b0010; 
		#1;
         	s=2'b00; d=4'b0011; 
		#1;
         	s=2'b00; d=4'b0100; 
		#1;
         	s=2'b00; d=4'b0101; 
		#1;
         	s=2'b00; d=4'b0110; 
		#1;
         	s=2'b00; d=4'b0111; 
		#1;
         	s=2'b00; d=4'b1000; 
		#1;
         	s=2'b00; d=4'b1001; 
		#1;
         	s=2'b00; d=4'b1010; 
		#1;
         	s=2'b00; d=4'b1011; 
		#1;
         	s=2'b00; d=4'b1100; 
		#1;
         	s=2'b00; d=4'b1101; 
		#1;
         	s=2'b00; d=4'b1110; 
		#1;
         	s=2'b00; d=4'b1111; 
		#1;
         	s=2'b01; d=4'b0000; 
		#1;
         	s=2'b01; d=4'b0001; 
		#1;
         	s=2'b01; d=4'b0010; 
		#1;
         	s=2'b01; d=4'b0011; 
		#1;
         	s=2'b01; d=4'b0100; 
		#1;
         	s=2'b01; d=4'b0101; 
		#1;
         	s=2'b01; d=4'b0110; 
		#1;
         	s=2'b01; d=4'b0111; 
		#1;
         	s=2'b01; d=4'b1000; 
		#1;
         	s=2'b01; d=4'b1001; 
		#1;
         	s=2'b01; d=4'b1010; 
		#1;
         	s=2'b01; d=4'b1011; 
		#1;
         	s=2'b01; d=4'b1100; 
		#1;
         	s=2'b01; d=4'b1101; 
		#1;
         	s=2'b01; d=4'b1110; 
		#1;
         	s=2'b01; d=4'b1111; 
		#1;
         	s=2'b10; d=4'b0000; 
		#1;
         	s=2'b10; d=4'b0001; 
		#1;
         	s=2'b10; d=4'b0010; 
		#1;
         	s=2'b10; d=4'b0011; 
		#1;
         	s=2'b10; d=4'b0100; 
		#1;
         	s=2'b10; d=4'b0101; 
		#1;
         	s=2'b10; d=4'b0110; 
		#1;
         	s=2'b10; d=4'b0111; 
		#1;
         	s=2'b10; d=4'b1000; 
		#1;
         	s=2'b10; d=4'b1001; 
		#1;
         	s=2'b10; d=4'b1010; 
		#1;
         	s=2'b10; d=4'b1011; 
		#1;
         	s=2'b10; d=4'b1100; 
		#1;
         	s=2'b10; d=4'b1101; 
		#1;
         	s=2'b10; d=4'b1110; 
		#1;
         	s=2'b10; d=4'b1111; 
		#1;
         	s=2'b11; d=4'b0000; 
		#1;
         	s=2'b11; d=4'b0001; 
		#1;
         	s=2'b11; d=4'b0010; 
		#1;
         	s=2'b11; d=4'b0011; 
		#1;
         	s=2'b11; d=4'b0100; 
		#1;
         	s=2'b11; d=4'b0101; 
		#1;
         	s=2'b11; d=4'b0110; 
		#1;
         	s=2'b11; d=4'b0111; 
		#1;
         	s=2'b11; d=4'b1000; 
		#1;
         	s=2'b11; d=4'b1001; 
		#1;
         	s=2'b11; d=4'b1010; 
		#1;
         	s=2'b11; d=4'b1011; 
		#1;
         	s=2'b11; d=4'b1100; 
		#1;
         	s=2'b11; d=4'b1101; 
		#1;
         	s=2'b11; d=4'b1110; 
		#1;
         	s=2'b11; d=4'b1111;
	end
endmodule
