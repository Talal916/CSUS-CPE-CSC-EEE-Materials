//Amrit Singh
//decoder 2x4
module DecoderMod(s,o);
   	input [1:0] s;
   	output [0:3] o;
   	wire [1:0] inv_s;
 
   	not(inv_s[1], s[1]);
   	not(inv_s[0], s[0]);
   
	and(o[0], inv_s[1], inv_s[0]);
   	and(o[1], inv_s[1],     s[0]);
   	and(o[2],     s[1], inv_s[0]);
   	and(o[3],     s[1],     s[0]);
endmodule

module TestMod; 
   	reg [1:0] s;
   	wire [0:3] o;
   	DecoderMod myDecoder(s, o);
 
   	initial begin
      		$monitor("%3d\t%b%b\t%b%b%b%b",
		$time, s[1], s[0], o[0], o[1], o[2], o[3]);
      		$display(" Time\ts\to"); 
                $display("------------------------");
       end
 
   	initial begin
      		s = 2'b00; 
		#1;
      		s = 2'b01; 
		#1;
      		s = 2'b10; 
		#1;
      		s = 2'b11;
   	end 
endmodule
