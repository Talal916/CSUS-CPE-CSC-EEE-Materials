module COMPARATOR(in1,in2,in3,in4,out1,out2,out3);
	input in1,in2,in3,in4;
	output out1,out2,out3;
	reg out1,out2,out3;
		always@(in1 or in2 or in3 or in4)
			begin
				out3<={in2,in1}<{in4,in3}; // less than
				// greater than
			if ({in2,in1}>{in4,in3})
				out1<= 1;
					else
					out1<= 0;
				// equivalent to G={a1,a0}>{b1,b0};
				out2<={in2,in1}=={in4,in3}; //logical equality
				end
				endmodule