module alu(s, cin, a, b, y );

input [2:0]  s;
input cin, a, b;

output y;

reg [1:0] F;

assign y = F[0];

always@(s or cin or a or b)
begin 
	case(s)
		0: F <= a + b + cin;
		1: F <= a + ~(b) + cin;
		2: F <= b;
		3: F <= ~(a & b);
		4: F <= a & b;
		5: F <= a | b;
		6: F <= ~a;
		7: F <= a ^ b;
	endcase
end

endmodule
