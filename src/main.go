// Day 5 of Advent of Code by Nils Offermann
package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
)

func main() {
	var test []string = fileToArray("./src/input.txt")
	fmt.Println(test[0])
}

func fileToArray(input string) []string {
	file, err := os.Open(input)

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
