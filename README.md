# ITP4507-Assignment
> IVE 2015/16 Contemporary Topics in Software Engineering (ITP4507) Assignment

> Java Program: Advanced Portfolio Management System

[![Build Status](https://travis-ci.com/alvinau0427/ITP4507-Assignment.svg?branch=master)](https://travis-ci.org/alvinau0427/ITP4507-Assignment)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

## Getting Started
Advanced Portfolio Management System (APMS) for maintaining security records. Program contains 8 command options for control the data of security, different function correspond different command key.

##### The following design patterns are applied in the system:
- Command pattern: Provide the `create`, `display`, `withdraw`, `undo`, `redo`, and `show undo / redo list` functions.
- Factory pattern: Create different Command objects and Security objects.
- Memento pattern: Provide `undo` and `redo` functions.

## Features
- Create a security record with zero quantity (Bond or Stock or any new kind of security in the coming future).
- Show security details (such as code, name, quantity, yield / exchange) by a given code (input code =## to show all records)
- Deposit / withdarw to / from a security record
- Undo last command
- Redo the last undone command
- Show undo / redo list

##### Function Command List:
(1)	Create Security Record (Command - "n") -> ("bo"/"st") -> ('string,string,float'/'string,string,string')
(2)	Show Security Record (Command - "s") -> ('security code'/ "##")
(3) Deposit Security (Command - "d") -> ('deposit quantity')
(4) Withdraw Security (Command - "w") -> ('withdraw quantity')
(5) Display the Undo/RedoList (Command - "l")
(6) Undo Last Command in the Undo List (Command - "u")
(7) Redo the last undo command (Command - "r")
(8) Exit the system (Command - "q")

## Installation
### Setup
```
$ cd Portfolio
$ javac *.java
```

### Run the program
```
java Main
```
- or execute `run.bat`

## Screenshots
![Image](https://github.com/alvinau0427/ITP4507-Assignment/blob/master/doc/demo.png)

## License
- ITP4507-Assignment is released under the [MIT License](https://opensource.org/licenses/MIT).
```
Copyright (c) 2020 alvinau0427

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
