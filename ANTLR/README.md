# ANTLR Compiler
A compiler built for a close-to-pure functional programming language for beginners.
## Setup
Follow the [Getting Started with ANTLR](https://github.com/antlr/antlr4/blob/master/doc/getting-started.md) guide.
### Windows (with WSL)
To be able to generate the ANTLR files, run the following sequence of commands in WSL from the root directory:
```
$ cd src/Compiler/Lang
$ dos2unix *.sh
$ ./generatefiles.sh
```
**Note:** you may need to install dos2unix for the above to work. This can easily be done, by running the following command in WSL:
```
$ sudo apt install dos2unix 
```
Now you should be all set an ready to compile the program.

## Running the compiler with IntelliJ IDEA
Follow [this guide](https://stackoverflow.com/a/1051705/12545726) to add the two `.jar` files in the `./Dependencies` directory to the project.

To be able to run the compiler from IntelliJ IDEA, left click the `Main` file in the Project tool window and select `Run 'Main'` from the dropdown menu. 

After doing the above, you should be able to run the program from the top right of IntelliJ IDEA by pressing the `Run selected configuration` button symbolized by the tilted green triangle.