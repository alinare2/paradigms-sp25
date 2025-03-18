import random

class Word:
    def __init__(self, word):
        self.word = word
        self.charList = [char.upper() for char in word]
        self.charSet = set(self.charList)
        
        #arrays for game state
        self.good = []
        self.bad = []
        self.correct = [""] * 5
    
    #special method to check if word attribute in Word class are the same.
    def __eq__(self, obj):
        return self.charList == obj.charList
    
    #checks word state
    def checkWord(self, obj, attempt):
        #compares each letter in guess and catagorizes it as bad, good, correct
        for i, char in enumerate(self.charList):
            if char == obj.charList[i]:
                if char not in obj.good:
                    obj.good.append(char)
                obj.correct[i] = char
            elif (char in obj.charSet):
                if char not in obj.good:
                    obj.good.append(char)
            else:
                if char not in obj.bad:
                    obj.bad.append(char)
        
        #if guess is word then prints message and returns true
        if (self == obj):
            print(f'Congratulations, you correctly identified the word after {attempt} attempts')
            return True 
        
        #prints current game state and returns false otherwise
        print(f'Good letters ={obj.good}')
        print(f'Bad letters ={obj.bad}')
        print(f'Correct letters ={obj.correct}\n')
        return False

#validating input for correct format
def getValidWord(wordList):
    while True:
        choice = input("Enter a valid 5-letter word: ").upper()
        if len(choice) != 5:
            print("Error: Word must be exactly 5 letters long.")
        elif (choice not in wordList):
            print("Error: Word not in List.")
        else:
            return choice

#read in the words.txt file into output
with open("words.txt", 'r') as f:
    output = f.read()
#split words by new line 
wordList = output.split('\n')

#open file in write mode to add each valid guess
fileToWrite = open('answer.txt', 'w')

#selects word from list and makes it into a Word class
selectedWord = random.choice(wordList)
answer = Word(selectedWord)

#init attempt count
attempt = 1

while (attempt <= 6):
    #get user input and turn to Word class
    wordChoice = getValidWord(wordList)
    choice = Word(wordChoice)
    
    #add to write file
    fileToWrite.write(choice.word+"\n")
    
    #checks game state for the word and breaks if guessed correctly
    if (choice.checkWord(answer, attempt)):
        break
    attempt += 1


fileToWrite.close()

#if correct guess then the loop ends early therefore we can check if user did not guess word
if (attempt > 6):
     print(f'The answer is {answer.word}. You did not correctly guess it within 6 tries.')