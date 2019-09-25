
LIBRARY ieee;
USE ieee.std_logic_1164.ALL;
 
ENTITY mem_top IS
    port(
		 clk   : IN  std_logic;
       reset : IN  std_logic; 
	    data  : inout std_logic_vector ( 7 downto 0);
       addr_out : OUT  std_logic_vector(3 downto 0);		
         cs_out : OUT  std_logic;
         we_out : OUT  std_logic;
         oe_out : OUT  std_logic
			
    );
END mem_top;
 
ARCHITECTURE behavior OF mem_top IS  
   
	 component ram    
    port (
       address :in    std_logic_vector ( 3 downto 0); 
       data    :inout std_logic_vector ( 7 downto 0); 
       cs      :in    std_logic;                                
       we      :in    std_logic;                                
       oe      :in    std_logic                                 
    );
    end component;

 
    COMPONENT mem_fsm
    PORT(
         clk   : IN  std_logic;
         reset : IN  std_logic;			
         address : OUT  std_logic_vector(3 downto 0);
			data  : INOUT std_logic_vector(7 downto 0);
         cs : OUT  std_logic;
         we : OUT  std_logic;
         oe : OUT  std_logic
        );
    END COMPONENT;
    
	 signal address :    std_logic_vector ( 3 downto 0); 
   
    signal   cs      :    std_logic;                                
    signal   we      :    std_logic;                                
    signal   oe      :    std_logic; 
 
BEGIN 

   cs_out <= cs;
	we_out <= we;
	oe_out <= oe;
	addr_out <= address;

   g1: mem_fsm PORT MAP (
          clk     => clk,
          reset   => reset,			 
          address => address,
			 data => data,
          cs => cs,
          we => we,
          oe => oe
        );
		  
	g2:  ram 
   port map(     
       address =>  address,                               
       data    =>  data,
       cs 		=> cs,
       we 		=> we,
       oe 		=> oe		 
    );  

   

END;
