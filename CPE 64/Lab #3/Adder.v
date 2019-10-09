module adder(a0, a1, a2, in4, a3, b0, b1, b2, b3, out1, out2, out3, out4, c_out);

	input a0, a1, a2, a3, b0, b1, b2, b3;
	output out1, out2, out3, out4, c_out;
	
	assign{c_out, out4, out3, out2, out1} = {a3, a2, a1, a0} + {b3, b2, b2, b1, b0};
	
	endmodule 
	
	
	