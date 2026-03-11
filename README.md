# ITP4507-Assignment
> **IVE 2015/16 Contemporary Topics in Software Engineering (ITP4507) Assignment**
>
> A robust command-line Java application designed for sophisticated security record management, leveraging multiple GoF (Gang of Four) design patterns to ensure scalability and maintainability.

[![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?logo=openjdk&logoColor=white)](#) &nbsp;
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE) &nbsp;

## System Architecture & Design Patterns
The core strength of APMS lies in its architectural design, ensuring that the system is "Open for extension, closed for modification."

### Applied Patterns:
* **Command Pattern:** Encapsulates all operations (create, deposit, withdraw, etc.) as objects, enabling a unified interface for execution and the ability to maintain a history for undo/redo.
* **Factory Pattern:** Decouples the creation logic of `Security` objects (Bonds, Stocks) and `Command` objects, allowing for easy integration of new security types in the future.
* **Memento Pattern:** Captures and externalizes the state of the security records, providing the foundation for the multi-level **Undo** and **Redo** functionality.

## Key Features
* **Dynamic Security Creation:** Supports Bonds and Stocks with zero initial quantity.
* **Flexible Inspection:** View detailed metrics (code, name, quantity, yield/exchange) for specific items or all records via `##`.
* **Transaction Management:** Streamlined deposit and withdrawal workflows.
* **Advanced State Control:** Full support for tracking, undoing, and redoing commands via an active command list.

## Command Reference
| Key | Action | Description |
| :---: | :--- | :--- |
| `n` | **New Record** | Create a new Security (`bo` for Bond, `st` for Stock) |
| `s` | **Show** | Display details of a security code (or `##` for all) |
| `d` | **Deposit** | Add quantity to an existing record |
| `w` | **Withdraw** | Subtract quantity from an existing record |
| `l` | **List** | Display the current Undo and Redo history stacks |
| `u` | **Undo** | Revert the last executed command |
| `r` | **Redo** | Re-execute the last undone command |
| `q` | **Quit** | Terminate the system |

## Installation & Execution
### Prerequisites
* JDK 8 or higher installed.

### Build from Source
```
cd Portfolio
javac *.java
```

### Run the program
```
java Main
```
**Note:** Windows users can also simply double-click the `run.bat` file to run the program.

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
