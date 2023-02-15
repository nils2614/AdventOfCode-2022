// Day 5 of Advent of Code by Nils Offermann
package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strconv"
)

func main() {
	var inputSlice []string = fileToSlice("./src/input.txt")
	var stackSlice [][]string = initializeStacks(inputSlice, 9, 8) //inputSlice[10]
	stackSlice = modifyStacks(stackSlice, "move 35 from 9 to 423")
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

	err = file.Close()
	if err != nil {
		return nil
	}
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
	spaces := [6]int{}
	index := 0

	for i := 0; i < len(mod); i++ {
		if mod[i] == 32 {
			spaces[index] = i
			index++
		}
	}
	spaces[5] = len(mod) // Add end of line as pseudo space

	fmt.Println(spaces)
	for i := 0; i < 3; i++ {
		tempNumber := ""
		for j := 1; j <= (spaces[(i*2)+1] - spaces[(i*2)] - 1); j++ {
			tempNumber = tempNumber + string(mod[spaces[(i*2)]+j])
		}
		//fmt.Println(tempNumber) // debug print

		toInt, _ := strconv.Atoi(tempNumber)
		returnArray[i] = toInt
	}

	fmt.Println(returnArray)
	return returnArray
}
