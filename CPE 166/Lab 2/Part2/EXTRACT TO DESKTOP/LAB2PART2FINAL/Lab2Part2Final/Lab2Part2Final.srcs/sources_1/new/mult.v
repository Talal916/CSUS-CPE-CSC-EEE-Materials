

module mult();

input reg [3:0] db; // input B
input d0 =4'b0000; //ground
wire load =1; 
wire da = 4'b1011; //multiplicand A
wire reg [7:0] p; //see block comment
wire reg [3:0] pH,pL; //see block comment



        dffa g1(clk, clr, load, da, d1); // da is always multiplicand A, goes to mux as d1 
        dffb g2(clk,clr,load,/* shift */,db,s); //s is qB, which is used to find LSB for mux
        
        mux g3(s,d0,d1,b);   //b is Y output from multiplexer, it goes into adder, which takes b input and PH output as a
        
        adder g4(pHNew,b,cout/*goes to P as shift*/,sum/*added to P*/);
        
        
        /*  DOESN'T BELONG HERE -ACCORDING TO JAYESH -- BELONGS IN FSM
        assign pL = {pH[0],pL[3:1]};
        assign pH = phNew;
        */
        
        
        
        





endmodule
