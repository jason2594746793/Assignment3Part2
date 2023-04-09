    # Writing for Assignment&nbsp;3 Part&nbsp;2 2023 #

- **Jingsheng Chen**
- **S2345463**
- **03**
- **Daniel Barber**
- **2023-04-08**

## Acknowledgements ##

| People                                                                           | Helps me                                                                                                                                                                                                                                                                             |
|----------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [ Kasia Zawistowska on piazza](https://piazza.com/class/lbkxl8hz9he5ae/post/249) | How to edit run configuration to pass my input files                                                                                                                                                                                                                                 |
| [ Brian Mitchell on piazza](https://piazza.com/class/lbkxl8hz9he5ae/post/234)    | - Instructions on activating the test files for "a3algorithms" <br/> - Clarification on translate(FrequencyWord) method in the Translation file<br/> - Clarification on the confusions caused by duplication of tasks and codes <br/> - Clarification on the libraries allowed <br/> |

| Technology                                                                                                | Helps me                                                                                                                            |
|-----------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------|
| OOP lecture 7 slides                                                                                      | How to import packages and how to refer to packages that have not imported.                                                         |
| OOP lecture 8 slides                                                                                      | - How to add and retrieve in ArrayLists and Hashmap<br/> - How to use enhanced loop<br/> - Usage of string.split                    |
| OOP lecture 10 slides                                                                                     | - How does modularisation and encapsulation works. <br/>- usage of private/public/protected modifier                                |                                                                               |
| OOP lecture 15 slides                                                                                     | - how does abstract and concrete classes and methods work <br/>- How to extends an abstract class                                   |
| [Oracle Java Documentation on Scanner ](https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html) | - How to use Scanner to read files <br/> - Usage of methods including hasNextLine()                                                 |
| [Oracle Java Documentation on Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)          | - How to use Map to store and match data <br/> - Usage of methods including containsKey(), put() and get()                          |
| [Oracle Java Documentation on Set](https://docs.oracle.com/javase/7/docs/api/java/util/Set.html)          | - How to use Set to store unique data.<br/> - Usage of methods including isEmpty(), contains(), toArray() and add()                 |
| [Stack Overflow](https://stackoverflow.com/a/57363630)                                                    | - Ensure my local machine has the correct jdk version as the assignement required                                                   |
| [Stack Overflow](https://stackoverflow.com/a/10079499)                                                    | - How to split a string with the separator as space or mutiple spaces.                                                              |
| [Stack Overflow](https://stackoverflow.com/a/1419849)                                                     | - understanding Enums in Java, and when and why to use Enum classes.                                                                |
| [Quora](https://qr.ae/prQyno)                                                                             | Understand the meaning of the reqex [^a-zA-Z0-9'\\s]+                                                                               |
| [Youtube](https://www.youtube.com/watch?v=vZm0lHciFsQ&ab_channel=CodingwithJohn)                          | How to use JUnit testing in Intellij                                                                                                |
| [w3school switch](https://www.w3schools.com/java/java_switch.asp)                                         | How to use switch statement in Java                                                                                                 |
| [Youdao Translator](https://fanyi.youdao.com/index.html#/)                                                | - Translated parts of the instructions that I do not understand into Chinese <br/> - Corrected some grammar mistakes of my writting |
| [Markdown Guide](https://www.markdownguide.org/extended-syntax/)                                          | Helped me to draw table using markdown format                                                                                       |

## Code location ##

When placing the code in `literatureStats`, I started by finding the classes that has
the most similarity on the structure as the classes in `a3algorithms`. In this case, `literatureStats.Verbosity`
class, `literatureStats.SortingOrder` class, and `literatureStats.Runner` class are almost identical to
`a3algorithms.Verbosity`, `a3algorithms.SortingOrder`, and `a3algorithms.ExampleRunner`.
Therefore, I just moved the code to the same methods in those classes.

`a3algorithms.SimpleFrequencyWord` and `literatureStats.FrequencyWord`
have similar structure as well, but `literatureStats.FrequencyWord` has a `normalise` method that uses the code from
`a3algorithms.Normaliser`, and `literatureStats.FrequencyWord` uses normalised word at places where
`a3algorithms.SimpleFrequencyWord` uses the original word. Other than that, they are almost
identical. So I moved the code to the same methods and just replace `word`
by `normalised`. I also used part of the code from `AdvancedTestFileReader`'s advancedReadFile method
to `FrequencyDocumentReader`'s readDocument method, since they both require to process the file/document between
a startmark and stopmark.

Additionally `literatureStats.Translation` used codes in `a3algorithms.VowelChecker` and
`a3algorithms.TrollSpeaker`. VowelChecker is used in `translate` method to check if a
character is a vowel and TrollSpeaker is used to translate a word into a troll language.

## DRY programming ##

Using package `literatureStats` and `a3algorithms` are a typical example of DRY programming.
Package can help encapsulation by providing different levels of visibility(verbosity in our case)
for classes.
It could help maintenance as it is clear where to find specific functionality. It also enables
code reuse across projects, which can save time and effort. A WET version of this might have
classes and methods with the same functionality, which can cause code duplication and increase
the maintenance cost.

Another example of DRY programming in our project is that the `FrequencyDocumentPG` inherits
`FrequencyDocument`, which means that `FrequencyDocumentPG` can use methods in
`FrequencyDocument`. This can avoid code duplication and increase the maintainability of the code.

`FrequencyDocument` and `FrequencyDocumentPG` both have multiple `constructor`s
with different parameters, so that they can be instantiated in different ways, while
keep the important logic of the constructor in one place. A WET version of this might have
different logic for different parameters, which can cause code duplications.
They also have several overloaded version of the `initialise` method with different
parameters. This ensures that they will eventually call the most complete version
of the method with all parameters, which can avoids code duplication.

## Relationships ##

`DataScientist` class acts as the central point of this project,
it is managing the execution of the two experiments.
`Runner` is used for start the main application, this class creates a `DataScientist`
class to perform the experiments.
`SortingOrder` is accessed by `DataScientist` class directly when invoking methods
like getTopNWords from `InformationDocument` class.
`Translation` is used by `DataScientist` in the experiment1Phase1, experiment1Phase3,
experiment2Phase1, and experiment2Phase3.

`InformationDocument` is used by `DataScientist` to hold instances
of both `FrequencyDocument` and `FrequencyDocumentPG`.It provides methods like getTopNWords,
getTopNWordsEnumerated, and getTopNFrequencyWords which are used by
`DataScientist` to perform the experiments

`FrequencyDocument` is accessed by `DataScientist` through `InformationDocument` class, via the
`InformationDocument<FrequencyDocument>` object.
`FrequencyDocumentPG` is a subclass of `FrequencyDocument`, and `DataScientist` access
this class in a similar way, which is also through the `InformationDocument<FrequencyDocumentPG>` object.
This design enables the `InformationDocument` class to
create the appropriate frequency document type depending on the experiment being executed.

`FrequencyDocumentReader` is accessed by DataScientist class via the `FrequencyDocument`
and `FrequencyDocumentPG` classes, which use the `FrequencyDocumentReader` to read and process documents.
`FrequencyReaderConfig` is accessed by DataScientist class via `FrequencyDocument` and `FrequencyDocumentPG`
classes, which use the `FrequencyReaderConfig` to create their configurations, and where
`Verbosity` is used to adjust the verbosity level of the document reader.
`FrequencyWord` is accessed by DataScientist class with `FrequencyWord` instances
via the `InformationDocument` class methods. `FrequencyWord` is also accessed by `FrequencyDocument`
and `FrequencyDocumentPG` classes, which use the `FrequencyWord` to create their word list.

## Explain reading a file ##

In the `FrequencyDocumentReader` class, there are serveral overloaded version of the `readDocument` method.
`readDocument(FrequencyReaderConfig config, String nonWordChars)` is the main method
for reading and processing the document. It takes a `FrequencyReaderConfig`
object and a pattern of the non-word characters, and follow the algorithm below to read and process the document:

1. The method uses the Scanner class to read the file line by line inside a try-with-resource block.
2. The method checks if the document has START_MARKER and if current line contains the
   START_MARKER, if yes, the next process can be started, else it checks if the
   document has STOP_MARKER and if current line contains STOP_MARKER, if fail, meaning there is
   no START and STOP markers for the document, else it means the STOP_MARKER is met and the
   process should be terminated.
3. The method remove all non-word characters in the current line and lowercase all the
   characters, then split the line into an array of words.
4. The method then iterate through the array of words, and for each word, it checks if the word
   is in the result map, if yes, it increments the frequency of the word, else it adds the word to the
   result map with frequency 1.
5. The method returns the result map.

In this class I have used `java.util.Scanner` to read the file line by line, and `java.util.HashMap` to store the
result. I have also used `java.util.String` to split the line into an array of words.

JDK 7 or later is recommended here becuase it has many new features, such as the try-with-resources statement,
which is introduced in Java 7. It is designed specifically
to handle resources that need to be closed after their usage, such as file streams, database connections,
or network sockets. In our case, it ensures the scanner is automatically closed
when it's no longer needed within a try-with-resources block.

## Explain your translate-to-dog implementation ##

My algorithm takes a word and converts it into doggie language by first make sure
the word is not empty, then it finds
the initial non-vowel characters in the word by compare each character to vowels.
Then the algorithm checks if the word begin with any of the special letters,
which are "b,g,r,w(and wo)". If the word begin with any of these letters,
the algorithm moves the non-vowel characters to the end and adds its special ending.
If the word doesn't begin with those special letters, the algorithm  
moves the non-vowel cluster to the end and adds "ay".
Finally, it returns the translated word.
