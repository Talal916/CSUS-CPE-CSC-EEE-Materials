`timescale 1ns / 1ps

module lab4(M0, M1, M2, CLR, CE, W, Qout, CLK, S, Cin, A, SEL);

    input M0;
    input M1;
    input M2;
    input CLR;
    input [2:0] CE;
    input [2:0] W;
    
    output Qout;
    input CLK;
    input [1:0] SEL;
    input [2:0] S;
    input Cin;
    input A;
    
    reg [4:0] Y;
    reg [2:0] Q;
    reg [2:0] R;

    always @(W[0] or M0 or A)
    begin
      if (W[0] == 1)
        Y[0] = M0;
      else
        Y[0] = A;
    end
      
    always @(W[1] or M1 or A)
    begin
      if (W[1] == 1)
        Y[1] = M1;
      else
        Y[1] = A;
    end

    always @(W[2] or M2 or A)
    begin
      if (W[2] == 1)
        Y[2] = M2;
      else
        Y[2] = A;
    end
    
    always@(posedge CLK or CE[0] or CLR) 
    begin
        case(CE[0])
            1'b0:    Q[0] = Y[0];
            1'b1:    Q[0] = CLR;
        endcase
    end

    always@(posedge CLK or CE[1] or CLR) 
    begin
        case(CE[1])
            1'b0:    Q[1] = Y[1];
            1'b1:    Q[1] = CLR;
        endcase
    end    

    always@(posedge CLK or CE[2] or CLR) 
    begin
        case(CE[2])
            1'b0:    Q[2] = Y[2];
            1'b1:    Q[2] = CLR;
        endcase
    end    

    always@(R[0] or R[1] or R[2] or SEL)
    begin
        case(SEL)
            2'b00:  Y[3] = R[0];
            2'b01:  Y[3] = R[1];
            2'b10:  Y[3] = R[2];
        endcase
    end
    
    
      
      
endmodule
