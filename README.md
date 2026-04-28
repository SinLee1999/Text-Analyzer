# Text Analyzer

A simple Java program that analyzes a text file and provides basic statistics such as word count, frequency, and the longest word.

## Features

* Counts total number of words
* Counts number of unique words
* Calculates letter frequency
* Calculates word frequency
* Finds the longest word
* Displays the top N most frequent words

## How It Works

The program reads a text file (data.txt), processes each word by:

* Converting to lowercase
* Removing non-alphabetic characters
* Counting occurrences using a `HashMap`




## Example Output

```
Top 4 most frequent words 
sells => 4
she => 4
shells => 3
the => 3

Total words = 27
Unique words = 14
Longest word = seashells

```

## Customization

* Change the input file name in:

  ```java
  File f = new File("data.txt");//data.txt to your file name.
  ```
* Adjust the number of top frequent words:

  ```java
  printTopFrequentWords(map, 2);
  ```

## Future Improvements

* Accept file input from command line arguments
* Ignore common stop words (e.g., "the", "and", "is")
* Handle punctuation more robustly
* Add sorting options (alphabetical, frequency ascending, etc.)
* Export results to a file

## Author

Sin Lee


