`timescale 1ns/1ps

module fullAdder(a,b,cin,sum,cout);
	input a,b,cin;
	
	output sum,cout;
	assign sum = a^b^cin;
	assign cout = (a&b)|(b&cin)|(cin&a);
endmodule

module rippleAdder(a,b,cin,s,cout);

	input [7:0] a,b;
	input cin;
	output [7:0] s;
	output cout;
	wire [7:1] c;
	
	fullAdder f1(a[0],b[0],cin,s[0],c[1]);
	fullAdder f2(a[1],b[1],cin,s[1],c[2]);
	fullAdder f3(a[2],b[2],cin,s[2],c[3]);
	fullAdder f4(a[3],b[3],cin,s[3],c[4]);
	fullAdder f5(a[4],b[4],cin,s[4],c[5]);
	fullAdder f6(a[5],b[5],cin,s[5],c[6]);
	fullAdder f7(a[6],b[6],cin,s[6],c[7]);
	fullAdder f8(a[7],b[7],cin,s[7],cout);
	
endmodule

module rippleAdder_tb;
	reg [7:0] a,b;
	reg cin;
	
	wire [7:0] s;
	wire cout;
	
	fullAdder uut(.a(a),.b(b),.cin(cin),.sum(sum),.cout(cout));
	
	initial begin
      $display("Talal Jawaid");
   end
	
	initial begin
	 a = 7'b0;

	 b = 7'b0;
	 
	 cin = 7'b0;
	
	#10;
	
	a = 7'b0;

	 b = 7'b0;
	 
	 cin = 7'b0;
	 
	#10;
	
	a = 7'b100010;

	 b = 7'b0;
	 
	 cin = 7'b0;
	 	#10;
	
	a = 7'b110;

	 b = 7'b0;
	 
	 cin = 7'b0;
	 	#10;
	
	a = 7'b101111;

	 b = 7'b0;
	 
	 cin = 7'b0;
	 	#10;
	
	a = 7'b110;

	 b = 7'b0;
	 
	 cin = 7'b0;
	 	 	#10;
	
	a = 7'b0;

	 b = 7'b0;
	 
	 cin = 7'b11011;
	 	 	#10;
	
	a = 7'b1101;

	 b = 7'b0;
	 
	 cin = 7'b0;
	 	 	#10;
	
	a = 7'b0;

	 b = 7'b0;
	 
	 cin = 7'b0;
	 	 	#10;
	
	a = 7'b11110;

	 b = 7'b0;
	 
	 cin = 7'b0;
	 	 	#10;
	
	a = 7'b110;

	 b = 7'b0;
	 
	 cin = 7'b0;
	 	 	#10;
	
	a = 7'b101;

	 b = 7'b1111;
	 
	 cin = 7'b0;
	 	 	#10;
	
	a = 7'b101;

	 b = 7'b10;
	 
	 cin = 7'b0;
	 	 	#10;
	

end
endmodule