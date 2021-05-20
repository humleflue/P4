# ANTLR Compiler

A compiler built for a close-to-pure functional programming language for beginners.

- [ANTLR Compiler](#antlr-compiler)
    * [Installation](#installation)
        + [Unix](#unix)
    * [Development setup](#development-setup)
        + [Windows (with WSL)](#windows-with-wsl)
        + [Running the compiler with IntelliJ IDEA](#running-the-compiler-with-intellij-idea)

## Installation

### Unix

0. Install Java (version 15)

Run the following commands in your terminal:

```shell
$ sudo apt-get install openjdk-15-jre
$ sudo apt-get install openjdk-15-jdk
$ export JAVA_HOME=/usr/lib/jvm/openjdk-15-jdk
$ export PATH=$PATH:$JAVA_HOME/bin
```

1. Download the jar file

Run the following commands in your terminal:

```shell
$ cd /usr/local/lib
$ sudo curl -O https://skaalum.tech/downloads/buff-1.03.jar
```

Or just download in browser from website: https://skaalum.tech/downloads/buff-1.03.jar and put it somewhere rational
like `/usr/local/lib`.

2. Create an alias for the Buff tool

Run the following command in your terminal:

```shell
$ alias buff='java -jar /usr/local/lib/buff-1.03.jar'
```

2.
    1. OPTIONAL: It's a good idea to put the alias in your `.bashrc` file

       Run the following command in your terminal:

        ```shell
        $ vim ~/.bashrc
        ```

        - Press `SHIFT` + `G` to go to the bottom of the file.
        - Press `SHIFT` + `A` to edit the file.
        - Press `ENTER` to make a line break.
        - Paste in `alias buff='java -jar /usr/local/lib/buff-0.1.jar'`.
        - Save and close the file with the following keystrokes: `ESCAPE`, `:`, `w`, `q`, `ENTER`

    2. Run the following command to rerun `.bashrc`:
        ```shell
        $ source ~/.bashrc
        ```

Now you should be able to compile a file by changing to a directory you would like to contain your file and running the
following command in your terminal, given that you have written some buff code in a file called `hello_world.buff`:

```shell
$ buff hello_world.buff
```

## Development setup

Follow the [Getting Started with ANTLR](https://github.com/antlr/antlr4/blob/master/doc/getting-started.md) guide.

### Windows (with WSL)

To be able to generate the ANTLR files, run the following sequence of commands in WSL from the `ANTLR/src/Compiler`
directory:

```
$ sudo apt install dos2unix 
$ dos2unix *.sh
$ ./generatefiles.sh
```

Now you should be all set an ready to compile the program.

### Running the compiler with IntelliJ IDEA

Open the ANTLR folder as an IntelliJ IDEA project.

Follow [this guide](https://stackoverflow.com/a/1051705/12545726) to add the two `.jar` files found in
the `./Dependencies` directory to the project.

After doing the above, you should be able to build and run the program from the top right of IntelliJ IDEA by pressing
the `Run selected configuration` button symbolized by the tilted green triangle. **If the tilted green triangle is
greyed out**, right click the `Main` file in the `Project tool` sidebar and select `Run 'Main'` from the dropdown menu. 
