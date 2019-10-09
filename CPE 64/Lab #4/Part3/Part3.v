module Part3(CLK,D,R,S,Q,QN);
	input CLK,D;
	output R, S, Q, QN;
	wire CLK,D;
	assign Q = ~ ( R | QN );
	assign QN = ~ ( S | Q );
	assign S = ~(CLK | ~(D | S) | R);
	assign R = ~(CLK | ~(R | ~(D | S)));
endmodule