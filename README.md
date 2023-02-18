# my-wordle-game
Hey yo!

## Backgrounds
It was a Friday afternoon. When the setting sun shined brightly into the huge windows of a 8th floor lounge, I got so bored.  :( 

Trying to keep my brain occupied, I took out my phone for some games. Unfortunately, the first thing (the thrid thing ... to be more accurate) in my mornings is to complete the daliy Wordle challenge on New York Times. So, I got no Wordle to play at that moment. I guess I'm not the only person who thinks the rate New York Times updates their challenges are a bit to slow. 

So, how about making my own Wordle game? A one I can play anytime. 

About myself. I'm a Freshman at an Art School (so it's obvious that I'm currently not majoring in comp-sci lol). And I just got started with Java. So why not write the game program using Java.

DISCLAIMER: I'm relatively new to Java. I don't write the best program. If you came by and saw places that need to be improved, I'll happy if u point them out. (My roommate who's a senior in comp-sci called my program a piece of shit, but I think he's joking, right?"

## How to play

### Where?
In the `src` directory, the `Game` class. 

### Rules:
- Guess the 5 letter word in 6 turns, with given hints from each turn
- "[  ]" means a letter presents and is at the right position.
- "{  }" means a letter presents but is NOT at the right position.

### Sample runs

#### 1. SOLID
In most cases, I start with words like `SLATE`, `CRANE`, `ADIEU` etc. These words may help us to gain the most informaiton, if lucky. 
In turn 1, I guessed `SLATE`. The program tells us at `S` is at the right position and `L` is present in the word but not at the right position. 
So, in turn 2, I guessed `SCOLD`, attempting to gain more info. `D` is at the right position and `O`, `L` are present but not at the right position. 
Then, in turn 3, there's only one word came to my mind - `SOLID`. I guessed it, and it was the answer.
```
Welcome to Wordle in the style of New York Times!
Rules: guess the 5 letter word in 6 turns.
       "[ ]" means the letter presents and is at the right position.
       "{ }" means the letter presents but is NOT at the right position.

--------------------------------GAME-NOW-STARTS---------------------------------

           Begin:  |     |     |     |     |     |  Your guess: slate 
(ACCEPTED) Turn 1: | [S] | {L} |  A  |  T  |  E  |  Your guess: scold
(ACCEPTED) Turn 2: | [S] |  C  | {O} | {L} | [D] |  Your guess: solid
(ACCEPTED) Turn 3: | [S] | [O] | [L] | [I] | [D] |  You've guessed the word in 3 turns. Well done

--------------------------------GAME-NOW-ENDS-----------------------------------
```

#### 2. FATAL
With the same logic:
```
--------------------------------GAME-NOW-STARTS---------------------------------

           Begin:  |     |     |     |     |     |  Your guess: crane
(ACCEPTED) Turn 1: |  C  |  R  | {A} |  N  |  E  |  Your guess: about
(ACCEPTED) Turn 2: | {A} |  B  |  O  |  U  | {T} |  Your guess: faith
(ACCEPTED) Turn 3: | [F] | [A] |  I  | {T} |  H  |  Your guess: fatal
(ACCEPTED) Turn 4: | [F] | [A] | [T] | [A] | [L] |  You've guessed the word in 4 turns. Well done

--------------------------------GAME-NOW-ENDS-----------------------------------
```

#### 3. EARLY
If you used up all your turns, the program will tell you what is answer is :) 
```
--------------------------------GAME-NOW-STARTS---------------------------------

           Begin:  |     |     |     |     |     |  Your guess: Adieu
(ACCEPTED) Turn 1: | {A} |  D  |  I  | {E} |  U  |  Your guess: barge
(ACCEPTED) Turn 2: |  B  | [A] | [R] |  G  | {E} |  Your guess: earth
(ACCEPTED) Turn 3: | [E] | [A] | [R] |  T  |  H  |  Your guess: earns
(ACCEPTED) Turn 4: | [E] | [A] | [R] |  N  |  S  |  Your guess: eared       // I intened to make this mistake
(ACCEPTED) Turn 5: | [E] | [A] | [R] |  E  |  D  |  Your guess: earls       // I intened to make this mistake
(ACCEPTED) Turn 6: | [E] | [A] | [R] | [L] |  S  |  You've used up all turns

The answer is EARLY. Better luck next time

--------------------------------GAME-NOW-ENDS-----------------------------------
```

### Things to know
- When entering the 5 lettered word guess, cases DO NOT matter.

An attempt will be rejected if:
- the length of your word is not 5
- there are non-alphabetic characters in the word
- it is not a valid word (determined by comparison with a huge word bank)
like this:
```
--------------------------------GAME-NOW-STARTS---------------------------------

           Begin:  |     |     |     |     |     |  Your guess: lengthIsNotFive     // length != 5
 (INVALID)                                          Your guess: *#%$                // Non-Alpha
 (INVALID)                                          Your guess: lmaos               // Not a word
 (INVALID)                                          Your guess: yield               // yeah... I yielded, entered a valid word
(ACCEPTED) Turn 1: |  Y  | {I} |  E  |  L  |  D  |  Your guess: 
```

- The answer for each puzzle is always a commonly used word. However, your attempts don't have to be.
- Sometimes, letters repeat. For instance, when the answer is `ERROR`. When the user enters the guess attempt `crane`. the output will be:
```|  C  | {R} |  A  |  N  | {E} |```. The `{R}` does not tell how many `R`s there is. On the other hand, if the user enters `racer`, the program will report ```| {R} |  A  |  C  |  E  | [R] |```. The `{R}` and `[R]` tells there's more than one `R`s when there are multiple `R`s in the attempt. 

- There are something wrong with the word banks :(

### Sometimes, the word banks fuck with you
You see, answers of each puzzle came out of the `CommonWords.txt` file, and the judgement of user's attempts are made according to the `AllWords.txt` file. In the case of `MULTI`, it's present in `CommonWords.txt` so it became the answer, but the judgement does not recognize it cuz it's not in the `AllWords.txt`. It happens more often when it comes to the difference of Britsh and American English. These small discrepancies are easy to fix. I'm on it. The chance of this happing is stll relatively low. 
```
--------------------------------GAME-NOW-STARTS---------------------------------

           Begin:  |     |     |     |     |     |  Your guess: slate
(ACCEPTED) Turn 1: |  S  | {L} |  A  | [T] |  E  |  Your guess: filth
(ACCEPTED) Turn 2: |  F  | {I} | [L] | [T] |  H  |  Your guess: multi
 (INVALID)                                          Your guess: 
 (INVALID)                                          Your guess: slate
(ACCEPTED) Turn 3: |  S  | {L} |  A  | [T] |  E  |  Your guess: slate
(ACCEPTED) Turn 4: |  S  | {L} |  A  | [T] |  E  |  Your guess: slate
(ACCEPTED) Turn 5: |  S  | {L} |  A  | [T] |  E  |  Your guess: slate
(ACCEPTED) Turn 6: |  S  | {L} |  A  | [T] |  E  |  You've used up all turns     // jumping to the end

The answer is MULTI. Better luck next time   // WTF ???

--------------------------------GAME-NOW-ENDS-----------------------------------
```

## Some next steps
- maybe developing an algorithm that plays the game.
- or recreate other NYT games like SpellingBee, CrossWords, etc.



see ya ~ 
