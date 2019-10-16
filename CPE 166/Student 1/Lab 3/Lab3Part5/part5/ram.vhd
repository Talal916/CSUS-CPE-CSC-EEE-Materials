library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;

entity ram is   
port (
       address :in    std_logic_vector ( 3 downto 0); 
       data    :inout std_logic_vector ( 7 downto 0); 
       cs      :in    std_logic;                                
       we      :in    std_logic;                                
       oe      :in    std_logic                                 
    );
end ram;
architecture beh_ram of ram is

type memory is array (0 to 15)of std_logic_vector (7 downto 0);
signal mem : memory ;

begin
 
   
      MEM_WRITE:
      process (address, data, cs, we) 
	  begin
         if (cs = '1' and we = '1') then
             mem(conv_integer(address)) <= data;
         end if;
      end process;
  
   
      MEM_READ:
     process (address, cs, we, oe, mem) begin
          if (cs = '1' and we = '0' and oe = '1')  then               
		data <= mem(conv_integer(address));  
	  else
		data <=  (others => 'Z' );
               
          end if;
      end process;
  
  end beh_ram;
 
