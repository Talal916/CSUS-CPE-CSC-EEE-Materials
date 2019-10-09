module Part5(CLK, q0, q1, q2, q3);
	input CLK;
	wire d0, d1, d2, d3;
	output reg q0, q1, q2, q3;
	
	assign d0 = ~q0;
	assign d1 = (~q1 & q0) | (~q0 & q1);
	assign d2 = (q1 & q0 & ~q2) | (~q1 & q2) | (~q0 & q2);
	assign d3 = (~q3 & q2 & q0 & q1) | (~q2 & q3) | (~q0 & q3) | (~q1 & q3);

	initial 
	begin
		q0 <= 0;
		q1 <= 0;
		q2 <= 0;
		q3 <= 0;
	end
	
	always @(posedge CLK)
	begin
		q0 <= d0;
		q1 <= d1;		
		q2 <= d2;
		q3 <= d3;
	end
endmodule 