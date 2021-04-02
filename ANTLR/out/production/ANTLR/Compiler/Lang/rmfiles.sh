#!/bin/bash
shopt -s extglob
echo Removing all unnecessary files...
rm !(README*|*.g4|*.sh)
echo All files removed successfully.
