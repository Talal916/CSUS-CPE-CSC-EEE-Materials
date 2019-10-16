library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;

entity sram is   
port (
       address :in    std_logic_vector ( 3 downto 0); 
       din     :in    std_logic_vector ( 7 downto 0);
       dout    :out   std_logic_vector ( 7 downto 0);
       cs      :in    std_logic;                                
       we      :in    std_logic;                                
       oe      :in    std_logic                                 
    );
end sram;

architecture beh_sram of sram is

type memory is array (0 to 15)of std_logic_vector (7 downto 0);
signal mem : memory ;

begin
 
   
      MEM_WRITE:
      process (address, din, cs, we) 
	  begin
         if (cs = '1' and we = '1') then
             mem(conv_integer(address)) <= din;
         end if;
      end process;
  
   
      MEM_READ:
     process (address, cs, we, oe, mem) 
     begin
      if (cs = '1' and we = '0' and oe = '1')  then               
		dout <= mem(conv_integer(address));  
	  else
		dout <=  (others => 'Z' );
               
      end if;
      end process;
  
  end beh_sram;
 
