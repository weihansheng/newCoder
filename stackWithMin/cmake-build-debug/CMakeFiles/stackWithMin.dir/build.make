# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.8

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/ke/program/clion-2017.2.2/bin/cmake/bin/cmake

# The command to remove a file.
RM = /home/ke/program/clion-2017.2.2/bin/cmake/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/ke/CLionProjects/stackWithMin

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/ke/CLionProjects/stackWithMin/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/stackWithMin.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/stackWithMin.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/stackWithMin.dir/flags.make

CMakeFiles/stackWithMin.dir/main.cpp.o: CMakeFiles/stackWithMin.dir/flags.make
CMakeFiles/stackWithMin.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/ke/CLionProjects/stackWithMin/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/stackWithMin.dir/main.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/stackWithMin.dir/main.cpp.o -c /home/ke/CLionProjects/stackWithMin/main.cpp

CMakeFiles/stackWithMin.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/stackWithMin.dir/main.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/ke/CLionProjects/stackWithMin/main.cpp > CMakeFiles/stackWithMin.dir/main.cpp.i

CMakeFiles/stackWithMin.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/stackWithMin.dir/main.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/ke/CLionProjects/stackWithMin/main.cpp -o CMakeFiles/stackWithMin.dir/main.cpp.s

CMakeFiles/stackWithMin.dir/main.cpp.o.requires:

.PHONY : CMakeFiles/stackWithMin.dir/main.cpp.o.requires

CMakeFiles/stackWithMin.dir/main.cpp.o.provides: CMakeFiles/stackWithMin.dir/main.cpp.o.requires
	$(MAKE) -f CMakeFiles/stackWithMin.dir/build.make CMakeFiles/stackWithMin.dir/main.cpp.o.provides.build
.PHONY : CMakeFiles/stackWithMin.dir/main.cpp.o.provides

CMakeFiles/stackWithMin.dir/main.cpp.o.provides.build: CMakeFiles/stackWithMin.dir/main.cpp.o


# Object files for target stackWithMin
stackWithMin_OBJECTS = \
"CMakeFiles/stackWithMin.dir/main.cpp.o"

# External object files for target stackWithMin
stackWithMin_EXTERNAL_OBJECTS =

stackWithMin: CMakeFiles/stackWithMin.dir/main.cpp.o
stackWithMin: CMakeFiles/stackWithMin.dir/build.make
stackWithMin: CMakeFiles/stackWithMin.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/ke/CLionProjects/stackWithMin/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable stackWithMin"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/stackWithMin.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/stackWithMin.dir/build: stackWithMin

.PHONY : CMakeFiles/stackWithMin.dir/build

CMakeFiles/stackWithMin.dir/requires: CMakeFiles/stackWithMin.dir/main.cpp.o.requires

.PHONY : CMakeFiles/stackWithMin.dir/requires

CMakeFiles/stackWithMin.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/stackWithMin.dir/cmake_clean.cmake
.PHONY : CMakeFiles/stackWithMin.dir/clean

CMakeFiles/stackWithMin.dir/depend:
	cd /home/ke/CLionProjects/stackWithMin/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/ke/CLionProjects/stackWithMin /home/ke/CLionProjects/stackWithMin /home/ke/CLionProjects/stackWithMin/cmake-build-debug /home/ke/CLionProjects/stackWithMin/cmake-build-debug /home/ke/CLionProjects/stackWithMin/cmake-build-debug/CMakeFiles/stackWithMin.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/stackWithMin.dir/depend

