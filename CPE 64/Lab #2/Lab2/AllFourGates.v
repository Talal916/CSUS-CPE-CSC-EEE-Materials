module AllFourGates(in1, in2, out, out1, out2, out3);

	input in1, in2;
	output out, out1, out2, out3;
	
	wire in1, in2, out, out1, out2, out3;
	
	and g1(out, in1, in2);
	or g2(out1, in1, in2);
	nand g3(out2,in1,in2);
	not g4(out3, in1);
	
endmodule 