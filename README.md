# DiceCalc #

DiceCalc is a calculator-themed pseudorandom dice roller.  It differs from
most other dice-rolling programs in that it operates with dice formula
strings, which many tabletop gamers will be familiar with from source books
and command-line or IRC bot dice rollers.  It uses a GUI resembling a pocket
calculator because I think it is cool.  I also think it's an eficient way to
type dice formulas.  However, the Dice class may be used separately for other
formula-based dice rollers.

## How It Works ##
In case you don't know what a dice formula is or how to read one, the look
like this:

    2d6+3

This tells you to roll two six-sided dice and add three.
More generally, they take this form:

    AdB+C

A is the number of dice to roll.  B specifices the type of die to roll.
Specifically, it is the number of sides.  This means that all of the dice in
this roll are of the same type.  C is the modifier.  Most commonly, this is a
constant that you add (or subtract; the + can be a -) to the result of the
preceding roll.  However, in DiceCalc, it can also be another dice formula,
meaning you can chain together dice rolls.  In other words, when you roll
damage for your +2 flaming longsword, you can enter:

    1d8+1d6+2

You can also have more than one constant modifier.  In fact, your whole roll
can consist of constant modifiers.

And that's how dice formulas work.  The Dice classdoes all the work and
returns a final value of the roll.  Note that unlike some other dice rollers,
DiceCalc does not also display the results of individual rolls.

## Possible Future Additions ##
* fudge dice ( + + 0 0 - - )
* median dice ( 2 3 3 4 4 5 )