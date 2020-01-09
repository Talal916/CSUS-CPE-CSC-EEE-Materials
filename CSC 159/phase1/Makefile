#-------------------------------------------------------
#	Makefile for GNU SPEDE/X86-GCC.
#	$Header: /export/home/aleks/Projects/Intel-159/Core/00-Tools/Scripts/RCS/model.makefile,v 2.11 2001/08/31 05:52:42 aleks Exp $
#	CSU Sacramento, CA. USA, Dr. J. Clevenger (clevenger@csus.edu)
#				brian witt (wittb@ecs.csus.edu)
#
#	C++ files have .C, .cxx, cpp or .cc extention.  Assembler files use
#	.S please.  Generated assembler files have .asm extention, so they
#	can easily be deleted during a ``make clean'' call.
#
#	Dependencies are inserted into user's Makefile.
#	Version control is whatever is needed (ie, not coded directly).
#	Reads "local.mk" if exists.  This requires GNU Make !!
#
#	For those wanting backup power, "make tarball" will create a tar
#	file of source and headers in the parent directory.  The Makefile
#	will never erase this file.
#
#       (27-mar-97, bwitt)  Revised to 68-mkmf
#	(19-Jan-2000, bwitt) Now for X86-SPEDE [2.1], based on [1.5]
#	(30-March-2000, bwitt) Added "tags" target [2.5]
#	(21-April-2000, bwitt) "make bootable" copies RAWRITE.EXE and BOOT.COM
#				Added "-include local.mk" [2.7]
#	(16-feb-2001, bwitt)	Added .cpp for C++ source files [2.8]
#	(31-March-2001, bwitt)	target "tarball" added [2.9]
#	(17-August-2001, bwitt)	Put OBJS= before include "local.mk" so it
#				can work with $(OBJS) [2.10]
#

MKF_VERSION=$Release$/March2001/bwitt

#
#  .asm is an output extension so we can generate assembly files.
#  These are for additional suffixes.
#
#  NOTE: *.asm files are deleted for `make clean', and should ONLY
#	be used for a target, not a source.  Use .S for assembler
#	files you write (do cpp before assembling).
#
.SUFFIXES: .S .asm .E .cxx .C .cc .cpp

#vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
#--------------------------------------
#  This section contains definitions which can (and in some cases MUST) 
#  be changed.  See commentary for details.  Don't use quotes in variable
#  assignments below.  After changing any values here, run "make depend".
#

#
#  (1) Please name your operating system.  Must be a legal filename,
#	and not contain spaces or punctuation.  It will be used to
#	name you DLI file (see "MY_DLI =" below).
#
OS_NAME = MyOS

#
#  (2) This section lists the source files for your executable.
#       NOTE: Keep the spaces around the equals sign (=) please.
#	If this changes, run "make depend" to update $OBJECTS.
#
SRC = entry.S kernel.c ksr.c proc.c tools.c 

#
#  (3) Add any compiler options you want.  They will be passed to gcc386
#	and g++386.  Some examples are "-v" to run the compiler in verbose
#	mode, will display details compiler takes.  Using "-I ../headers"
#	will tell the compiler to look in the directory "../headers" for
#	additional "include" files.
#
EXTRA_CFLAGS = 

#
#  (4) If you always want symbolic debugging information added to your
#	executable, set this to "-g" .  Or always use the "make debug"
#	target.  Use "-M" to create a mapfile of the image.
#
EXTRA_LINK_FLAGS =


#--------------------------------------
# End of student-customization section
#--------------------------------------
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

#--------------------------------------
#	Rules of construction:
#

.cc.o: 
	$(CPLUS) $(MODEL) $(CFLAGS) $(EXTRA_CFLAGS) -c -o $@ $< 
.cc.asm:
	$(CPLUS) $(MODEL) $(CFLAGS) $(EXTRA_CFLAGS) -S -o $@ $<
	@echo NOTE: $@ is a temporary file
