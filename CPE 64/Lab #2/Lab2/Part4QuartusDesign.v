module Part4QuartusDesign(in1, in2, in3, in4, out, out1);

	input in1, in2, in3, in4;
	output out, out1;
	
	wire in1, in2, in3, in4, out, out1;
	wire and1out, and2out, and3out, and4out, and5out, and6out;
	wire or1out, or2out, or3out, orout4;
	wire not1out, not2out, not3out, not4out;
	
	not not1(not1out, in1);
	not not2(not2out, in2);
	not not3(not3out, in3);
	not not4(not4out, in4);

	and and1(and1out, not2out, not1out);
	and and2(and2out, and3out, in1);
	and and3(and3out, not2out, not3out);
	and and4(and4out, not2out, in3);
	and and5(and5out, not3out, in4);
	and and6(and6out, not4out, in3);

	or or1(out, orout1, and5out, and2out);
	or or2(orout2, and1out, and4out);
	or or3(out1, orout3, orout2, orout4);
	or or4(orout4, and5out, and6out);
		
endmodule 

	