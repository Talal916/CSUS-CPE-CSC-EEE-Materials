// Amrit Singh
// decoder 2x4.v
//


module DecoderMod(s1,s0,o0,o1,o2,o3);
	input s1, s0;
	output o0,o1,o2,o3;
	wire s1Inverse, s0Inverse;

	not(s1Inverse,s1);
	not(s0Inverse,s0);

	and(o0, s1Inverse, s0Inverse);
	and(o1, s1Inverse, s0);
	and(o2, s1,s0Inverse);
	and(o3,s1,s0);
endmodule 

module TestMod;
	reg s1,s0;
	wire o0,o1,o2,o3;

	DecoderMod test(s1,s0,o0,o1,o2,o3);
	
	initial begin
		$monitor(" %0d \t%b \t%b \t%b \t%b \t%b \t%b",
		$time, s1,s0,o0,o1,o2,o3);
		$display(" Time \ts1 \ts0 \t o0 \t o1 \t o2 \t 03");
		$display("----------------------------------------------------------");
	end
	
	initial begin
		s1 =0; s0=0;
		#1;
		s1=0; s0=1;
		#1;
		s1=1; s0=0;
		#1;
		s1=1; s0=1;
	end
endmodule 
