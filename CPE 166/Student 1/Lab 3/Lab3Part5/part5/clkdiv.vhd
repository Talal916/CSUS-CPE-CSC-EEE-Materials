library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_arith.all;
 
 
entity clkdiv is
port (  	Osc:    	in std_logic;
            	clk:      	out std_logic);
end clkdiv;
 
 
architecture Behavioral of clkdiv is
            	signal clk_10kh:   std_logic;
            	signal cnt_div:                  	std_logic_vector(12 downto 0);
            	
begin
process(Osc)
begin
                            	if (rising_edge (Osc)) then
                                            	if (cnt_div = 4999)  then
                                                            	cnt_div<=(others => '0');
                                                            	clk_10kh <= '1';
                                            	elsif (cnt_div < 2499) then
                                                            	cnt_div <= cnt_div + 1;
                                                            	clk_10kh <= '1';
                                            	else
                                                            	cnt_div <= cnt_div + 1;
                                                            	clk_10kh <= '0';
                                            	end if;
                            	end if;
            	end process;
            	 clk <= clk_10kh;
end Behavioral;
