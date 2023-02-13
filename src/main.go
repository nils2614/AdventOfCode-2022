// Day 5 of Advent of Code by Nils Offermann
package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
)

func main() {
	var inputSlice []string = fileToSlice("./src/input.txt")
	var myStacks [][]string = initializeStacks(inputSlice, 9, 8)
	fmt.Println(myStacks[2])
}

func fileToSlice(inputFile string) []string {
	file, err := os.Open(inputFile)

	if err != nil {
		log.Fatalf("failed to open")
	}

	scanner := bufio.NewScanner(file)
	scanner.Split(bufio.ScanLines)
	var text []string

	for scanner.Scan() {
		text = append(text, scanner.Text())
	}

	file.Close()
	return text
}

func initializeStacks(inputSlice []string, width int, height int) [][]string {
	stackArray := make([][]string, width, width)

	for i := 0; i < width; i++ {
		stackArray[i] = make([]string, height, 50)
		for j := height - 1; j >= 0; j-- {
			myChar := string(inputSlice[j][1+i*4])
			//fmt.Println("i:", i, "j:", j, "c:", myChar)
			if myChar != " " {
				stackArray[i][height-j-1] = myChar
			}
		}
	}

	return stackArray
}
