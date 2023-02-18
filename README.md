# my-wordle-game
Hey yo!

## Backgrounds
It was a Friday afternoon, when the setting sun shined brightly into the huge windows of a 8th floor lounge. I got so bored.  :( 

Trying to keep my brain occupied, I took out my phone for some games. Unfortunately, the first thing (the thrid thing ... to be more accurate) in my mornings is to complete the daliy Wordle challenge on New York Times. So, I got no Wordle to play at that moment. I guess I'm not the only person who thinks the rate New York Times updates their challenges are a bit to slow. 

So, how a about making my own Wordle game? A one I can play anytime. 

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


### Sometimes, the program fucks with you

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


