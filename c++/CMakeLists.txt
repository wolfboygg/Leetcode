cmake_minimum_required(VERSION 3.17)
project(c_leetcode)

set(CMAKE_CXX_STANDARD 14)

add_executable(c_leetcode main.cpp repeatnum/RepeatNumber.cpp repeatnum/RepeatNumber.h findinarray/FindNumInEWArray.cpp findinarray/FindNumInEWArray.h replacespace/ReplaceSpace.cpp replacespace/ReplaceSpace.h clockprintarray/ClockPrintArray.cpp clockprintarray/ClockPrintArray.h findfirstcharinstring/FindFirstCharInString.cpp findfirstcharinstring/FindFirstCharInString.h)