.cc.E:
	$(CPLUS) $(MODEL) $(CFLAGS) $(EXTRA_CFLAGS) -E -o $@ $<

.C.o: 
	$(CPLUS) $(MODEL) $(CFLAGS) $(EXTRA_CFLAGS) -c -o $@ $< 
.C.asm:
	$(CPLUS) $(MODEL) $(CFLAGS) $(EXTRA_CFLAGS) -S -o $@ $<
	@echo NOTE: $@ is a temporary file
.C.E:
	$(CPLUS) $(MODEL) $(CFLAGS) $(EXTRA_CFLAGS) -E -o $@ $<

.cpp.o: 
	$(CPLUS) $(MODEL) $(CFLAGS) $(EXTRA_CFLAGS) -c -o $@ $< 
.cpp.asm:
	$(CPLUS) $(MODEL) $(CFLAGS) $(EXTRA_CFLAGS) -S -o $@ $<
	@echo NOTE: $@ is a temporary file
.cpp.E:
	$(CPLUS) $(MODEL) $(CFLAGS) $(EXTRA_CFLAGS) -E -o $@ $<

.cxx.o: 
	$(CPLUS) $(MODEL) $(CFLAGS) $(EXTRA_CFLAGS) -c -o $@ $< 
.cxx.asm:
	$(CPLUS) $(MODEL) $(CFLAGS) $(EXTRA_CFLAGS) -S -o $@ $<
	@echo NOTE: $@ is a temporary file
.cxx.E:
	$(CPLUS) $(MODEL) $(CFLAGS) $(EXTRA_CFLAGS) -E -o $@ $<

.c.o:
	$(CC) $(MODEL) $(CFLAGS) $(EXTRA_CFLAGS) -c -o $@ $<
.c.asm:
	$(CC) $(MODEL) $(CFLAGS) $(EXTRA_CFLAGS) -S -o $@ $<
	@echo NOTE: $@ is a temporary file
.c.E:
	$(CC) $(MODEL) $(CFLAGS) $(EXTRA_CFLAGS) -E -o $@ $<

.S.o:
	$(CC) -DASSEMBLER $(CFLAGS) $(EXTRA_CFLAGS) -c -o $@ $<
.S.E:
	$(CC) -DASSEMBLER $(CFLAGS) $(EXTRA_CFLAGS) -E -o $@ $<


#--------------------------------------
#	Programs to use:
#
## SHELL = /bin/sh

#CPLUS = /root/spede/Target-i386/i686/gnu/bin/i386-unknown-gnu-g++
CC = i386-unknown-gnu-gcc
AS = i386-unknown-gnu-as
AR = i386-unknown-gnu-ar
NM = i386-unknown-gnu-nm
CMD_LINKER = link386
CMD_MAKEMAKE = spede-mkmf

CMD_TAGS = ctags
CMD_DELETE = rm -f
CMD_COPY = cp -p

#  Program and options to download a DLI file.
CMD_DOWNLOADER = flash -d


#
#  Given the operating system name as a base, add various extensions.
#
MY_DLI = $(OS_NAME).dli


#--------------------------------------
#	List of files to be removed by "make clean"
#	Emacs rename backup files to foo~ (trailing tilde).
#

CLEAN_FILES = core *.o *.asm mapfile $(MY_DLI) *~ make.orig *.E tags \
	TAGS $(OS_NAME).boot $(OS_NAME).bin *.RC


#--------------------------------------
#	Options and Flags:
#

#
#  Optimizations flags and what they do. (*) Recommended.  If generating
#	A.OUT files, must specifiy "-fwritable-strings".
#
#	-fno-defer-pop		Immediately after function return, pop
#				the argument off (easier to debug).
#	-fdefer-pop		Wait until control flow splits before
#				popping functions args from stack.
#	-fwritable-strings	Please string constants in .data segment
#				so they can be modified (away from .code).
#	-fnowritable-strings	Please string constants inside .code segment,
#				which makes code dis-assembly confusing.
#	-O1			Perform minor optimizations. Also does code
#				flow analysis for improved error reporting.
#
## OPTIMIZE = -O1 -fno-defer-pop
OPTIMIZE =

