Spock
===============

Spock can be used to test Groovy or Java classes.

Feature (test) methods must have at least one 'block'.  Below I have listed the 
labels that signal the beginning of a block.

* <code>given:</code> (alias <code>setup:</code>)
 * This block is where you setup up your feature method and therefore must not have
    any blocks that precede it.
 * You are not required to have a 'setup' block in your test method and you can even
    ommit the label for this block as anything before the first labelled block will
    be treated as the setup block.

* <code>when:</code>
 * This is where you can invoke the action/behaviour/feature being tested. e.g.
    <code>when: String name = person.getName()</code>

* <code>then:</code>
 * This block occurs together with the when block to describe the expectation of the
    behaviour invoked by the when block. e.g. <code>then: name == "Nick"</code>
 * You may have multiple when/then blocks in a test method.

* <code>expect:</code>
 * This is for when you want to combine when/then blocks into one block where more 
    appropriate.
    e.g. <code>expect: person.getName() == "Nick"</code>
 
* <code>and:</code>
 * This block is used to repeat the previous block - with the aim of making the 
    method more readable.

* <code>cleanup:</code>
 * If you need to clean up after your test then this is the block to do it. This 
    block can only be followed by a <code>where</code> block.

* <code>where:</code>
 * When you want to provide various inputs and or test against variour outputs 
    (think parameterised tests). e.g. <code>where: input << [1, 2, 3]</code> which
    will run the feature method three times with each of the values supplied to 
    input.  A tabular form can also be use (See examples).
 * It is optional but must come last in the method when present and can't be 
    repeated.

For further information see the Spock wiki: <url>http://code.google.com/p/spock/wiki/SpockBasics</url>
 
