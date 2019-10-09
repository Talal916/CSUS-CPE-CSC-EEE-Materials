module Part1Design(in1, in2, in3, in4, out1, out2, out3, out4, out5);

	input in1, in2, in3, in4;
	output out1, out2, out3, out4, out5;
	
	wire in1, in2, in3, in4, in5, out1, out2, out3, out4, out5;
	wire and1out, and2out, and3out, and4out, and5out, and6out, and7out;
	wire not1out, not2out, not3out;
	wire or1out, or2out, or3out, or4out;
	
	and and1(and1out, in2, in3);
	and and2(and2out, not2out, not1out);
	and and3(and3out, not3out, not1out);
	and and4(and4out, in2, in1);
	and and5(and5out, and4out, in3);
	and and6(and6out, in2, not3out);
	and and7(and7out, not2out, in3);
	
	not not1(not1out, in1);
	not not2(not2out, in2);
	not not3(not3out, in3);
	
	or or1(out1, and1out, in1);
	or or2(or2out, and3out, and2out);
	or or3(out2, or2out, and5out);
	or or4(out3, and6out, and7out);
	
	assign out4 = not3out;
	assign out5 = in4;
	
	endmodule 
