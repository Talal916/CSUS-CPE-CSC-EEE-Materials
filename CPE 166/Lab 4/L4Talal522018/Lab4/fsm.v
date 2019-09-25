module fsm(clk, reset, clr, w, ce, sel, s);

input clk, reset;

output reg [3:0] ce;
output reg [2:0] w, s;
output reg [1:0] sel;
output reg clr;

reg [3:0] cs, ns;

parameter s_idle = 0, s1 = 1, s2 = 2, s3 = 3 , s4 = 4, s5 = 5, s6 = 6, s7 = 7, 
				s8 = 8, s9 = 9, s10 = 10, s11 = 11;

always@(posedge clk or posedge reset)
begin
	if(reset)
		cs <= s1;
	else
		cs <= ns;	
end

always@(cs)
begin
	 case(cs)
		s_idle: ns <= s_idle;
		s1: ns <= s2;
		s2: ns <= s3;
		s3: ns <= s4;
		s4: ns <= s5;
		s5: ns <= s6;
		s6: ns <= s7;
		s7: ns <= s8;
		s8: ns <= s9;
		s9: ns <= 10;
		s10: ns <= s11;
		s11: ns <= s_idle;
		default: ns <= s_idle;
	endcase 
end 

always@(cs)	
begin 
	case(cs)
		s_idle: begin ce <= 0; clr <= 0; w <= 0; s <= 0; sel <= 0; end 
		s1: begin ce <= 0; clr <= 1; w <= 0; s <= 0; sel <= 0; end
		s2: begin ce <= 3; clr <= 0; w <= 4; s <= 0; sel <= 0; end
		s3: begin ce <= 0; clr <= 0; w <= 4; s <= 0; sel <= 0; end
		s4: begin ce <= 0; clr <= 0; w <= 0; s <= 2; sel <= 0; end
		s5: begin ce <= 8; clr <= 0; w <= 0; s <= 2; sel <= 0; end
		s6: begin ce <= 0; clr <= 0; w <= 0; s <= 0; sel <= 0; end
		s7: begin ce <= 0; clr <= 0; w <= 0; s <= 1; sel <= 1; end
		s8: begin ce <= 8; clr <= 0; w <= 0; s <= 1; sel <= 1; end
		s9: begin ce <= 0; clr <= 0; w <= 0; s <= 0; sel <= 0; end
		s10: begin ce <= 4; clr <= 0; w <= 4; s <= 0; sel <= 0; end
		s11: begin ce <= 0; clr <= 0; w <= 0; s <= 0; sel <= 0; end
		default: begin ce <= 0; clr <= 0; w <= 0; s <= 0; sel <= 0; end
	endcase
end	
			

endmodule
