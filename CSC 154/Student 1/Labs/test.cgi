#!/bin/bash

echo "Content-type: text/plain"
echo
echo "*** Environment variables ***"
strings /proc/$$/environ
