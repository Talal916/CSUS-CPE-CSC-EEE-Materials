`timescale 1ns	/ 1ps
module ComparatorTestBench();
	reg a0, a1, b0, b1;
	wire out1, out2, out3;
	
	comparator uut (.a0(a0), .a1(a1), .b0(b0), .b1(b1), .out1(out1), .out2(out2), .out3(out3));
	
	initial begin
	a0 = 1'b0;a1 = 1'b0;b0 = 1'b0;b1 = 1'b0;
	
	#20;a0 = 1'b0;a1 = 1'b0;b0 = 1'b0;b1 = 1'b1;
	
	#20;a0 = 1'b0;a1 = 1'b0;b0 = 1'b1;b1 = 1'b0;
	
	#20;a0 = 1'b0;a1 = 1'b0;b0 = 1'b1;b1 = 1'b1;
	
	#20;a0 = 1'b0;a1 = 1'b1;b0 = 1'b0;b1 = 1'b0;
	
	#20;a0 = 1'b0;a1 = 1'b1;b0 = 1'b0;b1 = 1'b1;
	
	#20;a0 = 1'b0;a1 = 1'b1;b0 = 1'b1;b1 = 1'b0;
	
	#20;a0 = 1'b0;a1 = 1'b1;b0 = 1'b1;b1 = 1'b1;
	
	#20;a0 = 1'b1;a1 = 1'b0;b0 = 1'b0;b1 = 1'b0;
	
	#20;a0 = 1'b1;a1 = 1'b0;b0 = 1'b0;b1 = 1'b1;
	
	#20;a0 = 1'b1;a1 = 1'b0;b0 = 1'b1;b1 = 1'b0;
	
	#20;a0 = 1'b1;a1 = 1'b0;b0 = 1'b1;b1 = 1'b1;
	
	#20;a0 = 1'b1;a1 = 1'b1;b0 = 1'b0;b1 = 1'b0;
	
	#20;a0 = 1'b1;a1 = 1'b1;b0 = 1'b0;b1 = 1'b1;
	
	#20;a0 = 1'b1;a1 = 1'b1;b0 = 1'b1;b1 = 1'b0;
	
	#20;a0 = 1'b1;a1 = 1'b1;b0 = 1'b1;b1 = 1'b1;
	
	#20;$stop;
	
	end
endmodule

	