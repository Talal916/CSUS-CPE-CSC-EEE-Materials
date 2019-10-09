module part5_signed (a0,a1,a2,b0,b1,b2,E,L,G);
	input a0,a1,a2,b0,b1,b2;
	output E,L,G;
	reg E,L,G;
		always@( a0 or a1 or a2 or b0 or b1 or b2)
			begin
				case ({a0,a1,a2,b0,b1,b2})
					0 : begin
					E<=1;
					L<=0;
					G<=0;
					end
					1 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					2 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					3 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					4 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					5 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					6 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					7 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					8 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					9 : begin
					E<=1;
					L<=0;
					G<=0;
					end
					10 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					11 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					12 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					13 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					14 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					15 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					16 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					17 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					18 : begin
					E<=1;
					L<=0;
					G<=0;
					end
					19 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					20 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					21 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					22 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					23 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					24 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					25 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					26 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					27 : begin
					E<=1;
					L<=0;
					G<=0;
					end
					28 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					29 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					30 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					31 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					32 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					33 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					34 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					35 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					36 : begin
					E<=1;
					L<=0;
					G<=0;
					end
					37 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					38 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					39 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					40 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					41 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					42 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					43 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					44 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					45 : begin
					E<=1;
					L<=0;
					G<=0;
					end
					46 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					47 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					48 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					49 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					50 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					51 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					52 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					53 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					54 : begin
					E<=1;
					L<=0;
					G<=0;
					end
					55 : begin
					E<=0;
					L<=0;
					G<=1;
					end
					56 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					57 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					58 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					59 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					60 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					61 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					62 : begin
					E<=0;
					L<=1;
					G<=0;
					end
					63 : begin
					E<=1;
					L<=0;
					G<=0;
					end
					default :begin
					E<=0;
					L<=0;
					G<=0;
					end
					endcase
		end
		endmodule