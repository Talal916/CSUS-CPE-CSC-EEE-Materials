module NANDGate(in1, in2, out);
	input in1, in2;
	output out;
	
	wire in1, in2, out;
	
	nand g1(out, in1,in2);

endmodule 