#
#  If you set $CF_DEBUG to -g here, source files will _always_ compile
#  with symbolic debugging info.  Which makes "make debug" redundant.
#
CF_DEBUG = -g
TARGET_MACH = -i386-unknown-gnu
MODEL = $(TARGET_MACH)

#
#  $CFLAGS and $EXTRA_CFLAGS will be passed to GCC compiler.
#  -Wall	Report as many errors and warnings as possible.
#  -g		ALways include dbeug info on objects.
#
CFLAGS = -Wall $(OPTIMIZE) -g
ASFLAGS = $(TARGET_MACH)

LINK_FLAGS = $(CF_DEBUG) $(EXTRA_LINK_FLAGS)


#--------------------------------------
#	Start of "targets" which can be specified when invoking "make":
#	Added $(OS_NAME) for people that want a short-hand.
#
#	The use of double-colons (::) here allows the "local.mk" file to
#	extend all targets  This is required for `phony' targets (those
#	which don't actually create anything).
#
.PHONY :	all debug d clean text depends depend source help \
	$(OS_NAME) tags bootable salone tarball

all ::	$(MY_DLI)

$(OS_NAME) ::	$(MY_DLI)

debug ::
	-@$(CMD_DELETE) $(MY_DLI)
	@$(MAKE) 

d ::
	$(CMD_DOWNLOADER) $(MY_DLI)

clean ::
	$(CMD_DELETE) $(CLEAN_FILES)

tags ::
	$(CMD_TAGS) $(SRC)

text ::
	objdump386 --disassemble --file-headers --reloc --source $(MY_DLI) > dli.asm
	@echo "Image dis-assembly into dli.asm done."

tarball :	source
	tar cvf ../$(OS_NAME).tar $(SRC) *.h Makefile

bootable ::	$(MY_DLI) $(OS_NAME).ini RAWRITE.EXE 
	bootmaker -floppy $(OS_NAME).ini $(OS_NAME).boot
	@echo "Raw copy using \`dd' or RAWRITE.EXE $(OS_NAME).boot to a floppy."
	@echo "   dd if=$(OS_NAME).boot of=/dev/rdiskette bs=512"

salone ::	$(MY_DLI) $(OS_NAME).ini BOOT.COM
	bootmaker  $(OS_NAME).ini $(OS_NAME).bin
	@echo "Copy $(OS_NAME).bin and BOOT.COM to a floppy."

depends ::	depend
depend ::
	$(CMD_MAKEMAKE)

source ::	$(SRC)

help ::
	@echo "This Makefile builds $(MY_DLI)."
	@echo " make all     -- Builds your program $(MY_DLI)"
	@echo " make debug   -- Create program ready for symbolic debugging"
	@echo " make d       -- Download *current* version of $(MY_DLI)"
	@echo " make clean   -- Remove files which can be regenerated"
	@echo " make text    -- Dis-assemble $(MY_DLI) into 'dli.asm'"
	@echo " make tags    -- function tags for Emacs and vi"
	@echo " make depend  -- Rebuild dependencies"
	@echo " make source  -- Retrieve all source files from version control"
	@echo " make tarball -- Create TAR file in parent directory"
	@echo " make bootable -- Create self-booting image '$(OS_NAME).boot'"
	@echo " make salone  -- Create stand-alone version '$(OS_NAME).bin'"

#-------------------------------------
#  List of object files.
#### YQYQYQ-MARK-1 ####

OBJECTS =  entry.o kernel.o ksr.o proc.o tools.o

