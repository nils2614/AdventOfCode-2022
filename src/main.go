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
	var stackSlice [][]string = initializeStacks(inputSlice, 9, 8) //inputSlice[10]
	stackSlice = modifyStacks(stackSlice, "move 3 from 9 to 4")
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

func modifyStacks(mySlice [][]string, mod string) [][]string {
	interpretModification(mod)
	return mySlice
}

func interpretModification(mod string) [3]int {
	returnArray := [3]int{0, 0, 0}
	spaces := [5]int{}
	index := 0

	for i := 0; i < len(mod); i++ {
		if mod[i] == 32 {
			spaces[index] = i
			index++
		}
	}

	fmt.Println(spaces)
	fmt.Println(string(mod[spaces[0]+1]))
	fmt.Println(string(mod[spaces[2]+1]))
	fmt.Println(string(mod[spaces[4]+1]))

	return returnArray
}
