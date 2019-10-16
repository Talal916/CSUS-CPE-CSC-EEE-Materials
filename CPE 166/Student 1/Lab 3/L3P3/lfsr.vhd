library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_arith.all;

entity lfsr is
port(
	b2,clk,res,lfsgen,lfshold	: in std_logic;
	q							: out std_logic_vector(4 downto 1)
);
end lfsr;

architecture beh of lfsr is

signal cnt10: std_logic_vector(4 downto 1);

begin
	q <= cnt10;
	
	process(clk,res,lfsgen,lfshold,b2)
	begin
		if(res='1') then
			cnt10<="1111";
		elsif(lfsgen = '1') then
			if(rising_edge(clk)) then
				cnt10(4)<=cnt10(3);
				cnt10(3)<=cnt10(2);
				cnt10(2)<=cnt10(4) xor cnt10(1);
				cnt10(1)<=cnt10(4);
			end if;
		elsif(lfshold = '1') then
				cnt10(4)<=cnt10(4);
				cnt10(3)<=cnt10(3);
				cnt10(2)<=cnt10(2);
				cnt10(1)<=cnt10(1);
		end if;
	end process;

end beh;