#### YQYQYQ-STOP-1 ####
#-------------------------------------
#	If user has a "local.mk" here, then include that too.
#	Can add more dependencies to "all".  If extending existing targets,
#	you must use double-colon rules (see them above).  These rules are
#	executed in the order seen, ie those above, then from "local.mk".
#
#	Using "-include local.mk", GNU Make won't complain if file not found.
#

-include local.mk

#
#   Create a bootmaker INI file on demand.
#
$(OS_NAME).ini :
	@echo "Note: creating $(OS_NAME).INI file for bootmaker utility."
	@echo '#  Bootmaker INI file ($(MKF_VERSION)), created ' `date` > $(OS_NAME).ini
	@echo "[kernel]" 	>>		$(OS_NAME).ini
	@echo "type=boot" 	>> 		$(OS_NAME).ini
	@echo "file=$(MY_DLI)"	>> 		$(OS_NAME).ini
	@echo "ventry=128" 	>> 		$(OS_NAME).ini


#--------------------------------------
#	Programs to support booting from a floppy disk.
#	Files are stored in tools/etc/ dir.  Use dirname to remove "flash".
#	Climb to parent and back down to ../etc/ directory.  This convolution
#	means this file has no SPEDE paths hard-coded into it.
#
RAWRITE.EXE BOOT.COM :
	( d=`which flash` ; $(CMD_COPY) `dirname $$d`/../etc/$@ . );


#-------------------------------------
# end of primary targets
#--------------------------------------


#--------------------------------------
#	Targets that every SPEDE GCC project will have.
#

$(MY_DLI) :	$(OBJECTS) Makefile
	$(CMD_LINKER) $(LINK_FLAGS) -o $(MY_DLI) $(OBJECTS)


#--------------------------------------
#
#  Dependencies.
#### YQYQYQ-MARK-2 ####
#
#  Dependencies generated Thu Sep 12 18:41:13 PDT 2019 by (spede-mkmf $Revision: 1.2 $/1)
#

entry.o: entry.S \
 /gaia/home/project/spede2/Target-i386/i686/gnu/i386-unknown-gnu/include/spede/machine/asmacros.h \
 /gaia/home/project/spede2/Target-i386/i686/gnu/i386-unknown-gnu/include/spede/sys/cdefs.h
ksr.o: ksr.c spede.h \
 /gaia/home/project/spede2/Target-i386/i686/gnu/i386-unknown-gnu/include/spede/stdio.h \
 /gaia/home/project/spede2/Target-i386/i686/gnu/i386-unknown-gnu/include/spede/sys/cdefs.h \
 /gaia/home/project/spede2/Target-i386/i686/gnu/i386-unknown-gnu/include/spede/stdarg.h \
 /gaia/home/project/spede2/Target-i386/i686/gnu/i386-unknown-gnu/include/spede/flames.h \
 /gaia/home/project/spede2/Target-i386/i686/gnu/i386-unknown-gnu/include/spede/sys/types.h \
 /gaia/home/project/spede2/Target-i386/i686/gnu/i386-unknown-gnu/include/spede/sys/ascii.h \
 /gaia/home/project/spede2/Target-i386/i686/gnu/i386-unknown-gnu/include/spede/sys/bits.h \
 /gaia/home/project/spede2/Target-i386/i686/gnu/i386-unknown-gnu/include/spede/machine/io.h \
 /gaia/home/project/spede2/Target-i386/i686/gnu/i386-unknown-gnu/include/spede/stddef.h \
 /gaia/home/project/spede2/Target-i386/i686/gnu/i386-unknown-gnu/include/spede/machine/proc_reg.h \
 /gaia/home/project/spede2/Target-i386/i686/gnu/i386-unknown-gnu/include/spede/machine/seg.h \
 /gaia/home/project/spede2/Target-i386/i686/gnu/i386-unknown-gnu/include/spede/machine/asmacros.h \
 const-type.h ext-data.h tools.h
proc.o: proc.c const-type.h ext-data.h
tools.o: tools.c

#### YQYQYQ-STOP-2 ####

# eof

