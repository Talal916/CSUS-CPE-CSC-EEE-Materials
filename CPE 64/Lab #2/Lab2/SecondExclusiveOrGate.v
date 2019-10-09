module Lab2Part1B(in1, in2, out);
	input in1, in2;
	output out;
	
	wire in1, in2, out;
	wire nand1out, nand2out, nand3out;
	
	nand nand4(out, nand1out, nand3out);
	nand nand3(nand3out, nand2out, in1);
	nand nand2(nand2out, in1, in2);
	nand nand1(nand1out, in2, nand2out);	
	
endmodule 


