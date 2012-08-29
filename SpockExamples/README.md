Spock
===============

Spock can be used to test Groovy or Java classes.

The feature (test) methods can have the following blocks:

* <code>given:</code> (or alternatively <code>setup:</code>)
 * first block in the method
 * optional since it is implicit
 * this is where you setup the test 

* <code>when:</code>
 * invoke the action/behaviour being tested

* <code>then:</code>
 * occurs together with the when block
 * describes the expected condition

* <code>expect:</code>
 * can be used to combine when and then in one statement
* <code>cleanup:</code
 * TODO
 
* <code>where:</code
 * TODO
