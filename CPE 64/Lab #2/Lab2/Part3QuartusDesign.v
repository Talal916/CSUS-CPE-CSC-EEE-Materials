module Lab2Part1B(in1, in2, in3, in4, out);

	input in1, in2, in3, in4;
	output out;
	
	wire in1, in2, in3, in4, out;
	wire not1out, orout, and1out, and2out, and3out;
	
	and and1(and1out, not1out, in1);
	and and2(and2out, in4, and1out);
	and and3(and3out, in3, in4);
	
	not not1(not1out, in2);
	
	or or1(out, orout, and2out, and3out);
	
	
endmodule 

