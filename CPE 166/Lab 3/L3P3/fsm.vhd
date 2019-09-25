library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_arith.all;

entity fsm is
port(
	b1,b2,clk			: in std_logic;
	res,lfsgen,lfshold	: out std_logic);
end fsm;

architecture Behavioral of fsm is
type state is (s1,s2,s3);
signal cs,ns : state;
begin
	process(clk,b1)
	begin
		if(b1 ='1') then
			cs <= s1;
		elsif(rising_edge(clk)) then
			cs <= ns;
		end if;
	end process;

	process(cs,b1,b2)
	begin
		case (cs) is
			when s1 =>
				if (b1 = '1') then
					ns <= s1;
				elsif (b2 = '1') then
					ns<=s2;
				elsif(b2 = '0') then
					ns <= s3;
				end if;
			when s2 =>
				if (b1 = '1') then
					ns <= s1;
				elsif (b2 = '1') then
					ns<=s2;
				elsif(b2 = '0') then
					ns <= s3;
				end if;
			when s3 =>
				if (b1 = '1') then
					ns <= s1;
				elsif (b2 = '1') then
					ns<=s2;
				elsif(b2 = '0') then
					ns <= s3;
				end if;
		end case;
	end process;
	
	process(cs)
	begin
		case (cs) is
			when s1 =>
				res <= '1';
				lfsgen <= '0';
				lfshold <= '0';
			when s2 =>
				res <= '0';
				lfsgen <= '1';
				lfshold <= '0';
			when s3 =>
				res <= '0';
				lfsgen <= '0';
				lfshold <= '1';
		end case;
	end process;
end Behavioral;