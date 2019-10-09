`timescale 1ns	/ 1ps
module Part5TB();
	reg CLK;
	wire q0, q1, q2, q3;
	
	Part5 uut(.CLK(CLK), .q0(q0), .q1(q1), .q2(q2), .q3(q3));
	
	initial begin 
	CLK = 1'b0;
	forever	#5 CLK = ~CLK;
	end
	
	initial begin
	#500;
	$stop;
	
	end
	endmodule
