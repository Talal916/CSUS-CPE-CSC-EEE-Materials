library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_arith.all;


entity counter is
port(
C, CLR, UP_DOWN : in std_logic;
Q: out std_logic_vector(3 downto 0)
);
end counter;
architecture archi of counter is
signal tmp: std_logic_vector(3 downto 0);
begin
process (C, CLR)
begin
if (CLR='1') then
tmp <= "0000";
elsif (C'event and C='1') then
if (UP_DOWN='1') then
tmp <= tmp + 1;
else
tmp <= tmp - 1;
end if;
end if;
end process;
Q <= tmp;
end archi;

library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_arith.all;



entity clkdiv8 is
 port(clk1 : in std_logic;
 clk2 : out std_logic);
end clkdiv8;
architecture beh of clkdiv8 is
 signal counter: std_logic_vector(2 downto 0);
 begin


 process (clk1)
 begin
 if (rising_edge(clk1)) then
 if (counter=7) then
 clk2 <= '1';
 counter <= (others=>'0');
 elsif(counter<3) then
 clk2 <= '1';
 counter <= counter + 1;
 else
 clk2 <= '0';
 counter <= counter + 1;
 end if;
 end if;
 end process;

end beh;