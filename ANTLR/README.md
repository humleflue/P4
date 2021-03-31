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
Open this folder as an IntelliJ IDEA project.

Follow [this guide](https://stackoverflow.com/a/1051705/12545726) to add the two `.jar` files found in the `./Dependencies` directory to the project.

After doing the above, you should be able to build and run the program from the top right of IntelliJ IDEA by pressing the `Run selected configuration` button symbolized by the tilted green triangle.

**If tilted green triangle is greyed out**, left click the `Main` file in the Project tool window and select `Run 'Main'` from the dropdown menu. 