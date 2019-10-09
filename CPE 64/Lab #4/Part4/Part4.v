module Part4(PR,CR,CLK,D,Q,QN);
	input PR,CR,CLK,D;
	output Q,QN;
	wire nand1,nand2,nand3,S,R;
	assign Q = ~(QN & PR & S);
	assign QN = ~(R & nand2 & Q);
	assign S = ~(nand1 & CR & CLK);
	assign R = CR;
	assign nand1 = ~(PR & nand3 & S);
	assign nand2 = ~(CLK & nand3 & S);
	assign nand3 = ~(nand2 & D & R);
endmodule
